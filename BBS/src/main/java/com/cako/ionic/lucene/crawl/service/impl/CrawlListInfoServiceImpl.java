package com.cako.ionic.lucene.crawl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cako.ionic.lucene.crawl.dao.CrawlListInfoDao;
import com.cako.ionic.lucene.crawl.modal.CrawlListInfo;
import com.cako.ionic.lucene.crawl.service.CrawlListInfoService;
import com.orm.commons.service.impl.DefaultAbstractService;

@Service(value = "crawlListInfoService")
public class CrawlListInfoServiceImpl extends DefaultAbstractService<CrawlListInfo, String>
		implements CrawlListInfoService {

	@Autowired
	public CrawlListInfoDao crawlListInfoDao;

	@Override
	public List<CrawlListInfo> getCrawlListInfos() {
		return crawlListInfoDao.findAll();
	}

}
