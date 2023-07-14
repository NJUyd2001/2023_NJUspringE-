package com.selab.demo.dao;
import com.selab.demo.model.SoftwareDocCheckModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface SoftwareDocCheckDao {
    @Insert("INSERT INTO selabspringe.softwaredoccheck(tableid) VALUES (#{tableid})")
    @Options(useGeneratedKeys=true, keyProperty="SCID", keyColumn="SCID")
    void insert(SoftwareDocCheckModel softwareDocCheckModel);

    @Select("SELECT * FROM selabspringe.softwaredoccheck WHERE SCID = #{SCID}")
    List<SoftwareDocCheckModel> select(Integer SCID);

    @Select("SELECT SCID FROM selabspringe.softwaredoccheck WHERE SCID = #{SCID}")
    Integer select2(Integer SCID);

    @Update("UPDATE selabspringe.softwaredoccheck SET tableid = #{tableid} WHERE SCID = #{SCID}")
    void update(SoftwareDocCheckModel softwareDocCheckModel);

    @Delete("DELETE FROM selabspringe.softwaredoccheck WHERE SCID = #{SCID}")
    void delete(Integer SCID);
}
