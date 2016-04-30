package com.cako.ionic.lucene.crawl.zongheng.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cako.ionic.lucene.crawl.modal.NovelChapter;
import com.cako.ionic.lucene.crawl.modal.NovelReadModel;
import com.cako.ionic.lucene.crawl.service.NovelChapterService;
import com.cako.ionic.lucene.crawl.service.NovelReadService;
import com.cako.ionic.lucene.crawl.zongheng.ReadPage;
import com.cako.ionic.lucene.crawl.zongheng.ReadPageThreadService;
import com.orm.commons.exception.ServiceException;

@Service(value = "readPageThreadService")
public class ReadPageThreadServiceImpl implements ReadPageThreadService {

	@Autowired
	public NovelChapterService novelChapterService;
	@Autowired
	public NovelReadService novelReadService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cako.ionic.lucene.crawl.zongheng.ReadPageThreadService#startReadPage(
	 * )
	 */
	@Override
	public void startReadPage() {
		// 获取可以采集的章节信息
		NovelChapter chapter = novelChapterService.getRandChapter(1);
		try {
			if (chapter != null) {
				ReadPage readPage = new ReadPage(chapter.getUrl());
				// 获取小说阅读页信息
				NovelReadModel novel = readPage.analyzer();
				if (novel == null) {
					return;
				}
				// 写入小说章节序号
				novel.setChapterId(chapter.getChapterId());
				// 写入章节发布时间
				novel.setChapterTime(chapter.getChapterTime());
				// 保存小说阅读页信息
				novelReadService.save(novel);
				// 将小说的章节设置成已采集
				// db.updateChapterState(chapter.getId(), 0);
				chapter.setState(0);
				novelChapterService.save(chapter);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
