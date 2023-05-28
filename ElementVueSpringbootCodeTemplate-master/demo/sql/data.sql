create table test
(
    id          BIGINT AUTO_INCREMENT COMMENT 'ID'
        PRIMARY KEY ,
    data  VARCHAR(255)   DEFAULT''  NOT NULL  COMMENT '数据'
);