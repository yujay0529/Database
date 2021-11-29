
-- ALTER 문

-- 열 추가 : ALTER TABLE 테이블명 ADD ....

use sqldb1;

-- student 테이블에 stdTel 열 추가
ALTER TABLE student ADD stdTel VARCHAR(13);

DESCRIBE student;

-- 여러 개의 열 추가 : stdAge, stdAddress2 열 추가
ALTER TABLE student ADD (stdAge VARCHAR(2), stdAddress2 VARCHAR(50));

-- 열의 데이터 형식 변경 : stdAge 열의 데이터 타입을 INT로 변경
ALTER TABLE student MODIFY stdAge INT;

-- 열의 제약조건 변경 : stdName을 NULL 허용으로 설정
ALTER TABLE student MODIFY stdName VARCHAR(2) NULL;

-- 열 이름 변경 : stdTel을 stdHP로 변경 (데이터 타입 적으면 구문 오류)
ALTER TABLE student RENAME COLUMN stdTel TO stdHP;

-- 열 이름과 데이터 타입 변경
ALTER TABLE student CHANGE stdAddress stdAddress1 VARCHAR(30);

-- 열 삭제 : stdHP 열 삭제
ALTER TABLE student DROP COLUMN stdHP;

-- 여러 개의 열 삭제
ALTER TABLE student DROP stdAge,
					DROP stdAddress1,
                    DROP stdAddress2;
                    
                    
                    
-- --------------------------------------------
/*
	테이블 ALTER 연습문제
	1. product 테이블에 숫자 값을 갖는 prdStock과 제조일을 나타내는 prdDate 열 추가
	2. product 테이블의 prdCompany 열을 NOT NULL로 변경
	3. publisher 테이블에 pubPhone, pubAddress 열 추가
	4. publisher 테이블에서 pubPhone 열 삭제

*/

DESCRIBE product;
DESCRIBE publisher;

-- 1. product 테이블에 숫자값을 갖는 prdStock과 
-- 제조일을 나타내는 prdDate 열 추가
ALTER TABLE product ADD (prdStock INT, prdDate DATE);

-- 2. product 테이블의 prdCompany 열을 NOT NULL로 변경
ALTER TABLE product MODIFY prdCompany VARCHAR(30) NOT NULL;

-- 3. publisher 테이블에 pubPhone, pubAddress 열 추가
ALTER TABLE publisher ADD (pubPhone VARCHAR(13), pubAddress VARCHAR(50));

-- 4. publisher 테이블에서 pubPhone 열 삭제
ALTER TABLE publisher DROP COLUMN pubPhone;    

-- ----------------------------------------------------------
-- 기본키 삭제 (외래키 제약조건이 설정되어 있는 경우 기본키 테이블의 기본키 삭제 시 오류) 
ALTER TABLE department DROP PRIMARY KEY;

-- 외래키 제약조건 먼저 삭제하고 
-- dptNo를 외래키로 사용하고 있는 테이블 2개 : student와 professor
ALTER TABLE student 
	DROP CONSTRAINT FK_student_department;

ALTER TABLE professor 
	DROP CONSTRAINT FK_professor_department;
    
-- 외래키 제약조건이 삭제하고 나면 기본키 삭제 가능
ALTER TABLE department DROP PRIMARY KEY;

-- ------------------------------------------------------
-- 기본키 / 외래키 추가

-- 기본키 제약조건 추가 : department 테이블
ALTER TABLE department
	ADD CONSTRAINT PK_department_dptNo
    PRIMARY KEY (dptNo);

-- 또는
ALTER TABLE department
	ADD 
    PRIMARY KEY (dptNo);

-- 외래키 제약조건 추가 : student와 professor 테이블
ALTER TABLE student
ADD CONSTRAINT FK_student_department
FOREIGN KEY(dptNo) REFERENCES department(dptNo);

ALTER TABLE professor
ADD CONSTRAINT FK_professor_department
FOREIGN KEY(dptNo) REFERENCES department(dptNo);

-- ------------------------------------------
-- ON DELETE CASCADE 
-- student 테이블의 기존 외래키 삭제하고 다시 설정

-- 기존 외래키 삭제
ALTER TABLE student 
	DROP CONSTRAINT FK_student_department;

-- ON DELETE CASCADE로 다시 외래키 설정    
ALTER TABLE student 
	ADD CONSTRAINT FK_student_department 
    FOREIGN KEY(dptNo) REFERENCES department(dptNo)
    ON DELETE CASCADE;
    
-- ----------------------------------------------
/* 
	테이블 삭제 : DROP TABLE
	스키마, 테이블, 뷰, 인덱스 등 삭제하는 명령문
	테이블 구조와 데이터 모두 삭제
	(데이터만 삭제 시 DELETE 문 사용 - DML)
*/ 

DROP TABLE book;
DROP TABLE publisher;

-- 모든 제약조건 출력
select * from information_schema.table_constraints;

-- 특정 데이터베이스의 특정 테이블 제약조건 출력
select * from information_schema.table_constraints 
where table_schema="sqldb1" AND table_name = "student";

-- 특정 테이블의 제약조건 출력
select * from information_schema.table_constraints 
where table_name = "student";
