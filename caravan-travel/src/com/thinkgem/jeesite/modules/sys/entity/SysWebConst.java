/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 网站常量数据Entity
 * @author liuxiaoyu
 * @version 2015-12-21
 */
public class SysWebConst extends DataEntity<SysWebConst> {
	
	private static final long serialVersionUID = 1L;
	private String constuniq;		// 常量标识符
	private String constkey;		// 常量键
	private String keytype;		// 常量类型
	private String constvalue;		// 常量值
	private String constmark;		// 常量备注
	
	public SysWebConst() {
		super();
	}

	public SysWebConst(String id){
		super(id);
	}

	@Length(min=1, max=20, message="常量标识符长度必须介于 1 和 20 之间")
	public String getConstuniq() {
		return constuniq;
	}

	public void setConstuniq(String constuniq) {
		this.constuniq = constuniq;
	}
	
	@Length(min=0, max=50, message="常量键长度必须介于 0 和 50 之间")
	public String getConstkey() {
		return constkey;
	}

	public void setConstkey(String constkey) {
		this.constkey = constkey;
	}
	
	@Length(min=0, max=10, message="常量类型长度必须介于 0 和 10 之间")
	public String getKeytype() {
		return keytype;
	}

	public void setKeytype(String keytype) {
		this.keytype = keytype;
	}
	
	@Length(min=0, max=500, message="常量值长度必须介于 0 和 500 之间")
	public String getConstvalue() {
		return constvalue;
	}

	public void setConstvalue(String constvalue) {
		this.constvalue = constvalue;
	}
	
	public String getConstmark() {
		return constmark;
	}

	public void setConstmark(String constmark) {
		this.constmark = constmark;
	}
	
}