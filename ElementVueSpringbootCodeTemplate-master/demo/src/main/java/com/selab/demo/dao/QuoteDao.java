package com.selab.demo.dao;
import com.selab.demo.model.QuoteModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface QuoteDao {


    @Insert("INSERT INTO selabspringe.quote (time,softwarename,item,description,unitprice,ps,subtotalprice,tax,totalprice,provider) VALUES (#{time},#{softwarename},#{item},#{description},#{unitprice},#{ps},#{subtotalprice},#{tax},#{totalprice},#{provider})")
    @Options(useGeneratedKeys=true, keyProperty="QID", keyColumn="QID")
    void insert(QuoteModel quoteModel);

    @Select("SELECT * FROM selabspringe.quote WHERE QID = #{QID}")
    List<QuoteModel> findbyQID(Integer QID);

    @Select("SELECT QID FROM selabspringe.quote WHERE QID = #{QID}")
    Integer select2(Integer QID);

    @Update("UPDATE selabspringe.quote SET time = #{time},softwarename = #{softwarename}, item = #{item}, description = #{description}, unitprice = #{unitprice},ps =#{ps},subtotalprice=#{subtotalprice},tax=#{tax},totalprice=#{totalprice},provider=#{provider} WHERE QID = #{QID}")
    void update(QuoteModel quoteModel);


    @Delete("DELETE FROM selabspringe.quote WHERE QID = #{QID}")
    void delete(Integer QID);


}
