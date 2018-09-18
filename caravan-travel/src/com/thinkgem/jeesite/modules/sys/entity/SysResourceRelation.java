/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 资源关联Entity
 * 
 * @author liuxiaoyu
 * @version 2015-10-25
 */
public class SysResourceRelation extends DataEntity<SysResourceRelation> {

	private static final long serialVersionUID = 1L;
	private String positionid; // positionid
	private String resourceid; // resourceid
	private String datetime;

	private SysMediaResource sysMidiaResource;

	public SysResourceRelation() {
		super();
	}

	public SysResourceRelation(String positionid, String resourceid) {
		this.positionid = positionid;
		this.resourceid = resourceid;
	}

	public SysResourceRelation(String id) {
		super(id);
	}

	@Length(min = 1, max = 50, message = "positionid长度必须介于 1 和 50 之间")
	public String getPositionid() {
		return positionid;
	}

	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}

	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public SysMediaResource getSysMidiaResource() {
		return sysMidiaResource;
	}

	public void setSysMidiaResource(SysMediaResource sysMidiaResource) {
		this.sysMidiaResource = sysMidiaResource;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}