/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.enterprise.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.enterprise.entity.BxVideo;

/**
 * 北新视频管理DAO接口
 * @author liuxiaoyu
 * @version 2015-12-08
 */
@MyBatisDao
public interface BxVideoDao extends CrudDao<BxVideo> {

	public BxVideo getRecentVideo();
	
}