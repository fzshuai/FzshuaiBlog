package com.fzshuai.dao;

import com.fzshuai.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 软件二班傅同学
<<<<<<< HEAD
 * @date 2021-01-22 21:20
 */
public interface UserRepository extends JpaRepository<User, Long> {
=======
 * @description TODO
 * @date 2021-02-03 23:41
 */
public interface UserRepository extends JpaRepository<User,Long> {
>>>>>>> d30a2ee (项目第一次提交)

    User findByUsernameAndPassword(String username, String password);
}
