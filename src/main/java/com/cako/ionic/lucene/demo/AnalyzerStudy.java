package com.cako.ionic.lucene.demo;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class AnalyzerStudy {

	private static String str = "极客学院 ,Lucene案例开发";

	public static void print(Analyzer analyzer) {
		StringReader reader = new StringReader(str);
		try {
			TokenStream stream = analyzer.tokenStream("", reader);
			stream.reset();
			CharTermAttribute attribute = stream.getAttribute(CharTermAttribute.class);
			System.out.println("分词技术 ：" + analyzer.getClass());
			while (stream.incrementToken()) {
				System.out.print(attribute.toString() + "|");
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Analyzer analyzer = null;
		analyzer = new StandardAnalyzer();// 标准分词器
		print(analyzer);
		analyzer = new WhitespaceAnalyzer();// 空格分词器
		print(analyzer);
		analyzer = new SimpleAnalyzer();// 简单分词器
		print(analyzer);
		analyzer = new CJKAnalyzer();// 二分法分词器
		print(analyzer);
		analyzer = new KeywordAnalyzer();// 关键字分词器
		print(analyzer);
		analyzer = new StopAnalyzer();// 被忽略的分词器
		print(analyzer);
	}
}
