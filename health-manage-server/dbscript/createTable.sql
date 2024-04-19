# 用户表
# 用户信息模块
CREATE TABLE health_manage.user(
    id int not null AUTO_INCREMENT primary key comment '主键ID',
    login_id varchar(100) comment '用户名',
    username varchar(100) comment '用户名称',
    password varchar(100) comment '密码',
    email varchar(100) comment '邮箱',
    height varchar(100) comment '身高',
    weight varchar(100) comment '体重',
    age varchar(100) comment '年龄',
    sex varchar(100) comment '性别 male：女性, female：男性',
    user_level varchar(100) comment '用户等级 0：操作员， 1：管理员',
    create_time DATETIME comment '创建时间',
    update_time DATETIME comment '更新时间'
);

# 饮食管理
CREATE TABLE health_manage.diet(
    id int not null AUTO_INCREMENT primary key comment '主键ID',
    login_id varchar(100) comment '用户名',
    diet_date varchar(100) comment '饮食日期',
    diet_type varchar(100) comment '用餐类型: breakfast-早餐, lunch-午餐， dinner-晚餐',
    specific_plan varchar(100) comment '具体计划',
    diet_heat varchar(100) comment '热量'
);

#运动计划
CREATE TABLE health_manage.exercise(
    id int not null AUTO_INCREMENT primary key comment '主键ID',
    login_id varchar(100) comment '用户名',
    exercise_type varchar(100) comment '运动类型: running-跑步, cycling-骑行, walk-步行',
    exercise_date varchar(200) comment '运动日期',
    duration int comment '持续时间，单位：秒',
    consume_heat int comment '消耗热量，单位：卡路里'
);

#体检记录
CREATE TABLE health_manage.physical_examination_report(
    id int not null AUTO_INCREMENT primary key comment '主键ID',
    login_id varchar(100) comment '用户名',
    report_date varchar(200) comment '报告日期',
    report_content varchar(500) comment '报告内容',
    health_analysis varchar(500) comment '健康分析',
    suggestion varchar(500) comment '健康建议'
)