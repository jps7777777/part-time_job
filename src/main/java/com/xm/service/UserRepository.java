package com.xm.service;

import com.xm.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with Intellij IDEA.
 *
 * @Author: Gabriel
 * @Date: 2018-10-08
 * @Desciption:
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    // TODO 不能使用
    @Transactional
    @Modifying
    @Query("update User a set " +
            "a.name = CASE WHEN :#{#user.name} IS NULL THEN a.name ELSE :#{#user.name} END ," +
            "a.passwd =  CASE WHEN :#{#user.passwd} IS NULL THEN a.passwd ELSE :#{#user.passwd} END " +
            "where a.id = :#{#user.id}")
    int update(@Param("User") User user);

}

