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
import com.thinkgem.jeesite.modules.sys.entity.SysResourceRelation;
import com.thinkgem.jeesite.modules.sys.dao.SysResourceRelationDao;

/**
 * 资源关联Service
 * @author liuxiaoyu
 * @version 2015-10-25
 */
@Service
@Transactional(readOnly = true)
public class SysResourceRelationService extends CrudService<SysResourceRelationDao, SysResourceRelation> {
	
	@Autowired
	private SysResourceRelationDao relationDao;

	public SysResourceRelation get(String id) {
		return super.get(id);
	}
	
	public List<SysResourceRelation> findList(SysResourceRelation sysResourceRelation) {
		return super.findList(sysResourceRelation);
	}
	
	public Page<SysResourceRelation> findPage(Page<SysResourceRelation> page, SysResourceRelation sysResourceRelation) {
		return super.findPage(page, sysResourceRelation);
	}
	
	public List<SysResourceRelation> findByTag(String positionid,int num){
		return relationDao.findByTag(positionid, num);
	}
	
	@Transactional(readOnly = false)
	public void save(SysResourceRelation sysResourceRelation) {
		super.save(sysResourceRelation);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysResourceRelation sysResourceRelation) {
		super.delete(sysResourceRelation);
	}
	
	@Transactional(readOnly = false)
	public void batchSave(List<SysResourceRelation> list) {
		relationDao.insertBatch(list);
	}
	
}