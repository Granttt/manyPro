package com.thinkgem.jeesite.modules.enterprise.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;

import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.service.SysWebConstService;

public class EnterpriseUtils {
	
	 private static ServletContext context = SpringContextHolder.getBean(ServletContext.class);
	 
	 private static SysWebConstService constService = SpringContextHolder.getBean(SysWebConstService.class);
	 
	 public static Map<String,String> constMap  = new HashMap<String, String>();
	
    
    /**
     * 获取网站固定参数
     * @param uniString
     * @return
     */
    public static String getConstByUni(String uniString) {
    	String temp = constMap.get(uniString);
//    	if (StringUtils.isEmpty(temp)) {
    		if (!StringUtils.isEmpty(uniString)) {
    			constMap.put(uniString, constService.getByUni(uniString).getConstvalue());
    		}
//		}
    	return constMap.get(uniString);
    }


}
