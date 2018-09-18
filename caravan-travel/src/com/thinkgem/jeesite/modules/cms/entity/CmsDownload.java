/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 下载模型Entity
 * @author allen
 * @version 2016-02-23
 */
public class CmsDownload extends DataEntity<CmsDownload> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String href;		// 下载链接
	private String categoryid;		// 分类ID
	private String sort;		// 排序
	
	public CmsDownload() {
		super();
	}

	public CmsDownload(String id){
		super(id);
	}

	@Length(min=0, max=200, message="名称长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=1000, message="下载链接长度必须介于 0 和 1000 之间")
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
	@Length(min=0, max=11, message="排序长度必须介于 0 和 11 之间")
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	
}