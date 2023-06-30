package com.selab.demo.dao;

import com.selab.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface UserDao {
    /*@TODO insert into username, phone and emailAddr tables*/
    @Insert("INSERT INTO selabspringe.user(nickname, emailAddr, password, phone, usertype) VALUES (#{nickname}, #{emailAddr}, #{password}, #{phone}, #{usertype})")
    void insert(User user) throws DataAccessException;
    @Select("SELECT * FROM selabspringe.user WHERE nickname=#{nickname} AND password=#{password} AND usertype='C'")
    public User customerLogin(String nickname, String password);
    @Select("SELECT * FROM selabspringe.user WHERE nickname=#{nickname} AND password=#{password} AND usertype!='C'")
    public User staffLogin(String nickname, String password);
    @Select("SELECT * FROM selabspringe.user WHERE usertype='C'")
    public List<User> selectAllCustomer();
    @Select("SELECT * FROM selabspringe.user WHERE usertype!='C'")
    public List<User> selectAllStaff();
    // select all
    @Select("SELECT * FROM selabspringe.user")
    public List<User> selectAll();


    @Update("<script>                                           "
            + "update selabspringe.user                         "
            + "<set>                                            "
            + "  <if test='new_nickname  != null'> nickname =#{new_nickname},   </if> "
            + "  <if test='new_password  != null'> password =#{new_password},   </if> "
            + "  <if test='new_emailAddr != null'> emailAddr=#{new_emailAddr},  </if> "
            + "  <if test='new_phone     != null'> phone    =#{new_phone},      </if> "
            + "  <if test='new_fax       != null'> USERFAX  =#{new_fax}         </if> "
            + "</set>                                           "
            + "where UID = #{UID}                               "
            + "</script>                                        ")

    void update(Integer UID, String new_nickname,
            String new_password, String new_emailAddr, String new_phone,
                         String new_fax) throws DataAccessException;

    @Delete("DELETE FROM user WHERE UID=#{UID}")
    void delete(Integer UID) throws DataAccessException;
    @Select("SELECT UID FROM user WHERE UID=#{UID}")
    public Integer findByUID(Integer UID);
}

