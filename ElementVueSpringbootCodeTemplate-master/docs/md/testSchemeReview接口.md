# testSchemeReview接口手册

## 插入

网段：`/testReview/insert`

参数：

``` js
{
    "SoftWareName":"炒粉",
    "VersionNumber":"1.1.1",
    "ProjectNum":"9",
    "PID":"3",
    "TestCategory":"手测",
    "WritingNormality":"TestcaseCover",
    "TestEnvironment":"etst",
    "Completeness":"test",
    "SelectMethod":"test",
    "TestcaseCover":"test",
    "InputOutputData":"test",
    "Timing":"test",
    "HumanResourcesArrangement":"test",
    "tableData": [{
        "Duty": "测试工程师",
        "EvaluationOpinion": "eo1",
        "Sign": "s1",
        "Date": "d1"
        }, {
        "Duty": "测试室负责人",
        "EvaluationOpinion": "eo2",
        "Sign": "s2",
        "Date": "d2"
        }, {
        "Duty": "质量负责人",
        "EvaluationOpinion": "eo3",
        "Sign": "s3",
        "Date": "d3"
        }, {
        "Duty": "技术负责人",
        "EvaluationOpinion": "eo4",
        "Sign": "s4",
        "Date": "d4"
        }, {
        "Duty": "监督人",
        "EvaluationOpinion": "eo5",
        "Sign": "s5",
        "Date": "d5"
        }
    ]
}
```
返回实例：

返回**TRID**

``` js
9
```
## 搜索

- 根据**TRID**搜索

网段：`/testReview/select/byTRID`

参数：

``` js
{
    "TRID":""
}
```

- 根据**PID**搜索

网段：`/testReview/select/byPID`

参数：

``` js
{
    "PID":""
}
```

返回全部信息，实例：

``` js
{
    "tableData": [
        {
            "duty": "测试工程师",
            "evaluationOpinion": "s1",
            "sign": "eo1",
            "date": "d1"
        },
        {
            "duty": "测试室负责人",
            "evaluationOpinion": "s2",
            "sign": "eo2",
            "date": "d2"
        },
        {
            "duty": "质量负责人",
            "evaluationOpinion": "s3",
            "sign": "eo3",
            "date": "d3"
        },
        {
            "duty": "技术负责人",
            "evaluationOpinion": "s4",
            "sign": "eo4",
            "date": "d4"
        },
        {
            "duty": "监督人",
            "evaluationOpinion": "s5",
            "sign": "eo5",
            "date": "d5"
        }
    ],
    "pid": 3,
    "timing": "test",
    "inputOutputData": "test",
    "qm_Opinion": "质量负责人|s3|eo3|d3",
    "completeness": "test",
    "testEnvironment": "etst",
    "testCategory": "手测",
    "trid": 7,
    "projectNum": "9",
    "te_Opinion": "测试工程师|s1|eo1|d1",
    "td_Opinion": "技术负责人|s4|eo4|d4",
    "versionNumber": "1.1.1",
    "softwareName": "炒粉",
    "testcaseCover": "test",
    "si_Opinion": "监督人|s5|eo5|d5",
    "selectMethod": "test",
    "trm_Opinion": "测试室负责人|s2|eo2|d2",
    "writingNormality": "TestcaseCover",
    "humanResourcesArrangement": "test"
}
```