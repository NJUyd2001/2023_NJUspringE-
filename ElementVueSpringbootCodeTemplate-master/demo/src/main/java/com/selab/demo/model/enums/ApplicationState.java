package com.selab.demo.model.enums;

/**
 * 申请状态enums
 */
public enum ApplicationState {
    等待市场部人员,等待测试部人员,市场部审核,市场部通过,市场部不通过,测试部通过,测试部不通过
}
/**
 * 等待市场部人员（提交申请）->等待测试部人员->市场部审核->市场部通过->测试部通过（委托通过）
 *                                        | |        |  -----
 *                                        | -----    |      |
 *                                        |      |  测试部不通过（重新提交）
 *                                        |      |
 *                                        |      |
 *                                     市场部不通过（重新提交）
 */
