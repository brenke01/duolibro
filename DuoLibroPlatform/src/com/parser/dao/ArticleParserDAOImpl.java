package com.parser.dao;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.pojo.Article;
import com.pojo.ArticleDetail;


public class ArticleParserDAOImpl extends HibernateDaoSupport implements ArticleParserDAO {

	
	public ArticleDetail getArticleDetail(final Long id) {
		  List list = getHibernateTemplate().find("from ArticleDetail where ad_id=?", id);
		  if (list != null && !list.isEmpty() && list.get(0) != null) {
			  return (ArticleDetail)list.get(0);
		  }else {
			  return null;
		  }
	  }

	public List<Article> getArticlesByDetailID(final Long id) {
		  List list = getHibernateTemplate().find("from Article where article_detail_id=?", id);
		  if (list != null && !list.isEmpty() && list.get(0) != null) {
			  return list;
		  }else {
			  return null;
		  }
	  }
}