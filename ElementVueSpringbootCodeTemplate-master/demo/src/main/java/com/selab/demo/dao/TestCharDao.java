package com.selab.demo.dao;
import com.selab.demo.model.TestCharModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TestCharDao {
    @Insert("INSERT INTO selabspringe.testchar(testcharacteristic,testspecification,testresult) VALUES (#{testcharacteristic} ,#{testspecification},#{testresult})")
    @Options(useGeneratedKeys=true, keyProperty="testid", keyColumn="testid")
    void insert(TestCharModel testCharModel);

    @Select("SELECT * FROM selabspringe.testchar WHERE testid = #{testid}")
    List<TestCharModel> select(Integer testid);

    @Select("SELECT testid FROM selabspringe.testchar WHERE testid = #{testid}")
    Integer select2(Integer testid);

    @Update("UPDATE selabspringe.testchar SET testcharacteristic = #{testcharacteristic}, testspecification = #{testspecification},testresult=#{testresult} WHERE testid = #{testid}")
    void update(TestCharModel testCharModel);

    @Delete("DELETE FROM selabspringe.testchar WHERE testid = #{testid}")
    void delete(Integer testid);
}
