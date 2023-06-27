package com.selab.demo.model.enums;

public enum state {
    R,W,P,A
}
/**
 * R：委托被拒绝
 * W：待审核
 * P：正在审核中（已经有人在审了，将其锁住不让别人访问）
 * A：审核通过
 */
