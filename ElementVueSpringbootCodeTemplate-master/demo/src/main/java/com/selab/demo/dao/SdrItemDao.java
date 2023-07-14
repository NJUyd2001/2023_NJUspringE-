package com.selab.demo.dao;

import com.selab.demo.model.SoftwareDocReviewModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SdrItemDao {
    @Insert("INSERT INTO selabspringe.sdrtableitem(ReviewCategories, ReviewItem, ReviewContent, ReviewResultExplanation, radio) VALUES"+
            " (#{ReviewCategories}, #{ReviewItem}, #{ReviewContent}, #{ReviewResultExplanation}, #{radio})")
    @SelectKey(keyColumn = "ID", before = false, resultType = Integer.class, statement = {"select last_insert_id()"}, keyProperty = "ID")
    public void insert(SoftwareDocReviewModel.SdrItem sdrItem);
    @Select("SELECT * FROM sdrtableitem WHERE ID=#{ID}")
    public SoftwareDocReviewModel.SdrItem selectByID(Integer ID);
    @Select("SELECT * FROM sdrtableitem WHERE SDRID=#{SDRID}")
    public SoftwareDocReviewModel.SdrItem[] selectBySDRID(Integer SDRID);
    @Update("UPDATE sdrtableitem SET ReviewCategories=#{ReviewCategories}, ReviewItem=#{ReviewItem}, ReviewContent=#{ReviewContent}" +
            ", ReviewResultExplanation=#{ReviewResultExplanation}, radio=#{radio} WHERE ID=#{ID}")
    public void update(SoftwareDocReviewModel.SdrItem sdrItem);

    @Delete("DELETE FROM sdrtableitem WHERE ID=#{ID}")
    public void delete(Integer ID);
    @Delete("DELETE FROM sdrtableitem WHERE SDRID=#{SDRID}")
    public void deleteAll(Integer SDRID);
}
