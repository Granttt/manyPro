/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CmsSlide;
import com.thinkgem.jeesite.modules.cms.dao.CmsSlideDao;

/**
 * 幻灯片Service
 * @author liuxiaoyu
 * @version 2015-12-18
 */
@Service
@Transactional(readOnly = true)
public class CmsSlideService extends CrudService<CmsSlideDao, CmsSlide> {

	public CmsSlide get(String id) {
		return super.get(id);
	}
	
	public List<CmsSlide> findList(CmsSlide cmsSlide) {
		return super.findList(cmsSlide);
	}
	
	public Page<CmsSlide> findPage(Page<CmsSlide> page, CmsSlide cmsSlide) {
		return super.findPage(page, cmsSlide);
	}
	
	@Transactional(readOnly = false)
	public void save(CmsSlide cmsSlide) {
		super.save(cmsSlide);
	}
	
	@Transactional(readOnly = false)
	public void delete(CmsSlide cmsSlide) {
		super.delete(cmsSlide);
	}
	
}