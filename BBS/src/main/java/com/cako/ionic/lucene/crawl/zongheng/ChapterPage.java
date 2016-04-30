/**  
*@Description:     
*/
package com.cako.ionic.lucene.crawl.zongheng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cako.ionic.lucene.crawl.CrawlBase;
import com.cako.ionic.lucene.crawl.modal.NovelChapter;
import com.cako.ionic.lucene.util.ParseMD5;
import com.cako.ionic.lucene.util.RegexUtil;
import com.orm.commons.utils.JsonMapper;

public class ChapterPage extends CrawlBase {
	// 请求头信息
	private static HashMap<String, String> params;
	// 章节信息正则表达式
	private static final String CHAPTER = "<td class=\"chapterBean\" chapterId=\"\\d*\" chapterName=\"(.*?)\" chapterLevel=\"\\d*\" wordNum=\"(.*?)\" updateTime=\"(\\d*?)\"><a href=\"(.*?)\" title=\".*?\">";
	// 提取的内容在正则表达式中的位置
	private static final int[] array = { 1, 2, 3, 4 };

	static {
		params = new HashMap<String, String>();
		params.put("Referer", "http://book.zongheng.com");
		params.put("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36");
		params.put("Host", "book.zongheng.com");
	}

	public ChapterPage(String url) {
		readPageByGet(url, params, "utf-8");
	}

	/**
	 * @return
	 * @Author:lulei
	 * @Description: 返回小说章节列表页信息
	 */
	public List<NovelChapter> analyzer() {
		List<NovelChapter> list = new ArrayList<NovelChapter>();
		String dealStr = getPageSourceCode();
		String regexStr = CHAPTER;
		if (dealStr != null && regexStr != null && array != null) {
			Pattern pattern = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			Matcher matcher = pattern.matcher(dealStr);
			int j = 0;
			while (matcher.find() && j <= 15) {
				String[] ss = new String[array.length];
				for (int i = 0; i < array.length; i++) {
					ss[i] = matcher.group(array[i]).trim();
				}
				System.out.println(new JsonMapper().toJson(ss));
				j++;
				list.add(analyzer(ss, j));
			}
		}

		return list;
	}

	/**
	 * @param array
	 * @param i
	 * @return
	 * @Author:lulei
	 * @Description: 返回小说章节信息
	 */
	private NovelChapter analyzer(String[] array, int i) {
		NovelChapter bean = new NovelChapter();
		bean.setUrl(array[3]);
		String string = ParseMD5.parseStrToMD5(bean.getUrl());
		bean.setUrlMd5(string);
		bean.setTitle(array[0]);
		bean.setWordCount(Integer.parseInt(array[1]));
		bean.setChapterTime(Long.parseLong(array[2]));
		bean.setChapterId(i);
		return bean;
	}

	/**
	 * @return
	 * @Author:lulei
	 * @Description: 获取章节信息：章节名、字数、更新时间、阅读页地址
	 */
	public List<String[]> getChapters() {
		return RegexUtil.getList(getPageSourceCode(), CHAPTER, array);
	}
}
