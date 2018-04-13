package com.pojo;
import javax.persistence.*;

@Entity
@Table(name="article")
public class Article {
	  @Id @GeneratedValue
	  @Column(name = "a_id")
	  private Long id;
	  
	  @Column(name = "artcile_detail_id")
	  private Long articleDetailID;
	  
	  @Column(name = "portion_id")
	  private Long portionID;

	  @Column(name = "order_number")
	  private Long orderNumber;
	  
	  @Column(name = "s3Objectkey")
	  private String s3ObjectKey;
	  
	  
	  public Long getID() {
		  return id;
	  }
	  public void setID(Long id) {
		  this.id = id;
	  }
	  
	  public Long getArticleDetailID() {
		  return articleDetailID;
	  }
	  public void setArticleID(Long articleDetailID) {
		  this.articleDetailID = articleDetailID;
	  }
	  public Long getPortionID() {
		  return portionID;
	  }
	  public void setPortionID(Long portionID) {
		  this.portionID = portionID;
	  }
	  public Long getOrderNumber() {
		  return orderNumber;
	  }
	  public void setOrderNumber(Long orderNumber) {
		  this.orderNumber = orderNumber;
	  }
	  public String getS3ObjectKey() {
		  return s3ObjectKey;
	  }
	  public void setS3ObjectKey(String s3ObjectKey) {
		  this.s3ObjectKey = s3ObjectKey;
	  }

	}