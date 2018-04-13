package com.pojo;
import javax.persistence.*;

@Entity
@Table(name="article_detail")
public class ArticleDetail {
	  @Id @GeneratedValue
	  @Column(name = "ad_id")
	  private Long id;
	  
	  @Column(name = "name")
	  private String name;
	  
	  @Column(name = "s3_folder_key")
	  private String s3FolderKey;
	  
	  
	  public Long getID() {
		  return id;
	  }
	  public void setID(Long id) {
		  this.id = id;
	  }
	  
	  public String getName() {
		  return name;
	  }
	  public void setName(String name) {
		  this.name = name;
	  }
	  public String getS3FolderKey() {
		  return s3FolderKey;
	  }
	  public void setS3FolderKey(String s3FolderKey) {
		  this.s3FolderKey = s3FolderKey;
	  }

	}