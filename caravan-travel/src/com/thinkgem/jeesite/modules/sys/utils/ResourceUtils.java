package com.thinkgem.jeesite.modules.sys.utils;

import java.util.List;

import javax.servlet.ServletContext;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.utils.Collections3;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.sys.entity.SysResourceRelation;
import com.thinkgem.jeesite.modules.sys.service.SysResourceRelationService;

public class ResourceUtils {
	
	 private static ServletContext context = SpringContextHolder.getBean(ServletContext.class);
	 private static SysResourceRelationService relationService = SpringContextHolder.getBean(SysResourceRelationService.class);
	 
	 private static final String ResourceFocusCache = "focus_cache";
	 
	 public static List<SysResourceRelation> getFocusList(String positionid,int num) {
		 List<SysResourceRelation> list = (List<SysResourceRelation>) CacheUtils.get(ResourceFocusCache,"focusList");
		 if (Collections3.isEmpty(list)) {
			 	Page<SysResourceRelation> page = new Page<SysResourceRelation>(1,num, -1);
				page = relationService.findPage(page, new SysResourceRelation());
				list = page.getList();
				CacheUtils.put(ResourceFocusCache, "focusList", list);
		 }
		 return list;
	 }

}
