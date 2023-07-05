package com.selab.demo.model;
/**
 * @author 刘轩昂
 * @time 2023/7/3
 * */
public class StateModel {
    private Integer SID; // 状态编号
    private Integer PID; // 对应进程的编号
    private Integer UID; // 对应用户的编号
    private Integer AID; // 对应委托的编号
    private String state; /*发起委托(委托修改) 1    -> 市场部 通过 11 不通过 10 -> 测试部 通过 111 不通过 110
                           *生成报价 2 客户接受报价  -> 21 不接受 20
                           *生成合同草稿 3         -> 客户 接受并填写合同 31 不接受 30 -> 市场部 审核通过 311 不通过310
                           *用户发送样品 4         -> 验收通过 41 不通过 40
                           *测试部 编写测试方案 5   -> 质量部 通过 51 不通过 50
                           *填写测试文档 6
                           *测试完成，生成测试报告 7 -> 测试部主管通过 71 不通过 70 -> 用户审核通过 711 不通过710 -> 授权签字人 7111 7110
                           *测试部 归档 发送测试报告 8 -> 确认接受 81
                           */
}
