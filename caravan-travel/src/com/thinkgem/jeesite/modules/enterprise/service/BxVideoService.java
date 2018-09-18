/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.enterprise.service;

import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.dao.ArticleDao;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.enterprise.entity.BxVideo;
import com.thinkgem.jeesite.modules.enterprise.dao.BxVideoDao;

/**
 * 北新视频管理Service
 * @author liuxiaoyu
 * @version 2015-12-08
 */
@Service
@Transactional(readOnly = true)
public class BxVideoService extends CrudService<BxVideoDao, BxVideo>   {
	@Autowired
	private BxVideoDao bxVideoDao;

	public BxVideo get(String id) {
		return super.get(id);
	}
	
	public List<BxVideo> findList(BxVideo bxVideo) {
		return super.findList(bxVideo);
	}
	

	
	@Transactional(readOnly = false)
	public void save(BxVideo bxVideo) {
		bxVideo.setMark(StringEscapeUtils.unescapeHtml4(bxVideo.getMark()));
		super.save(bxVideo);
	}
	
	@Transactional(readOnly = false)
	public void delete(BxVideo bxVideo) {
		super.delete(bxVideo);
	}


	public Page<BxVideo> findPage(Page<BxVideo> page, BxVideo video, boolean isDataScopeFilter) {
		
		return super.findPage(page, video);
		
	}

	public BxVideo getRecentVideo() {
		// TODO Auto-generated method stub
		return bxVideoDao.getRecentVideo();
	}

	
}