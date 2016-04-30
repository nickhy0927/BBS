package com.cako.ionic.lucene.crawl.service;

import com.cako.ionic.lucene.crawl.modal.NovelInfoModel;
import com.orm.commons.service.BaseService;

public interface NovelInfoService extends BaseService<NovelInfoModel, String> {

	public String getRandIntroPageUrl(Integer state);

	public boolean haveNovelInfo(String id);
}
