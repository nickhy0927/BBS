package com.cako.ionic.lucene.crawl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.cako.ionic.lucene.crawl.modal.NovelInfoModel;
import com.orm.commons.service.CakoHyJpaRepostiory;

public interface NovelInfoDao extends CakoHyJpaRepostiory<NovelInfoModel, String> {

	@Query("select n.url from NovelInfoModel n where n.state = ?1")
	public List<String> getRandIntroPageUrl(Integer state);

	
}
