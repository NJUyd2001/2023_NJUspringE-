package com.selab.demo.dao;
import com.selab.demo.model.SampleCheckModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface SampleCheckDao {
    @Insert("INSERT INTO selabspringe.samplecheck (views,pass) VALUES(#{views},#{pass})")
    @Options(useGeneratedKeys=true, keyProperty="SID", keyColumn="SID")
    public void insert(SampleCheckModel sampleCheckModel);

    @Select("SELECT * FROM selabspringe.samplecheck WHERE SID = #{SID}")
    public List<SampleCheckModel> select(Integer SID);

    @Select("SELECT SID FROM selabspringe.samplecheck WHERE SID = #{SID}")
    public Integer select2(Integer SID);

    @Update("UPDATE selabspringe.samplecheck SET views=#{views},pass=#{pass} WHERE SID = #{SID}")
    public void update(SampleCheckModel sampleCheckModel);

    @Delete("DELETE FROM selabspringe.samplecheck WHERE SID = #{SID}")
    public void delete(Integer SID);

}
