/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.SysWebConst;

/**
 * 网站常量数据DAO接口
 * @author liuxiaoyu
 * @version 2015-12-21
 */
@MyBatisDao
public interface SysWebConstDao extends CrudDao<SysWebConst> {
	
	public SysWebConst getConst(@Param("constuniq") String uniString);
	
}