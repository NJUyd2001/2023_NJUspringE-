        ruleForm1:{
            applicantID:'1',
            processID:'1',
            time:"2017-09-02 10:29:14",
            phone:"15968774896",
            TypeTest:[
                '软件确认测试',
              ],
            SoftWareName:'蔡徐坤炒粉事件',
            VersionNumber:'2.5',
            ClientChinese:'小黑子',
            ClientEnglish:'ikun',
            DevelopmentCompany:'C先生',
            AttributeOfCompany:"内资企业",
            SoftwareUserObjectDescription:'练习时长两年半',
            MainFunction:'炒粉不放鸡精',
            NeededStandard:[
                  "GB/T 25000.51-2016",
                ],
            NeededTechnicalIndex:[
                  "功能性",
                ],
            SoftWareSize:{
              Number:1,
              Point:2,
              RowNumber:3,
            },
            SoftWareType:["操纵系统",
                        ],
            RuntimeEnvironment:{
                Client:{
                OS:{
                  Windows:'xp',
                  Linux:'12108',
                  other:''
              },
              Mermory:'2048MB',
              Other:''
              },
              Server:{
                HardWare:{
                FrameWork:["PC服务器",],  
                Mermory:'1024',
                HardDisk:'why',
                OtherDisk:'to'
              },
              SoftWare:{
                OS:'ji',
                Versions:'ni',
                PL:'tai',
                FrameWork:["服务器端软件架构:C/S",],
                DataBase:'mei',
                MiddleWare:'oh',
                Other:'baby'
              },
              },
              NetWork:'zhi',  
               },
            SoftwareMedium:["U盘"],
            Document:'yin',
            SamplesSubmitted:["中心直接销毁"],
            WantedFinishTime:'',
        },









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
