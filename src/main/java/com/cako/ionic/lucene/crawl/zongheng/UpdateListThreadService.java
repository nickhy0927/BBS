package com.cako.ionic.lucene.crawl.zongheng;

import java.util.List;

public interface UpdateListThreadService {

	/**
	 * @param id
	 * @param state
	 * @Description: 更新简介信息的state值
	 */
	void updateInfoState(String id, Integer state);

	/**
	 * 将采集到的简介页url信息保存到数据库中
	 * 
	 * @param urls
	 */
	void saveInfoUrls(List<String> urls);

	void updateInfoUrls(String url);

}