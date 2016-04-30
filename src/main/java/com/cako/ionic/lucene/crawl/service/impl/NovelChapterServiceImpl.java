package com.cako.ionic.lucene.crawl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cako.ionic.lucene.crawl.dao.NovelChapterDao;
import com.cako.ionic.lucene.crawl.modal.NovelChapter;
import com.cako.ionic.lucene.crawl.service.NovelChapterService;
import com.orm.commons.service.impl.DefaultAbstractService;

@Service(value = "novelChapterService")
public class NovelChapterServiceImpl extends DefaultAbstractService<NovelChapter, String>
		implements NovelChapterService {
	@Autowired
	public NovelChapterDao novelChapterDao;

	@Override
	public NovelChapter getRandChapter(Integer state) {
		List<NovelChapter> randChapter = novelChapterDao.getRandChapter(state);
		return randChapter != null && randChapter.size() > 0 ? randChapter.get(0) : null;
	}

}
