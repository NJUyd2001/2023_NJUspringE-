package com.selab.demo.dao;
import com.selab.demo.model.TestCaseTableModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestCaseTableDao {
    @Insert("INSERT INTO selabspringe.testcasetable(testclassificaion,num,testcasedesign,stockdescription,expectedresult,designer,testtime) VALUES (#{testclassificaion} ,#{num},#{testcasedesign},#{stockdescription},#{expectedresult},#{designer},#{testtime})")
    @Options(useGeneratedKeys=true, keyProperty="tableid", keyColumn="tableid")
    void insert(TestCaseTableModel testCaseTableModel);

    @Select("SELECT * FROM selabspringe.testcasetable WHERE tableid = #{tableid}")
    List<TestCaseTableModel> select(Integer tableid);

    @Select("SELECT tableid FROM selabspringe.testcasetable WHERE tableid = #{tableid}")
    Integer select2(Integer tableid);

    @Update("UPDATE selabspringe.testcasetable SET testclassificaion = #{testclassificaion}, num = #{num},testcasedesign=#{testcasedesign},stockdescription=#{stockdescription},expectedresult=#{expectedresult},designer=#{designer},testtime=#{testtime} WHERE tableid = #{tableid}")
    void update(TestCaseTableModel testCaseTableModel);

    @Delete("DELETE FROM selabspringe.testcasetable WHERE tableid = #{tableid}")
    void delete(Integer tableid);
}
