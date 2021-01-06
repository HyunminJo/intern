## 크루메이트 인턴
### 작성자 : 조현민
### 인턴 기간 : 2020년 10 5일 ~ 2021년 01월 04일

---

## Development Environment(개발 환경)
<table>
 <tr>
   <td><b>Development tools</b></td>
   <td>Spring Boot</td>
 </tr>
 <tr>
   <td><b>DBMS</b></td>
   <td> Oracle -SQL Developer</td> 
 </tr>
 <tr>
   <td><b>Server</b></td>
   <td>Apache Tomcat 8.5</td> 
 </tr>
 <tr>
   <td><b>language</b></td>
   <td>Java, HTML5, CSS3, javascript, JQuery, Servlet, MyBatis, Spring</td> 
 </tr>
 <tr>
  <td><b>Design</b></td>
  <td>Responsive Web</td> 
 </tr>
</table>

![캡처](https://user-images.githubusercontent.com/66407414/103542154-dac5c600-4edf-11eb-9f4f-5e71e97f9ea7.PNG)
<br/>

# 1. 팝업창 관리
<img src="https://user-images.githubusercontent.com/66407414/103749178-84c06200-5048-11eb-9f01-565ddd9ff9a1.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="popupList"></img>

- 일반 게시판에서 응용하여 전시일자와 팝업 구분, 전시여부를 검색조건 구현.

<img src="https://user-images.githubusercontent.com/66407414/103749886-6f980300-5049-11eb-9e52-a995a007eb8b.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="insertPopup"></img>

- Mode가 'create' 일 경우 팝업 등록으로 이동.
- 팝업이 열리는 일자와 팝업 위치, 크기, 팝업 구분 등 옵션을 추가한다.
- 팝업 종료일자가 시작일자보다 빠르면 alert으로 알림.
- 팝업 크기 입력 값이 없으면 alert으로 알림.
- 팝업 시작점 입력 값이 없으면 alert으로 알림.
- 팝업창명 입력 값이 없으면 alert으로 알림.
- 내용 입력 값이 없으면 alert으로 알림.

<img src="https://user-images.githubusercontent.com/66407414/103766534-52bbf980-5062-11eb-826c-5b9c01d2d3a7.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="updatePopup"></img>

- Mode가 'update' 일 경우 팝업 수정.
- 입력 값은 팝업 등록과 동일.

<img src="https://user-images.githubusercontent.com/66407414/103766829-dbd33080-5062-11eb-883e-56a5bbcf6073.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="deletePopup"></img>

- popup 시퀀스 번호를 받아서 해당 popup의 전시 여부를 'N'으로 수정.
---
# 2. FAQ 게시판

<img src="https://user-images.githubusercontent.com/66407414/103773438-653c3000-506e-11eb-8da5-8f7005df9ac2.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="faqList"></img>

- 각 분류 선택 시 contentGroup의 값을 받아 결과 값을 다시 출력.

<img src="https://user-images.githubusercontent.com/66407414/103773000-bdbefd80-506d-11eb-831f-fe60d88c6172.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="faqList"></img>

- 키워드 검색 시 입력한 값을 받아서 값이 포함된 결과를 산출,그 검색한 결과에 분류 선택 시 해당 분류에 검색 결과를 산출.
---
# 3. 상품 등록

<img src="https://user-images.githubusercontent.com/66407414/103774715-5bb3c780-5070-11eb-8b82-78662a043615.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="insertProduct1"></img>

- ajax를 사용하여 업체와 원산지 목록을 출력.
- 팝업을 사용하여 브랜드 list 출력 후 브랜드 선택한 값을 callback 함수를 실행하여 브랜드 이름 출력.
- 상단 아이콘과 하단 아이콘은 단 한 개씩만 출력.
- ajax를 사용하여 상품의 분류 목록을 받아오고 받아 온 값을 다시 ajax를 사용하여 해당 값의 하위 목록을 출력.
- 분류 정보 삭제 시 alert으로 꼭 하나는 존재하도록 구현.
- 정상가와 판매가에 값이 없을 경우 alert으로 설정.

<img src="https://user-images.githubusercontent.com/66407414/103774719-5ce4f480-5070-11eb-8036-84d13cd83350.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="insertProduct2"></img>

- 옵션사용여부에서 사용으로 클릭 시 ajax를 통하여 버튼 속성 변경.
- 옵션재고추가 버튼 클릭 시 옵션 분류명과 옵션명을 합쳐 옵션 갯수 만큼 조합, 추가금액은 합산.
- 옵션사용여부에서 사용 시 재고추가 후의 사용여부 체크박스 칸이 값이 없을 경우 alert으로 설정.

<img src="https://user-images.githubusercontent.com/66407414/103774720-5d7d8b00-5070-11eb-9153-9dacddf123c9.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="insertProduct3"></img>

- 관련상품정보 있음으로 클릭 시 ajax를 사용하여 버튼 속성 변경.
- 관련상품추가 버튼 클릭 시 팝업 창 띄우고 상품들을 list 형식으로 출력.
- 상품을 검색할 수 있는 기능 추가.
- 상품 체크 박스 클릭 후 입력 버튼 클릭 시 선택한 상품의 값을 callback 함수를 실행하여 ajax로 출력.
- 정보고시정보 해당 분류 마다 ajax로 행 출력.
- 대표 이미지 추가 시 상품 이미지정보의 첫 메인 화면에 출력.
- 상품 상세정보는 위즈윅을 사용하여 구현.
---
# 3. 회원가입

<img src="https://user-images.githubusercontent.com/66407414/103778775-14303a00-5076-11eb-9c45-5de4c2633370.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="addUser1"></img>

- 이름과 핸드폰 번호를 조회하여 기존 회원인지 구분.
- 개인정보 수집 및 이용 동의의 선택 정보와 마케팅 개인정보 활용 동의에 체크 시 회원정보 입력 페이지에서 표시, 미체크시 안보이게 구현.

<img src="https://user-images.githubusercontent.com/66407414/103778781-15f9fd80-5076-11eb-9a5c-fb12a688f7c0.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="addUser2"></img>

- 아이디 중복 체크 구현
- 휴대폰 번호가 이미 기존 회원과 동일하면 가입 못하게 구현.

