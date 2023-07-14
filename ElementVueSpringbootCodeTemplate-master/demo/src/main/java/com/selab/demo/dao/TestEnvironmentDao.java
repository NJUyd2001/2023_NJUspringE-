package com.selab.demo.dao;
import com.selab.demo.model.TestEnvironmentModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestEnvironmentDao {

    @Insert("INSERT INTO selabspringe.testenvironment(hardid,softid,neededstandard,referencematerial) VALUES (#{hardid} ,#{softid},#{neededstandard},#{referencematerial})")
    @Options(useGeneratedKeys=true, keyProperty="TEID", keyColumn="TEID")
    void insert(TestEnvironmentModel testEnvironmentModel);

    @Select("SELECT * FROM selabspringe.testenvironment WHERE TEID = #{TEID}")
    List<TestEnvironmentModel> select(Integer TEID);

    @Select("SELECT TEID FROM selabspringe.testenvironment WHERE TEID = #{TEID}")
    Integer select2(Integer TEID);

    @Update("UPDATE selabspringe.testenvironment SET hardid = #{hardid}, softid = #{softid},neededstandard=#{neededstandard},referencematerial=#{referencematerial} WHERE TEID = #{TEID}")
    void update(TestEnvironmentModel testEnvironmentModel);

    @Delete("DELETE FROM selabspringe.testenvironment WHERE TEID = #{TEID}")
    void delete(Integer TEID);
}
