/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.dao.SysResourcePositionDao;
import com.thinkgem.jeesite.modules.sys.dao.SysResourceRelationDao;
import com.thinkgem.jeesite.modules.sys.entity.SysResourcePosition;
import com.thinkgem.jeesite.modules.sys.entity.SysResourceRelation;

/**
 * 资源挂载位置管理Service
 * @author liuxiaoyu
 * @version 2015-10-19
 */
@Service
@Transactional(readOnly = true)
public class SysResourcePositionService extends CrudService<SysResourcePositionDao, SysResourcePosition> {
	
	@Autowired
	private SysResourceRelationDao relationDao;

	public SysResourcePosition get(String id) {
		return super.get(id);
	}
	
	public List<SysResourcePosition> findList(SysResourcePosition sysResourcePosition) {
		return super.findList(sysResourcePosition);
	}
	
	public Page<SysResourcePosition> findPage(Page<SysResourcePosition> page, SysResourcePosition sysResourcePosition) {
		return super.findPage(page, sysResourcePosition);
	}
	
	@Transactional(readOnly = false)
	public void save(SysResourcePosition sysResourcePosition) {
		super.save(sysResourcePosition);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysResourcePosition sysResourcePosition) {
		super.delete(sysResourcePosition);
	}
	
}