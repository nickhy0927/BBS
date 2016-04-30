package com.cako.ionic.lucene.crawl.zongheng.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cako.ionic.lucene.crawl.modal.NovelInfoModel;
import com.cako.ionic.lucene.crawl.service.NovelInfoService;
import com.cako.ionic.lucene.crawl.zongheng.UpdateList;
import com.cako.ionic.lucene.crawl.zongheng.UpdateListThreadService;
import com.cako.ionic.lucene.util.ParseMD5;

@Service(value = "updateListThreadService")
public class UpdateListThreadServiceImpl implements UpdateListThreadService {

	@Autowired
	public NovelInfoService novelInfoService;

	/**
	 * @param id
	 * @return
	 * @Description: 判断小说简介信息是否存在
	 */
	private boolean haveNovelInfo(String id) {
		try {
			NovelInfoModel novelInfoModel = novelInfoService.get(id);
			return novelInfoModel == null ? false : true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @param id
	 * @param state
	 * @Description: 更新简介信息的state值
	 */
	@Override
	public void updateInfoState(String id, Integer state) {
		try {
			NovelInfoModel model = novelInfoService.get(id);
			model.setState(state);
			novelInfoService.save(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @param url
	 * @Description:将采集到的简介页url保存到数据库中
	 */
	private void insertInfoUrl(String id, String url) {
		try {
			NovelInfoModel model = new NovelInfoModel();
			model.setUrl(url);
			model.setId(id);
			model.setState(1);
			novelInfoService.save(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将采集到的简介页url信息保存到数据库中
	 * 
	 * @param urls
	 */
	@Override
	public void saveInfoUrls(List<String> urls) {
		if (urls == null || urls.size() < 1) {
			return;
		}
		for (String url : urls) {
			String id = ParseMD5.parseStrToMD5(url);
			if (haveNovelInfo(id)) {
				updateInfoState(id, 1);
			} else {
				insertInfoUrl(id, url);
			}
		}
	}

	@Override
	public void updateInfoUrls(String url) {
		UpdateList updateList = new UpdateList(url);
		// 获取更新列表页URL信息
		List<String> urls = updateList.getPageUrl(true);
		saveInfoUrls(urls);
	}

}
