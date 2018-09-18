/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.SysWebConst;
import com.thinkgem.jeesite.modules.sys.dao.SysWebConstDao;

/**
 * 网站常量数据Service
 * @author liuxiaoyu
 * @version 2015-12-21
 */
@Service
@Transactional(readOnly = true)
public class SysWebConstService extends CrudService<SysWebConstDao, SysWebConst> {

	public SysWebConst get(String id) {
		return super.get(id);
	}
	
	public SysWebConst getByUni(String uniString) {
		return dao.getConst(uniString);
	}
	
	public List<SysWebConst> findList(SysWebConst sysWebConst) {
		return super.findList(sysWebConst);
	}
	
	public Page<SysWebConst> findPage(Page<SysWebConst> page, SysWebConst sysWebConst) {
		return super.findPage(page, sysWebConst);
	}
	
	@Transactional(readOnly = false)
	public void save(SysWebConst sysWebConst) {
		super.save(sysWebConst);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysWebConst sysWebConst) {
		super.delete(sysWebConst);
	}
	
}