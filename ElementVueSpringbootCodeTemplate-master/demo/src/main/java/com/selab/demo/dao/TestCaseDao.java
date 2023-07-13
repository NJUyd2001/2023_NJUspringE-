package com.selab.demo.dao;
import com.selab.demo.model.TestCaseModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper

public interface TestCaseDao {
    @Insert("INSERT INTO selabspringe.testcase(tableid) VALUES (#{tableid})")
    @Options(useGeneratedKeys=true, keyProperty="TCID", keyColumn="TCID")
    void insert(TestCaseModel testCaseModel);

    @Select("SELECT * FROM selabspringe.testcase WHERE TCID = #{TCID}")
    List<TestCaseModel> select(int TCID);

    @Select("SELECT TCID FROM selabspringe.testcase WHERE TCID = #{TCID}")
    Integer select2(int TCID);

    @Update("UPDATE selabspringe.testcase SET tableid=#{tableid} WHERE TCID = #{TCID}")
    void update(TestCaseModel testCaseModel);

    @Delete("DELETE FROM selabspringe.testcase WHERE TCID = #{TCID}")
    void delete(int TCID);
}
