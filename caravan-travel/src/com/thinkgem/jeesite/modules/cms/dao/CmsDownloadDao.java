/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.CmsDownload;

/**
 * 下载模型DAO接口
 * @author allen
 * @version 2016-02-23
 */
@MyBatisDao
public interface CmsDownloadDao extends CrudDao<CmsDownload> {
	
}