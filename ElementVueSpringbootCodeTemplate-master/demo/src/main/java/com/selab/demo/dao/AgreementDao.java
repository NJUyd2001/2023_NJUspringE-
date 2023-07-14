package com.selab.demo.dao;
import com.selab.demo.model.AgreementModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AgreementDao {
    @Insert("INSERT INTO selabspringe.agreement (client,trustee,legalrepresentative1,legalrepresentative2,name,date1,date2) VALUES (#{client},#{trustee},#{legalrepresentative1},#{legalrepresentative2},#{name},#{date1},#{date2})")
    @Options(useGeneratedKeys=true, keyProperty="AgID", keyColumn="AgID")
    public void insert(AgreementModel agreementModel);

    @Select("SELECT * FROM selabspringe.agreement WHERE AgID=#{AgID}")
    public List<AgreementModel> select(Integer AgID);

    @Select("SELECT AgID FROM selabspringe.agreement WHERE AgID=#{AgID}")
    public Integer select2(Integer AgID);

    @Update("UPDATE selabspringe.agreement SET client=#{client},trustee=#{trustee}, legalrepresentative1=#{legalrepresentative1}, legalrepresentative2=#{legalrepresentative2}, name=#{name},date1=#{date1},date2=#{date2}")
    public void update (AgreementModel agreementModel);

    @Delete("DELETE FROM selabspringe.agreement WHERE AgID = #{AgID}")
    public void delete(Integer AgID);

}
