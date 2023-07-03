package com.selab.demo.dao;
import com.selab.demo.model.AuditinformationModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface AuditinformationDao {
    @Insert("INSERT INTO selabspringe.auditinformation(security,finish,tool,testsample,requirementdocument,userdocument,operationducument,other,confirmopinion,opinionofacceptance,number,ps) VALUES (#{security}, #{finish}, #{tool}, #{testsample}, #{requirementdocument}, #{userdocument}, #{operationducument}, #{other}, #{confirmopinion}, #{opinionofacceptance}, #{number}, #{ps})")
    @Options(useGeneratedKeys=true, keyProperty="auditID", keyColumn="auditID")
    public void insert(AuditinformationModel auditinformationModel);

    @Select("SELECT * FROM selabspringe.auditinformation WHERE auditID = #{auditID}")
    public List<AuditinformationModel> find(Integer auditID);

    @Update("UPDATE selabspringe.auditinformation SET security=#{security},finish=#{finish},tool=#{tool},testsample=#{testsample},requirementdocument=#{requirementdocument},userdocument=#{userdocument},operationducument=#{operationducument},other=#{other},confirmopinion=#{confirmopinion},opinionofacceptance=#{opinionofacceptance},number=#{number},ps=#{ps} WHERE auditID=#{auditID}")
    public void update(AuditinformationModel auditinformationModel);

    @Delete("DELETE FROM selabspringe.auditinformation WHERE auditID = #{auditID}")
    public void delete(Integer auditID);

}
