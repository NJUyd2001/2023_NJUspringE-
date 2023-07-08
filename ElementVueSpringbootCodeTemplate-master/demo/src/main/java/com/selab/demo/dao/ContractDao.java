package com.selab.demo.dao;
import com.selab.demo.model.ContractModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ContractDao {
    @Insert("INSERT INTO selabspringe.contract (itemname,client,trustee,qc,date,periodofvalidity,ddl,changenumber,changeday) VALUES(#{itemname},#{client},#{trustee},#{qc},#{date},#{periodofvalidity},#{ddl},#{changenumber},#{changeday})")
    @Options(useGeneratedKeys=true, keyProperty="CID", keyColumn="CID")
    public void insert(ContractModel contractModel);

    @Select("SELECT * FROM selabspringe.contract WHERE CID = #{CID}")
    public List<ContractModel> select(Integer CID);

    @Select("SELECT CID FROM selabspringe.contract WHERE CID = #{CID}")
    public Integer select2(Integer CID);

    @Update("UPDATE selabspringe.contract SET itemname = #{itemname},client = #{client},trustee = #{trustee},qc = #{qc},date = #{date},periodofvalidity = #{periodofvalidity},ddl = #{ddl},changenumber = #{changenumber},changeday = #{changeday} WHERE CID = #{CID}")
    public void update(ContractModel contractModel);

    @Delete("DELETE FROM selabspringe.contract WHERE CID = #{CID}")
    public void delete(Integer CID);
}
