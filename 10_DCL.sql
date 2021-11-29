-- 10_DCL.sql

use sqldb3;

use mysql;

-- DCL

-- 사용자 계정 조회
SELECT * FROM user;

-- 사용자 계정 생성
-- CREATE USER 계정@호스트 idendified by 비밀번호
-- 호스트
	-- localhost : 로컬에서 접근 가능
    -- 192.168.172.1 : 특정 IP에서 접근 가능
    -- '%' : 어디에서나 접근 가능
    
-- 비밀번호 변경
-- SET PASSWORD for '계정명'@호스트 = '새 비밀번호';

-- 계정 삭제 : DROP USER 계정@호스트;

-- 계정 생성
CREATE USER newuser1@'%' identified by '1111';
-- newuser1으로 Connecton 생성해서 서버에 연결되는 확인
-- 스키마 접근 불가

-- 비밀번호 변경
SET PASSWORD for 'newuser1'@'%' = '1234';
-- 서버 연결 해본다 : 기존 번호 1111로 하면 안 되고, 
-- 새 비밀번호 1234로 하면 됨

-- 계정 삭제
DROP USER 'newuser1'@'%';

-- ------------------------------------------------------
-- 권한

-- 권한 조회 : SHOW GRANTS FOR 사용자계정;
SHOW GRANTS FOR dbuser;

-- 권한 부여 : GRANT 권한 ON 데이터베이스.테이블 TO 계정@호스트;
-- 모든 권한 부여 : GRANT ALL PRIVILEGES ON *.* TO 계정@호스트;

-- 특정 DB의 모든 테이블에 특정 권한 부여
-- GRANT select, insert, update, delete ON DB명.* TO 계정@호스트;

-- 특정 DB의 모든 테이블에 대한 권한 삭제
-- REVOKE ALL PRIVILEGES ON DB명.* FROM 계정@호스트;

-- 특정 DB의 모든 테이블에 대해 특정 권한 삭제
-- REVOKE select, insert, update, delete ON DB명.* FROM 계정@호스트;

-- 권한 실습

-- 계정 생성
CREATE USER newuser1@'%' identified by '1111';

-- newuser1 권한 조회
SHOW GRANTS FOR newuser1;

-- 서버 접속 가능
-- 아무런 스키마 안 보임 : 스키마 사용 권한 없음

-- 모든 권한 부여 : GRANT ALL PRIVILEGES ON *.* TO 계정@호스트;
GRANT ALL PRIVILEGES ON *.* TO newuser1@'%';

-- newuser1 권한 조회
SHOW GRANTS FOR newuser1;
-- 다시 접속
-- 모든 스키마/테이블 접근 가능

-- newuser1의 SELECT 권한 삭제
REVOKE select ON *.* FROM newuser1@'%';
-- 테이블 접근 가능한지 확인 : Tables could not fetched
-- 테이블 접근 불가

-- newuser1의 권한 조회
SHOW GRANTS FOR newuser1;
-- select 권한 없음

-- sqldb3의 모든 테이블에 select 권한 부여
GRANT select ON sqldb3.* TO newuser1@'%';
-- 다른 스키마(데이터베이스) 테이블 : Tables could not fetched
-- sqldb3만 테이블 접근 가능

SHOW GRANTS FOR newuser1;
-- select 권한 추가됨


