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
import com.thinkgem.jeesite.modules.enterprise.entity.BxDashiji;
import com.thinkgem.jeesite.modules.enterprise.dao.CompanyHistoryDao;

/**
 * 北新大事记Service
 * @author liuxiaoyu
 * @version 2015-12-02
 */
@Service
@Transactional(readOnly = true)
public class BxDashijiService extends CrudService<CompanyHistoryDao, BxDashiji> {
	
	@Autowired
	CompanyHistoryDao bxDashijiDao;
	
	
	public BxDashiji get(String id) {
		return super.get(id);
	}
	
	public List<BxDashiji> findList(BxDashiji bxDashiji) {
		return super.findList(bxDashiji);
	}
	
	public Page<BxDashiji> findPage(Page<BxDashiji> page, BxDashiji bxDashiji) {
		return super.findPage(page, bxDashiji);
	}
	
	@Transactional(readOnly = false)
	public void save(BxDashiji bxDashiji) {
		bxDashiji.setDsjcontent(StringEscapeUtils.unescapeHtml4(bxDashiji.getDsjcontent()));
		super.save(bxDashiji);
	}
	
	@Transactional(readOnly = false)
	public void delete(BxDashiji bxDashiji) {
		super.delete(bxDashiji);
	}
	
	public List<BxDashiji> selectAll(){
		return bxDashijiDao.selectAll();
	}
}