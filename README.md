# Mobile_Programming
컴퓨터공학과 모바일 프로그래밍 정리입니다.

## 23.09.06 프로젝트 개발 일지
#### [SplashActivity 3초간 지속 후 IntroActivity로 변경]
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/63361fdc-ecbe-484d-aa3e-37297a21537b)       
#### [auth패키지의 IntroActivity 화면]
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/dbd816b9-cd83-4d6f-afd6-05c2748ad7f3)    
```
SplashActivity 화면을 구현한 후에 배경색을 노랑색으로 변경하고
로고 이미지를 다운받아서 Split으로 화면의 정중앙에 위치시켰다.
또 메인화면으로 바로 SplashActivity가 나올 수 있도록 AndroidManifest 에서 intent 태그를 SplashActivity 안으로 넣어주었다.

values/themes.xml에서 WindowNoTitle 값을 True로 줘서 타이틀 바를 없앴다.
values/colors.xml에서 mainColor를 정의하여 색상코드없이 사용할 수 있도록 하였다.
상태표시바 colorPrimaryVariant를 mainColor로 변경하여 전체적인 색상의 통일성을 부여하였다.

다음으로 로그인,로그아웃,회원가입 등 계정인증과 관련한 패키지 auth를 생성하고
패키지 안에 IntroActivity를 생성하였다.

SplashActivity를 3초간 띄우고 IntroActivity를 띄우도록 Handler.postDelayed를 사용하였다.

플러터를 사용할 때보다 핫리로드 기능이 없다는 단점과
layout의 Split에서 로고의 위치를 마우스로 설정할 수 있다는 장점을 발견하였다.

다음으로 auth 패키지 안의 IntroActivity를 꾸며준다.
```
## 23.09.07 프로젝트 개발 일지
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/8545fefe-0167-423a-9aba-9941091b225a)
```
Relativelayout 안에 이미지View를 두 개 넣고 LinearLayout(orientation:vertical) 안에 로그인, 회원가입, 비회원 가입 버튼을 세 개 추가하였다.
다음에는 intent를 사용하여 버튼을 눌렀을 때 화면이 이동하는 기능을 추가할 예정이다.    
```
## 23.09.07 프로젝트 개발 일지
```
auth 패키지 안에 LoginActivity(로그인버튼 눌렀을때 이동할 화면), JoinActivity(회원가입버튼 눌렀을 때 이동할 화면)을 생성한다.
데이터 바인딩과 뷰 바인딩 중 데이터 바인딩 기술을 사용하기 위해서 Gradle Script 밑의 build.gradle(Module: app이름)의 android 안에
다음에 해당하는 코드 dataBinding { enabled true }를 넣고 Sync now를 선택한다.
activity_IntroActivity의 코드를 layout으로 감싼다.
IntroActivity에 바인딩을 생성한다. 바인딩을 생성한 후 에는 activity_IntroActivity에 가서 버튼에 각각 id를 부여하였다.
로그인 android:id="@+id/loginBtn", 회원가입 android:id="@+id/joinBtn", 비회원 가입 android:id="@+id/noAccountBtn"
다시 IntroActivity로 가서 binding.loginBtn.setOnClickListenr 이벤트리스너를 사용하여 LoginActivity로 이동하는 intent를 생성한 후
startActivity로 intent를 넣어준다. 회원가입도 같은 방법으로 생성한다.
각 버튼을 눌렀을 때 이벤트리스너에 넣은 각각의 액티비티로 화면전환을 하는 기능을 구현하였다.
다음에는 LoginActivity와 JoinActivity에 UI를 넣어준다.
auth 패키지 안에 LoginActi지
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/8620a8e3-f721-4df6-951e-f448af172dc1)
```
#### 로그인 페이지
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/460a3f47-8c16-4c94-973b-e7a385dcc2bf)
```
Login페이지를 꾸며줄텐데 LinearLayout 안에 로그인 텍스트뷰를 상단 가운데에 넣어주고
LinearLayout안에 하나의 EditText를 넣어주었다.
EditText의 바깥부분을 꾸며주는 LinearLayout 하나를 넣었다.
EditText 레이아웃 스타일(background, textSize, margin)을 themes.xml 파일의
AuthEditText라는 이름의 style의 item으로 넣어주었다.
style="@style/AuthEditText"를 넣어서 만든 스타일을 적용하였다.
회원가입 페이지(joinActivity)같은 경우에는 로그인 페이지(loginActivity)과 유사하기에 코드를 로그인 페이지에서 가져와서 수정하는 방식으로 만들었다.

같은 방법으로 EditText를 복사해서 비밀번호 입력칸을 만들어주고
inputType을 패스워드로 줘서 입력했을 때 *모양이 들어가도록 수정하였다.
마지막으로 최하단에 로그인하기 버튼을 생성하였다.
다음으로 Firebase 데이터베이스를 사용하기 위한 준비를 한다.
```












