package com.cako.ionic.lucene.crawl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.cako.ionic.lucene.crawl.modal.NovelChapter;
import com.orm.commons.service.CakoHyJpaRepostiory;

public interface NovelChapterDao extends CakoHyJpaRepostiory<NovelChapter, String> {
	@Query("select chapter from NovelChapter chapter where chapter.state = ?1")
	public List<NovelChapter> getRandChapter(Integer state);
}
