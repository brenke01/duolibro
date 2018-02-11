
package com.user.dao;
import com.pojo.*;

public interface UserDAO {
 void saveUser(User user);
  User getUserByUsername(String username);
}