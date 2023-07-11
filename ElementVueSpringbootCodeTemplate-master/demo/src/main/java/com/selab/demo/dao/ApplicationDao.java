package com.selab.demo.dao;

import com.selab.demo.model.ApplicationModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplicationDao {
    @Insert("INSERT INTO selabspringe.application (applicantID, processID, time, phone, testTYPE, sNAME, PA, PAE, PB, PB_type, mainfunction, USS, sDES, stestBASIS, elsestestBASIS, TESTINDEX, elseINDEX, scale_num, scale_score, scale_lines, sTYPE, ENVIRONMENTW, ENVIRONMENTL, ENVIRONMENTN, ENVIRONMENTE, ENVIRONMENT, ARCHITECTURE, hMEMORY, hHARDDISK, hELSEDEMAND, sOS, sVERSION, sLANGUAGE, sARCHITECTURE, sDATABASE, sMIDDLEWARE, sELSEDEMAND, MEDIUM, doc_path1, doc_path2, doc_path3, doc_path4, SAMPLEDELETE, EXDATE, auditinfor, version_num, hOPERATINGENVIRONMENT, sOPERATINGENVIRONMENT) VALUES (#{applicantID}, #{processID}, #{time}, #{phone}, #{testTYPE}, #{sNAME}, #{PA}, #{PAE}, #{PB}, #{PB_type}, #{mainfunction}, #{USS}, #{sDES}, #{stestBASIS}, #{elsestestBASIS}, #{TESTINDEX}, #{elseINDEX}, #{scale_num}, #{scale_score}, #{scale_lines}, #{sTYPE}, #{ENVIRONMENTW}, #{ENVIRONMENTL}, #{ENVIRONMENTN}, #{ENVIRONMENTE}, #{ENVIRONMENT}, #{ARCHITECTURE}, #{hMEMORY}, #{hHARDDISK}, #{hELSEDEMAND}, #{sOS}, #{sVERSION}, #{sLANGUAGE}, #{sARCHITECTURE}, #{sDATABASE}, #{sMIDDLEWARE}, #{sELSEDEMAND}, #{MEDIUM}, #{doc_path1}, #{doc_path2}, #{doc_path3}, #{doc_path4}, #{SAMPLEDELETE}, #{EXDATE},  #{auditinfor}, #{version_num}, #{hOPERATINGENVIRONMENT}, #{sOPERATINGENVIRONMENT})")
    @Options(useGeneratedKeys=true, keyProperty="AID", keyColumn="AID")
    void insertApp(ApplicationModel applicationModel);
    @Select("SELECT * FROM selabspringe.application WHERE applicantID=#{username} ")
    List<ApplicationModel> findbyuserA(int username);
    @Select("SELECT * FROM selabspringe.application WHERE processID=#{username} ")
    List<ApplicationModel> findbyprocess(int username);
    @Select("SELECT * FROM selabspringe.application WHERE AID=#{AID} ")
    List<ApplicationModel> findbyAID(int AID);
    @Select("SELECT AID FROM selabspringe.application WHERE AID=#{AID} ")
    Integer findbyAID2(int AID);
    @Select("SELECT AID FROM selabspringe.application")
    List<Integer> findAID();
    @Select("SELECT * FROM selabspringe.application")
    List<ApplicationModel> findALL();
    @Update("UPDATE selabspringe.application SET applicantID = #{applicantID}, processID = #{processID}, time = #{time}, phone = #{phone}, testTYPE = #{testTYPE}, sNAME = #{sNAME}, PA = #{PA}, PAE = #{PAE}, PB = #{PB}, PB_type = #{PB_type}, mainfunction = #{mainfunction}, USS = #{USS}, sDES = #{sDES}, stestBASIS = #{stestBASIS}, elsestestBASIS = #{elsestestBASIS}, TESTINDEX = #{TESTINDEX}, elseINDEX = #{elseINDEX}, scale_num = #{scale_num}, scale_score = #{scale_score}, scale_lines = #{scale_lines}, sTYPE = #{sTYPE}, ENVIRONMENTW = #{ENVIRONMENTW}, ENVIRONMENTL = #{ENVIRONMENTL}, ENVIRONMENTN = #{ENVIRONMENTN}, ENVIRONMENTE = #{ENVIRONMENTE}, ENVIRONMENT = #{ENVIRONMENT}, ARCHITECTURE = #{ARCHITECTURE}, hMEMORY = #{hMEMORY}, hHARDDISK = #{hHARDDISK}, hELSEDEMAND = #{hELSEDEMAND}, sOS = #{sOS}, sVERSION = #{sVERSION}, sLANGUAGE = #{sLANGUAGE}, sARCHITECTURE = #{sARCHITECTURE}, sDATABASE = #{sDATABASE}, sMIDDLEWARE = #{sMIDDLEWARE}, sELSEDEMAND = #{sELSEDEMAND}, MEDIUM = #{MEDIUM}, doc_path1 = #{doc_path1}, doc_path2 = #{doc_path2}, doc_path3 = #{doc_path3}, doc_path4 = #{doc_path4}, SAMPLEDELETE = #{SAMPLEDELETE}, EXDATE = #{EXDATE}, auditinfor = #{auditinfor}, version_num = #{version_num} WHERE AID=#{AID}")
    void updateapplication(ApplicationModel applicationModel);
    @Delete("DELETE FROM selabspringe.application WHERE AID = #{AID}")
    void deleteapplication(int AID);
    @Update("UPDATE selabspringe.application SET USS = #{USS}, version = #{version}, tableid = #{tableid} WHERE AID = #{AID}")
    void insertruleform(String USS,String version,String tableid,int AID);

    @Update("UPDATE selabspringe.application SET USS = #{USS}, version = #{version}, tableid = #{tableid} WHERE AID = #{AID}")
    void updateruleform(String USS,String version,String tableid,int AID);

    @Update("UPDATE selabspringe.application SET auditinfor = #{auditinfor}, confirmopinion = #{confirmopinion} WHERE AID = #{AID}")
    void insertopinion(String auditinfor,String confirmopinion,Integer AID);

    @Select("SELECT * FROM selabspringe.application WHERE AID=#{AID}")
    List<ApplicationModel> findopinion(Integer AID);

    @Update("UPDATE selabspringe.application SET auditID = #{auditID} WHERE AID = #{AID}")
    void insertauditinformation(Integer auditID,Integer AID);

    @Select("SELECT auditID FROM selabspringe.application WHERE AID=#{AID}")
    Integer findauditinformation(Integer AID);
}
