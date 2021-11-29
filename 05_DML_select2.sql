
use sqldb3;

/*
	ORDER BY 
	특정 열의 값을 기준으로 쿼리 결과 정렬
	ASC : 오름차순 (생략 가능)
	DESC : 내림차순
*/ 

-- 도서명 순으로 도서 검색 (기본 : 오름차순 (일반적으로 ASC 생략))
SELECT *
FROM book
ORDER BY bookName ASC;

-- 일반적으로 ASC 생략
SELECT *
FROM book
ORDER BY bookName;

-- 도서명 순으로 도서 검색 (내림차순 : DESC)
SELECT *
FROM book
ORDER BY bookName DESC;

-- 한글-영문-숫자 순
SELECT *
FROM book
ORDER BY
(CASE WHEN ASCII(SUBSTRING(bookName, 1)) BETWEEN 48  AND 57 THEN 3
	  WHEN ASCII(SUBSTRING(bookName, 1)) < 122 THEN 2 ELSE 1 END), bookName;
-- 영어 대문자 A ~ Z : 65 ~ 90
-- 영어 소문자 a ~ z : 97 ~ 122
-- 숫자 0 ~ 9: 48 ~ 57

-- 영문 - 한글 - 숫자 순
SELECT *
FROM book
ORDER BY
(CASE WHEN ASCII(SUBSTRING(bookName, 1)) BETWEEN 48  AND 57 THEN 3
	  WHEN ASCII(SUBSTRING(bookName, 1)) < 122 THEN 1 ELSE 2 END), bookName;

-- ------------------------------------------------------
/* 
	상위 N개 출력 : LIMIT N
	LIMIT 5
	또는 OFFSET 0 설정 (OFFSET : 시작 위치) - 첫 번째부터 시작
	LIMIT 5 OFFSET 0

	또는 LIMIT 시작, 개수
	LIMIT 0, 5  : 첫 번째부터 5개
	LIMIT 10, 5 : 11번째부터 5개
*/

-- 상위 N개 출력 : LIMIT N
SELECT *
FROM book
ORDER BY bookName
LIMIT 5; -- 첫 번째부터 5개 (상위 5개)

SELECT *
FROM book
ORDER BY bookName
LIMIT 5 OFFSET 0; -- 첫 번째부터 5개 (상위 5개)

SELECT *
FROM book
ORDER BY bookName
LIMIT 0, 5; -- 첫 번째부터 5개 (상위 5개)

SELECT *
FROM book
ORDER BY bookName
LIMIT 10, 7; -- 11번쩨부터 7개

SELECT *
FROM book
LIMIT 10, 5; -- 11번쩨부터 5개
-- -------------------------------------

-- 정렬 계속
-- 도서 테이블에서 재고 수량을 기준으로 내림차순 정렬하여
-- 도서명, 저자, 재고 출력
SELECT bookName, bookAuthor, bookStock
FROM book
ORDER BY bookStock DESC;

-- 2차 정렬
-- 도서 테이블에서 재고 수량을 기준으로 내림차순 정렬하여
-- 도서명, 저자, 재고 출력
-- 재고 수량이 동일한 경우, 저자명으로 오름차순 2차 정렬
SELECT bookName, bookAuthor, bookStock
FROM book
ORDER BY bookStock DESC, bookAuthor ASC;

-- 2차 정렬 시에도 ASC 생략 가능
SELECT bookName, bookAuthor, bookStock
FROM book
ORDER BY bookStock DESC, bookAuthor;

-- ----------------------------------------------
/*
	집계 함수
	SUM() : 합계
	AVG() : 평균
	COUNT() : 선택된 열 행 수 (널 값은 제외)
	COUNT(*) : 모든 열을 대상으로 전체 행 수
	MAX() : 최대
	MIN() : 최소
*/ 

-- SUM() : 합계

-- 도서 테이블에서 총 재고 수량 계산하여 출력
-- 열 이름으로 함수 코드 SUM(bookStock)이 출력
SELECT SUM(bookStock) 
FROM book;

-- 열 이름 'sum of bookStock' 총 재고수량 계산하여 출력alter
SELECT SUM(bookStock) AS 'sum of bookStock'
FROM book;

-- 열 이름으로 한글 가능
SELECT SUM(bookStock) AS '총 재고량'
FROM book;

-- 큰 따옴표, 작은 따옴표 다 사용 가능
SELECT SUM(bookStock) AS "총 재고량"
FROM book;

-- 열이름에 공백이 들어 있지 않으면 따옴표 없어도 됨
SELECT SUM(bookStock) AS 총재고량
FROM book;

-- 도서판매 테이블에서
-- 고객번호 2인 호날두가 주문한 도서의 총 주문 수량 계산하여 출력
SELECT SUM(bsQty) AS '총 주문 수량'
FROM booksale
WHERE clientNo = '2'; 

-- 확인
SELECT clientNo, bsQty FROM bookSale;

-- MIN() / MAX()

-- 도서판매 테이블서 최대/최소 주문수량
SELECT MAX(bsQty) AS "최대 주문량", MIN(bsQty) AS "최소 주문량"
FROM booksale;

-- 도서 테이블에서 도서의 가격 총합, 평균가, 최고가, 최저가 출력
SELECT SUM(bookPrice) AS '가격 총합',
	   AVG(bookPrice) AS 평균가,
       MAX(bookPrice) AS 최대가,
       MIN(bookPrice) AS 최저가
FROM book;

-- AS 없어도 됨
SELECT SUM(bookPrice) '가격 총합',
	   AVG(bookPrice) 평균가,
       MAX(bookPrice) 최대가,
       MIN(bookPrice) 최저가
FROM book;

-- 평균가를 정수로 표현 (반올림) : ROUND(숫자)
-- 소수 이하 자리수 출력 : ROUND(숫자,소수이하 자리수)
SELECT SUM(bookPrice) AS '가격 총합',
	   ROUND(AVG(bookPrice)) AS 평균가,
       MAX(bookPrice) AS 최대가,
       MIN(bookPrice) AS 최저가
FROM book;

-- COUNT(*) / COUNT(열이름)
-- 도서판매 테이블에서 도서 판매 건수 출력 (모든 행의 수)
SELECT COUNT(*) AS "총 판매 건수"
FROM bookSale;

-- 고객 테이블에서 전체 고객 수 (모든 행의 수 출력)
SELECT COUNT(*) AS "총 고객 수"
FROM client;

-- 전체 취미 출력  : 9개 행
SELECT clientHobby FROM client;

-- 고객 테이블에서 총 취미 개수 출력 - 7개
-- NULL 값은 제외
SELECT COUNT(clientHobby) AS '취미'
FROM client;

-- 취미 열에서 값이 들어 있은 행의 수 출력 - 5 개 (NULL과 공백 제외)
SELECT COUNT(clientHobby) AS '취미'
FROM client
WHERE clientHobby NOT IN ('');
-- 총 9개
-- NULL 2개, 공백 2개

-- 또는 결과 동일
SELECT COUNT(clientHobby) AS '취미'
FROM client
WHERE clientHobby != '';

-- -----------------------------------------------------
/*
	GROUP BY  절
	그룹 쿼리를 기술할 때 사용
	특정 열로 그룹화한 후 각 그룹에 대해 한 행씩 쿼리 결과 생성
*/

-- 도서판매 테이블에서 도서별로 판매수량 합계 출력
SELECT bookNo, SUM(bsQty) AS "판매량 합계"
FROM booksale
GROUP BY bookNo;
-- 1002 : 4개
-- 1004 : 2개

SELECT * FROM booksale;

-- GROUP BY 절에서 정렬 : 열이름으로 정렬
SELECT bookNo, SUM(bsQty) AS "판매량 합계"
FROM booksale
GROUP BY bookNo
ORDER BY bookNo;

-- 또는 열 순서로 정렬해도 됨
SELECT bookNo, SUM(bsQty) AS "판매량 합계"
FROM booksale
GROUP BY bookNo
ORDER BY 1; -- 첫 번째 열(bookNo)로 정렬

-- 두 번째 열(판매량 합계)로 정렬
SELECT bookNo, SUM(bsQty) AS "판매량 합계"
FROM booksale
GROUP BY bookNo
ORDER BY 2; 

SELECT bookNo, SUM(bsQty) AS "판매량 합계"
FROM booksale
GROUP BY bookNo
ORDER BY "판매량 합계"; -- 정렬 안 됨 -- 열 이름에 따옴표 있으면 정렬 안됨

SELECT bookNo, SUM(bsQty) AS 판매량합계
FROM booksale
GROUP BY bookNo
ORDER BY 판매량합계; -- 열 이름에 따옴표 없으면 정렬됨 (열 이름에 공백 없어야 함)

-- ----------------------------------------------
/*
	HAVING 절
	HAVING 조건
	GROUP BY 절에 의해 구성된 그룹들에 대해 적용할 조건 기술
	SUM(), AVG(), MAX(), MIN(), COUNT() 등의 집계 함수와 함께 사용
	주의 !!
	반드시  GROUP BY 절과 함께 사용
	WHERE 절보다 뒤에
	검색 조건에 집계함수가 와야 함
*/

-- 도서 테이블에서 가격이 25000원 도서에 대해서
-- 출판사별로 도서 수 합계 (출판사별 : 그룹화)
-- 단, '도서 수 합계'가 2인 이상만 출력
SELECT pubNo, COUNT(*) AS "도서 수 합계"
FROM book
WHERE bookPrice >= 25000
GROUP BY pubNo
HAVING COUNT(*) >= 2;
-- 1 2
-- 2 6

-- HAVING 조건이 없는 경우
SELECT pubNo, COUNT(*) AS "도서 수 합계"
FROM book
WHERE bookPrice >= 25000
GROUP BY pubNo;
-- 1 2
-- 2 6
-- 3 1

-- ----------------------------------------------
-- 연습문제

-- 1. 도서 테이블에서 가격 순으로 내림차순 정렬하여, 
-- 도서명, 저자, 가격 출력. 
-- (가격이 같으면 저자 순으로 오름차순 정렬)
SELECT bookName, bookAuthor, bookPrice
FROM book
ORDER BY bookPrice DESC, bookAuthor ASC;

-- 2. 도서 테이블에서 저자에 '길동'이 들어가는 도서의 
-- 총 재고 수량 계산하여 출력
SELECT SUM(bookStock) AS "총 재고 수량"
FROM book
WHERE bookAuthor LIKE '%길동%'; -- 23개

SELECT bookAuthor, bookStock
FROM book;


-- 3. 도서 테이블에서 '서울 출판사' 도서 중 최고가와 최저가 출력 
SELECT MAX(bookPrice) AS "최고가", MIN(bookPrice) AS "최저가"
FROM book
WHERE pubNo = '1';

SELECT bookName, bookPrice, pubNo
FROM book
WHERE pubNo = '1';

SELECT * FROM publisher;


-- 4. 도서 테이블에서 출판사별로 '총 재고 수량'과 '평균 재고 수량' 계산하여 출력
-- 총 재고 수량"으로 내림차순 정렬
SELECT pubNo, SUM(bookStock) AS 총재고수량,
			  AVG(bookStock) AS '평균 재고 수량'
FROM book 
GROUP BY pubNo
ORDER BY 총재고수량 DESC;

-- 주의!! : MySQL에서는 ORDER BY 다음의 열이름에 따옴표 있으면 안 됨
SELECT pubNo, SUM(bookStock) AS '총재고수량',
			  AVG(bookStock) AS '평균 재고 수량'
FROM book 
GROUP BY pubNo
ORDER BY '총재고수량' DESC; -- 따옴표 있으면 정렬 안 됨

-- 열이름 대신 숫자 사용
SELECT pubNo, SUM(bookStock) AS '총재고수량',
			  AVG(bookStock) AS '평균 재고 수량'
FROM book 
GROUP BY pubNo
ORDER BY 2 DESC; 


-- 정수로 표현 (반올림)
SELECT pubNo, SUM(bookStock) AS "총 재고 수량",
			  ROUND(AVG(bookStock)) AS "평균 재고 수량"
FROM book 
GROUP BY pubNo
ORDER BY 2 DESC;

-- 소수 둘째 자리까지 출력
SELECT pubNo, SUM(bookStock) AS "총 재고 수량",
			  ROUND(AVG(bookStock), 2) AS "평균 재고 수량"
FROM book 
GROUP BY pubNo
ORDER BY 2 DESC;

-- 올림 : CEIL()
SELECT pubNo, SUM(bookStock) AS "총 재고 수량",
			  CEIL(AVG(bookStock)) AS "평균 재고 수량"
FROM book 
GROUP BY pubNo
ORDER BY 2 DESC;

-- 버림 : FLOOR()
SELECT pubNo, SUM(bookStock) AS "총 재고 수량",
			  FLOOR(AVG(bookStock)) AS "평균 재고 수량"
FROM book 
GROUP BY pubNo
ORDER BY 2 DESC;

-- 5. 도서판매 테이블에서 고객별로(그룹화:기본키(외래키)) 
-- '총 주문 수량'과 '총 주문 건수' 출력. 단 주문 건수가 2이상인 고객만 해당.
SELECT clientNo, COUNT(*) AS "총 주문 건수", SUM(bsQty) AS "총 주문 수량"
FROM bookSale
GROUP BY clientNo
HAVING COUNT(*) >= 2; 
-- 2건, 3건 출력됨

-- HAVING 조건이 없는 경우 : 1건들도 출력
SELECT clientNo, COUNT(*) AS "총 주문 건수", SUM(bsQty) AS "총 주문 수량"
FROM bookSale
GROUP BY clientNo;

SELECT clientNo, bsQty
FROM bookSale;

