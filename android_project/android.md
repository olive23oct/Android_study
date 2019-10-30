# 안드로이드 
- [개발자가이드](https://developer.android.com/guide/)

## 안드로이드의 특징
- 오픈소스
- 무료
- 자바기반
- 해상도를 고려해서 만들어야 함
- 하드웨어 장치를 제어해서 어플리케이션을 만들 수 있음
- 17년부터 코틀린 사용 가능

## 안드로이드 스튜디오
1. 자바설치 - jdk1.8
2. [안드로이드 스튜디오](http://developer.android.com) 설치
3. 안드로이드 sdk 설치 - 가상폰
- -vt-x
- SDK manager 
- Android version 선택
 
## 안드로이드 프로젝트

- Android Virtual Device Manager
	- Pixel 3 XL (갤럭시 노트)	
	- system image 다운 
- MainActivity - AppCompatActivity 상속을 받아 사용
- setContentView
	- 화면과 연결
- resource 
- layout
- value	 : 변수화, 언어에 따른 버전 관리
	-stirng : 이름변경
- drawable : 이미지

- toast : 작업에 관한 피드백 제공. 화면에 토스트 메시지 표시
	- Toast.makeText(context, text, duration);
- intent : 웹 페이지 연결, 전화걸기 가능

- 이벤트 
	- 이벤트가 실행되었을 때 어떤 함수를 실행할 것인가
	- 함수 연결 방식
- close project 

## 실습
- 버튼 이벤트
	- 버튼그리기
	- 함수(void onClickAlarm(View view) {} )
	- 이벤트연결
		- 가장 쉬운 방법 : onclick = 정의
- 다른 앱 실행하기 
	- Intent 
- 다른 Activity 생성 및 실행
	- java와 xml 파일 추가
- manifest 에 activity  추가	
- main에서 onClick 함수를 통해 새 activity와 연결. Intent 클래스 
- 새창닫기 : finish()

## 설정
- 폰트 변경 : File - Settings
- 자동 import : File - Settings - IDE setting - Editor - Auto Import 두 개 항목 선택
