/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.enterprise.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.enterprise.entity.BxDashiji;

/**
 * 北新大事记DAO接口
 * @author liuxiaoyu
 * @version 2015-12-02
 */
@MyBatisDao
public interface CompanyHistoryDao extends CrudDao<BxDashiji> {
	public List<BxDashiji> selectAll();
}