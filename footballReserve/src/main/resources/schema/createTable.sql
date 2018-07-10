drop table board_review_tb;
drop table BOARD_TB;
drop table USER_TB;
 
 create table USER_TB
(
      user_id         varchar(100)   primary key,
      user_pwd   varchar(100) NOT NULL,
      user_name   varchar(100) NOT NULL,
      user_email         varchar(100) NOT NULL,
      user_phone         varchar(100) NOT NULL,
      user_dt      timestamp NOT NULL,
      user_authority char(1) NOT NULL default 1,
      user_point       varchar(100) NOT NULL,
      user_usage         varchar(100) NOT NULL,
	  user_grade   char(1) NOT NULL default 1
);

create table BOARD_TB
(
	BOARD_NO int(100) AUTO_INCREMENT,
    BOARD_TYPE varchar(100) NOT NULL unique,
    USER_ID VARCHAR(100) NOT NULL,
    BOARD_SUB varchar(100) NOT NULL,
    BOARD_CONTENT varchar(100) NOT NULL,
    BOARD_DT timestamp NOT NULL,
    BOARD_HIT int(100) NOT NULL,
	constraint board_userId_fk foreign key(user_Id) references user_tb(user_Id),
    primary key(BOARD_NO,BOARD_TYPE)
);

create table BOARD_REVIEW_TB(
	REVIEW_NO int(100) auto_increment,
    REVIEW_ORIGIN_NO int(10) NOT NULL,
    BOARD_NO int(100) NOT NULL, 
    BOARD_TYPE varchar(100) NOT NULL,
    REVIEW_CONTENT VARCHAR(100) NOT NULL,
    REVIEW_WRITER VARCHAR(100) NOT null,
    REVIEW_DT timestamp NOT NULL,
	GROUPORD INT(10) DEFAULT NULL,
	GROUPLAYER INT(10) DEFAULT NULL,
    constraint boardReview_boardNo_fk foreign key(BOARD_NO) references board_tb(BOARD_NO),
    constraint boardReview_boardType_fk foreign key(BOARD_TYPE) references board_tb(BOARD_TYPE),
    primary key(REVIEW_NO)
);