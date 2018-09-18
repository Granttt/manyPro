/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.SysMediaResource;

/**
 * 系统多媒体资源管理DAO接口
 * @author liuxiaoyu
 * @version 2015-11-04
 */
@MyBatisDao
public interface SysMediaResourceDao extends CrudDao<SysMediaResource> {
	
}