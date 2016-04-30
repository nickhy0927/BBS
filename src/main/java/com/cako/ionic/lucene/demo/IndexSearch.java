package com.cako.ionic.lucene.demo;

import java.io.File;
import java.nio.file.Path;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * 索引查询
 * 
 * @author DavisHy
 *
 */
public class IndexSearch {

	public static void main(String[] args) {
		Directory directory = null;
		Path path = new File("D:\\develop\\works\\java\\lecene").toPath();
		try {
			directory = FSDirectory.open(path);
			DirectoryReader reader = DirectoryReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			Analyzer analyzer = new StandardAnalyzer();
			QueryParser parser = new QueryParser("content", analyzer);
			Query query = parser.parse("不清楚");
			TopDocs docs = searcher.search(query, 10);
			if (docs != null) {
				System.out.println("符合条件文档的总数  :" + docs.totalHits);
				System.out.println("符合条件文档的总数  :" + docs.totalHits);
				ScoreDoc[] scoreDocs = docs.scoreDocs;
				for (int i = 0; i < scoreDocs.length; i++) {
					ScoreDoc scoreDoc = scoreDocs[i];
					Document document = searcher.doc(scoreDoc.doc);
					System.out.println(document.get("id"));
					System.out.println(document.get("content"));
					System.out.println(document.get("num"));

				}
			}
			directory.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
