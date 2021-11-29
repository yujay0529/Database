/*
	스키마(데이터베이스) 새로 생성 : sqldb3
	CSV 파일의 데이터를 읽어서 테이블 생성
	publisher
	book
	client
	bookSale
	데이터 타입 변경 : text -> VARCHAR()
	모든 xxxNo는 문자 타입
	날짜는 DATE 타입
	기본키 / 외래키 설정
*/

use sqldb3;

-- CSV 파일 임포트 : publisher / book / client / bookSale    

-- publisher 테이블 변경
-- 기본키 제약 조건 추가하기 전에 text 타입을 VARCHAR(10)으로 변경
-- 변경하지 않으면 text 길이가 앖다는 오류 발생    
ALTER TABLE publisher MODIFY  pubNo VARCHAR(10)  NOT NULL,
					  MODIFY pubName VARCHAR(20);

-- 기본키 제약 조건 추가    
ALTER TABLE publisher 
		ADD CONSTRAINT PK_publisher_pubNo 
		PRIMARY KEY (pubNo);        

DESCRIBE publisher;
SELECT * FROM publisher;

-- book 테이블 변경
-- 기본키 제약 조건 추가하기 전에 text 타입을 VARCHAR(10)으로 변경
-- 변경하지 않으면 text 길이가 앖다는 오류 발생    
ALTER TABLE book MODIFY  bookNo VARCHAR(10) NOT NULL, 
				 MODIFY bookName VARCHAR(20),
				 MODIFY bookAuthor VARCHAR(30),
				 MODIFY bookDate DATE,
				 MODIFY  pubNo VARCHAR(10) NOT NULL; -- 외래키 pubNo  

-- 기본키 제약 조건 추가    
ALTER TABLE book 
		ADD CONSTRAINT PK_book_bookNo 
		PRIMARY KEY (bookNo);

-- 외래키 제약 조건 추가
ALTER TABLE book 
		ADD CONSTRAINT FK_book_publisher 
		FOREIGN KEY (pubNo) REFERENCES publisher (pubNo);

DESCRIBE book;
SELECT * FROM book;

-- client 테이블 변경
-- 기본키 제약 조건 추가하기 전에 text 타입을 VARCHAR(10)으로 변경
-- 변경하지 않으면 text 길이가 앖다는 오류 발생    
ALTER TABLE client MODIFY clientNo VARCHAR(10) NOT NULL, 
				   MODIFY clientName VARCHAR(30),
				   MODIFY clientPhone VARCHAR(13),
				   MODIFY clientAddress VARCHAR(50),
				   MODIFY clientBirth DATE,
				   MODIFY clientHobby VARCHAR(30),
				   MODIFY clientGender VARCHAR(1); 

-- 기본키 제약 조건 추가    
ALTER TABLE client 
		ADD CONSTRAINT PK_client_clientNo 
		PRIMARY KEY (clientNo);         

DESCRIBE client;
SELECT * FROM client;

-- bookSale 테이블 변경 
ALTER TABLE bookSale MODIFY bsNo VARCHAR(10) NOT NULL, 
					 MODIFY bsDate DATE,
					 MODIFY clientNo VARCHAR(10) NOT NULL, -- clientNo 외래키
					 MODIFY bookNo VARCHAR(10) NOT NULL;  -- bookNo 외래키

-- 기본키 제약 조건 추가    
ALTER TABLE bookSale 
		ADD CONSTRAINT PK_bookSale_bsNo 
		PRIMARY KEY (bsNo);  	

-- 외래키 제약 조건 추가
ALTER TABLE bookSale 
		ADD CONSTRAINT FK_bookSale_book 
		FOREIGN KEY (bookNo) REFERENCES book (bookNo);
		
ALTER TABLE bookSale 
		ADD CONSTRAINT FK_bookSale_client 
		FOREIGN KEY (clientNo) REFERENCES client (clientNo);

DESCRIBE bookSale;
SELECT * FROM bookSale;
    
-- -----------------------------------------------------------------

-- book 테이블에서 모든 행 검색하여 출력
-- 모든 열(*) 선택
SELECT * FROM book;

-- 도서명과 가격만 검색하여 출력
SELECT bookName, bookPrice FROM book;

-- 저자만 검색하여 출력
SELECT bookAuthor FROM book;

-- 저자만 검색하여 출력 (중복되는 행은 한번만 출력)
-- DISTINCT
SELECT DISTINCT bookAuthor FROM book;

-- --------------------------------------------
-- WHERE 조건

-- 비교 (= , <, >, <=, >=, !=)

-- 저자가 '홍길동'인 도서의 도서명, 저자 출력
SELECT bookName, bookAuthor
FROM book
WHERE bookAuthor = '홍길동';

-- 가격이 30000원 이상인 도서의 도서명, 가격, 재고 출력
SELECT bookName, bookPrice, bookStock
FROM book
WHERE bookPrice >= 30000;

-- 재고가 3~5 사이인 도서의 도서명, 재고 출력
SELECT bookName, bookStock
FROM book
WHERE bookStock >= 3 AND bookStock <= 5;

-- BETWEEN (범위) 사용
-- BETWEEN A AND B
SELECT bookName, bookStock
FROM book
WHERE bookStock BETWEEN 3 AND 5;

-- 리스트에 포함 (IN, NOT IN)
-- 출판사명이 '서울 출판사'(pubNo='1')와 '도서출판 강남'(pubNo='2')인 도서의
-- 도서명, 출판사번호 출력
SELECT bookName, pubNo
FROM book
WHERE pubNo IN ('1', '2'); 

-- 출판사명이 '도서출판 강남'이 아닌 도서의
-- 도서명, 출판사번호 출력
SELECT bookName, pubNo
FROM book
WHERE pubNo NOT IN('2');

-- NULL (IS NULL, IS NOT NULL)
-- 고객 테이블에서 취미 열 확인 : null 값 없음
SELECT * FROM client;

-- NULL 실습을 위해 일부러 null로 설정
UPDATE client SET clientHobby=null WHERE clientName='호날두';
UPDATE client SET clientHobby=null WHERE clientName='샤라포바';

-- 모든 고객명, 취미 출력
SELECT clientName, clientHobby FROM client;

-- 취미에 null 값이 들어 있는 행만 출력
SELECT clientName, clientHobby 
FROM client
WHERE clientHobby IS NULL;

-- 취미가 null 값인 아닌 행만 출력
SELECT clientName, clientHobby 
FROM client
WHERE clientHobby IS NOT NULL;

-- 취미에 공백이 들어 있는 행만 출력
SELECT clientName, clientHobby 
FROM client
WHERE clientHobby = '';

-- ''와 '    ' 결과 동일
-- 스페이스 개수 상관없이 공백으로 인식
SELECT clientName, clientHobby 
FROM client
WHERE clientHobby = '    ';

-- 논리 (AND, OR)
-- 저자가 '홍길동'이면서 재고가 3권 이상인 모든 도서 출력
SELECT * 
FROM book
WHERE bookAuthor = '홍길동' AND bookStock >= 3;

SELECT * 
FROM book
WHERE bookAuthor = '홍길동';

-- 저자가 '홍길동'이거나 '성춘향'인 모든 도서 출력
SELECT * 
FROM book
WHERE bookAuthor = '홍길동' OR bookAuthor = '성춘향';

-- 패턴 매칭 (LIKE)
-- 출판사 테이블에서 출판사명에 '출판사'가 포함된 모든 행 출력
SELECT *
FROM publisher
WHERE pubName LIKE '%출판사%';

-- 고객 중 출생년도가 1990년대인 모든 고객의 고객명, 생년월일 출력
SELECT clientName, clientBirth 
FROM client
WHERE clientBirth LIKE '199%';

-- 고객 테이블에서 고객명이 4글자인 모든 고객 정보 출력
SELECT *
FROM client
WHERE clientName LIKE '____';

-- 도서 테이블에서 도서명에 '안드로이드'가 들어 있지 않는 도서의 도서명 출력
SELECT bookName
FROM book
WHERE bookName NOT LIKE '%안드로이드%';

-- 전체 도서명 출력
SELECT bookName
FROM book;

-- --------------------------------------------------------------
-- 연습문제
-- 1. 고객 테이블에서 고객명, 생년월일, 성별 출력
SELECT clientName, clientBirth, clientGender FROM client;

-- 2. 고객 테이블에서 주소만 검색하여 출력 (중복되는 주소는 한번만 출력)
SELECT DISTINCT clientAddress FROM client;
SELECT clientAddress FROM client;

-- 3. 고객 테이블에서 취미가 '축구'이거나 '등산'인 고객의 고객명, 취미 출력
SELECT clientName, clientHobby 
FROM client
WHERE clientHobby = '축구' OR clientHobby = '등산';

-- 4. 도서 테이블에서 저자의 두 번째 위치에 '길'이 들어 있는 저자명 출력
-- (중복되는 저자명은 한번만 출력)
SELECT DISTINCT bookAuthor FROM book
WHERE bookAuthor LIKE '_길%';

-- 5. 도서 테이블에서 발행일이 2019년인 도서의 도서명, 저자, 발행일 출력
SELECT bookName, bookAuthor, bookDate FROM book 
WHERE bookDate LIKE '2019%';

-- 6. 도서판매 테이블에서 고객번호1, 2를 제외한 모든 판매 데이터 출력
SELECT* FROM bookSale
WHERE clientNo NOT IN('1', '2');

-- 7. 고객 테이블에서 취미가 NULL이 아니면서 
-- 주소가 '서울'인 고객의 고객명, 주소, 취미 출력
SELECT clientName, clientAddress, clientHobby FROM client
WHERE clientHobby IS NOT NULL AND clientAddress LIKE '%서울%';

SELECT clientName, clientAddress, clientHobby FROM client
WHERE clientAddress LIKE '%서울%';

-- '천안'으로 한 경우 결과 다르게 출력
SELECT clientName, clientAddress, clientHobby FROM client
WHERE clientHobby IS NOT NULL AND clientAddress LIKE '%천안%';

SELECT clientName, clientAddress, clientHobby FROM client
WHERE clientAddress LIKE '%천안%';

-- 8. 도서 테이블에서 가격이 25000원 이상이면서 
-- 저자 이름에 '길동'이 들어가는 도서의 도서명, 저자, 가격, 재고 출력
SELECT bookName, bookPrice, bookAuthor, bookStock FROM book 
WHERE bookPrice >= 25000 AND  bookAuthor LIKE '%길동';

-- 9. 도서 테이블에서 가격이 20,000 ~ 25,000원인 모든 도서 출력
SELECT * FROM book
WHERE bookPrice BETWEEN 20000 AND 25000;

-- 10. 도서 테이블에서 저자명에 '길동'이 들어 있지 않는 도서의 도서명, 저자 출력
SELECT bookName, bookAuthor FROM book
WHERE bookAuthor NOT LIKE '%길동%';








