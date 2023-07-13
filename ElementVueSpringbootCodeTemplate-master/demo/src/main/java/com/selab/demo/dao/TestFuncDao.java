package com.selab.demo.dao;
import com.selab.demo.model.TestFuncModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TestFuncDao {

    @Insert("INSERT INTO selabspringe.testfunc(functionmodule,functionrequirement,testresult) VALUES (#{functionmodule} ,#{functionrequirement},#{testresult})")
    @Options(useGeneratedKeys=true, keyProperty="testid", keyColumn="testid")
    void insert(TestFuncModel testFuncModel);

    @Select("SELECT * FROM selabspringe.testfunc WHERE testid = #{testid}")
    List<TestFuncModel> select(int testid);

    @Select("SELECT testid FROM selabspringe.testfunc WHERE testid = #{testid}")
    Integer select2(int testid);

    @Update("UPDATE selabspringe.testfunc SET functionmodule = #{functionmodule}, functionrequirement = #{functionrequirement},testresult=#{testresult} WHERE testid = #{testid}")
    void update(TestFuncModel testFuncModel);

    @Delete("DELETE FROM selabspringe.testfunc WHERE testid = #{testid}")
    void delete(int testid);
}
