package com.dm.springcloud.persistence;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * sentinel 规则文件存储工具类
 */
@Slf4j
public class RuleFileUtils {


    /**
     * 若路径不存在就创建路径
     */
    public static void mkdirIfNotExits(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            log.info("创建Sentinel规则目录:{}", filePath);
            file.mkdirs();
        }
    }


    /**
     * 若文件不存在就创建路径
     */
    public static void createFileIfNotExits(Map<String, String> ruleFileMap) throws IOException {

        Set<String> ruleFilePathSet = ruleFileMap.keySet();

        Iterator<String> ruleFilePathIter = ruleFilePathSet.iterator();

        while (ruleFilePathIter.hasNext()) {
            String ruleFilePathKey = ruleFilePathIter.next();
            String ruleFilePath = PersistenceRuleConstant.rulesMap.get(ruleFilePathKey).toString();
            File ruleFile = new File(ruleFilePath);
            if (ruleFile.exists()) {
                log.info("创建Sentinel 规则文件:{}", ruleFile);
                ruleFile.createNewFile();
            }
        }
    }

}