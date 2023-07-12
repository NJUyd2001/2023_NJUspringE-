package com.selab.demo.dao;
import com.selab.demo.model.StableModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface StableDao {


    @Insert("INSERT INTO selabspringe.stable (milestonetasks,workload,start,end) VALUES (#{milestonetasks},#{workload},#{start},#{end})")
    @Options(useGeneratedKeys = true, keyProperty = "stableid", keyColumn = "stableid")
    void insert(StableModel stableModel);

    @Select("SELECT * FROM selabspringe.stable WHERE stableid = #{stableid}")
    List<StableModel> select(Integer stableid);

    @Select("SELECT stableid FROM selabspringe.stable WHERE stableid = #{stableid}")
    Integer select2(Integer stableid);

    @Update("UPDATE selabspringe.stable SET milestonetasks = #{milestonetasks},workload = #{workload}, start = #{start}, end = #{end} WHERE stableid = #{stableid}")
    void update(StableModel stableModel);


    @Delete("DELETE FROM selabspringe.stable WHERE stableid = #{stableid}")
    void delete(Integer stableid);
}