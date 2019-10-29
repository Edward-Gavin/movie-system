-- auto-generated definition
create table task
(
    id          int auto_increment
        primary key,
    title       varchar(256) not null comment '任务名称',
    equipment   varchar(150) null,
    end         varchar(150) null comment '结束时间',
    start       varchar(150) null comment '开始时间',
    responsible varchar(128) not null comment '负责人',
    status      int(4)       not null comment '任务状态',
    publish     varchar(128) not null comment '发布者',
    detail      varchar(250) null,
    date        varchar(250) null
)
    charset = utf8;
