/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.SysResourcePosition;

/**
 * 资源挂载位置管理DAO接口
 * @author liuxiaoyu
 * @version 2015-10-19
 */
@MyBatisDao
public interface SysResourcePositionDao extends CrudDao<SysResourcePosition> {
	
}