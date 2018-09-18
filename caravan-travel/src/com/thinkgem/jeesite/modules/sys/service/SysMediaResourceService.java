/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.SysMediaResource;
import com.thinkgem.jeesite.modules.sys.dao.SysMediaResourceDao;

/**
 * 系统多媒体资源管理Service
 * @author liuxiaoyu
 * @version 2015-11-04
 */
@Service
@Transactional(readOnly = true)
public class SysMediaResourceService extends CrudService<SysMediaResourceDao, SysMediaResource> {

	public SysMediaResource get(String id) {
		return super.get(id);
	}
	
	public List<SysMediaResource> findList(SysMediaResource sysMediaResource) {
		return super.findList(sysMediaResource);
	}
	
	public Page<SysMediaResource> findPage(Page<SysMediaResource> page, SysMediaResource sysMediaResource) {
		return super.findPage(page, sysMediaResource);
	}
	
	@Transactional(readOnly = false)
	public void save(SysMediaResource sysMediaResource) {
		super.save(sysMediaResource);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysMediaResource sysMediaResource) {
		super.delete(sysMediaResource);
	}
	
}