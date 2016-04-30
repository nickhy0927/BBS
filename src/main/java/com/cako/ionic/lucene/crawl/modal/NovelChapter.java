package com.cako.ionic.lucene.crawl.modal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.orm.commons.utils.IdEntity;

/**
 * 小说章节信息
 * 
 * @author DavisHy
 *
 */
@Entity
@Table(name = "no_chapter")
public class NovelChapter extends IdEntity {
	private String url;
	private String urlMd5;
	private String title;// 标题、、小说名称
	private int wordCount;// 小说字数
	private int chapterId;// 小说章节排序
	private long chapterTime;

	private Integer state;

	/**
	 * 小说简介
	 */
	private String novelInfoId;

	public String getUrlMd5() {
		return urlMd5;
	}

	public void setUrlMd5(String urlMd5) {
		this.urlMd5 = urlMd5;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public long getChapterTime() {
		return chapterTime;
	}

	public void setChapterTime(long chapterTime) {
		this.chapterTime = chapterTime;
	}

	public String getNovelInfoId() {
		return novelInfoId;
	}

	public void setNovelInfoId(String novelInfoId) {
		this.novelInfoId = novelInfoId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
