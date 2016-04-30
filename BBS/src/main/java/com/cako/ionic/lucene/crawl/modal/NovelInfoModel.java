package com.cako.ionic.lucene.crawl.modal;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.orm.commons.utils.IdEntity;

/**
 * 小说简介信息
 * 
 * @author DavisHy
 *
 */
@Entity
@Table(name = "no_novelinfo")
public class NovelInfoModel extends IdEntity {
	private String url;
	private String name;// 小说名
	private String author;// 小说作者
	private String descr;// 小说描述
	private String types;// 小说的类型
	private String lastChapter;// 最新章节
	private String chapterListUrl;// 最新章节地址
	private int wordCount;// 小说的字数
	private int chapterCount;// 章节的字数
	private String keyWords;// 小说的关键字

	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Lob
	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getLastChapter() {
		return lastChapter;
	}

	public void setLastChapter(String lastChapter) {
		this.lastChapter = lastChapter;
	}

	public String getChapterListUrl() {
		return chapterListUrl;
	}

	public void setChapterListUrl(String chapterListUrl) {
		this.chapterListUrl = chapterListUrl;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public int getChapterCount() {
		return chapterCount;
	}

	public void setChapterCount(int chapterCount) {
		this.chapterCount = chapterCount;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
}
