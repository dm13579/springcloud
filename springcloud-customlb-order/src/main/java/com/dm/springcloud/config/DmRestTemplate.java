package com.dm.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.client.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

/**
 * 自定义负载均衡算法
 */
@Slf4j
public class DmRestTemplate extends RestTemplate {

    private DiscoveryClient discoveryClient;

    public DmRestTemplate(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    /**
     * 重写和改写RestTemplte.doExecute方法
     * 主要逻辑：在调用前修改调用地址
     *
     * @param url
     * @param method
     * @param requestCallback
     * @param responseExtractor
     * @param <T>
     * @return
     * @throws RestClientException
     */
    @Override
    protected <T> T doExecute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {
        Assert.notNull(url, "URI is required");
        Assert.notNull(method, "HttpMethod is required");
        ClientHttpResponse response = null;

        Object var14;
        try {
            log.info("请求的url路径为:{}",url);
            //把服务名 替换成我们的IP
            url = replaceUrl(url);

            log.info("替换后的路径:{}",url);

            ClientHttpRequest request = this.createRequest(url, method);
            if (requestCallback != null) {
                requestCallback.doWithRequest(request);
            }

            response = request.execute();
            handleResponse(url, method, response);
            return (responseExtractor != null ? responseExtractor.extractData(response) : null);
        } catch (IOException var12) {
            String resource = url.toString();
            String query = url.getRawQuery();
            resource = query != null ? resource.substring(0, resource.indexOf(63)) : resource;
            throw new ResourceAccessException("I/O error on " + method.name() + " request for \"" + resource + "\": " + var12.getMessage(), var12);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    /**
     * url 替换
     *
     * @param url
     * @return
     */
    private URI replaceUrl(URI url) {
        //1:从URI中解析调用的调用的serviceName=product-center
        String serviceName = url.getHost();
        log.info("调用微服务的名称:{}",serviceName);

        //2:解析我们的请求路径 reqPath= /selectProductInfoById/1
        String reqPath = url.getPath();
        log.info("请求path:{}",reqPath);

        //3:通过微服务的名称去nacos服务端获取 对应的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("product-center");
        if(instances == null || instances.isEmpty()){
            throw new RuntimeException("没有可用的微服务实例列表:"+serviceName);
        }

        //4:负载均衡实例列表挑选一个ip
        String serviceIp = chooseTargetIp(instances);
        String source = serviceIp+reqPath;
        try {
            return new URI(serviceIp+reqPath);
        } catch (URISyntaxException e) {
            throw new RuntimeException("根据source:{}构建URI异常"+source);
        }
    }

    /**
     * 挑选目标地址（在这里使用随机）
     *
     * @param instances
     * @return
     */
    private String chooseTargetIp(List<ServiceInstance> instances) {
        Random random = new Random();
        Integer randomIndex = random.nextInt(instances.size());
        String ip = instances.get(randomIndex).getUri().toString();
        log.info("随机选举的服务IP:{}",ip);
        return ip;
    }
}