package com.cako.ionic.lucene.crawl.service;

import com.cako.ionic.lucene.crawl.modal.NovelChapter;
import com.orm.commons.service.BaseService;

public interface NovelChapterService extends BaseService<NovelChapter, String> {

	public NovelChapter getRandChapter(Integer state);
}
