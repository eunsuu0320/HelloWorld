CREATE TABLE poketmon
  (name VARCHAR2(20) PRIMARY KEY, 
   type VARCHAR2(10) NOT NULL,
   hp   NUMBER DEFAULT 100,
   skil1 VARCHAR2(100) NOT NULL,
   skil2 VARCHAR2(100) NOT NULL,
   skil3 VARCHAR2(100) NOT NULL,
   choice NUMBER DEFAULT 0);
   
DROP TABLE poketmon;
   
select *
from  poketmon;

INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('나인테일', '불', '전광석화', '불꽃진화', '도깨비불');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('꼬부기', '물', '몸통박치기', '거품', '물대포');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('고라파덕', '물', '햘퀴기', '물의 파동', '아쿠아테일');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('갸라도스', '물', '회오리', '용의분노', '하이드로펌프');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('이상해씨', '풀', '몸통박치기', '덩굴채찍', '씨뿌리기');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('로젤리아', '풀', '햘퀴기', '메가드레인', '꽃잎댄스');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('다탱구', '풀', '몸통박치기', '잎날가르기', '리프스톰');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('피카츄', '전기', '몸통박치기', '전광석화', '10만볼트');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('찌리리공', '전기', '몸통박치기', '스파크', '챠지빔');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('썬더', '전기', '전기쇼크', '방전', '번개');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('뮤츠', '전설', '염동력', '미래예지', '파동탄');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('루기아', '전설', '바람일으키기', '하이드로펌프', '불새');
INSERT INTO poketmon (name, type, skil1, skil2, skil3)
VALUES ('디아루가', '전설', '용의숨결', '러스터캐논', '시간의포효');
   
CREATE TABLE skil
  (skil_name VARCHAR2(30) NOT NULL,
   damage NUMBER NOT NULL);
   
INSERT INTO skil (skil_name, damage)
VALUES ('방전', 75);
INSERT INTO skil (skil_name, damage)
VALUES ('염동력', 50);
INSERT INTO skil (skil_name, damage)
VALUES ('미래예지', 80);
INSERT INTO skil (skil_name, damage)
VALUES ('파동탄', 95);
INSERT INTO skil (skil_name, damage)
VALUES ('바람일으키기', 40);
INSERT INTO skil (skil_name, damage)
VALUES ('하이드로펌프', 70);
INSERT INTO skil (skil_name, damage)
VALUES ('불새', 90);
INSERT INTO skil (skil_name, damage)
VALUES ('용의숨결', 60);
INSERT INTO skil (skil_name, damage)
VALUES ('러스터캐논', 80);
INSERT INTO skil (skil_name, damage)
VALUES ('시간의포효', 95);

select *
from   skil;

delete 
from  skil
where skil_name = '방전';
   