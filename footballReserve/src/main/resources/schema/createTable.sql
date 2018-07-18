drop table FB_RESERVE_TB;
drop table FB_PPH_TB;
drop table FB_IMAGE_TB;
drop table FB_REVIEW_TB;
drop table FB_RENTAL_TB;
drop table FB_FACILITIES_TB;
drop table FB_TB;
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
    BOARD_TYPE varchar(100) NOT NULL,
    USER_ID VARCHAR(100) NOT NULL,
    BOARD_SUB varchar(100) NOT NULL,
    BOARD_CONTENT varchar(100) NOT NULL,
    BOARD_DT timestamp NOT NULL,
    BOARD_HIT int(100) NOT NULL,
	constraint board_userId_fk foreign key(user_Id) references user_tb(user_Id),
    primary key(BOARD_NO,BOARD_TYPE)
);

create table BOARD_REVIEW_TB(
	REVIEW_NO int(100) auto_increment ,
    REVIEW_ORIGIN_NO int(10) NOT NULL,
    BOARD_NO int(100) NOT NULL, 
    BOARD_TYPE varchar(100) NOT NULL,
    REVIEW_CONTENT VARCHAR(100) NOT NULL,
    REVIEW_WRITER VARCHAR(100) NOT null,
    REVIEW_DT timestamp NOT NULL,
	GROUPORD INT(10) DEFAULT NULL,
	GROUPLAYER INT(10) DEFAULT NULL,
    constraint boardReview_boardNo_fk foreign key(BOARD_NO) references board_tb(BOARD_NO),
    primary key(REVIEW_NO)
);

create table FB_TB(
	FB_NO INT(100) auto_increment,
    USER_ID VARCHAR(100) NOT NULL,
    FB_SUB VARCHAR(100) NOT NULL,
    FB_CONTENT VARCHAR(100) NOT NULL,
    FB_ADDR VARCHAR(100) NOT NULL,
    FB_MAXUSER INT(100) NOT NULL,
    constraint FB_USERID_FK foreign key(USER_ID) references user_tb(USER_ID),
    primary key(FB_NO)
);

create table FB_FACILITIES_TB(
	FB_NO INT(100),
    FB_GRASS CHAR(1) NOT NULL,
    FB_LIGHT CHAR(1) NOT NULL,
    FB_SR CHAR(1) NOT NULL,
    FB_PARK CHAR(1) NOT NULL,
    constraint FB_FACILITIES_FBNO_FK foreign key(FB_NO) references FB_TB(FB_NO)
);

CREATE TABLE FB_RENTAL_TB(
	FB_NO INT(100),
	FB_RETAL_BALL CHAR(1) NOT NULL,
    FB_RETAL_UNIFORM CHAR(1) NOT NULL,
    FB_RETAL_SHOES CHAR(1) NOT NULL,
    constraint FB_RENTAL_FBNO_FK foreign key(FB_NO) references FB_TB(FB_NO)
);

CREATE TABLE FB_REVIEW_TB(
	FR_NO INT(100) auto_increment,
    FB_NO INT(100),
    FR_CONTENT VARCHAR(100) NOT NULL,
    FR_START INT(10) NOT NULL,
    constraint FB_REVIEW_FBNO_FK foreign key(FB_NO) references FB_TB(FB_NO),
    primary key(FR_NO)
);

CREATE TABLE FB_IMAGE_TB(
	FB_IMAGE_NO INT(100) auto_increment,
    FB_NO INT(100),
    FB_IMG_PATH VARCHAR(100) NOT NULL,
    FB_IMG_LOCATION VARCHAR(100) NOT NULL,
    constraint FB_IMAGE_FBNO_FK foreign key(FB_NO) references FB_TB(FB_NO),
    primary key(FB_IMAGE_NO)
);

CREATE TABLE FB_PPH_TB(
	FB_NO INT(100),
    FB_PRICE INT(100) NOT NULL,
    FB_START timestamp NOT NULL,
    FB_END timestamp NOT NULL,
    constraint FB_PPH_FBNO_FK foreign key(FB_NO) references FB_TB(FB_NO)
);

CREATE TABLE FB_RESERVE_TB(
	RE_NO INT(100) auto_increment,
    USER_ID varchar(100),
    FB_NO int(100),
    RE_START timestamp,
    RE_END timestamp,
    RE_STATUS char(1),
	constraint FB_RESERVE_FBNO_FK foreign key(FB_NO) references FB_TB(FB_NO),
	constraint FB_RESERVE_USERID_FK foreign key(user_Id) references user_tb(user_Id),
	primary key(RE_NO)
);
