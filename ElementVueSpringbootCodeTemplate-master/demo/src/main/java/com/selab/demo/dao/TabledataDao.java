package com.selab.demo.dao;

import com.selab.demo.model.TabledataModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TabledataDao {
    @Insert("INSERT INTO selabspringe.tabledata(name,id,functions) VALUES (#{name} ,#{id}, #{functions})")
    @Options(useGeneratedKeys=true, keyProperty="TID", keyColumn="TID")
    void insert(TabledataModel tablemodel);

    @Select("SELECT * FROM selabspringe.tabledata WHERE TID = #{TID}")
    List<TabledataModel> findbyTID(Integer TID);

    @Select("SELECT TID FROM selabspringe.tabledata WHERE TID = #{TID}")
    Integer findbyTID2(Integer TID);

    @Update("UPDATE selabspringe.tabledata SET id = #{id}, name = #{name}, functions =#{functions} WHERE TID = #{TID}")
    void update(TabledataModel tabledataModel);

    @Delete("DELETE FROM selabspringe.tabledata WHERE TID = #{TID}")
    void delete(Integer TID);


}
