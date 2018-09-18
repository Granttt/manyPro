/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 系统多媒体资源管理Entity
 * @author liuxiaoyu
 * @version 2015-11-04
 */
public class SysMediaResource extends DataEntity<SysMediaResource> {
	
	private static final long serialVersionUID = 1L;
	private String resourcename;		// 资源名称
	private Integer resourcetype;		// 资源类型
	private String resourceurl;		// 资源地址
	private String resourcedesc;		// 资源描述
	private String hrefurl;		// 外链地址
	
	public SysMediaResource() {
		super();
	}

	public SysMediaResource(String id){
		super(id);
	}

	@Length(min=0, max=20, message="资源名称长度必须介于 0 和 20 之间")
	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	
	public Integer getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(Integer resourcetype) {
		this.resourcetype = resourcetype;
	}
	
	@Length(min=0, max=400, message="资源地址长度必须介于 0 和 400 之间")
	public String getResourceurl() {
		return resourceurl;
	}

	public void setResourceurl(String resourceurl) {
		this.resourceurl = resourceurl;
	}
	
	@Length(min=0, max=400, message="资源描述长度必须介于 0 和 400 之间")
	public String getResourcedesc() {
		return resourcedesc;
	}

	public void setResourcedesc(String resourcedesc) {
		this.resourcedesc = resourcedesc;
	}
	
	@Length(min=0, max=500, message="外链地址长度必须介于 0 和 500 之间")
	public String getHrefurl() {
		return hrefurl;
	}

	public void setHrefurl(String hrefurl) {
		this.hrefurl = hrefurl;
	}
}