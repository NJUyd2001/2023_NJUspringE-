# application数据文档

author：李晨博

注：这段内容是根据王辰枫在MySQL当中的注释整理而来的，如果有疑问，除去联系我，也请额外联系他，谢谢！

|key|数据类型|数据含义|是否不能为空（NOT NULL）|
|---|---|---|---|
|AID（主键）|int|申请号|NOT NULL|
|applicantID|int|申请人ID|NOT NULL|
|processID|int|审核进度ID|-|
|time|date|时间|NOT NULL|
|phone|string|电话|NOT NULL|
|testTYPE|enum|测试类型<br />C：软件确认测试，<br />I：成果/技术鉴定测试，<br />A：转向资金验收测试|NOT NULL|
|sNAME|string|软件名称|NOT NULL|
|PA|string|委托方|-|
|PAE|string|委托方（英文）|NOT NULL|
|PB|string|受委托方（开发单位）|NOT NULL|
|PB_type|enum|单位性质<br />D：内资企业，<br />F：外（合）资企业，<br />G：港澳台企业，<br />S：科研院校，<br />O：政府事业团队，<br />E：其他|NOT NULL|
|else_type|string|当PB_type == E时有效<br />单位性质为其他|-|
|USS|string|用户对象描述|NOT NULL|
|sDES|string|软件描述（功能，简介）|NOT NULL|
|stestBASIS|string|测试依据，由所有依据的代号组成一个字符串<br />1:GB/T 25000.51-2016，<br />2:GB/T 25000.10-2016，<br />3:GB/T 28452-2012，<br />4:GB/T 30961-2014，<br />5:NST-03-Wl12-2011，<br />6:NST-03-Wl13-2011，<br />7:NST-03-Wl22-2014|-|
|elsestestBASIS|string|测试依据其他|-|
|TESTINDEX|string|需要测试的技术指标|-|
|elseINDEX|string|技术指标其他|-|
|scale_num|int|功能数|-|
|scale_score|int|功能点数|-|
|scale_lines|int|代码行数|-|
|sTYPE|char|软件类型|-|
|ENVIRONMENTW|string|运行环境Windows|-|
|ENVIRONMENTL|string|运行环境Linux|-|
|ENVIRONMENTN|string|运行环境内存|-|
|ENVIRONMENTE|string|运行环境其他|-|
|ENVIRONMENT|string|运行环境其他要求|-|
|ARCHITECTURE|enum|服务器端架构，<br />P：PC端，<br />U：UNIX/Linux，<br />E：其他|-|
|hMEMORY|string|服务器端硬件：内存要求|-|
|hHARDDISK|string|服务器端硬件：硬盘要求|-|
|hELSEDEMAND|string|服务器端硬件：其他要求|-|
|sOS|string|服务器端软件：操作系统|-|
|sVERSION|string|服务器端软件：版本|-|
|sLANGUAGE|string|服务器端软件：编程语言|-|
|sARCHITECTURE|enum|服务器端软件架构，<br />C：C/S，<br />B：B/S，<br />E：其他|-|
|sDATABASE|string|服务器端软件：数据库|-|
|sMIDDLEWARE|string|服务器端软件：中间件|-|
|sELSEDEMAND|string|服务器端软件：其他需求|-|
|MEDIUM|enum|样品软件介质，<br />G：光盘，<br />U：U盘，<br />E：其他|-|
|doc_path1|string|样品文档|NOT NULL|
|doc_path2|string|用户文档|NOT NULL|
|doc_path3|string|操作文档|NOT NULL|
|doc_path4|string|申请人签字|NOT NULL|
|SAMPLEDELETE|enum|A：中心直接销毁，<br />B：样品退还|NOT NULL|
|EXDATE|string|希望测试完成时间|NOT NULL|
|t_state|enum|测试部审核结果，<br />A：委托被拒绝，<br />B：待审核，<br />C：正在审核中（已经有人再审了），<br />D：审核通过|NOT NULL|
|m_state|enum|市场部审核结果,<br />A：委托被拒绝,<br />B：待审核,<br />C：正在审核中（已经有人再审了）,<br />D：审核通过|NOT NULL|
|auditinfor|string|state==A时有意义：委托修改意见|-|
