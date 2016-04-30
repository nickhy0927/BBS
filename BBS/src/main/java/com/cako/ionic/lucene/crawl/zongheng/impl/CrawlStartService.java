package com.cako.ionic.lucene.crawl.zongheng.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cako.ionic.lucene.crawl.modal.CrawlListInfo;
import com.cako.ionic.lucene.crawl.service.CrawlListInfoService;
import com.cako.ionic.lucene.crawl.zongheng.IntroPageThreadService;
import com.cako.ionic.lucene.crawl.zongheng.ReadPageThreadService;
import com.cako.ionic.lucene.crawl.zongheng.UpdateListThreadService;

@Component
@Transactional(readOnly = true)
public class CrawlStartService {

	@Autowired
	public UpdateListThreadService updateListThreadService;

	@Autowired
	public IntroPageThreadService introPageThreadService;

	@Autowired
	public ReadPageThreadService readPageThreadService;

	@Autowired
	public CrawlListInfoService crawlListInfoService;

	/**
	 * @Description:启动更新列表页采集线程
	 */
	public void startCrawlList() {
		List<CrawlListInfo> infos = crawlListInfoService.getCrawlListInfos();
		for (CrawlListInfo info : infos) {
			if (info.getUrl() == null || "".equals(info.getUrl())) {
				continue;
			}
			updateListThreadService.updateInfoUrls(info.getUrl());
		}
	}

	/**
	 * @Author:lulei
	 * @Description: 启动简介页采集线程
	 */
	public void startCrawlIntro() {
		introPageThreadService.startIntroPage();
	}

	/**
	 * @Author:lulei
	 * @Description:启动阅读页采集线程
	 */
	public void startCrawlRead() {
		readPageThreadService.startReadPage();
	}

	public void startThread() {
		System.out.println("线程池已经启动............");
		startCrawlList();
		startCrawlIntro();
		startCrawlRead();
	}

}
