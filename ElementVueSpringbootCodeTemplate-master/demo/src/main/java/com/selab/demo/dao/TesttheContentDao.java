package com.selab.demo.dao;
import com.selab.demo.model.TesttheContentModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TesttheContentDao {
    @Insert("INSERT INTO selabspringe.testthecontent(testid1,testid2,testid3,testid4,testid5,testid6) VALUES (#{testid1} ,#{testid2},#{testid3},#{testid4},#{testid5},#{testid6})")
    @Options(useGeneratedKeys=true, keyProperty="TID", keyColumn="TID")
    void insert(TesttheContentModel TesttheContentModel);

    @Select("SELECT * FROM selabspringe.testthecontent WHERE TID = #{TID}")
    List<TesttheContentModel> select(Integer TID);

    @Select("SELECT TID FROM selabspringe.testthecontent WHERE TID = #{TID}")
    Integer select2(Integer TID);

    @Update("UPDATE selabspringe.testthecontent SET testid1 = #{testid1}, testid2 = #{testid2},testid3=#{testid3},testid4=#{testid4},testid5=#{testid5},testid6=#{testid6} WHERE TID = #{TID}")
    void update(TesttheContentModel TesttheContentModel);

    @Delete("DELETE FROM selabspringe.testthecontent WHERE TID = #{TID}")
    void delete(Integer TID);

}
