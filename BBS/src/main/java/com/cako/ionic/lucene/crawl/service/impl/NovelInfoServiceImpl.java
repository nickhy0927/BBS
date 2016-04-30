package com.cako.ionic.lucene.crawl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cako.ionic.lucene.crawl.dao.NovelInfoDao;
import com.cako.ionic.lucene.crawl.modal.NovelInfoModel;
import com.cako.ionic.lucene.crawl.service.NovelInfoService;
import com.orm.commons.service.impl.DefaultAbstractService;

@Service(value = "novelInfoService")
public class NovelInfoServiceImpl extends DefaultAbstractService<NovelInfoModel, String> implements NovelInfoService {

	@Autowired
	public NovelInfoDao novelInfoDao;

	@Override
	public String getRandIntroPageUrl(Integer state) {
		List<String> list = novelInfoDao.getRandIntroPageUrl(state);
		return list != null && list.size() > 0 ? list.get(0) : "";
	}

	@Override
	public boolean haveNovelInfo(String id) {
		List<NovelInfoModel> infos = new ArrayList<NovelInfoModel>();
		return infos != null && infos.size() > 0 ? true : false;
	}

}
