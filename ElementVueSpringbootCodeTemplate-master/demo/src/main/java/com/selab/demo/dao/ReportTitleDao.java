package com.selab.demo.dao;
import com.selab.demo.model.ReportTitleModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ReportTitleDao {
    @Insert("INSERT INTO selabspringe.reporttitle (softwarename,versionnumber,client,typetest,date) VALUES(#{softwarename},#{versionnumber},#{client},#{typetest},#{date})")
    @Options(useGeneratedKeys=true, keyProperty="RTID", keyColumn="RTID")
    public void insert(ReportTitleModel reportTitleModel);

    @Select("SELECT * FROM selabspringe.reprottitle WHERE RTID = #{RTID}")
    public List<ReportTitleModel> select(Integer RTID);

    @Select("SELECT RTID FROM selabspringe.reprottitle WHERE RTID = #{RTID}")
    public Integer select2(Integer RTID);

    @Update("UPDATE selabspringe.reporttitle SET softwwarename=#{softearename},versionnumber=#{versionnumber},client=#{client},typetest=#{typetest},date=#{date} WHERE RTID = #{RTID}")
    public void update(ReportTitleModel reportTitleModel);

    @Delete("DELETE FROM selabspringe.reporttitle WHERE RTID = #{RTID}")
    public void delete(Integer RTID);
}
