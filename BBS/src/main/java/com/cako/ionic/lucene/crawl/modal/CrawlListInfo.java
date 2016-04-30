package com.cako.ionic.lucene.crawl.modal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.orm.commons.utils.IdEntity;

/**
 * 爬虫程序入口地址信息：更新列表页信息
 * 
 * @author DavisHy
 *
 */
@Entity
@Table(name = "no_crawllistinfo")
public class CrawlListInfo extends IdEntity {
	private String url;
	private String info;// 入口描述
	private int frequency;// 抓新频率

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
