package com.cako.ionic.lucene.crawl.zongheng.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cako.ionic.lucene.crawl.modal.NovelChapter;
import com.cako.ionic.lucene.crawl.modal.NovelInfoModel;
import com.cako.ionic.lucene.crawl.service.NovelChapterService;
import com.cako.ionic.lucene.crawl.service.NovelInfoService;
import com.cako.ionic.lucene.crawl.zongheng.ChapterPage;
import com.cako.ionic.lucene.crawl.zongheng.IntroPage;
import com.cako.ionic.lucene.crawl.zongheng.IntroPageThreadService;
import com.orm.commons.exception.ServiceException;

@Service(value = "introPageThreadService")
public class IntroPageThreadServiceImpl implements IntroPageThreadService {

	@Autowired
	public NovelInfoService novelInfoService;
	@Autowired
	public NovelChapterService novelChapterService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cako.ionic.lucene.crawl.zongheng.IntroPageThreadService#
	 * startIntroPage()
	 */
	@Override
	public void startIntroPage() {
		// 获取可以采集的简介页URL
		String url = novelInfoService.getRandIntroPageUrl(1);
		try {
			if (url != null) {
				IntroPage intro = new IntroPage(url);
				// 获取简介页信息
				NovelInfoModel novelInfoModel = intro.analyzer();
				if (novelInfoModel != null) {
					ChapterPage chapterPage = new ChapterPage(novelInfoModel.getChapterListUrl());
					// 获取章节列表页信息
					List<NovelChapter> chapters = chapterPage.analyzer();
					// 写入小说章节个数
					novelInfoModel.setChapterCount(chapters == null ? 0 : chapters.size());
					// 保存简介页信息
					novelInfoService.save(novelInfoModel);
					// 保存章节列表页信息
					for (NovelChapter novelChapterModel : chapters) {
						novelChapterModel.setNovelInfoId(novelInfoModel.getId());
						novelChapterService.save(novelChapterModel);
					}
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
