package com.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.*;
import com.user.dao.*;
@Repository("userDAO")
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
  
  @Transactional
  public void saveUser(User user) {
	  getHibernateTemplate().save(user);
    }
  
  public User getUserByUsername(String userName) {
	  List list = getHibernateTemplate().find("from User where username=?", userName);
	  if (list != null && !list.isEmpty() && list.get(0) != null) {
		  return (User)list.get(0);
	  }else {
		  return null;
	  }
  }
  
  
/*  
  
    public User validateUser(Login login) {
    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
    + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
    
    
    
  } 


class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setAddress(rs.getString("address"));
    user.setPhone(rs.getInt("phone"));
    return user;
  }*/
}