package com.dm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
  *                  ,;,,;
  *                ,;;'(    
  *      __      ,;;' ' \   
  *   /'  '\'~~'~' \ /'\.)  
  * ,;(      )    /  |.     
  *,;' \    /-.,,(   ) \    
  *     ) /       ) / )|    
  *     ||        ||  \)     
  *    (_\       (_\
  *@ClassName SpringcloudRibbonOrderApplication
  *@Description TODO
  *@Author dm
  *@Date 2020/3/7 20:17
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudRibbonPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRibbonPayApplication.class, args);
    }
}
