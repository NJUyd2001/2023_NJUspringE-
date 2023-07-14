package com.selab.demo.dao;
import com.selab.demo.model.TestSoftModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestSoftDao {
    @Insert("INSERT INTO selabspringe.testsoft(softwarecategory,softwarename,edition) VALUES (#{softwarecategory} ,#{softwarename},#{edition})")
    @Options(useGeneratedKeys=true, keyProperty="softid", keyColumn="softid")
    void insert(TestSoftModel testSoftModel);

    @Select("SELECT * FROM selabspringe.testsoft WHERE softid = #{softid}")
    List<TestSoftModel> select(Integer softid);

    @Select("SELECT softid FROM selabspringe.testsoft WHERE softid = #{softid}")
    Integer select2(Integer softid);

    @Update("UPDATE selabspringe.testsoft SET softwarecategory = #{softwarecategory}, softwarename = #{softwarename},edition=#{edition} WHERE softid = #{softid}")
    void update(TestSoftModel testSoftModel);

    @Delete("DELETE FROM selabspringe.testsoft WHERE softid = #{softid}")
    void delete(Integer softid);
}
