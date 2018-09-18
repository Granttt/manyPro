/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CmsDownload;
import com.thinkgem.jeesite.modules.cms.dao.CmsDownloadDao;

/**
 * 下载模型Service
 * @author allen
 * @version 2016-02-23
 */
@Service
@Transactional(readOnly = true)
public class CmsDownloadService extends CrudService<CmsDownloadDao, CmsDownload> {

	public CmsDownload get(String id) {
		return super.get(id);
	}
	
	public List<CmsDownload> findList(CmsDownload cmsDownload) {
		return super.findList(cmsDownload);
	}
	
	public Page<CmsDownload> findPage(Page<CmsDownload> page, CmsDownload cmsDownload) {
		return super.findPage(page, cmsDownload);
	}
	
	@Transactional(readOnly = false)
	public void save(CmsDownload cmsDownload) {
		super.save(cmsDownload);
	}
	
	@Transactional(readOnly = false)
	public void delete(CmsDownload cmsDownload) {
		super.delete(cmsDownload);
	}
	
}