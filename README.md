# server-location
WiFi 측위 기반 시스템 서버

>## 220613 근무 내용
> 1. POST, GET 요청 처리 API 생성
> 2. MySQL 데이터베이스 이용, 연동
> 3. 외부 클라우드 서버에 MySQL 설정 및 DB 연결
> 4. 서버에서 데이터베이스에 데이터 추가 및 수정 (미완)
> 
> 기타 : <b>mybatis</b>와 spring-boot, mysql-jdbc-connector 이용

>## 220614 근무 내용
> 1. 데이터베이스에 쿼리 날리고, 결과값 반환 (mapper 위치 혼동)
> 2. Kickoff, 과제계획서

>## 220615 근무 내용
> 1. 테이블 스키마 변경(uuid 열 추가, 자료형 변경)
> 2. Spring Boot 기본 개념

>## 220616 근무 내용
> 1. 테이블 스키마 변경(building 열 추가)
>
> 기타 : MySQL의 Decimal 형을 Java의 Float 형으로 변환하고 반대로 변환하는 과정에서 오차가 발생할 여지가 있는지 확인해볼 필요가 있음. 오차 발생 여부가 있다면 BigDecimal형으로 치환