package com.parser.service;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.util.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parser.dao.ArticleParserDAO;

@Service("ArticleParserService")
@Transactional
public class ArticleParserService{
	
    private ArticleParserDAO articleParserDAO;
    
    public void setArticleParserDAO(ArticleParserDAO dao){
    	this.articleParserDAO = dao;
    	}
    public String getArticle() throws IOException {
    	String article = "";
    	Properties prop = new Properties();
    	InputStream input = null;
    	String s3Key = "";
    	String s3SecretKey = "";
    	try {
    		input = new FileInputStream(".\\src\\resources\\config.properties");

    		//load a properties file
    		prop.load(input);

    		// get the property value and print it out
    		s3Key = prop.getProperty("s3Key");
    		s3SecretKey = prop.getProperty("s3SecretKey");
    		input.close();
        	BasicAWSCredentials awsCreds = new BasicAWSCredentials(s3Key, s3SecretKey);
        	AmazonS3 s3 = AmazonS3ClientBuilder.standard()
        		    .withRegion("us-east-1")
        		    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
        		    .build();
        	ListObjectsV2Result result = s3.listObjectsV2("duolibro-articles");
        	List<S3ObjectSummary> objects = result.getObjectSummaries();
        	{for (S3ObjectSummary os: objects) {
        		System.out.println("* " + os.getKey());
        	}}
        	try {
        	    S3Object o = s3.getObject("duolibro-articles", "loremipsum/loremipsum_1");
        	    S3ObjectInputStream s3is = o.getObjectContent();
        	    byte[] read_buf = IOUtils.toByteArray(s3is);
        	    article = new String(read_buf, "UTF-8");
        	    
        	    s3is.close();
        	    return article;

        	} catch (AmazonServiceException e) {
        	    System.err.println(e.getErrorMessage());
        	} catch (FileNotFoundException e) {
        	    System.err.println(e.getMessage());
        	} catch (IOException e) {
        	    System.err.println(e.getMessage());
        	}

    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}

        return article;

    }
}