package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.ApplicationDao;
import com.selab.demo.model.ApplicationModel;
import com.selab.demo.model.enums.testTYPE;
import com.selab.demo.model.enums.PB_type;
import com.selab.demo.model.enums.ARCHITECTURE;
import com.selab.demo.model.enums.sARCHITECTURE;
import com.selab.demo.model.enums.MEDIUM;
import com.selab.demo.model.enums.SAMPLEDELETE;
import com.selab.demo.model.enums.state;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class ApplicationService {

    @Autowired
    ApplicationDao applicationDao;
    private JSONArray stringcrack(String words, JSONArray array){
        if(words == null) return array;
        Integer i = words.length();
        Integer j = 0;
        while (i>j){
            String unit = new String();
            while(i>j&&words.charAt(j)!=','){
                unit += words.charAt(j);
                j++;
            }
            unit += '\0';
            array.add(unit);
            j++;
        }
        return array;
    }

    private String JSONrepack(String postJson){
        JSONArray jsonArray = JSONArray.parseArray(postJson);
        Integer r = jsonArray.size();
        JSONArray res = new JSONArray();
        if(r==null)
            return postJson;
        Integer i=0;
        while(i<r){
            JSONObject newjsonObject = new JSONObject();
            JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(jsonArray.get(i)));
            newjsonObject.put("AID",jsonObject.getString("aID"));
            newjsonObject.put("applicantID",jsonObject.getString("applicantID"));
            newjsonObject.put("processID",jsonObject.getString("processID"));
            newjsonObject.put("time",jsonObject.getDate("time"));
            newjsonObject.put("phone",jsonObject.getString("phone"));
            JSONArray typetest = new JSONArray();
            String testTYPE = jsonObject.getString("testTYPE");
            typetest = stringcrack(testTYPE, typetest) ;
            newjsonObject.put("TypeTest",typetest);
            newjsonObject.put("SoftWareName",jsonObject.getString("sNAME"));
            newjsonObject.put("VersionNumber",jsonObject.getString("version_num"));
            newjsonObject.put("ClientChinese",jsonObject.getString("pA"));
            newjsonObject.put("ClientEnglish",jsonObject.getString("pAE"));
            newjsonObject.put("DevelopmentCompany",jsonObject.getString("pB"));
            newjsonObject.put("AttributeOfCompany",jsonObject.getString("pB_type"));
            newjsonObject.put("SoftwareUserObjectDescription",jsonObject.getString("sDES"));
            newjsonObject.put("MainFunction",jsonObject.getString("mainfunction"));
            JSONArray neededstandard = new JSONArray();
            String stestBASIS = jsonObject.getString("stestBASIS");
            neededstandard = stringcrack(stestBASIS,neededstandard);
            newjsonObject.put("NeededStandard",neededstandard);
            JSONArray neededTechnicalIndex = new JSONArray();
            String TESTINDEX = jsonObject.getString("tESTINDEX");
            neededTechnicalIndex = stringcrack(TESTINDEX,neededTechnicalIndex);
            newjsonObject.put("NeededTechnicalIndex",neededTechnicalIndex);
            JSONObject softwaresize = new JSONObject();
            softwaresize.put("Number",jsonObject.getString("scale_num"));
            softwaresize.put("Point",jsonObject.getString("scale_score"));
            softwaresize.put("RowNumber",jsonObject.getString("scale_lines"));
            newjsonObject.put("SoftWareSize",softwaresize);
            JSONArray softwaretype = new JSONArray();
            String sTYPE = jsonObject.getString("sTYPE");
            neededstandard = stringcrack(stestBASIS,softwaretype);
            newjsonObject.put("SoftWareType",softwaretype);
            JSONObject runtimeenvironment = new JSONObject();
            JSONObject client = new JSONObject();
            JSONObject os = new JSONObject();
            os.put("windows",jsonObject.getString("eNVIRONMENTW"));
            os.put("Linux",jsonObject.getString("eNVIRONMENTL"));
            os.put("other",jsonObject.getString("eNVIRONMENTE"));
            client.put("OS",os);
            client.put("Mermory",jsonObject.getString("eNVIRONMENTN"));
            client.put("Other",jsonObject.getString("eNVIRONMENT"));
            runtimeenvironment.put("Client",client);
            JSONObject server = new JSONObject();
            JSONObject hardware = new JSONObject();
            JSONArray hardFramework = new JSONArray();
            String hOPERATINGENVIRONMENT = jsonObject.getString("hOPERATINGENVIRONMENT");
            hardFramework = stringcrack(hOPERATINGENVIRONMENT,hardFramework);
            hardware.put("Mermory",jsonObject.getString("hMEMORY"));
            hardware.put("HardDisk",jsonObject.getString("hHARDDISK"));
            hardware.put("OtherDisk",jsonObject.getString("hELSEDEMAND"));
            server.put("HardWare",hardware);
            JSONObject software = new JSONObject();
            software.put("OS",jsonObject.getString("sOS"));
            software.put("Versions",jsonObject.getString("sVERSION"));
            software.put("PL",jsonObject.getString("sLANGUAGE"));
            JSONArray softFramework = new JSONArray();
            String sOPERATINGENVIRONMENT = jsonObject.getString("sOPERATINGENVIRONMENT");
            softFramework = stringcrack(sOPERATINGENVIRONMENT,softFramework);
            software.put("FrameWork",softFramework);
            software.put("DataBase",jsonObject.getString("sDATABASE"));
            software.put("MiddleWare",jsonObject.getString("sMIDDLEWARE"));
            software.put("Other",jsonObject.getString("sELSEDEMAND"));
            runtimeenvironment.put("SoftWare",software);
            runtimeenvironment.put("NetWork",jsonObject.getString("sARCHITECTURE"));
            newjsonObject.put("RuntimeEnvironment",runtimeenvironment);
            JSONArray medium = new JSONArray();
            String MEDIUM = jsonObject.getString("mEDIUM");
            medium = stringcrack(MEDIUM,medium);
            newjsonObject.put("SoftwareMedium",medium);
            newjsonObject.put("Document",jsonObject.getString("doc_path1"));
            JSONArray samplessubmitted = new JSONArray();
            String SAMPLEDELETE = jsonObject.getString("sAMPLEDELETE");
            samplessubmitted = stringcrack(SAMPLEDELETE,samplessubmitted);
            newjsonObject.put("SamplesSubmitted",samplessubmitted);
            newjsonObject.put("WantedFinishTime",jsonObject.getString("eXDATE"));

            res.add(newjsonObject);
            ++i;
        }
        return JSON.toJSONString(res);
    }

    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer applicantID = jsonObject.getInteger("applicantID");
        Integer processID = jsonObject.getInteger("processID");
        Date time = jsonObject.getDate("time");
        String phone = jsonObject.getString("phone");
        String testTYPE  = new String();
        JSONArray typetest = jsonObject.getJSONArray("TypeTest");
        Integer r = typetest.size();
        if(r!=null){
            Integer i =0;
            while(i<r){
                testTYPE += typetest.get(i);
                if(i<r-1){
                    testTYPE += ',';
                }
                i++;
            }
        }
        String sNAME = jsonObject.getString("SoftWareName");
        String version_num = jsonObject.getString("VersionNumber");
        String PA = jsonObject.getString("ClientChinese");
        String PAE = jsonObject.getString("ClientEnglish");
        String PB = jsonObject.getString("DevelopmentCompany");
        String PB_type  = jsonObject.getString("AttributeOfCompany");
        String sDES = jsonObject.getString("SoftwareUserObjectDescription");
        String mainfunction = jsonObject.getString("MainFunction");
        JSONArray neededstandard = jsonObject.getJSONArray("NeededStandard");
        r = neededstandard.size();
        String stestBASIS = new String();
        if(r!=null){
            Integer i =0;
            while(i<r){
                stestBASIS += neededstandard.get(i);
                if(i<r-1){
                    stestBASIS += ',';
                }
                i++;
            }
        }
        JSONArray neededTechnicalIndex = jsonObject.getJSONArray("NeededTechnicalIndex");
        r = neededTechnicalIndex.size();
        String TESTINDEX = new String();
        if(r!=null){
            Integer i =0;
            while(i<r){
                TESTINDEX += neededTechnicalIndex.get(i);
                if(i<r-1){
                    TESTINDEX += ',';
                }
                i++;
            }
        }
        JSONObject softwaresize = jsonObject.getJSONObject("SoftWareSize");
        Integer scale_num = softwaresize.getInteger("Number");
        Integer scale_score = softwaresize.getInteger("Point");
        Integer scale_lines = softwaresize.getInteger("RowNumber");
        JSONArray softwaretype = jsonObject.getJSONArray("SoftWareType");
        String sTYPE = new String();
        r = softwaretype.size();
        if(r!=null){
            Integer i =0;
            while(i<r){
                sTYPE += softwaretype.get(i);
                if(i<r-1){
                    sTYPE += ',';
                }
                i++;
            }
        }
        JSONObject runtimeenvironment = jsonObject.getJSONObject("RuntimeEnvironment");
        JSONObject client = runtimeenvironment.getJSONObject("Client");
        JSONObject os = client.getJSONObject("OS");
        String ENVIRONMENTW = os.getString("Windows");
        String ENVIRONMENTL = os.getString("Linux");
        String ENVIRONMENTE = os.getString("other");
        String ENVIRONMENTN = client.getString("Mermory");
        String ENVIRONMENT = client.getString("Other");
        JSONObject server = runtimeenvironment.getJSONObject("Server");
        JSONObject hardware = server.getJSONObject("HardWare");
        JSONArray hardFramework = hardware.getJSONArray("FrameWork");
        String hOPERATINGENVIRONMENT = new String();
        r = hardFramework.size();
        if(r!=null){
            Integer i =0;
            while(i<r){
                hOPERATINGENVIRONMENT += hardFramework.get(i);
                if(i<r-1){
                    hOPERATINGENVIRONMENT += ',';
                }
                i++;
            }
        }
        String hMEMORY = hardware.getString("Mermory");
        String hHARDDISK = hardware.getString("HardDisk");
        String hELSEDEMAND = hardware.getString("OtherDisk");
        JSONObject software = server.getJSONObject("SoftWare");
        String sOS = software.getString("OS");
        String sVERSION = software.getString("Versions");
        String sLANGUAGE = software.getString("PL");
        JSONArray softFramework = software.getJSONArray("FrameWork");
        String sOPERATINGENVIRONMENT = new String();
        r = softFramework.size();
        if(r!=null){
            Integer i =0;
            while(i<r){
                sOPERATINGENVIRONMENT += softFramework.get(i);
                if(i<r-1){
                    sOPERATINGENVIRONMENT += ',';
                }
                i++;
            }
        }
        String sDATABASE = software.getString("DataBase");
        String sMIDDLEWARE = software.getString("MiddleWare");
        String sELSEDEMAND = software.getString("Other");
        String sARCHITECTURE  = runtimeenvironment.getString("NetWork");
        JSONArray medium = jsonObject.getJSONArray("SoftwareMedium");
        r = medium.size();
        String MEDIUM  = new String();
        if(r!=null){
            Integer i =0;
            while(i<r){
                MEDIUM += medium.get(i);
                if(i<r-1){
                    MEDIUM += ',';
                }
                i++;
            }
        }
        String doc_path1 = jsonObject.getString("Document");
        JSONArray samplessubmitted = jsonObject.getJSONArray("SamplesSubmitted");
        String SAMPLEDELETE  = new String();
        r = samplessubmitted.size();
        if(r!=null){
            Integer i =0;
            while(i<r){
                SAMPLEDELETE += samplessubmitted.get(i);
                if(i<r-1){
                    SAMPLEDELETE += ',';
                }
                i++;
            }
        }
        String EXDATE = jsonObject.getString("WantedFinishTime");


        String USS = jsonObject.getString("USS");
        String elsestestBASIS = jsonObject.getString("elsestestBASIS");
        String elseINDEX = jsonObject.getString("elseINDEX");
        ARCHITECTURE ARCHITECTURE  = jsonObject.getObject("ARCHITECTURE",ARCHITECTURE.class);

        String doc_path2 = jsonObject.getString("doc_path2");
        String doc_path3 = jsonObject.getString("doc_path3");
        String doc_path4 = jsonObject.getString("doc_path4");
        state t_state  = jsonObject.getObject("t_state",state.class);
        state m_state  = jsonObject.getObject("m_state",state.class);
        String auditinfor = jsonObject.getString("auditinfor");

        ApplicationModel applicationModel = new ApplicationModel(0,applicantID, processID, time, phone, testTYPE, sNAME, PA, PAE, PB, PB_type, USS, sDES, stestBASIS, elsestestBASIS, TESTINDEX, elseINDEX, scale_num, scale_score, scale_lines, sTYPE, ENVIRONMENTW, ENVIRONMENTL, ENVIRONMENTN, ENVIRONMENTE, ENVIRONMENT, ARCHITECTURE, hMEMORY, hHARDDISK, hELSEDEMAND, sOS, sVERSION, sLANGUAGE, sARCHITECTURE, sDATABASE, sMIDDLEWARE, sELSEDEMAND, MEDIUM, doc_path1, doc_path2, doc_path3, doc_path4, SAMPLEDELETE, EXDATE, t_state, m_state, auditinfor,version_num,hOPERATINGENVIRONMENT,sOPERATINGENVIRONMENT,mainfunction);
        applicationDao.insertApp(applicationModel);
        return "application inserted successfully";
    }

   public String checkbyuserA(String postJson){
       JSONObject jsonObject = JSONObject.parseObject(postJson);
       int username = jsonObject.getInteger("applicantID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyuserA(username)));
        return JSONrepack(JSON.toJSONString(applicationDao.findbyuserA(username)));
    }

    public String checkbyprocess(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        int username = jsonObject.getInteger("processID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyprocess(username)));
        return JSONrepack(JSON.toJSONString(applicationDao.findbyprocess(username)));
    }
    public String checkbyAID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        int AID = jsonObject.getInteger("AID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyAID(AID)));
        return JSONrepack(JSON.toJSONString(applicationDao.findbyAID(AID)));
    }
    public String updateapplication(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer AID = jsonObject.getInteger("AID");
        Integer applicantID = jsonObject.getInteger("applicantID");
        Integer processID = jsonObject.getInteger("processID");
        Date time = jsonObject.getDate("time");
        String phone = jsonObject.getString("phone");
        String testTYPE  = new String();
        JSONArray typetest = jsonObject.getJSONArray("TypeTest");
        Integer r = typetest.size();
        if(r!=null){
            Integer i =0;
            while(i<=r){
                testTYPE += typetest.get(i);
                if(i<r){
                    testTYPE += ',';
                }
                i++;
            }
        }
        String sNAME = jsonObject.getString("SoftWareName");
        String version_num = jsonObject.getString("VersionNumber");
        String PA = jsonObject.getString("ClientChinese");
        String PAE = jsonObject.getString("ClientEnglish");
        String PB = jsonObject.getString("DevelopmentCompany");
        String PB_type  = jsonObject.getString("AttributeOfCompany");
        String sDES = jsonObject.getString("SoftwareUserObjectDescription");
        String mainfunction = jsonObject.getString("MainFunction");
        JSONArray neededstandard = jsonObject.getJSONArray("NeededStandard");
        r = neededstandard.size();
        String stestBASIS = new String();
        if(r!=null){
            Integer i =0;
            while(i<=r){
                stestBASIS += neededstandard.get(i);
                if(i<r){
                    stestBASIS += ',';
                }
                i++;
            }
        }
        JSONArray neededTechnicalIndex = jsonObject.getJSONArray("NeededTechnicalIndex");
        r = neededTechnicalIndex.size();
        String TESTINDEX = new String();
        if(r!=null){
            Integer i =0;
            while(i<=r){
                TESTINDEX += neededTechnicalIndex.get(i);
                if(i<r){
                    TESTINDEX += ',';
                }
            }
        }
        JSONObject softwaresize = jsonObject.getJSONObject("SoftWareSize");
        Integer scale_num = softwaresize.getInteger("Number");
        Integer scale_score = softwaresize.getInteger("Point");
        Integer scale_lines = softwaresize.getInteger("RowNumber");
        JSONArray softwaretype = jsonObject.getJSONArray("SoftWareType");
        String sTYPE = new String();
        r = softwaretype.size();
        if(r!=null){
            Integer i =0;
            while(i<=r){
                sTYPE += softwaretype.get(i);
                if(i<r){
                    sTYPE += ',';
                }
                i++;
            }
        }
        JSONObject runtimeenvironment = jsonObject.getJSONObject("RuntimeEnvironment");
        JSONObject client = runtimeenvironment.getJSONObject("Client");
        JSONObject os = client.getJSONObject("OS");
        String ENVIRONMENTW = os.getString("Windows");
        String ENVIRONMENTL = os.getString("Linux");
        String ENVIRONMENTE = os.getString("other");
        String ENVIRONMENTN = client.getString("Mermory");
        String ENVIRONMENT = client.getString("Other");
        JSONObject server = runtimeenvironment.getJSONObject("Server");
        JSONObject hardware = server.getJSONObject("HardWare");
        JSONArray hardFramework = hardware.getJSONArray("FrameWork");
        String hOPERATINGENVIRONMENT = new String();
        r = hardFramework.size();
        if(r!=null){
            Integer i =0;
            while(i<=r){
                hOPERATINGENVIRONMENT += hardFramework.get(i);
                if(i<r){
                    hOPERATINGENVIRONMENT += ',';
                }
                i++;
            }
        }
        String hMEMORY = hardware.getString("Mermory");
        String hHARDDISK = hardware.getString("HardDisk");
        String hELSEDEMAND = hardware.getString("OtherDisk");
        JSONObject software = server.getJSONObject("SoftWare");
        String sOS = software.getString("OS");
        String sVERSION = software.getString("Versions");
        String sLANGUAGE = software.getString("PL");
        JSONArray softFramework = software.getJSONArray("FrameWork");
        String sOPERATINGENVIRONMENT = new String();
        r = softFramework.size();
        if(r!=null){
            Integer i =0;
            while(i<=r){
                sOPERATINGENVIRONMENT += softFramework.get(i);
                if(i<r){
                    sOPERATINGENVIRONMENT += ',';
                }
                i++;
            }
        }
        String sDATABASE = software.getString("DataBase");
        String sMIDDLEWARE = software.getString("MiddleWare");
        String sELSEDEMAND = software.getString("Other");
        String sARCHITECTURE  = runtimeenvironment.getString("NetWork");
        JSONArray medium = jsonObject.getJSONArray("SoftwareMedium");
        r = medium.size();
        String MEDIUM  = new String();
        if(r!=null){
            Integer i =0;
            while(i<=r){
                MEDIUM += medium.get(i);
                if(i<r){
                    MEDIUM += ',';
                }
                i++;
            }
        }
        String doc_path1 = jsonObject.getString("Document");
        JSONArray samplessubmitted = jsonObject.getJSONArray("SamplesSubmitted");
        String SAMPLEDELETE  = new String();
        r = samplessubmitted.size();
        if(r!=null){
            Integer i =0;
            while(i<=r){
                SAMPLEDELETE += samplessubmitted.get(i);
                if(i<r){
                    SAMPLEDELETE += ',';
                }
                i++;
            }
        }
        String EXDATE = jsonObject.getString("WantedFinishTime");


        String USS = jsonObject.getString("USS");
        String elsestestBASIS = jsonObject.getString("elsestestBASIS");
        String elseINDEX = jsonObject.getString("elseINDEX");
        ARCHITECTURE ARCHITECTURE  = jsonObject.getObject("ARCHITECTURE",ARCHITECTURE.class);

        String doc_path2 = jsonObject.getString("doc_path2");
        String doc_path3 = jsonObject.getString("doc_path3");
        String doc_path4 = jsonObject.getString("doc_path4");
        state t_state  = jsonObject.getObject("t_state",state.class);
        state m_state  = jsonObject.getObject("m_state",state.class);
        String auditinfor = jsonObject.getString("auditinfor");


        String result = applicationDao.findbyAID2(AID);
        if (result == null) {
            return "the application does not exist";
        }
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyAID(AID)));
        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(applicationDao.findbyAID(AID).get(0)) ) ;
        if(applicantID == null)
            applicantID = oldjsonObject.getInteger("applicantID");
        if(processID == null)
            processID = oldjsonObject.getInteger("processID");
        if(time == null)
            time = oldjsonObject.getDate("time");
        if(phone == null)
            phone = oldjsonObject.getString("phone");
        if(testTYPE == null)
            testTYPE  = oldjsonObject.getString("testTYPE");
        if(sNAME == null)
            sNAME = oldjsonObject.getString("sNAME");
        if(PA == null)
            PA = oldjsonObject.getString("pA");
        if(PAE == null)
            PAE = oldjsonObject.getString("pAE");
        if(PB == null)
            PB = oldjsonObject.getString("pB");
        if(PB_type == null)
            PB_type  = oldjsonObject.getString("pB_type");
        if(mainfunction == null)
            mainfunction = oldjsonObject.getString("mainfunction");
        if(USS == null)
            USS = oldjsonObject.getString("uSS");
        if(sDES==null)
            sDES = oldjsonObject.getString("sDES");
        if(stestBASIS == null)
            stestBASIS = oldjsonObject.getString("stestBASIS");
        if(elsestestBASIS == null)
            elsestestBASIS = oldjsonObject.getString("elsestestBASIS");
        if(TESTINDEX == null)
             TESTINDEX = oldjsonObject.getString("tESTINDEX");
        if(elseINDEX == null)
            elseINDEX = oldjsonObject.getString("elseINDEX");
        if(scale_num == null)
            scale_num = oldjsonObject.getInteger("scale_num");
        if(scale_score == null)
            scale_score = oldjsonObject.getInteger("scale_score");
        if(scale_lines == null)
            scale_lines = oldjsonObject.getInteger("scale_lines");
        if(sTYPE == null)
            sTYPE = oldjsonObject.getString("sTYPE");
        if(ENVIRONMENTW == null)
            ENVIRONMENTW = oldjsonObject.getString("eNVIRONMENTW");
        if(ENVIRONMENTL == null)
            ENVIRONMENTL = oldjsonObject.getString("eNVIRONMENTL");
        if(ENVIRONMENTN == null)
            ENVIRONMENTN = oldjsonObject.getString("eNVIRONMENTN");
        if(ENVIRONMENTE == null)
            ENVIRONMENTE = oldjsonObject.getString("eNVIRONMENTE");
        if(ENVIRONMENT == null)
            ENVIRONMENT = oldjsonObject.getString("eNVIRONMENT");
        if(ARCHITECTURE == null)
            ARCHITECTURE  = oldjsonObject.getObject("aRCHITECTURE",ARCHITECTURE.class);
        if(hMEMORY == null)
            hMEMORY = oldjsonObject.getString("hMEMORY");
        if(hHARDDISK == null)
            hHARDDISK = oldjsonObject.getString("hHARDDISK");
        if(hELSEDEMAND == null)
            hELSEDEMAND = oldjsonObject.getString("hELSEDEMAND");
        if(sOS == null)
            sOS = oldjsonObject.getString("sOS");
        if(sVERSION == null)
            sVERSION = oldjsonObject.getString("sVERSION");
        if(sLANGUAGE == null)
            sLANGUAGE = oldjsonObject.getString("sLANGUAGE");
        if(sARCHITECTURE == null)
            sARCHITECTURE  = oldjsonObject.getString("sARCHITECTURE");
        if(sDATABASE == null)
            sDATABASE = oldjsonObject.getString("sDATABASE");
        if(sMIDDLEWARE == null)
            sMIDDLEWARE = oldjsonObject.getString("sMIDDLEWARE");
        if(sELSEDEMAND == null)
            sELSEDEMAND = oldjsonObject.getString("sELSEDEMAND");
        if(MEDIUM == null)
            MEDIUM  = oldjsonObject.getString("mEDIUM");
        if(doc_path1 == null)
            doc_path1 = oldjsonObject.getString("doc_path1");
        if(doc_path2 == null)
            doc_path2 = oldjsonObject.getString("doc_path2");
        if(doc_path3 == null)
            doc_path3 = oldjsonObject.getString("doc_path3");
        if(doc_path4 == null)
            doc_path4 = oldjsonObject.getString("doc_path4");
        if(SAMPLEDELETE == null)
            SAMPLEDELETE  = oldjsonObject.getString("sAMPLEDELETE");
        if(EXDATE == null)
            EXDATE = oldjsonObject.getString("eXDATE");
        if(t_state == null)
            t_state  = oldjsonObject.getObject("t_state",state.class);
        if(m_state == null)
            m_state  = oldjsonObject.getObject("m_state",state.class);
        if(auditinfor == null)
            auditinfor = oldjsonObject.getString("auditinfor");
        if(version_num == null)
            version_num = oldjsonObject.getString("version_num");
        if(hOPERATINGENVIRONMENT == null)
            hOPERATINGENVIRONMENT = oldjsonObject.getString("hOPERATINGENVIRONMENT");
        if(sOPERATINGENVIRONMENT == null)   sOPERATINGENVIRONMENT = oldjsonObject.getString("sOPERATINGENVIRONMENT");


        ApplicationModel applicationModel = new ApplicationModel(AID,applicantID, processID, time, phone, testTYPE, sNAME, PA, PAE, PB, PB_type, USS, sDES, stestBASIS, elsestestBASIS, TESTINDEX, elseINDEX, scale_num, scale_score, scale_lines, sTYPE, ENVIRONMENTW, ENVIRONMENTL, ENVIRONMENTN, ENVIRONMENTE, ENVIRONMENT, ARCHITECTURE, hMEMORY, hHARDDISK, hELSEDEMAND, sOS, sVERSION, sLANGUAGE, sARCHITECTURE, sDATABASE, sMIDDLEWARE, sELSEDEMAND, MEDIUM, doc_path1, doc_path2, doc_path3, doc_path4, SAMPLEDELETE, EXDATE, t_state, m_state, auditinfor,version_num,hOPERATINGENVIRONMENT,sOPERATINGENVIRONMENT,mainfunction);


        applicationDao.updateapplication(applicationModel);


        return "update complete";
    }

    public String deleteapplication(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        int AID = jsonObject.getInteger("AID");
        String result = applicationDao.findbyAID2(AID);
        if (result == null) {
            return "the application does not exist";
        }
        applicationDao.deleteapplication(AID);
        return "delete complete";
    }
}




