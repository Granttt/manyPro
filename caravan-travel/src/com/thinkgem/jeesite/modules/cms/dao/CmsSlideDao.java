/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.CmsSlide;

/**
 * 幻灯片DAO接口
 * @author liuxiaoyu
 * @version 2015-12-18
 */
@MyBatisDao
public interface CmsSlideDao extends CrudDao<CmsSlide> {
	
}