package com.selab.demo.dao;

import com.selab.demo.model.MessageModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;

@Mapper
public interface MessageDao {

    @Insert("INSERT INTO selabspringe.messages(sender_id,receiver_id,regTime,message,doc_ex_path) VALUES(#{sender_id}, #{receiver_id}, #{regTime}, #{message}, #{doc_ex_path})")
    void insert(MessageModel messageModel);

    @Select("SELECT * FROM selabspringe.messages WHERE MID = #{MID}")
    List<MessageModel> findbyMID(Integer MID);

    @Select("SELECT * FROM selabspringe.messages WHERE sender_id = #{sender_id}")
    List<MessageModel> finfbysender_id(Integer sender_id);

    @Select("SELECT * FROM selabspringe.messages WHERE receiver_id = #{receiver_id}")
    List<MessageModel> findbyreceiver_id(Integer receiver_id);

    @Select("SELECT message FROM selabspringe.messages WHERE MID = #{MID}")
    String findbyMID2(Integer MID);

    @Update("UPDATE selabspringe.messages SET sender_id = #{sender_id}, receiver_id = #{receiver_id}, regTime = #{regTime}, message = #{message}, doc_ex_path = #{doc_ex_path} WHERE MID = #{MID}")
    void update(MessageModel messageModel);

    @Delete("DELETE FROM selabspringe.messages WHERE MID = #{MID}")
    void delete(Integer MID);
}
