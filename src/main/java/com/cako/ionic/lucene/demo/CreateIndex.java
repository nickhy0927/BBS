package com.cako.ionic.lucene.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class CreateIndex {

	public static void main(String[] args) {
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		OpenMode openMode = OpenMode.CREATE_OR_APPEND;
		config.setOpenMode(openMode);

		Directory directory = null;
		IndexWriter indexWriter = null;
		Path path = new File("D:\\develop\\works\\java\\lecene").toPath();
		try {
			directory = FSDirectory.open(path);
			indexWriter = new IndexWriter(directory, config);
			Document doc1 = new Document();
			doc1.add(new StringField("id", "1234567", Store.YES));
			doc1.add(new TextField("content", "你好今天在下雨，你看见了吗？", Store.YES));
			doc1.add(new IntField("num", 100, Store.YES));
			indexWriter.addDocument(doc1);
			Document doc2 = new Document();
			doc2.add(new StringField("id", "1234", Store.YES));
			doc2.add(new TextField("content", "你好今天在下雨，你看见了吗？不清楚，我没有去仔细观察", Store.YES));
			doc2.add(new IntField("num", 200, Store.YES));
			indexWriter.addDocument(doc2);
			Document doc3 = new Document();
			doc3.add(new StringField("id", "12", Store.YES));
			doc3.add(new TextField("content", "你好今天在下雨，你看见了吗？似乎明天还得下雨呢", Store.YES));
			doc3.add(new IntField("num", 300, Store.YES));
			indexWriter.addDocument(doc3);
			indexWriter.commit();

			indexWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
