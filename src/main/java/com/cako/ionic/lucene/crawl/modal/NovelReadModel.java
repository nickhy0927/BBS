package com.cako.ionic.lucene.crawl.modal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.orm.commons.utils.IdEntity;

/**
 * 小说阅读页信息
 * 
 * @author DavisHy
 *
 */
@Entity
@Table(name = "no_novelread")
public class NovelReadModel extends IdEntity {
	private String url;
	private String title;// 标题、、小说名称
	private int wordCount;// 小说字数
	private int chapterId;// 小说章节排序
	private long chapterTime;
	private String content;
	private NovelChapter novelChapterModel;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name = "novel_chapter_id")
	public NovelChapter getNovelChapterModel() {
		return novelChapterModel;
	}

	public void setNovelChapterModel(NovelChapter novelChapterModel) {
		this.novelChapterModel = novelChapterModel;
	}
}
