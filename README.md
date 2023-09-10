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
#### 파이어베이스 등록 (Firebase Authentication 사용)
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/ff61dada-aa51-4d3d-85d0-9e741c64aca4)       
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/057312a2-65c2-4367-b437-ef908e419881)            
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/fde6dbee-65f2-402d-9ff0-007958cfed3a)     
```
capstonedesign이라는 이름의 파이어베이스 프로젝트를 생성하고 앱 등록에서 패키지명(com.example.capstonedesign)을 넣고
구성 설정 파일을 다운받아서 project의 app폴더에 넣어준다.

Firebase Sdk를 지시대로 넣어준다. plugin 등등 이때 app 수준의 build.gradle 파일인지 project 수준의 build.gradle 파일인지 잘 구분해서
넣는다.

빌드-Authentication에서 이메일, 비밀번호, 익명 사용설정한다.
```
[파이어베이스 Android 공식 문서](https://firebase.google.com/docs/auth/android/start?hl=ko)    
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/8d4b264d-9044-49a2-987e-9206d6c05408)    
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/383521be-f7d1-49a7-ae60-120df9d9dea1)   
```
Android에서 Firebase 인증 시작하기 공식문서를 참조하여 기존 회원을 넣는 작업을 수행하였다.
여기서 Java의 형태로 auth를 생성하고 회원가입페이지가 실행되었을 때 임의의 이메일과 비밀번호를 가지는 유저를 삽입해보았다.
정상적으로 임의의 이메일과 비밀번호를 가지는 유저가 Firebase Auth에 저장됨을 확인할 수 있었다.
```
## joinActivity(회원가입)페이지 데이터바인딩
#### 이메일, 비밀번호 체크 로직
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/ca8617cf-3b46-4d4c-9395-ecf6c0dee8de)
```
joinActivity를 바인딩하기 위해서 joinActivity 레이아웃의 코드를 layout으로 감싼 후에
joinActivity(회원가입) 액티비티에서 회원가입하기 버튼을 눌렀을 때 이메일과 비밀번호 데이터 값을 전달하기 위해서
joinActivity 데이터 바인딩을 생성합니다. joinActivity의 버튼에 joinBtn id를 부여하고
버튼을 클릭했을 때 발생하는 이벤트리스너에서 이메일과 패스워드 EditText에 입력된 것 각각을 email, password1, password2 변수에
텍스트 문자열 형태로 저장합니다. (각 EditText의 id를 부여한 후)

email, password1, password2가 비어있을 때 토스트 메시지를 출력하도록 로직을 수정하고
password1과 password2가 같지 않을 때 비밀번호를 똑같이 입력하라는 메시지를 출력하도록 수정합니다.
또 password1 비밀번호의 길이가 6보다 작을 때 비밀번호를 6보다 길게 입력하라는 메시지를 출력하도록 수정합니다.
isGoToJoin boolean 변수값이 true에서 각 조건 즉 이메일, 비밀번호가 비어있거나 비밀번호가 6자 이상이거나, password1, password2가 같지않을때
isGoToJoin 변수 값이 false로 변경되게하고 isGoToJoin이 true일 때(즉 회원가입을 할 수 있는 조건이 되는 이메일과 비밀번호일 때)
파이어베이스 auth에 이메일과 패스워드를 가지고 유저를 생성하도록 합니다.
```
## 23.09.08 개발일지
#### 올바른 이메일과 비밀번호를 입력했을 때 성공 메시지와 함께 화면 이동
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/654f2c2d-0c1e-48d6-a7ab-4a7dcd9f4ced)
#### MainActivity에서 뒤로가기를 눌렀을 때 앱이 종료
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/aad77945-328d-43c7-928c-b13e82ec7662)
```
이메일과 패스워드를 입력하고 회원가입하기 버튼을 눌렀을 때 화면이 이동되도록 intent를 만들어주었다.
이때 intent의 flags의 NEW_TASK, CLEAR_TASK 를 사용하여 화면이 MainActivity로 이동된 다음 뒤로가기를 눌렀을 때 앱이 종료되도록 설정한다.
(회원가입(로그인)이 되고 난 후에는 뒤로가기를 했을 때 다시 회원가입 페이지로 가기보다 앱이 종료되는 것이 더 자연스럽기 때문)
```
## 23.09.09 개발일지
#### 로그인 기능 구현
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/5827f3a9-f740-434a-b4d1-a0520df299e8)
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/25cdfee9-54fe-4007-94a7-94a34ef56d49)
```
이제 로그인 기능을 넣기 위해서 로그인 액티비티의 레이아웃을 Layout으로 감싼 후에 바인딩을 생성한다.
로그인 액티비티의 이메일, 패스워드, 로그인버튼에 id를 생성한다.
Firebase auth의 signInWithEmailAndPassword 메서드를 사용하여 이메일과 패스워드로 로그인 시도를 했을 때
성공햇을 때와 실패했을 때의 로직을 구현했다.
로그인에 성공하면 MainActivity로 이동하는 intent를 실행하게끔 한다.(joinActivity의 intent와 동일)
```

## 23.09.10 개발일지
#### 로그아웃 기능 구현
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/98ef4509-d9ba-40da-a7c0-53a6c59b93dc)
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/3dfe2c26-cfce-41c7-ae98-ccbf6e079b42)
```
로그인, 회원가입을 한 후에 나오는 MainActivity에 로그아웃 기능을 하는 버튼을 추가하였다.
MainActivity에 Firebase auth의 signOut 메서드를 사용하여 로그아웃 기능을 구현하고
IntroActivity로 이동하는 intent를 생성하여 화면 이동기능을 추가하였다.
```
#### 익명 로그인 기능 구현
```
IntroActivity의 비회원 로그인 버튼을 바인딩하고 Firebase auth의 signInAnonymously 메서드를 사용하여 익명 로그인을 구현한다.
익명 로그인을 하면 로그인 성공 메시지와 함께 MainAcitivity로 이동하도록 하고 익명 로그인에 실패하면 실패 메시지를 띄운다.
```
#### SplashActivity에서 화면 이동 로직 구현 (로그인User->바로 Main, 로그아웃User->Intro)
```
로그인이 된 유저가 앱을 종료하고 다시 앱에 들어갈 때 MainActivity가 아닌 IntroActivity로 이동하는 문제가 발생함을 확인했다.
SplashActivity 화면이 나타난 후에 auth의 currentUser의 uid 값이 있다면 (로그인을 한 적 있는 경우) MainActivity로 바로 이동하게끔 하고
uid를 체크해서 없다면 (로그인한 적이 없는 경우거나 로그아웃을 한 경우) IntroAcitivty로 이동하게끔 로직을 생성했다.

auth의 currentUser의 uid를 체크하는 과정에서 flutter에서 썼던 ? 구문을 사용하였다, 즉 kotlin 역시도 flutter와 마찬가지로
null saftey(널 안정성) 기능을 제공한다는 것을 확인할 수 있었다.
```
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/0eb2926e-8c8f-4c9f-90fb-1e1727fcadeb)
```
MainActivity의 최상단에는 min_logo 이미지뷰와 menu 이미지 뷰를 하나의 LinearLayout에 구성하고
그 밑에 LinearLayout을 생성하여 구분선 효과를 줬다. (LinearLayout 2개를 쌓음)
```
