package com.selab.demo.dao;
import com.selab.demo.model.TestRecordTableModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TestRecordTableDao {
    @Insert("INSERT INTO selabspringe.testrecordtable(num,checkcontent,description,radio) VALUES (#{num} ,#{checkcontent},#{description},#{radio})")
    @Options(useGeneratedKeys=true, keyProperty="tableid", keyColumn="tableid")
    void insert(TestRecordTableModel testRecordTableModel);

    @Select("SELECT * FROM selabspringe.testrecordtable WHERE tableid = #{tableid}")
    List<TestRecordTableModel> select(int TRID);

    @Select("SELECT tableid FROM selabspringe.testrecordtable WHERE tableid = #{tableid}")
    Integer select2(int tableid);

    @Update("UPDATE selabspringe.testrecordtable SET num = #{num}, checkcontent = #{checkcontent},description=#{description},radio=#{radio} WHERE tableid = #{tableid}")
    void update(TestRecordTableModel testRecordTableModel);

    @Delete("DELETE FROM selabspringe.testrecordtable WHERE tableid = #{tableid}")
    void delete(int tableid);
}
