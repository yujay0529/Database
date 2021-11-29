use sqldb2;

-- 출판사 테이블 생성
CREATE TABLE publisher(
		pubNo VARCHAR(10) NOT NULL PRIMARY KEY,
        pubName VARCHAR(30) NOT NULL
);

-- 도서 테이블 생성
CREATE TABLE book (
	bookNo VARCHAR(10) NOT NULL PRIMARY KEY,
	bookName VARCHAR(30) NOT NULL,
	bookPrice INT DEFAULT 10000 CHECK(bookPrice > 1000),
	bookDate DATE,
	pubNo VARCHAR(10) NOT NULL,	
	CONSTRAINT FK_book_publisher FOREIGN KEY (pubNo) REFERENCES publisher (pubNo)
);

-- publisher 테이블에 데이터 입력
-- INSERT INTO 테이블명 (열이름 리스트)  VALUES (값리스트);
INSERT INTO publisher (pubNo, pubName) VALUES ('1', '서울 출판사');
INSERT INTO publisher (pubNo, pubName) VALUES ('2', '강남 출판사'); 
INSERT INTO publisher (pubNo, pubName) VALUES ('3', '종로 출판사');   
    
-- publisher 테이블 내용 조회
SELECT * FROM publisher;    
    
-- book 테이블에 데이터 입력
INSERT INTO book (bookNo, bookName, bookPrice, bookDate, pubNo)
	VALUES('1', '자바', 20000, '2021-05-17', '1');
    
-- 모든 열에 데이터를 입력할 경우 열이름 생략 가능
INSERT INTO book 
	VALUES('2', '자바스크립트', 23000, '2019-05-17', '3');   

-- 여러 개의 데이터를 한 번에 INSERT
INSERT INTO book (bookNo, bookName, bookPrice, bookDate, pubNo)
	VALUES('3', '데이터베이스', 35000, '2021-07-11', '2'),
		  ('4', '알고리즘', 18000, '2021-01-15', '3'),
          ('5', '웹프로그래밍', 22000, '2019-09-15', '2');
    
-- 여러 개의 데이터를 한 번에 INSERT
-- 모든 열에 데이터를 입력할 경우 열이름 생략 가능
INSERT INTO book 
	VALUES('6', '데이터베이스', 35000, '2021-07-11', '2'),
		  ('7', '알고리즘', 18000, '2021-01-15', '3'),
          ('8', '웹프로그래밍', 22000, '2019-09-15', '2');    

-- book 테이블 내용 조회          
   SELECT * FROM book;  
   -- ---------------------------------------------------------
   /*
   연습문제
	INSERT 문을 사용하여
	학과 / 학생 테이블에 다음과 같이 데이터 입력
	SELECT 문으로 조회
*/
        -- 학과 테이블 생성
    CREATE TABLE department(
        dptNo VARCHAR(10) NOT NULL PRIMARY KEY,
        dptName VARCHAR(30) NOT NULL,
        dptTel VARCHAR(13)
    );

  -- 학생 테이블 생성 
	CREATE TABLE student (
		stdNo VARCHAR(10) NOT NULL PRIMARY KEY,
		stdName VARCHAR(30) NOT NULL,
		stdYear INT DEFAULT 4 CHECK(stdYear >= 1 AND stdYear <= 4),
        stdAddress VARCHAR(50), 
		stdBirthDay DATE,
		dptNo VARCHAR(10) NOT NULL,
        CONSTRAINT FK_student_department FOREIGN KEY (dptNo) REFERENCES department (dptNo)
	);
   
    INSERT INTO department (dptNo, dptName, dptTel)
	VALUES  ('1', '컴퓨터학과', '02-1111-1111'),    
			('2', '경영학과', '02-2222-2222'),
			('3', '수학과', '02-7777-7777');
    
    SELECT * FROM department;  
    
    INSERT INTO student (stdNo, stdName, stdYear, stdAddress, stdBirthDay, dptNo) 
	VALUES  ('2018002', '이몽룡', 4, '서울시 강남구', '1998-05-07', '1'),  
			('2019003', '홍길동', 3, '경기도 안양시', '1999-11-11', '2'),
			('2021003', '성춘향', 1, '전라북도 남원시', '2002-01-02', '3'),
            ('2021004', '변학도', 1, '서울시 종로구', '2000-11-11', '2');  

    SELECT * FROM student;  
    
    -- -------------------------------------------------------------
    -- product.csv 파일 임포트해서 product 테이블 생성
    
    DESCRIBE product;
    DESC product;
    
    -- 파일 임포트 시 제약조건 없어짐 
    
    -- 기본키 추가
    -- 기본키를 추가하기 전에 text 타입를 VARCHAR() 타입으로 변경
    -- 변경하지 안으면 text 길이가 없다는 오류 발생
    
    -- 기본키인 prdNo를 VARCHAR(10) NOT NULL로 변경
    ALTER TABLE product MODIFY prdNo VARCHAR(10) NOT NULL;
    
    -- 기본키 제약조건 추가
    ALTER TABLE product
		ADD CONSTRAINT PK_product_prdNo
        PRIMARY KEY (prdNo);
    
    -- 모든 text 타입을 VARCHAR 타입으로 변경
     ALTER TABLE product MODIFY prdName VARCHAR(20),
						 MODIFY prdMaker VARCHAR(30),
                         MODIFY prdColor VARCHAR(10),
                         MODIFY ctgNo VARCHAR(10);
    
    -- ------------------------------------------------
    -- UPDATE 문
    /*
    UPDATE 문 (데이터 수정)
	특정 열의 값을 수정하는 명령어 
	조건에 맞는 행을 찾아서 열의 값을 수정
	기본 형식 : UPDATE 테이블명 SET 열이름=새값 WHERE 조건;
	예: 상품번호가 5인 행의 상품명을 ‘UHD TV’로 수정
	UPDATE product SET prdName = ‘UHD TV’ WHERE prdNo=’5’;

    */
    --  상품 테이블 내용 조회
    SELECT * FROM product;
    
    -- 상품번호가 1005인 상품의 상품명을 ‘UHD TV’로 변경
    UPDATE product SET prdName = 'UHD TV' WHERE prdNo='1005';
    
    -- -----------------------------------------------
    
/*
    DELETE 문 (데이터 삭제)
	테이블에 있는 기존 행을 삭제하는 명령어
	기본 형식 : DELETE FROM 테이블명 WHERE 조건;
	예: DELETE FROM product WHERE prdName = ‘그늘막 텐트’;
	테이블의 모든 행 삭제
	DELETE FROM product;
*/

-- 상품명이 '그늘막 텐트'인 상품 삭제alter  
DELETE FROM product WHERE prdName = '그늘막 텐트';    
    
--  상품 테이블 내용 조회
SELECT * FROM product;    
    
-- -----------------------------------------------------------
/*
연습문제
1. book 테이블에 다음과 같이 행 삽입 
 (출판사 데이터는 테이블 구조에 맞게 입력) - 9번 10번으로 입력
2. book 테이블에서 도서명이 '자바'인 행의 가격을 22000으로 변경
3. book 테이블에서 발행일이 2018년도인 행 삭제  

*/
-- 1. book 테이블에 다음과 같이 행 삽입 (출판사 데이터는 테이블 구조에 맞게 입력)
INSERT INTO book (bookNo, bookName, bookPrice, bookDate, pubNo)
	VALUES  ('9', 'JAVA 웹프로그래밍', 30000, '2021-03-10', '1'),
			('10', '파이썬 데이터 과학', 24000, '2018-02-05', '2'); 

-- 2. book 테이블에서 도서명이 '자바'인 행의 가격을 22000으로 변경
UPDATE book SET bookPrice=22000 WHERE bookName='자바';

-- 3. book 테이블에서 발행일이 2018년도인 행 삭제
DELETE FROM book 
	WHERE bookDate >= '2018-01-01' AND bookDate <= '2018-12-31';
    
    
-- ---------------------------------------------------------------

/*
	종합 연습문제
	다음과 같이 SQL 문 작성
	1. 고객 테이블 (customer) 생성 
	2. 고객 테이블의 전화번호 열을 NOT NULL로 변경
	3. 고객 테이블에 ‘성별’, ‘나이’ 열 추가
	4. 고객 테이블에 데이터 삽입 (3개)
	5. 고객명이 홍길동인 고객의 전화번호 값 수정 (값은 임의로)
	6. 나이가 20살 미만인 고객 삭제
*/


-- 1. 고객 테이블 (customer) 생성  
CREATE TABLE customer(
	custNo VARCHAR(10) NOT NULL PRIMARY KEY,
	custName VARCHAR(30),
	custPhone VARCHAR(13),
	custAddress VARCHAR(50)
);

-- 2. 고객 테이블의 전화번호 열을 NOT NULL로 변경
ALTER TABLE customer MODIFY custPhone VARCHAR(13) NOT NULL;

DESCRIBE customer;

-- 3. 고객 테이블에 ‘성별’, ‘나이’ 열 추가
ALTER TABLE customer ADD (custGender VARCHAR(1), custAge INT);

DESCRIBE customer;

-- 4. 고객 테이블에 데이터 삽입 (3개)
INSERT INTO customer (custNo, custName, custPhone, custAddress, custGender, custAge) 
VALUES  ('1001', '홍길동', '010-1111-1111', '강원도 평창', '남', 25),  
		('1002', '이몽룡', '010-2222-2222', '서울 종로구', '남', 15),
		('1003', '성춘향', '010-3333-3333', '서울시 강남구', '여', 27);

SELECT * FROM customer;  

-- 5. 고객명이 홍길동인 고객의 전화번호 값 수정 (값은 임의로)
UPDATE customer SET custPhone='010-1234-1234' WHERE custName='홍길동';

SELECT * FROM customer;

-- 6. 나이가 20살 미만인 고객 삭제
DELETE FROM customer WHERE custAge < 20;

SELECT * FROM customer;  










 