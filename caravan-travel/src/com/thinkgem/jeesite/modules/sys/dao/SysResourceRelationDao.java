/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.SysResourceRelation;

/**
 * 资源关联DAO接口
 * @author liuxiaoyu
 * @version 2015-10-25
 */
@MyBatisDao
public interface SysResourceRelationDao extends CrudDao<SysResourceRelation> {
	
	public int insertBatch(List list);
	
	public List<SysResourceRelation> findByTag(@Param(value="positionid") String positionid,@Param(value="num")int num);
	
	
}