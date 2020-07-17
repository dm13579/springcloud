package com.dm.springcloud.persistence;

import java.util.HashMap;
import java.util.Map;

/**
 * 规则持久化 常量配置类
 */
public class PersistenceRuleConstant {

    /**
     * 各种存储sentinel规则映射map
     */
    public static Map<String,String> rulesMap = new HashMap<String, String>();

    /**
     * 存储文件路径
     */
    public static final String STORE_PATH = System.getProperty("user.home") + "\\sentinel\\rules\\";

    /**
     * 流控规则文件
     */
    public static final String FLOW_RULE_PATH = "flowRulePath";

    /**
     * 降级规则文件
     */
    public static final String DEGRAGE_RULE_PATH = "degradeRulePath";

    /**
     * 授权规则文件
     */
    public static final String AUTH_RULE_PATH = "authRulePath";

    /**
     * 系统规则文件
     */
    public static final String SYSTEM_RULE_PATH = "systemRulePath";

    /**
     * 热点参数文件
     */
    public static final String HOT_PARAM_RULE = "hotParamRulePath";

    static {
        rulesMap.put(FLOW_RULE_PATH, STORE_PATH + "flowRule.json");
        rulesMap.put(DEGRAGE_RULE_PATH, STORE_PATH + "degradeRule.json");
        rulesMap.put(SYSTEM_RULE_PATH, STORE_PATH + "systemRule.json");
        rulesMap.put(AUTH_RULE_PATH, STORE_PATH + "authRule.json");
        rulesMap.put(HOT_PARAM_RULE, STORE_PATH + "hotParamRule.json");
    }
}
