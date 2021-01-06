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

# 2. FAQ 게시판

<img src="https://user-images.githubusercontent.com/66407414/103773438-653c3000-506e-11eb-8da5-8f7005df9ac2.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="faqList"></img>

- 각 분류 선택 시 contentGroup의 값을 받아 결과 값을 다시 출력.

<img src="https://user-images.githubusercontent.com/66407414/103773000-bdbefd80-506d-11eb-831f-fe60d88c6172.gif" width="400%" height="300%" title="px(픽셀) 크기 설정" alt="faqList"></img>

- 키워드 검색 시 입력한 값을 받아서 값이 포함된 결과를 산출,그 검색한 결과에 분류 선택 시 해당 분류에 검색 결과를 산출.
