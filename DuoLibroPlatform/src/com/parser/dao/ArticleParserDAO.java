package com.parser.dao;
import java.util.List;

import com.pojo.*;

public interface ArticleParserDAO {
	ArticleDetail getArticleDetail(final Long id);
	List<Article> getArticlesByDetailID(final Long id);
}

