## web 연결
- HttpURLConnection

## 공공기관 API
- [공공데이터 서비스](https://www.data.go.kr/)
- 활용신청
- 마이페이지에서 신청결과 확인

## 파일 설정
- AndroidManifest.xml 에 추가
- <uses-permission android:name="android.permission.INTERNET"/>
- <application> 
- android:usesCleartextTraffic="true"

## Thread
- runOnUiThread 
- handler역할
	- 가져온 데이터를 UI로 넘김
	- 현재 쓰레드가 UI쓰레드이면 액션이 즉시 실행된다
	- 현재 쓰레드가 UI쓰레드가 아니면 액션은 UI쓰레드의 이벤트 큐에 올라간다



