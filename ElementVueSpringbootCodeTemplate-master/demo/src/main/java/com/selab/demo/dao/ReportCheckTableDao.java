package com.selab.demo.dao;
import com.selab.demo.model.ReportCheckTableModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ReportCheckTableDao {
    @Insert("INSERT INTO selabspringe.reportchecktable(num,checkcontent,description,radio) VALUES (#{num} ,#{checkcontent},#{description},#{radio})")
    @Options(useGeneratedKeys=true, keyProperty="tableid", keyColumn="tableid")
    void insert(ReportCheckTableModel reportCheckTableModel);

    @Select("SELECT * FROM selabspringe.reportchecktable WHERE tableid = #{tableid}")
    List<ReportCheckTableModel> select(int TRID);

    @Select("SELECT tableid FROM selabspringe.reportchecktable WHERE tableid = #{tableid}")
    Integer select2(int tableid);

    @Update("UPDATE selabspringe.reportchecktable SET num = #{num}, checkcontent = #{checkcontent},description=#{description},radio=#{radio} WHERE tableid = #{tableid}")
    void update(ReportCheckTableModel reportCheckTableModel);

    @Delete("DELETE FROM selabspringe.reportchecktable WHERE tableid = #{tableid}")
    void delete(int tableid);
}
