package com.selab.demo.dao;
import com.selab.demo.model.TestHardModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface TestHardDao {
    @Insert("INSERT INTO selabspringe.testhard(hardwarecategory,hardwarename,setting,quantity) VALUES (#{hardwarecategory} ,#{hardwarename},#{setting},#{quantity})")
    @Options(useGeneratedKeys=true, keyProperty="hardid", keyColumn="hardid")
    void insert(TestHardModel testHardModel);

    @Select("SELECT * FROM selabspringe.testhard WHERE hardid = #{hardid}")
    List<TestHardModel> select(int hardid);

    @Select("SELECT hardid FROM selabspringe.testhard WHERE hardid = #{hardid}")
    Integer select2(int hardid);

    @Update("UPDATE selabspringe.testhard SET hardwarecategory = #{hardwarecategory}, hardwarename = #{hardwarename},setting=#{setting},quantity=#{quantity} WHERE hardid = #{hardid}")
    void update(TestHardModel testHardModel);

    @Delete("DELETE FROM selabspringe.testhard WHERE hardid = #{hardid}")
    void delete(int hardid);
}
