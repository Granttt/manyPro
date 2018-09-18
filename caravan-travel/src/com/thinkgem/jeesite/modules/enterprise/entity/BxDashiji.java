/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.enterprise.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 北新大事记Entity
 * @author liuxiaoyu
 * @version 2015-12-02
 */
public class BxDashiji extends DataEntity<BxDashiji> {
	
	private static final long serialVersionUID = 1L;
	private String dsjtitle;		// 概览
	private String dsjyear;		// 年份
	private Date dsjdate;		// 日期
	private String dsjpic;		// 图片
	private String dsjcontent;		// 内容
	
	public BxDashiji() {
		super();
	}

	public BxDashiji(String id){
		super(id);
	}

	@Length(min=0, max=200, message="概览长度必须介于 0 和 200 之间")
	public String getDsjtitle() {
		return dsjtitle;
	}

	public void setDsjtitle(String dsjtitle) {
		this.dsjtitle = dsjtitle;
	}
	
	@Length(min=1, max=11, message="年份长度必须介于 1 和 11 之间")
	public String getDsjyear() {
		return dsjyear;
	}

	public void setDsjyear(String dsjyear) {
		this.dsjyear = dsjyear;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDsjdate() {
		return dsjdate;
	}

	public void setDsjdate(Date dsjdate) {
		this.dsjdate = dsjdate;
	}
	
	@Length(min=0, max=500, message="图片长度必须介于 0 和 500 之间")
	public String getDsjpic() {
		return dsjpic;
	}

	public void setDsjpic(String dsjpic) {
		this.dsjpic = dsjpic;
	}
	
	public String getDsjcontent() {
		return dsjcontent;
	}

	public void setDsjcontent(String dsjcontent) {
		this.dsjcontent = dsjcontent;
	}
	
}