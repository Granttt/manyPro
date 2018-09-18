/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.MessageBoard;

/**
 * 留言内容DAO接口
 * @author gaoxiyang
 * @version 2016-12-20
 */
@MyBatisDao
public interface MessageBoardDao extends CrudDao<MessageBoard> {
	
}