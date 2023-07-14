package com.selab.demo.dao;
import com.selab.demo.model.SoftwareDocCheckTableModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface SoftwareDocCheckTableDao {
    @Insert("INSERT INTO selabspringe.softwaredocchecktable(reviewcategories,reviewitem,reviewcontent,revieweresultexplanation,radio) VALUES (#{reviewcategories} ,#{reviewitem},#{reviewcontent},#{revieweresultexplanation},#{radio})")
    @Options(useGeneratedKeys=true, keyProperty="tableid", keyColumn="tableid")
    void insert(SoftwareDocCheckTableModel softwareDocCheckTableModel);

    @Select("SELECT * FROM selabspringe.softwaredocchecktable WHERE tableid = #{tableid}")
    List<SoftwareDocCheckTableModel> select(Integer tableid);

    @Select("SELECT tableid FROM selabspringe.softwaredocchecktable WHERE tableid = #{tableid}")
    Integer select2(Integer tableid);

    @Update("UPDATE selabspringe.softwaredocchecktable SET reviewcategories = #{reviewcategories}, reviewitem = #{reviewitem},reviewcontent=#{reviewcontent},revieweresultexplanation=#{revieweresultexplanation},radio=#{radio} WHERE tableid = #{tableid}")
    void update(SoftwareDocCheckTableModel softwareDocCheckTableModel);

    @Delete("DELETE FROM selabspringe.softwaredocchecktable WHERE tableid = #{tableid}")
    void delete(Integer tableid);
}
