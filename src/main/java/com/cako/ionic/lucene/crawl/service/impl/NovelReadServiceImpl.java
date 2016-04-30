package com.cako.ionic.lucene.crawl.service.impl;

import org.springframework.stereotype.Service;

import com.cako.ionic.lucene.crawl.modal.NovelReadModel;
import com.cako.ionic.lucene.crawl.service.NovelReadService;
import com.orm.commons.service.impl.DefaultAbstractService;

@Service(value = "novelReadService")
public class NovelReadServiceImpl extends DefaultAbstractService<NovelReadModel, String> implements NovelReadService {

}
