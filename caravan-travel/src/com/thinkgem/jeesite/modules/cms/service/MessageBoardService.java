/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.MessageBoard;
import com.thinkgem.jeesite.modules.cms.dao.MessageBoardDao;

/**
 * 留言内容Service
 * @author gaoxiyang
 * @version 2016-12-20
 */
@Service
@Transactional(readOnly = true)
public class MessageBoardService extends CrudService<MessageBoardDao, MessageBoard> {

	public MessageBoard get(String id) {
		return super.get(id);
	}
	
	public List<MessageBoard> findList(MessageBoard messageBoard) {
		return super.findList(messageBoard);
	}
	
	public Page<MessageBoard> findPage(Page<MessageBoard> page, MessageBoard messageBoard) {
		return super.findPage(page, messageBoard);
	}
	
	@Transactional(readOnly = false)
	public void save(MessageBoard messageBoard) {
		super.save(messageBoard);
	}
	
	@Transactional(readOnly = false)
	public void delete(MessageBoard messageBoard) {
		super.delete(messageBoard);
	}
	
}