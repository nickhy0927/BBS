package com.cako.ionic.lucene.crawl.service;

import java.util.List;

import com.cako.ionic.lucene.crawl.modal.CrawlListInfo;
import com.orm.commons.service.BaseService;

public interface CrawlListInfoService extends BaseService<CrawlListInfo, String> {

	public List<CrawlListInfo> getCrawlListInfos();
}
