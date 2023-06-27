# Application接口文档
author:李晨博

注意！本文档提到的所有接口都应该使用post方法


## /application/insert

增加一个新的application项目

输入示例：
{
    "applicantID":"1111332",
    "processID":"222",
    "time":"2017-09-02 10:29:14",
    "phone":"1",
    "testTYPE":"C",
    "sNAME":"1",
    "PA":"1",
    "PAE":"1",
    "PB":"1",
    "PB_type":"D",
    "else_type":"1",
    "USS":"1",
    "sDES":"1",
    "stestBASIS":"1",
    "elsestestBASIS":"1",
    "TESTINDEX":"1",
    "elseINDEX":"1",
    "scale_num":"1",    
    "scale_score":"1",
    "scale_lines":"1",
    "sTYPE":"1",
    "ENVIRONMENTW":"1",
    "ENVIRONMENTL":"1",
    "ENVIRONMENTN":"1",
    "ENVIRONMENTE":"1",
    "ENVIRONMENT":"1",
    "ARCHITECTURE":"U",
    "hMEMORY":"1",
    "hHARDDISK":"1",
    "hELSEDEMAND":"1",
    "sOS":"1",
    "sVERSION":"1",
    "sLANGUAGE":"1",
    "sARCHITECTURE":"C",
    "sDATABASE":"1",
    "sMIDDLEWARE":"1",
    "sELSEDEMAND":"1",
    "MEDIUM":"E",
    "doc_path1":"E",
    "doc_path2":"E",
    "doc_path3":"E",
    "doc_path4":"E",
    "SAMPLEDELETE":"A",
    "EXDATE":"E",
    "t_state":"A",
    "m_state":"A",
    "auditinfor":"E"
}
为空的部分可以直接不加入，或者写为""

输出：application inserted successfully

# /application/checkbyapplicant
根据applicant项查找所有符合的aplication

输入示例：
{
    "applicant":"3"
}

输出：所有符合条件的applicant组成的list，如果没有，则输出空list
输出示例1：（为空）
[
    "[]"
]

输出示例2：
["[{\"aID\":5,\"aRCHITECTURE\":\"U\",\"applicantID\":3,\"auditinfor\":\"E\",\"doc_path1\":\"E\",\"doc_path2\":\"E\",\"doc_path3\":\"E\",\"doc_path4\":\"E\",\"eNVIRONMENT\":\"1\",\"eNVIRONMENTE\":\"1\",\"eNVIRONMENTL\":\"1\",\"eNVIRONMENTN\":\"1\",\"eNVIRONMENTW\":\"1\",\"eXDATE\":\"E\",\"elseINDEX\":\"1\",\"else_type\":\"1\",\"elsestestBASIS\":\"1\",\"hELSEDEMAND\":\"1\",\"hHARDDISK\":\"1\",\"hMEMORY\":\"1\",\"mEDIUM\":\"E\",\"m_state\":\"A\",\"pA\":\"1\",\"pAE\":\"1\",\"pB\":\"1\",\"pB_type\":\"D\",\"phone\":\"1\",\"processID\":23,\"sAMPLEDELETE\":\"A\",\"sARCHITECTURE\":\"C\",\"sDATABASE\":\"1\",\"sDES\":\"1\",\"sELSEDEMAND\":\"1\",\"sLANGUAGE\":\"1\",\"sMIDDLEWARE\":\"1\",\"sNAME\":\"1\",\"sOS\":\"1\",\"sTYPE\":\"1\",\"sVERSION\":\"1\",\"scale_lines\":1,\"scale_num\":1,\"scale_score\":1,\"stestBASIS\":1,\"tESTINDEX\":1,\"t_state\":\"A\",\"testTYPE\":\"C\",\"time\":1504319354000,\"uSS\":\"1\"}]"]

输出示例3：
["[{\"aID\":2,\"aRCHITECTURE\":\"U\",\"applicantID\":3,\"auditinfor\":\"E\",\"doc_path1\":\"E\",\"doc_path2\":\"E\",\"doc_path3\":\"E\",\"doc_path4\":\"E\",\"eNVIRONMENT\":\"1\",\"eNVIRONMENTE\":\"1\",\"eNVIRONMENTL\":\"1\",\"eNVIRONMENTN\":\"1\",\"eNVIRONMENTW\":\"1\",\"eXDATE\":\"E\",\"elseINDEX\":\"1\",\"else_type\":\"1\",\"elsestestBASIS\":\"1\",\"hELSEDEMAND\":\"1\",\"hHARDDISK\":\"1\",\"hMEMORY\":\"1\",\"mEDIUM\":\"E\",\"m_state\":\"A\",\"pA\":\"1\",\"pAE\":\"1\",\"pB\":\"1\",\"pB_type\":\"D\",\"phone\":\"1\",\"processID\":222,\"sAMPLEDELETE\":\"A\",\"sARCHITECTURE\":\"C\",\"sDATABASE\":\"1\",\"sDES\":\"1\",\"sELSEDEMAND\":\"1\",\"sLANGUAGE\":\"1\",\"sMIDDLEWARE\":\"1\",\"sNAME\":\"1\",\"sOS\":\"1\",\"sTYPE\":\"1\",\"sVERSION\":\"1\",\"scale_lines\":1,\"scale_num\":1,\"scale_score\":1,\"stestBASIS\":1,\"tESTINDEX\":1,\"t_state\":\"A\",\"testTYPE\":\"C\",\"time\":1504319354000,\"uSS\":\"1\"},{\"aID\":5,\"aRCHITECTURE\":\"U\",\"applicantID\":3,\"auditinfor\":\"E\",\"doc_path1\":\"E\",\"doc_path2\":\"E\",\"doc_path3\":\"E\",\"doc_path4\":\"E\",\"eNVIRONMENT\":\"1\",\"eNVIRONMENTE\":\"1\",\"eNVIRONMENTL\":\"1\",\"eNVIRONMENTN\":\"1\",\"eNVIRONMENTW\":\"1\",\"eXDATE\":\"E\",\"elseINDEX\":\"1\",\"else_type\":\"1\",\"elsestestBASIS\":\"1\",\"hELSEDEMAND\":\"1\",\"hHARDDISK\":\"1\",\"hMEMORY\":\"1\",\"mEDIUM\":\"E\",\"m_state\":\"A\",\"pA\":\"1\",\"pAE\":\"1\",\"pB\":\"1\",\"pB_type\":\"D\",\"phone\":\"1\",\"processID\":23,\"sAMPLEDELETE\":\"A\",\"sARCHITECTURE\":\"C\",\"sDATABASE\":\"1\",\"sDES\":\"1\",\"sELSEDEMAND\":\"1\",\"sLANGUAGE\":\"1\",\"sMIDDLEWARE\":\"1\",\"sNAME\":\"1\",\"sOS\":\"1\",\"sTYPE\":\"1\",\"sVERSION\":\"1\",\"scale_lines\":1,\"scale_num\":1,\"scale_score\":1,\"stestBASIS\":1,\"tESTINDEX\":1,\"t_state\":\"A\",\"testTYPE\":\"C\",\"time\":1504319354000,\"uSS\":\"1\"},{\"aID\":11,\"aRCHITECTURE\":\"U\",\"applicantID\":3,\"auditinfor\":\"E\",\"doc_path1\":\"E\",\"doc_path2\":\"E\",\"doc_path3\":\"E\",\"doc_path4\":\"E\",\"eNVIRONMENT\":\"1\",\"eNVIRONMENTE\":\"1\",\"eNVIRONMENTL\":\"1\",\"eNVIRONMENTN\":\"1\",\"eNVIRONMENTW\":\"1\",\"eXDATE\":\"E\",\"elseINDEX\":\"1\",\"else_type\":\"1\",\"elsestestBASIS\":\"1\",\"hELSEDEMAND\":\"1\",\"hHARDDISK\":\"1\",\"hMEMORY\":\"1\",\"mEDIUM\":\"E\",\"m_state\":\"A\",\"pA\":\"1\",\"pAE\":\"1\",\"pB\":\"1\",\"pB_type\":\"D\",\"phone\":\"1\",\"processID\":223,\"sAMPLEDELETE\":\"A\",\"sARCHITECTURE\":\"C\",\"sDATABASE\":\"1\",\"sDES\":\"1\",\"sELSEDEMAND\":\"1\",\"sLANGUAGE\":\"1\",\"sMIDDLEWARE\":\"1\",\"sNAME\":\"1\",\"sOS\":\"1\",\"sTYPE\":\"1\",\"sVERSION\":\"1\",\"scale_lines\":1,\"scale_num\":1,\"scale_score\":1,\"stestBASIS\":1,\"tESTINDEX\":1,\"t_state\":\"A\",\"testTYPE\":\"C\",\"time\":1504319354000,\"uSS\":\"1\"},{\"aID\":13,\"aRCHITECTURE\":\"U\",\"applicantID\":3,\"auditinfor\":\"E\",\"doc_path1\":\"E\",\"doc_path2\":\"E\",\"doc_path3\":\"E\",\"doc_path4\":\"E\",\"eNVIRONMENT\":\"1\",\"eNVIRONMENTE\":\"1\",\"eNVIRONMENTL\":\"1\",\"eNVIRONMENTN\":\"1\",\"eNVIRONMENTW\":\"1\",\"eXDATE\":\"E\",\"elseINDEX\":\"1\",\"else_type\":\"1\",\"elsestestBASIS\":\"1\",\"hELSEDEMAND\":\"1\",\"hHARDDISK\":\"1\",\"hMEMORY\":\"1\",\"mEDIUM\":\"E\",\"m_state\":\"A\",\"pA\":\"1\",\"pAE\":\"1\",\"pB\":\"1\",\"pB_type\":\"D\",\"phone\":\"1\",\"processID\":223,\"sAMPLEDELETE\":\"A\",\"sARCHITECTURE\":\"C\",\"sDATABASE\":\"1\",\"sDES\":\"1\",\"sELSEDEMAND\":\"1\",\"sLANGUAGE\":\"1\",\"sMIDDLEWARE\":\"1\",\"sNAME\":\"1\",\"sOS\":\"1\",\"sTYPE\":\"1\",\"sVERSION\":\"1\",\"scale_lines\":1,\"scale_num\":1,\"scale_score\":1,\"stestBASIS\":1,\"tESTINDEX\":1,\"t_state\":\"A\",\"testTYPE\":\"C\",\"time\":1504319354000,\"uSS\":\"1\"}]"]

# #/application/checkbyprocess
根据process值查找所有符合的application

输入示例：
{
    "processID":"23"
}

输出：所有符合条件的applicant组成的list，如果没有，则输出空list

输出示例1：（为空）
[
    "[]"
]

输出示例2：

["[{\"aID\":5,\"aRCHITECTURE\":\"U\",\"applicantID\":3,\"auditinfor\":\"E\",\"doc_path1\":\"E\",\"doc_path2\":\"E\",\"doc_path3\":\"E\",\"doc_path4\":\"E\",\"eNVIRONMENT\":\"1\",\"eNVIRONMENTE\":\"1\",\"eNVIRONMENTL\":\"1\",\"eNVIRONMENTN\":\"1\",\"eNVIRONMENTW\":\"1\",\"eXDATE\":\"E\",\"elseINDEX\":\"1\",\"else_type\":\"1\",\"elsestestBASIS\":\"1\",\"hELSEDEMAND\":\"1\",\"hHARDDISK\":\"1\",\"hMEMORY\":\"1\",\"mEDIUM\":\"E\",\"m_state\":\"A\",\"pA\":\"1\",\"pAE\":\"1\",\"pB\":\"1\",\"pB_type\":\"D\",\"phone\":\"1\",\"processID\":23,\"sAMPLEDELETE\":\"A\",\"sARCHITECTURE\":\"C\",\"sDATABASE\":\"1\",\"sDES\":\"1\",\"sELSEDEMAND\":\"1\",\"sLANGUAGE\":\"1\",\"sMIDDLEWARE\":\"1\",\"sNAME\":\"1\",\"sOS\":\"1\",\"sTYPE\":\"1\",\"sVERSION\":\"1\",\"scale_lines\":1,\"scale_num\":1,\"scale_score\":1,\"stestBASIS\":1,\"tESTINDEX\":1,\"t_state\":\"A\",\"testTYPE\":\"C\",\"time\":1504319354000,\"uSS\":\"1\"}]"]

# #/application/checkbyAID
根据AID查找所有符合的application

输入示例：
{
    "AID":"5"
}

输出：所有符合条件的applicant组成的list，如果没有，则输出空list

输出示例1：（为空）
[
    "[]"
]

输出示例2：
["[{\"aID\":5,\"aRCHITECTURE\":\"U\",\"applicantID\":3,\"auditinfor\":\"E\",\"doc_path1\":\"E\",\"doc_path2\":\"E\",\"doc_path3\":\"E\",\"doc_path4\":\"E\",\"eNVIRONMENT\":\"1\",\"eNVIRONMENTE\":\"1\",\"eNVIRONMENTL\":\"1\",\"eNVIRONMENTN\":\"1\",\"eNVIRONMENTW\":\"1\",\"eXDATE\":\"E\",\"elseINDEX\":\"1\",\"else_type\":\"1\",\"elsestestBASIS\":\"1\",\"hELSEDEMAND\":\"1\",\"hHARDDISK\":\"1\",\"hMEMORY\":\"1\",\"mEDIUM\":\"E\",\"m_state\":\"A\",\"pA\":\"1\",\"pAE\":\"1\",\"pB\":\"1\",\"pB_type\":\"D\",\"phone\":\"1\",\"processID\":23,\"sAMPLEDELETE\":\"A\",\"sARCHITECTURE\":\"C\",\"sDATABASE\":\"1\",\"sDES\":\"1\",\"sELSEDEMAND\":\"1\",\"sLANGUAGE\":\"1\",\"sMIDDLEWARE\":\"1\",\"sNAME\":\"1\",\"sOS\":\"1\",\"sTYPE\":\"1\",\"sVERSION\":\"1\",\"scale_lines\":1,\"scale_num\":1,\"scale_score\":1,\"stestBASIS\":1,\"tESTINDEX\":1,\"t_state\":\"A\",\"testTYPE\":\"C\",\"time\":1504319354000,\"uSS\":\"1\"}]"]

# #/application/updateapplication
更新对应AID的application信息

注意！此项更新只看AID，其余所有信息都会被更新覆盖

输入示例：
{
    "AID":"2",
    "applicantID":"1111332",
    "processID":"222",
    "time":"2017-09-02 10:29:14",
    "phone":"1",
    "testTYPE":"C",
    "sNAME":"1",
    "PA":"1",
    "PAE":"1",
    "PB":"1",
    "PB_type":"D",
    "else_type":"1",
    "USS":"1",
    "sDES":"1",
    "stestBASIS":"1",
    "elsestestBASIS":"1",
    "TESTINDEX":"1",
    "elseINDEX":"1",
    "scale_num":"1",    
    "scale_score":"1",
    "scale_lines":"1",
    "sTYPE":"1",
    "ENVIRONMENTW":"1",
    "ENVIRONMENTL":"1",
    "ENVIRONMENTN":"1",
    "ENVIRONMENTE":"1",
    "ENVIRONMENT":"1",
    "ARCHITECTURE":"U",
    "hMEMORY":"1",
    "hHARDDISK":"1",
    "hELSEDEMAND":"1",
    "sOS":"1",
    "sVERSION":"1",
    "sLANGUAGE":"1",
    "sARCHITECTURE":"C",
    "sDATABASE":"1",
    "sMIDDLEWARE":"1",
    "sELSEDEMAND":"1",
    "MEDIUM":"E",
    "doc_path1":"E",
    "doc_path2":"E",
    "doc_path3":"E",
    "doc_path4":"E",
    "SAMPLEDELETE":"A",
    "EXDATE":"E",
    "t_state":"A",
    "m_state":"A",
    "auditinfor":"E"
}

输出1：（AID对应的application不存在）
the application does not exist

输出2：（更新成功）
update complete

# #/application/deleteapplication
删除对应AID的application

注意！此处只看AID，所有AID之外的信息都会被无视

输入示例：
{
    "AID":"1"
}

输出1：（AID对应的application不存在）
the application does not exist

输出2：（删除成功）
delete complete