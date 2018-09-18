/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;


import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 资源挂载位置管理Entity
 * @author liuxiaoyu
 * @version 2015-10-19
 */
public class SysResourcePosition extends DataEntity<SysResourcePosition> {
	
	private static final long serialVersionUID = 1L;
	private String positionName;		// 位置名称
	private String positionDesc;		// 位置描述
	private Integer positionWidth;		// 位置宽度
	private Integer positionHeight;		// 位置高度
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SysResourcePosition() {
		super();
	}

	public SysResourcePosition(String id){
		super(id);
	}

	@Length(min=0, max=20, message="位置名称长度必须介于 0 和 20 之间")
	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	@Length(min=0, max=100, message="位置描述长度必须介于 0 和 100 之间")
	public String getPositionDesc() {
		return positionDesc;
	}

	public void setPositionDesc(String positionDesc) {
		this.positionDesc = positionDesc;
	}
	
	public Integer getPositionWidth() {
		return positionWidth;
	}

	public void setPositionWidth(Integer positionWidth) {
		this.positionWidth = positionWidth;
	}
	
	public Integer getPositionHeight() {
		return positionHeight;
	}

	public void setPositionHeight(Integer positionHeight) {
		this.positionHeight = positionHeight;
	}
	
}