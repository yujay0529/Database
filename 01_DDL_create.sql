-- 스키마 (데이터베이스) 생성 및 삭제
-- SCHEMA / DATABASE 동일
CREATE SCHEMA sqldb1 DEFAULT CHARACTER SET utf8;
CREATE DATABASE sqldb2 DEFAULT CHARACTER SET UTF8MB4;

-- 스키마(데이터베이스) 삭제
DROP SCHEMA sqldb;
DROP DATABASE sqldb2;

-- 사용할 데이터베이스 생성
CREATE SCHEMA sqldb1 DEFAULT CHARACTER SET utf8;

-- 테이블 생성
-- CREATE TABLE
-- 속성(열)과 속성에 관한 제약 정의
-- 기본키(PRIMARY KEY), 외래키(FOREIGN KEY) 정의

-- 사용할 데이터베이스 지정
use sqldb1;

-- 상품 테이블 생성
-- 제약 조건 설정
	-- 기본키 : prdNo NOT NULL
    -- prdName NOT NULL

CREATE TABLE product(
	prdNo VARCHAR(10) NOT NULL PRIMARY KEY,
    prdName VARCHAR(30) NOT NULL,
    prdPrice INT,
    prdCompany VARCHAR(30)
);

-- 상세 정보 출력
DESCRIBE product;

-- 키본키 제약 조건 설정 방법2
CREATE TABLE product2(
	prdNo VARCHAR(10) NOT NULL,
    prdName VARCHAR(30) NOT NULL,
    prdPrice INT,
    prdCompany VARCHAR(30),
    PRIMARY KEY(prdNo)
);

-- 키본키 제약 조건 설정 방법3
CREATE TABLE product3(
	prdNo VARCHAR(10) NOT NULL,
    prdName VARCHAR(30) NOT NULL,
    prdPrice INT,
    prdCompany VARCHAR(30),
	CONSTRAINT PK_product_prdNo PRIMARY KEY(prdNo)
);

DESCRIBE product3;

-- 출판사 테이블과 도서 테이블 생성
-- 기본키 / 외래키 제약 조건 설정

/*
출판사 테이블 생성 (출판사 번호, 출판사명)
제약조건 설정
- 기본키로 pubNo NOT NULL
- pubName NOT NULL
*/

-- publisher
-- pubNo 가변문자 10
-- pubName 가변문자 30 
-- 제약조건 설정하고
-- 테이블 생성

CREATE TABLE publisher(
	 pubNo VARCHAR(10) NOT NULL PRIMARY KEY,
     pubName VARCHAR(30) NOT NULL
);

-- 도서 테이블 생성 : book
-- 외래키 (출판사 번호 pubNo) 제약조건 설정
-- 제약조건 설정
	-- 기본키 : bookNo NOT NULL
    -- 외래키 : pubNo (참조 테이블의 기본키와 동일하게 설정 : VARCHAR(10) NOT NULL)
    -- bookPrice : 기본값 10000 (DEFALUT), 1000 보다 크게 설정 (CHECK(bookPrice > 1000))


CREATE TABLE book(
	 bookNo VARCHAR(10) NOT NULL PRIMARY KEY,
     bookName VARCHAR(30) NOT NULL,
     bookPrice INT DEFAULT 10000 CHECK(bookPrice > 1000),
     bookDate DATE,
     pubNo VARCHAR(10) NOT NULL,
     CONSTRAINT FK_book_publisher FOREIGN KEY (pubNo) REFERENCES publisher(pubNo)
);

-- CONSTRAINT FK_book_publisher FOREIGN KEY (pubNo) REFERENCES publisher(pubNo)
-- CONSTRAINT 외래키 이름 FOREIGN KEY (외래키로 사용하는 열이름) REFERENCES 참조하는 테이블명(기본키)
-- REFERENCES 참조하는 테이블명(기본키) : 현재의 외래키가 기본키로 소속되어 있는 테이블 (부모 테이블)
-- CONSTRAINT : 제약 조건 

-- book 테이블 상세 정보 출력
DESCRIBE book;

CREATE SCHEMA sqldb1 DEFAULT CHARACTER SET utf8;
use sqldb1;

/*
	연습문제
	학생(student)과 학과(department) 테이블 생성하고 데이터 3개씩 입력
	제약조건
	기본키 설정
	필요한 경우 외래키 설정
	학생은 학과에 소속
	학생 이름과 학과 이름은 NULL 값을 허용하지 않음
	학년은 4를 기본값으로, 범위를 1~4로 설정 (AND 키워드 사용)
*/
/*
	테이블 생성 순서
	(1) 학과(department)  테이블
	(2) 학생(student) 테이블 : 학과번호를 외래키로 설정
*/

-- 학과(department)  테이블
CREATE TABLE department(
	 dptNo VARCHAR(10) NOT NULL PRIMARY KEY,
     dptName VARCHAR(30) NOT NULL,
     dptTel VARCHAR(13)
);

-- 학생(student) 테이블

CREATE TABLE student(
	stdNo VARCHAR(10) NOT NULL PRIMARY KEY,
    stdName VARCHAR(30) NOT NULL,
    stdYear INT DEFAULT 4 CHECK(stdYear >=1 AND stdYear <= 4),
    stdAddress VARCHAR(50),
    stdBirthday DATE,
    dptNo VARCHAR(10) NOT NULL,
    CONSTRAINT FK_student_department FOREIGN KEY (dptNo) REFERENCES department(dptNo)
);

/*
	교수 테이블
	교수번호 : 기본키, NOT NULL 
	학과코드 : 외래키 설정
*/

CREATE TABLE professor(
	profId VARCHAR(10) NOT NULL PRIMARY KEY,
    profName VARCHAR(30) NOT NULL,
    profPosition VARCHAR(20),
    profTel VARCHAR(13),
    dptNo VARCHAR(10) NOT NULL,
    CONSTRAINT FK_professor_department FOREIGN KEY (dptNo) REFERENCES department(dptNo)
);


/*
	과목 테이블
	과목코드 : 기본키, NOT NULL
	교수번호 : 외래키 설정
*/

CREATE TABLE course(
	courseId VARCHAR(10) NOT NULL PRIMARY KEY,
    courseName VARCHAR(30) NOT NULL,
    courseCredit INT,
    profId VARCHAR(10) NOT NULL,
    CONSTRAINT FK_course_professor FOREIGN KEY (profId) REFERENCES professor(profId)
);
-- 주의!! : profId는 professor 테이블에서 기본키로 설정되어 있어야 한다

/*
	성적 테이블
	학번과 과목코드 2개로 기본키 설정
	학번 : 외래키 설정
	과목코드 : 외래키 설정  
    
    성적
    등급
*/

CREATE TABLE scores(
	stdNo VARCHAR(10) NOT NULL,
    courseId VARCHAR(10) NOT NULL,
    scScore INT,
    scGrade VARCHAR(2),
    CONSTRAINT PK_scores_stdNo_courseId PRIMARY KEY(stdNo, courseId),    
    CONSTRAINT FK_course_student FOREIGN KEY (stdNo) REFERENCES student(stdNo),
    CONSTRAINT FK_course_course FOREIGN KEY (courseId) REFERENCES course(courseId)
);


-- ----------------------------------------------------------------------

-- 자동 증가 : AUTO_INCREMENT
-- 기본 1부터 1씩 증가
CREATE TABLE board(
	 boardNo INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
     boardTitle VARCHAR(30) NOT NULL,
     boardWriter VARCHAR(20),
     boardContent VARCHAR(100) NOT NULL
);


-- 초기값 100으로 설정하고 3씩 증가
CREATE TABLE board2(
	 boardNo INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
     boardTitle VARCHAR(30) NOT NULL,
     boardWriter VARCHAR(20),
     boardContent VARCHAR(100) NOT NULL
);

ALTER TABLE board2 AUTO_INCREMENT = 100;
SET @@AUTO_INCREMENT_INCREMENT=3;

-- 100부터 시작해서 3씩 증가하는 것을
-- 1부터 1씩 증가하는 것으로 변경

SET @COUNT = 0;
UPDATE board2 SET boardNo = @COUNT:=@COUNT+1;

-- 자바에서 변수값 1 증가 : sum = sum + 1 과 동일한 의미

-- 2번을 삭제하고 새로 하나 추가했더니 4부터 시작하는 것이 아니라 아까 106 다음의 109부터 시작
/*
	다시 1부터 1씩 증가하도록 변경
	다시 0으로 설정하고
	SET @COUNT = 0;
	UPDATE board2 SET boardNo = @COUNT:=@COUNT+1;

	초기값을 1로 다시 설정
	ALTER TABLE board2 AUTO_INCREMENT = 1;
*/

SET @COUNT = 0;
UPDATE board2 SET boardNo = @COUNT:=@COUNT+1;

ALTER TABLE board2 AUTO_INCREMENT = 1;








