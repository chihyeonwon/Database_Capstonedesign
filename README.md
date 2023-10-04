# 데이터베이스응용_캡스톤디자인 프로젝트
컴퓨터공학과 캡스톤디자인 프로젝트 정리입니다.

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
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/8620a8e3-f721-4df6-951e-f448af172dc1)
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
#### Navigation
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/6cf26d60-6a63-4676-ae7f-25c98fbda9b8)
```
app에서 main_nav Android Resource File을 추가한다. 이 때 Resource Type을 Navigation으로 한다.

Fragment들을 넣을 패키지를 생성하고 그 아래에 5개의 Fragment들을 만들어 준다. (탭이 5개 필요하기 때문)
(HomeFragment(Blank), TipFragment, TalkFragment, BookmarkFragment, StoreFragment)

activity_main.xml- Design - Containers - NavHostFragment를 넣는다. (이 때 main_nav Resource File을 선택)

main_nav Design에서 생성한 5개의 fragment들을 추가한다.
```
#### Home Fragment Layout 
![image](https://github.com/wonttan/Mobile_Programming/assets/58906858/2899fd77-2cb8-4c4d-8780-78e946455950)
```
homeFragement의 최하단에 Navigation layout을 만들어 주기 위해서 LinearLayout 안에 5개의 이미지를 넣었다.
(각 이미지의 layout_weight를 1로하고 부모 layout에서 weightSum을 5로 줘서 5개의 이미지의 비율을 일정하도록 하였다)
데이터 바인딩을 이용하기 위해 이미지 뷰 각각에 id를 부여하고 코드를 layout으로 감싼다.

다음에는 각 이미지를 클릭했을 때 fragment가 전환되는 기능을 구현하면 될 것 같다.
```
#### Navigate to Tiptap Fragment
![image](https://github.com/wonchihyeon/Mobile_Programming/assets/58906858/57cddf57-279f-4191-8895-fdbe4dc56580)
![image](https://github.com/wonchihyeon/Mobile_Programming/assets/58906858/d0b1c4a2-3e16-4733-8e8c-bb2595cee835)
```
homeFragment에서 바인딩을 생성한다.(DataBindingUtil.inflate)

main_nav의 design에서 homeFragment 와 나머지 4개의 fragments를 연결한다.(action 생성)
homeFragment에서 바인딩한 tiptap을 클릭했을 때
it.findNavController().navigate(R.id.action_homeFragment_to_tipFragment) 메서드를 이용하여 tipFrament로 이동하도록 설정하였다.
```
#### 탭 표시바 생성
![image](https://github.com/wonchihyeon/Mobile_Programming/assets/58906858/edb72b7e-b4af-415a-96bd-6acddc27bf96)     
![image](https://github.com/wonchihyeon/Mobile_Programming/assets/58906858/bd579a5b-e6f8-46ff-96ea-3c6fdede60d7)    
```
탭이 어떤 Fragment에 위치하는 지 알 수 있게 표시하기 위해서 LinearLayout 5개를 사용하여 탭 표시바를 생성한다.
LinearLayout 5개를 나열하되 layout_weight="1"로 줘서 5개의 영역으로 나누고 각 Fragment의 LinearLayout 영역의 색을 변경한다.
```
## 23.09.11
#### Fragment 연결
![image](https://github.com/wonchihyeon/Mobile_Programming/assets/58906858/707867e4-16b2-45e4-afa2-25e5c80cc7f9)
```
각 Fragment들을 모두 연결한다.
 homeFragment에서 사용한 navigate함수를 조금씩 바꿔가면서 나머지 Fragment들의 코드들을 Fragment에 맞게 고친다.
```
## 23.09.16 개발일지
#### Tip Fragment UI 
![image](https://github.com/wonchihyeon/Mobile_Programming/assets/58906858/e458048f-a987-4f2c-8c78-ca96ac82c1f6)
```
Tip Fragment의 레이아웃은 하나의 Layout에 3개의 이미지를 일정한 간격으로 배치한 후
이 LinearLayout 세 개를 Vertical 수직으로 배치하였습니다.
```
## 23.09.18 개발일지
#### ContentsList Activity
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/6ef8acfb-101d-4843-9a62-5f531e9517cf)
```
팁 Fragment에서 Contents를 클릭했을 때 ContentsList가 나올 Activity를 생성한다.
Activity에는 상단에 TextView와 recycleview를 배치한다.
```
#### content_rv_item layout File 작성
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/e29d0ba8-98cd-43bd-903c-1b41cee97b61)
```
각 Item이 있을 content_rv_item 이름의 Layout 파일을 작성한다
layout 파일에는 상단에 이미지와 텍스트를 넣는다.
```
#### ContentRVAdapter kotlin File 작성
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/1e923414-3cb1-428d-9db0-a2de9d246892)
```
ContentRVAdapter를 작성한다.

ContentRVAdapter의 멤버 함수로 onCreateViewHolder, onBindViewHolder, getItemCount를 implement 한다.
onCreateViewHolder에는 생성한 content_rv_item layout을 하나씩 가져오는 것을 수행한다.
onBindViewHolder는 생성한 item을 넣을 수 있도록 하는 작업을 수행한다.
getItemCount는 생성한 Content Item의 개수가 몇 개인지 Item의 size를 리턴한다.
```
#### ContentListActivity 작성
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/d2529c8e-c485-47ba-97e3-b59d2f0fdc3d)   
```
작성한 ContentRVAdapter를 ContentListActivity로 가져온다.

activity_content_list에서 작성한 RecycleView를 findById로 가져와서 rv에 저장한다.

rv에 item을 add 메서드로 넣고

ContentRVAdapter 함수를 호출할때 생성한 item String 타입의 리스트를 매개변수로 넘겨준다.
```
#### TipFragment 화면이동 구현
#### Tip Fragment에서 첫 번째 Contents를 클릭했을 때 화면이동
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/38a5796b-180e-442c-b1c8-5c5b5745ce6e)
```
tip Fragment의 첫 번째 imageView에 category1 이름의 id를 부여하고
이 imageView를 클릭했을 때 ContentsListActivity로 이동하도록 intent를 생성한다.

Tip Fragment에서 첫 번째 ImageView를 클릭하면 ContentsListActivity로 이동하게 되고
item 3개가 정상적으로 화면에 출력됨을 알 수 있다.
```
#### ContentListActivity GridLayoutManager
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/0870e152-23ea-4542-ac55-2dad0d0ab5d7)
```
Content를 Grid(격자)형태로 배치하기 위해서 Manager를 LinearLayoutManager에서 GridLayoutManager로 수정한다.
GridLayoutManager(this, 2) 2줄로 한다.

다음에는 각 item을 데이터로 받아서 Text로 작성하는 작업을 한다.
```
#### RecyclerView Data Flow Diagram
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/283a260a-559b-4763-a75f-646f02763af6)    
#### item을 a,b,c가 아닌 Model을 넘겨준다.
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/efbfafd4-8b7a-40b4-8fe0-2342af79f7ed)    
```
지금까지 생성한 ContentListActivity에서 Adaptor를 통한 데이터 전송의 흐름을 나타내면 다음과 같다.

ContentListActivity에서 생성한 a,b,c 세 개의 item을 Adapter로 보내주고 ContentRVAdapter에서 item들을 하나씩 넘겨준다.
ContentListActivity에서 생성한 rv adpater에 끝으로 연결한다.

다음 작업으로 a, b, c item을 imgUrl과 title이 들어 있는 Model 로 넘긴다.
```
#### ContentModel Kotlin File 작성
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/ead315d4-1d36-434e-bba8-8566d35eb1d4)    
#### ContentListView에서 추가한 ContentModel의 데이터를 화면에 뿌린다.
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/264f9730-b9c1-49e0-b346-fe2726d22283)
```
ContentModel Kotlin File을 작성한다.

data class () 안에 String 타입의 ImageUrl과 title을 넣어준다.

ContentRVAdapter의 데이터 타입을 String에서 ContentModel로 수정하고
add.Item의 매개변수 또한 ContentModel의 데이터타입과 같이 수정한다. ContentModel("imageurl1", "title1")

content_rv_item의 각 요소에 id를 부여하고 (TextView의 id를 textArea)
ContentRVAdapter의 bindItem 함수(items들 하나씩을 화면에 표시해주는 함수)에서 item의 title을 바인딩한 TextView에 대입해준다.
```
#### Android Glide를 사용하여 웹 상의 이미지 가져오기
[imageUrl 소스](https://philosopher-chan.tistory.com/1235)   
[Glide Implementation Github 주소](https://github.com/bumptech/glide)
#### Glide를 사용해서 웹 상의 이미지를 안드로이드 프로젝트에 보여주기
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/298a9434-11af-4df9-85ae-a876fda295b9)     
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/22e73e36-2d24-4487-9d91-10d7160d91b2)
```
imageUrl은 웹에 있는 이미지의 주소를 복사해서 ContentModel의 첫 번째 인자에 넣어준다.
웹에 있는 이미지를 안드로이드에 넣어주기 위해서 Glide를 사용한다.
Glide Implementation을 build.gradle에 추가한다(app 수준)
Glide를 사용하여 웹 상의 이미지 주소를(Glide.load)해서 imageViewArea에 넣어준다(Glide.into).
웹 상의 이미지 데이터가 가져와져서 프로젝트에 나타나는 것을 확인했다.
```
## 23.09.21 개발일지
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/83f83f3f-e2d4-40ce-8323-2abdc983df08)
```
웹 상의 이미지를 모두 추가하였다. imageurl 15개를 넣는 단순 작업이다.
```
#### ContentModel 수정
```
webView 기능을 수행하기 위해
ContentModel에 세 번째에 webUrl 데이터를 넣을 수 있도록 webUrl을 생성하고 웹 이미지가 있는 url을 세 번째 인자로 추가한다.
```
#### RVAdapter 수정
```
RVAdapter에 ItemClick OnClick 메서드를 구현하고 ContentsListActivity에서 Click 메서드를 호출한다.
click메서드 안에 intent를 생성한다.
intent할 Activity인 ContentShowActivity를 생성하고 ContentShowActivity는 webView를 넣는다.
intent의 putExtra를 사용하여 선택한 아이템의 url 데이터를 넘겨주도록 설정했다.(intent.putExtra("url", item[position].webUrl)

ContentShowActivity는 ContentList에서 선택한 아이템의 url 데이터를 받도록 설정했다.
intent.getStringExtra("url")을 사용하여 가져온 webUrl을 getUrl 변수에 저장한다.

webView를 findViewById로 찾고 webView.loadUrl을 사용하여 가져온 url(getUrl)을 load한다.
```
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/0c0ecd2a-ae7f-4322-9f83-68248eb1d126)
```
이미지를 클릭했을 때 웹으로 이동하는 기능을 구현하였다.

이제 Firebase의 데이터베이스를 사용한다.
```
## 23.09.22 개발일지
#### Firebase Realtime Database 설정
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/ea53d17a-de49-4163-bd56-f0b248db705e)
```
Firebase Realtime Database 데이터베이스를 만들고 Firebase 보안 규칙을 수정한다.
```
#### Firease Database에 push() 메서드로 자동으로 데이터 생성
##### Firebase Database에 데이터 생성
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/77e15c3b-9bf0-4d0c-8c72-142e850fd337)
```
 // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("contents")

        myRef.push()
            .setValue(ContentModel("title1","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FblYPPY%2Fbtq66v0S4wu%2FRmuhpkXUO4FOcrlOmVG4G1%2Fimg.png","https://philosopher-chan.tistory.com/1235"))

다음은 Firebase 데이터베이스에 데이터 모델을 넣는 예시코드를 보였다. Model -> 데이터의 집합
contents라는 이름의 root 밑에 임의의 이름에 데이터모델데이터(imageUrl, title, webUrl 데이터가 있는 ContentModel)를 넣었다.
```
## 23.09.23 개발일지
#### Firebase Database의 데이터 가져오기
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/2a0e74e3-537e-4b2a-b3da-9ec081c6f84b)
```
Firebase Database의 데이터를 가져와서 프로젝트에 적용한다.

개발문서의 데이터 가져오기 부분을 참고하여 ValueEventListener를 작성한다.
데이터를 가져오고 어뎁터를 동기화한다(rvAdapter.notifyDataSetChanged)
```
## 23.09.24 개발일지
#### category1과 category2를 구분해서 데이터 가져오기
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/9e46c122-cff7-47f2-bbb3-8aaa72b4133c)
#### category1
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/f11f1d39-fef3-4204-acb0-feef41231e5b)
#### category2
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/d34cb512-cf63-47e2-b54e-ed272376a0c0)
```
ContentList의 두 번째 아이콘에 category2 이름의 id를 부여하고 두 번째 컨텐츠를 클릭했을 때 화면이동을 구현한다.
화면이동 시에 category이름의 value값을 category1일 때는 category1을 전달하도록 하고 category2일때는 category2 값을 전달하도록
설정한다.(intent.putExtra(category, "category1") and intent.putExtra(category, "category2")

이 전달받는 값을 category 변수를 선언해서 받고 category1일 때와 category2일 때 데이터베이스에서 어떤 데이터를 가져올지 결정하는
if 조건문을 건다.

category1일 때는 contents에서 데이터를 가져오고 category2일때는 contents2에서 데이터를 가져오게끔 설정한다.
```
## 23.09.25 개발일지
#### BoardWrite Activity Layout
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/98753241-0c7f-4d43-a84e-6e7d436a8dec)
```
게시판 코드가 들어갈 board 패키지를 생성한다.
board 패키지 밑에 게시판 정보를 쓰는 BoardWrite Activity를 생성한다.

두 개의 EditText와 ImageView를 세로로 생성해줬다.
```
#### TalkFragment에 글쓰기 버튼 추가
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/246234c5-4c7f-4e35-adab-7edfa20feb78)
```
TalkFragment의 오른쪽 맨 아래에 글쓰기 버튼 아이콘을 추가한다.
```
## 23.09.26 개발일지
#### BoardWrite Activity Layout 수정
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/153ac007-3c89-41f4-af92-7e438d40f503)
```
BoardWrite Activity Layout을 수정했다.

제목, 내용을 입력하는 EditText부분과 이미지를 업로드하는 ImageView, 입력 버튼을 만들었다.
```
#### Board Database 설정
```
Firebase RealTime Database의 board 이름 밑에 게시글(BoardWrite Activity)에서 입력한 데이터가 들어가도록 설정한다.
바인딩을 사용하기 위해서 BoardWrite Activity를 layout으로 감싼다.

또 데이터베이스의 path를 저장하는 것을 모아두기 위해 utils 패키지 밑에 FBRef kotlin class File을 작성한다.
```
#### 입력 버튼 기능 구현
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/cec8f75b-ad38-4d20-bb6c-1361ff8679bc)       
#### Log.d(TAG, title), Log.d(TAG, content)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/d93e1d17-b044-46a5-9aba-7b1225ea068c)     
```
BoardWrite Activity의 각 요소에 각각의 이름을 부여하고 입력 버튼(writeBtn)을 클릭했을 때
제목(titleArea), 내용(contentArea)에 입력한 내용을 각각 title, content 변수에 바인딩을 이용하여
저장한 후 로그를 찍어 보았다. Log.d(TAG, title), Log.d(TAG, content)
입력한 내용이 로그에 잘 찍어 나오는 것을 확인했다.
```
## 23.09.27 개발일지
#### item key 값을 저장하는 itemKeyList 생성
```
itemKeyList 생성하고 itemKeyList에 dataModel의 key를 넣어준다.
생성한 itemKeyList를 Adapter에 넘겨준다.

Adapter에서 keyList의 position을 받아서 keyList 중에 key를 하나씩 가져온다.
```
## 23.09.28 개발일지
#### 북마크 데이터 저장
```
Firebase에서 uid를 받아오는 부분을 utils 패키지 밑의 FBAuth kotlin File에서 getUid 함수를 생성하고
리턴값으로 FirebaseAuth.getInstance()의 currentUser.uid 현재 로그인한 사용자의 uid 값을 반환하도록 한다.

utils의 FBRef 파일에 bookmarkRef 이름의 데이터베이스 주소를 생성하는 부분을 넣어준다. (path: bookmark_list)

어댑터에서 FBRef.bookmarkRef.child(FBAuth.getUid()).child(key).setValue(Good) 즉

데이터베이스에 bookmark_list 밑에 uid 밑에 key에 Good이라는 값을 저장했다.
```
#### 북마크 데이터 불러오기
```
bookmark_list 밑에 있는 데이터들을 가져와서 uid 아래에 데이터의 key값이 있다면 ui를 검정색으로 칠해주고
아니라면 흰색으로 그대로 놔두는 작업을 진행한다.

ContentListActivity에서 getBookmarkData 함수를 생성하고 전에 사용한 postListner를 수정하여 북마크 데이터를
불러온다.
```
#### 북마크 데이터 모델로 수정하기
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/3c916d2d-2649-4108-a57b-f50bca6cc224)     
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/834d0ddd-cc8a-40b7-bc96-b839cccaabd4)      
##### ContentListActivity .child(FirebaseAuth.getUid())
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/5a86fd1a-45fe-4438-a489-006805cbb911)
```
북마크의 데이터를 데이터 모델로 가공하여 사용한다.

contentList 패키지 밑에 BookmarkModel Kotlin File을 작성한다.
data class 안에 Boolean 타입의 BookmarkModel 변수를 null 값으로 저장하면서 선언한다.

ContentRVAdpater 파일의 북마크 이미지를 클릭했을 때 데이터베이스에 저장하는 부분 (.setValue)에
생성한 BookmarkModel의 값을 true 로 설정하고 매개변수로 데이터를 전달한다.

키와 값이 이상한데 uid 밑의 값을 키와 값으로 분리하기 위해서
ContentListActivity에서 값을 받아올때 uid 밑의 값들을 키와 값으로 받아온다.(.child(FirebaseAuth.getUid())
Log를 찍어봤을 때 key값과 value값이 잘 나오고 있는 것을 확인할 수 있다.

컨텐츠의 id값을 키로 받아오는 것을 알 수 있다.

북마크 리스트의 id값들을 저장하는 bookmarkIdList를 생성한다.

bookmarkIdList에 북마크 컨텐츠의 id 값을 넣어준다.(add(dataModel.key.toString())

어댑터로 이 bookmarkIdList를 넘겨서 리스트에 해당하는 북마크id가 있으면 북마크를 까맣게하고
없다면 북마크를 하얗게 하는 부분을 처리한다.

어댑터에 bookmarkIdList를 받고 어댑터를 쓰는 ContentListActivity에도 추가한다.

어댑터를 전역변수(lateinit val)로 선언하면서
getBookmarkData 함수에서도 쓸 수 있도록 동기화 작업(rvAdapter.notifyDataSetChanged())을 수행한다.

bookmarkListId 리스트에서 key 값(Content의 id)을 포함하면
bookmarkArea의 ImageSource를 R.drawable.bookmark_color 검정색 북마크를 표시하도록 하고
포함하지 않으면 R.drawable.bookmark_white 하얀색 북마크를 표시하도록 로직을 처리한다.
```
#### 23.09.28 북마크 작업 내용 정리
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/ebe4a6b8-9a42-4dad-a443-a638fc84258a)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/f0ee9c3a-4628-4c5d-9371-d86f02fdd10c)     
```
작업내용을 정리하자면 북마크로 넘겨줄 때의 데이터를 데이터모델(Boolean 형식의 값)으로 전달하고
데이터베이스에서 받아올 때 FirebaseAuth uid 밑의 문서들을 키와 값으로 분리하여 받아온다.

선택했을 때 북마크의 컨텐츠 id 값을 리스트로 저장한 다음 어뎁터로 그 리스트를 넘겨주고
리스트와 키값을 비교하여 리스트에 키값이 포함되어 있다면(이미 북마크로 저장해 두었다면)
까만 이미지로 변경하고 포함되어 있지 않다면 하얀 이미지로 설정하는 작업을 수행하였다.

컨텐츠 id의 키값 1, 2번째 값이 북마크 리스트의 uid 밑의 키값과 같기 때문에 두 개는 까맣게
두 개는 하얗게 나오는 것을 알 수 있고 또 북마크를 눌렀을 때 키값(컨텐츠id)이 북마크 리스트에
들어가게 되어 까맣게 변하는 것을 알 수 있다.

다음은 북마크를 삭제하는 작업(하얀 ui로 변경)을 수행한다.
```
#### 북마크 삭제 기능 구현
```
ContentRVAdapter에서 bookmark를 setOnClickListener 클릭했을 때 북마크가 있을 때와 없을 때의
로직을 처리한다.

북마크가 있을 때는 removeValue로 북마크 데이터 값을 삭제하고
북마크가 없을 때는 setValue로 BookmarkModel(true) 데이터를 넣어준다.

다음은 북마크를 동적으로 삭제하는 것을 구현한다.
```
#### 북마크 동적 삭제 기능 구현
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/dc774fea-e0fa-48ac-b284-ff532e32f3f5)      
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/89bdaf17-9a14-4c31-a471-1a32bc0d0b4f)     
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/ee8ee419-e0d6-432e-a83e-d78d79ee3d6f)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/6c2a2f72-7315-4f83-b651-5f9a7175d298)
```
getBookmarkData에서 onDataChange 기존의 데이터가 변경될 때 리스트에 들어있는 데이터를 클리어해주고
리스트에 있는 데이터를 받아온 다음 리스트를 업데이트하도록 수정한다.

북마크 수정, 삭제 기능이 정상적으로 구현됨을 확인했다.
```
#### 카테고리와 북마크 데이터들을 북마크 Fragment로 가져온다.
```
북마크 탭을 구현하기 위해서 일단 데이터베이스 상의 경로 contents와 contents2의 경로를 각각
FBRef 파일의 category1, category2 변수에 저장한다.

Bookmark Fragment 파일에 카테고리의 데이터들을 모두 가져오는 getCategoryData 함수를 생성하고
postListener 부분의 코드를 그대로 복사한다음 FBRef.category1, category2로 수정한다.

북마크의 데이터들을 모두 가져오는 getBookmarkData() 함수를 ContentListActivity에서 가져온다.
```
#### 전체 컨텐츠 중에서, 사용자가 북마크한 정보만 보여준다.
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/2523882e-c7ed-4b4a-b328-3e3acd8d3275)
#### title 3번을 추가
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/33e3d342-405f-4cee-8669-9d24e6935aab)
```
어뎁터로 컨텐츠 데이터와 북마크 데이터를 넘겨준다음 데이터들을 어댑터에서 처리한다.

BookmarkADApter kotlin File을 생성하고 기존에 만들었던 ContentRVAdapter를 복사한다.

BookmarkFragment Activity에서 RecyclerView를 생성하고 BookmarkFragment에서
생성한 어댑터를 연결한다.

북마크한 데이터만 가져오도록 수정하기 위해서 북마크id 리스트가 키값을 포함하고 있다면
그 item과 keyList를 받도록 로직을 수정한다. 
```
## 23.09.29 개발일지
#### 게시글 업로드 기능 구현
#### boardRef 게시판 데이터베이스 아키텍처 설계
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/3581b00f-8e39-482d-99bf-fbdc37eaca7c)    
#### 글쓰기 테스트
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/9e37b65f-0a8f-4f31-aaa2-16696bb138ac)     
#### 글쓰기 데이터를 데이터베이스에 저장
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/62a6ac5a-cc7e-4130-b15d-b4f9025fafd5)    
```
다시 BoardWriteActivity로 와서 writeBtn 글쓰기 버튼을 클릭했을 때
데이터베이스 board 밑에 고유한 key값 밑에 boardModel 데이터를 넣어주는 데이터베이스 형식을 가진다.

boardModel 게시판 모델은 title(글의제목), content(글의내용), uid(글쓴이 id), time(글을 쓴 시간) 데이터를 포함한다.

그러기 위해선 BoardModel kotlin data class file을 작성한다.
BoardModel은 title,content,uid,time 변수를 String 문자열로 넣어준다.

FBRef.boardRef.push().setValue(title, content, "uid", "time) 을 사용하여 BoardWrite Activity에서 글의 제목과 내용을 입력하고
writeBtn을 클릭했을 때 boardRef 밑의 push() 고유한 키 밑에 4개의 데이터가 파이어베이스 실시간 데이터베이스에 들어가는 것을 알 수 있다.

예는 글쓰기 페이지에서 title123(title), this is title(content), uid,time(default)를 입력하고 입력버튼을 클릭했을 때의
생성된 데이터의 모습이다.
```
#### 글쓰기 테스트2
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/4b449f4e-6860-47a3-8e22-439d9d0a64cc)
#### 글쓰기 테스트2 (현재 사용자 uid, 현재 시간 time 데이터 추가)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/38e4baa4-0f55-4166-a925-9defd5bf6563)
```
uid는 FBAuth의 getUid 메서드에서 가져올 수 있고 이를 uid 변수에 저장한 후 Board모델에 넣는다.

time은 FBAuth 파일에서 getTime() 메서드를 생성하고 이를 time 변수에 저장한 후 Board모델에 넣는다.

예는 글의 제목에 test12345, 내용에 this is title2를 넣고 입력 버튼을 눌렀을 때
실시간 테이터베이스에 title, content, uid, time 데이터가 정상적으로 들어감을 확인했다.

tiem 시간 데이터가 이상하게 나오는 문제를 뮬레이터의 시스템 시간의 Region을 한국(South Korea)로 변경하여 고쳤다.
```
#### 글쓰기 페이지 스크롤뷰로 수정
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/b635f89c-e77b-48d0-a4f4-fefbb02a6dd8)
```
글의 제목과 내용을 입력할 때 키보드로 가려져서 불편한 문제점을 기존 LinearLayout을 ScrollView로 감싸고 LinearLayout으로 한번 더
감싸서 스크롤 뷰로 만들어준다.
```
#### 토스트메시지 기능, 액티비티 사라지는 기능 구현
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/1a42a09e-e5db-4cf5-b9e0-d20bd608b94f)
```
입력이 모두 끝난 후에 입력 버튼을 누르면 게시글 입력 완료 메시지와 함께 게시글 글쓰기 페이지에서 나가지는 (finish()) 기능을 구현한다.
```
#### 게시글 데이터 불러오기
#### board_item_list layout
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/7ce2767f-90fd-4877-a6c9-663d5a196899)
#### TalkFragment에 sample data
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/69b69ec9-8a76-4067-9643-a310f4c8982e)    
```
1. ListView 생성 2. ListView에 들어갈 item layout 생성 3. ListView와 item을 연결하는 어댑터 생성 4. ListView와 Adpater를 TalkFragment에서 연결

Talk Fragment에서 boardListView 이름의 ListView 생성한다.

board_item_list layout 파일을 작성한다.
item_list 파일에는 title, content, time 세 개의 textView를 적절하게 배치한다.

BoardListLVAdpater kotlin 파일을 작성한다.

BoardModel 형식의 게시판리스트 데이터들을 가져와서 view와 item 들을 연결해준다.

Talk Fragment에서 boardListView 리스트뷰와 BoardListLVAdapter를 연결한다.

샘플 데이터 모델을 만들고 리스트 안에 넣은다음 어댑터로 넘겨주면 talk fragment에 샘플 데이터가 나오는 것을
확인할 수 있다.

다음 작업으로 샘플 데이터 대신 파이어베이스 데이터베이스에 있는 데이터모델을 리스트에 넣는 작업을 수행한다.
```
#### Firebase의 게시글 데이터를 불러오기
#### talkFragment Log.d
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/591c473c-278c-458b-92bc-f2f8ebbbe1dd)     
#### 게시글 입력 기능 구현
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/1075ba5a-b6c0-4f47-9172-4700b38b5efa)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/84dfbdad-448a-41c7-89aa-19deeb2f9319)
```
Firebase의 게시글 데이터를 불러오는 부분을 getFBBoardData 함수를 생성하여 구현한다.
bookmark 데이터를 가져올 때 사용한 postListener 부분을 복사한 다음 일부 수정하여 사용한다.

getFBBoardData 함수로 리턴되는 값의 로그를 찍어봤을 때 키와 value 값(BoardModel(title, content, uid, time) 값이 정상적으로
불러와지는 것을 확인할 수 있다.

불러와진 BoardModel 데이터들을 저장할 boardDataList 리스트를 생성하고 리스트에 받아온 데이터모델을 하나씩 넣어준다.

샘플리스트 대신 방금 생성한 boardDataList를 어댑터에 넣어준다.

데이터가 다 받아온 다음 어댑터를 동기화하는 부분을 추가해준다.
하는 방법은 BoardRVAdapter를 private lateinit val 전역 변수로 선언해준 다음
getFBBoardData 함수의 onDataChange 함수에서 boardRVAdapter.notifyDataSetChanged()를 사용하여 어댑터를 동기화해준다.

board_list_item의 title, content, time 각각에 적절한 id값을 부여하고
BoardListLVAdpater의 getView 함수에서 title TextView의 텍스트 값을 boardList 데이터모델의 title 값으로 저장한다.

content와 time 역시도 데이터모델의 content, time 값으로 저장한다.

talk fragment에서 게시글데이터를 받아올 때 리스트를 한번 초기화해주고 받아오는 코드를 추가한다. (boardDataList.clear())

게시글을 입력한 후에 입력 버튼을 누르면 talk fragment에 입력한 게시글의 title, content, time 값이 정상적으로 출력됨을 확인할 수 있다.
```
## 23.09.30 개발일지
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/652e4861-7075-43b6-afc6-372c5100701d)
```
게시글을 선택했을 때 게시글을 들어가서 보는 게시글 보기페이지를 만든다.

게시글 보기 액티비티(BoardInsideActivity)를 생성한다.
만들기에 앞서서 Talk Fragment에서 각각의 게시글을 클릭했을 때(setOnItemClickListener) 게시글 보기 액티비티(BoardInsideAcitivty)로
화면 이동(intent)하면서 선택한 아이템의 title(boardDataList[position.title]), content, time 데이터를 화면전환할 때 넘겨준다(putExtra)

게시글 보기 액티비티에서 넘어온 데이터를 받아온다.(getStringExtra)

로그를 찍어서 게시글 보기 액티비티로 클릭한 게시글의 title, content, time 데이터가 잘 찍히는 것을 알 수 있다.

다음으로 넘어온 데이터를 가공하여 Layout에 보여주기만 하면 된다.
```

#### 게시글 보기 페이지 Layout 
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/18545c9f-55ce-4b53-b308-cdc6bedf6003)
```
게시글 보기 페이지를 꾸며준다.

게시글 보기 페이지는 title, time, content TextView를 이용하여 LinearLayout(vertical)로 배치하였다.
바인딩할 수 있도록 layout으로 감싸주고, 각각의 TextView에 적절한 id를 부여한다.
```
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/2959ad92-0c7c-4077-b874-e765e9fe5e83)
```
바인딩을 생성하고 title, content, time 각각의 text를 화면전달할 때 넘어온 선택한 title, content, time 데이터를 넣어준다.

게시글을 클릭하면 각각에 해당되는 값들이 잘 나오는 것을 확인할 수 있다.
```
#### 최근 게시물을 맨 앞으로 올라오게 하는 기능 구현
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/42bd8434-3051-4edc-9749-f94f4f46b2d7)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/3d95248c-b563-4f17-a8e0-118747cd2f44)
```
보통의 게시판에서 최신 글이 맨 위로 올라오는 데 이는 리스트를 뒤집어 주기만 하면 기능을 간단하게 구현할 수 있다.

talk fragment에서 게시글을 받아오는 부분에(getFBBoardData()) 동기화하는 부분(notifyDataSetChanged()) 앞에
데이터리스트를 뒤집는 코드를 추가한다.boardDataList.reverse()

게시글을 입력하고 입력버튼을 누르면 입력한 게시글이 최상단에 위치하는 것을 알 수 있다.
```
#### 이미지 업로드 기능 구현
#### 외부 이미지 접근 권한 설정
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/6b0dbe14-623c-4dfd-b601-a9d702f6fc27)
#### 내부 저장소 갤러리로 화면이동하는 코드
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/39c6a12f-5e4f-4132-aa3e-9c6e501baa50)    
#### 적절한 이미지 소스 다운로드
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/a5909594-d945-4f81-b198-aa3882fc6072)
#### 내부 이미지 저장소에 접근
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/5b055b71-30ed-4fe0-bfed-1063d41e3c9a)
#### 선택한 이미지를 업로드
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/2e632342-39e2-4f4c-9728-b7269d6e0444)
```
이미지 업로드 권한을 AndroidManifest.xml파일에서 외부 저장소 접근 권한을 설정해준다.
(permission.READ_EXTERNAL_STORAGE)

이미지 업로드 ImageView에 imageArea id를 부여한다.
이미지 업로드를 클릭했을 때의 이벤트를 구현해준다.

onActivityResult라고 해서 resultCode가 OK이고 100이면 정상적으로 내부 이미지 저장소로 화면이동이 되도록 설정한다.

웹에서 강아지 이미지를 다운로드 한 후에 이미지 추가 ImageView를 클릭하면 내부 저장소로 이동하고 내부 저장소에 다운로드한
이미지가 있는 것을 확인할 수 있다.

onActivityResult에서 resultCode가 OK, 100일 경우 binding.imageArea.setImageURI(data?.data) 이미지 데이터를 보여주도록
설정한다.

이미지를 선택하면 글쓰기 페이지에 정상적으로 들어가는 것을 확인했다.

다음 작업은 선택한 게시글의 이미지를 파이어베이스에 저장하는 작업을 수행한다. 
```
#### Firebase Storage 스토리지 사용
[Android Firebase Storage 개발문서](https://firebase.google.com/docs/storage/android/start?hl=ko)    
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/fc419aeb-98b9-48fb-a0c9-277b92c063d9)    
#### Firebase Storage로 이미지 업로드
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/7da1e6a8-6b89-4fc9-aedf-d958985aed26)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/4bae6437-9738-482a-8cf7-c5625cd458c4)
```
이미지 서버를 데이터베이스 서버와 따로 사용을 한다.
파이어베이스 스토리지를 시작하고 파이어베이스 스토리지 개발문서를 참조한다.

build.gradle에 필요한 kotlin sdk를 넣어준다.

storage 변수를 만들고 Firebase.storage를 선언한다.

메모리 이미지를 업로드하는 개발문서 부분을 참조하여 ImageArea를 imageView로 넣어주고 mountains.jpg라는 이름의 reference로
이미지를 업로드하도록 코드를 넣는다.

선택한 이미지가 storage에 올라간 것을 확인했다.

키값을 먼저 생성하고 게시글데이터를 생성하도록 코드를 수정한다.
key를 먼저 생성 -> 생성한 랜덤한 key값 밑에 데이터를 넣어준다.

그 key값을 이미지의 이름으로 넣어준다. mountains.jpg -> key+".png"
키값으로 이미지의 고유한 이름으로 설정하여 다른 이미지들과 구분하는 역할을 한다.

이렇게 이미지의 이름을 생성된 게시글의 키 값으로 해주면 다른 부분에서 활용 가능하다.(이미지에 대한 정보를 알기 때문에) 구분

다음으로 Storage의 이미지를 불러오는 부분을 작업한다.
```
#### 게시글 보기 페이지 수정
```
게시글 보기 페이지에 업로드한 이미지를 불러와서 보여주는 ImageView를 생성한다.
```
#### 게시글 이미지 다운로드
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/92081ccb-3dfd-416b-aac1-29ce51a9a7bc)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/766507d9-aa8b-4fa2-9bf0-2e11ef011b76)
```
이미지를 다운로드하는 방법을 여러 가지가 있는데 그 중 FirebaseUI 방법을 사용한다.

gradle 파일에 ui-storage sdk를 넣어주고 getImageData() 함수를 생성한다.
downloadUrl.addOnCompleteListener를 사용하여 task가 성공적일 때 이미지뷰를 glide into로 넣어준다.

이미지를 업로드하는 버튼을 눌러서 업로드를 한다면 이미지를 업로드하도록 하고
버튼을 누르지 않았다면 = 이미지 업로드 x 이미지 업로드 없이 게시물을 올리게끔 로직을 수정한다.
```
#### 게시글 수정, 삭제 UI 버튼 레이아웃
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/10f51563-4d30-47ec-be51-7f545782e2b4)     
#### custom_dialog layout
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/7256ae1f-bc39-461a-baf2-bb86a35c1c3e)
#### AlertDialog 다이얼로그 기능 구현(custom_dialog를 띄우기)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/8f17710e-f45d-4036-bbe0-6ca8ba56f393)
```
게시물 보기 레이아웃의 최상단 오른쪽에 boardSettingIcon을 넣어준다.
boardSettingIcon을 클릭하면 custom_dialog layout이 나오도록 이벤트 처리한다.

custom_dialog layout파일을 작성한다. 수정과 삭제 버튼을 배치한다.

만든 custom_dialog를 띄우는 showDialog() 함수 생성한다.
함수를 clickListener 이벤트처리 쪽에 넣어주고 실행하면 클릭했을 때 custom_dialog가 정상적으로 나오는 것을 확인한다.

수정, 삭제 버튼 각각에 id를 부여하고 alertdialog의 수정버튼을 id로 찾아서 onClickListener 이벤트 처리를 넣어준다.(삭제버튼도 마찬가지)

다음으로 삭제 버튼을 눌렀을 때 게시글을 삭제하는 기능을 구현한다.
```
## 23.10.01 개발일지

#### 게시글 삭제 기능 구현
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/e1dce880-b401-4d03-9308-628497a4bfcb)
```
게시판 글의 키값을 lateinit var 전역변수로 뺀 다음 boardRef 레퍼런스의 키값을 removeValue()한다.

getBoardData에서 계속 앱이 죽는 문제가 발생하여 예외가 발생했을 때 처리하는 try catch문을 사용하였다.

앱을 실행하고 삭제버튼을 클릭하면 게시글이 정상적으로 삭제됨을 확인했다.
```
#### 게시글 수정 페이지 Layout 
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/73329a84-438e-41bf-b201-2ba329cd146b)
```
게시글 수정을 위한 BoardEdit Acitivity를 생성하고 layout은 BoardWrite Activity의 Layout을 복사해서 일부 수정하여 사용한다.

수정 버튼을 눌렀을 때 BoardEdit 화면이동 기능을 구현한다.
```

#### 게시글 수정 페이지 구현 -1
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/6f62c9bc-879a-4e33-be7f-b2b2b7f39c3f)
```
다이얼로그에서 수정 페이지로 화면이동이 될 때 putExtra로 키값이 전달되도록 한다.
수정페이지에서 이 키 값을 받은 다음 게시글 보기 페이지(boardInside)에서 getBoardData 함수를 가져와서 사용한다.
함수안의 textView를 가져올 때와 editText를 가져올 때 사용하는 메서드가 다름에 유의한다(TextView : text , editText : .setText())

수정 페이지에 게시글보기의 데이터(title, content)들이 정상적으로 들어가는 것을 알 수 있다.
```

## 23.10.02 개발일지

#### 게시글 수정 페이지 구현 -2 (이미지)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/f4fb78cc-06ea-4bc8-aa7c-2a8ddd4f3d28)
```
게시물보기페이지에서 게시글 수정 페이지로 이미지를 받아오는 부분을 구현한다.

게시물보기페이지의 getImageData함수를 복사한 다음 수정해서 사용한다.

게시물 수정페이지에서 이미지가 잘 나오는 것을 알 수 있다.
```
#### 게시글 수정 기능 구현 完
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/2f21b3fd-8116-4faf-b719-b3976efaa063)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/69aa4fb9-ec22-40ca-9d0b-e79f6f8d6869)
```
수정한 데이터를 파이어베이스에 집어넣는다.
edit 버튼을 누르면 boardRef 경로의 데이터베이스에 변경한 텍스트들을 넣어주는 editBoardData 메서드를 만들고
이벤트 처리를 해준다. (boardRef.child(key).setValue(BoardModel(binding.titleArea.text.toString, ~)

이 글을 수정하고 삭제할 수 있는 것은 로그인한 사용자, 즉 FBAuth.getUid()가 되는데 따로 writeUid 변수를 만들어서
getBoardData에서 모델의 uid를 writeUid에 저장한다음 이를 사용한다.

게시물 수정 페이지의 이미지를 클릭했을 때 이미지를 업로드하는 ImageUpload도 복사해서 사용한다.
수정 버튼을 눌렀을 때 imageUpload가 이루어져서 덮어써지도록 수정하였다.

예는 게시글 제목 test1, 내용 test1, 고양이 이미지를 게시글 수정 페이지에서 제목 test2, 내용 test2, 강아지 이미지로
변경(수정)하는 예이다. 게시글 수정이 정상적으로 이루어지는 것을 확인했다.
```
#### 로그아웃 기능 구현
#### LOGOUT Button Layout
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/90d1bb7f-3d81-4023-a4f4-89c280774f5b)
```
로그아웃 등의 기능이 들어가는 setting 패키지 밑의 SettingActivity를 생성한다.
로그아웃 버튼은 노란색 배경에 LOGOUT 텍스트를 넣어줬다.

MainActivity의 settingBtn을 클릭하면 SettingActivity로 이동하고 SettingActivity 가운데의 로그아웃 버튼을 클릭하면
IntroActivity로 이동하도록 설정한다.

logout 버튼을 클릭하면 Firebase의 signOut 메서드가 실행되어 로그아웃이 되고 IntroActivity로 정상적으로 이동됨을 확인했다.
```

#### 글쓴이만 수정 삭제 가능하도록 권한 부여
#### 새로운 사용자의 글쓰기 데이터(기존 uid와 다른 새로운 uid)
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/af6a0306-737f-4497-99c3-2d25ea370295)
#### 내가 쓴 글의 글보기 페이지
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/f46b8c5c-af1f-454b-9bd5-d3bdfa87af01)
#### 내가 쓰지 않은 글의 글보기 페이지
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/a385e041-2410-438b-afd6-8531d61ceb5c)
```
게시글의 수정 삭제는 글쓴이만 수정 삭제가 가능하도록 해야 한다.
즉 게시글의 데이터베이스의 uid가 현재 로그인한 uid와 다르면 수정 삭제가 불가능해야 한다.

이를 위해 로그아웃을 진행한 후에 새로운 익명 로그인을 시도하고 title:test3, content:test3의 새로운 게시글을 작성하였다.
데이터베이스 안의 게시판 데이터의 uid가 새로운 값이 들어가 있는 것을 확인할 수 있다.

게시물 보기 페이지(BoardInside Activity)에서 수정 삭제를 할 수 있는 권한, 즉 아이콘을 글쓴이에게만 보여주면 되는 로직처리를 하면 된다.

원래 게시물 보기 페이지의 settinrgBtn visible을 invisible로 설정하고 BoardInsideActivity의 getBoardData에서 DataModel의 uid(글작성자 uid)와
FBAuth.uid(로그인유저의 uid)를 비교해서 같다면 settingBtn의 isVisible 값을 true로 변경시켜주는 로직처리를 한다.

방금 작성한 test3 글의 오른쪽 최상단에는 settingBtn이 나오지만 내가 작성하지 않은 test2 글의 오른쪽 최상단에는 settingBtn이 나오지 않는 것을
알 수 있다.
```
#### 내가 쓴 글의 배경색 변경
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/f2c37c77-6b29-4180-8f64-2456414c0167)
```
내가 쓴 글의 LinearLayout 부분을 주황색으로 칠해서 다른 글과 구분한다.

BoardListLAdapter에서 item_list를 연결해주는 getView 메서드에서 boardList[position]의 uid와 FBAuth.getUid() 값이 같으면
LinearLayout의 backgroundColor를 오렌지색으로 변경한다.

내가 쓴 글은 오렌지 색으로 잘 나오는 것을 확인한다.
```
## 23.10.03 개발일지
#### 댓글 영역 레이아웃 설계
#### 이미지가 있을 때 댓글 영역
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/6ad1f9f6-3492-4462-a075-3a9b3cfc8162)
#### 이미지가 없을 때 댓글 영역
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/73bc3d6d-7961-45d8-93cb-f2608d57621a)
```
게시물 보기 레이아웃에 댓글 넣는 영역을 리스트 뷰로 구현한다.
전체를 스크롤 뷰로 감싸고 ListView를 생성한다.

이미지가 있을 때 즉 getImageData 메서드 안의 task가 성공적일 때 이미지를 보여주고
task가 실패하면 이미지 영역을 보이지않게 설정한다.(visible = false)
```
#### 댓글 창 레이아웃 설계
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/7dc8fa26-c56c-458d-a774-f053b36462a2)
```
댓글 창은 스크롤뷰가 아닌 바깥에 RelativeLayout으로 최하단에 고정하여 스크롤 뷰의 영향을 받지 않게하고
댓글을 입력하는 부분 EditText과 댓글 입력 버튼 Button을 생성하였다.

게시물 보기 페이지의 최하단에 댓글을 입력할 수 있는 입력창과 입력 버튼이 정상적으로 들어갔다.
```
#### 댓글 데이터 구조
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/5f80ed2e-d81b-4d78-b152-b69b25734fa2)     
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/effd8b9d-db9d-4861-aad0-4ee8b29efb37)
#### 댓글 기능 구현
![image](https://github.com/wonchihyeon/Database_Capstonedesign/assets/58906858/02558d9f-ec84-4146-a8bb-3aa63d5643c2)
```
댓글 창에 입력한 텍스트를 파이어베이스의 데이터베이스에 저장한다.

댓글 입력 창과 버튼 각각에 적절한 id값을 부여하고 게시물 보기 페이지에서 이벤트 처리를 구현한다.

댓글 데이터의 데이터구조는 comment Ref 밑에 BoardKey -CommentKey - CommentData 아키텍처를 설계한다.

데이터 형태가 String인 commentTitle 한개만 들어가는 CommentModel 데이터 모델을 작성한다.

commentTitle의 값으로는 commentArea에 입력된 텍스트 데이터가 들어가도록 한다.

입력버튼을 누르고 나면 토스트메시지와 함께 입력한 텍스트가 사라지도록 한다.(setText(""))

댓글을 입력하고 입력한 텍스트 데이터(hello)가 데이터베이스에 잘 들어가는 것을 확인할 수 있다.

다음 작업으로는 리스트뷰에 입력한 텍스트 데이터들을 모두 불러와서 보여주는 작업을 수행한다.
```
## 23.10.04 개발일지
#### commentModel 수정
![image](https://github.com/chihyunwon/Database_Capstonedesign/assets/58906858/839e8def-e1c6-4651-a423-1b9ce8c80774)
#### comment_list_item layout
![image](https://github.com/chihyunwon/Database_Capstonedesign/assets/58906858/d5315d46-eb46-4c91-9599-9537071ea638)
```
commentModel에 시간 데이터도 들어갈 수 있도록 commentCreatedTime 변수 타입을 넣어준다.
댓글을 입력하면 데이터베이스에 title과 시간 데이터가 들어가는 것을 알 수 있다.

comment_list_item layout 파일을 작성한다. layout 파일은 board_list_item을 일부 수정하여 title과 time이 들어가도록 한다.

리스트와 연결할 CommentLVAdapter 이름의 어댑터파일을 만들어 준다. BoardLVAdapter 코드를 복사한 다음 일부를 수정한다.

게시물보기페이지(BoardInsideActivity)에서 comment data를 모두 받아오는 getCommentData 메서드를 작성한다.
코드는 TalkFragment의 getFBBoardData의 postListener 부분을 복사한 다음 일부를 수정한다.

어댑터를 만들고 어댑터와 리스트뷰를 연결한다. 
```
#### 댓글 기능 구현
#### 댓글 기능 test1
![image](https://github.com/chihyunwon/Database_Capstonedesign/assets/58906858/ee9c9016-14d7-4c32-96e6-89c6070eac2f)
![image](https://github.com/chihyunwon/Database_Capstonedesign/assets/58906858/426d9a3b-b0c3-4910-a741-7e84c2b46891)
#### 댓글 기능 test2
![image](https://github.com/chihyunwon/Database_Capstonedesign/assets/58906858/55694775-788b-4e61-b858-2d8f98440738)
![image](https://github.com/chihyunwon/Database_Capstonedesign/assets/58906858/a0473661-46ba-46e0-bc58-d67e1fac0162)
```
댓글 기능을 테스트하기 위해서 this is test 댓글을 입력창에 작성한 후에 입력 버튼을 클릭하면
정상적으로 댓글이 입력되는 것을 확인할 수 있다.
```
## 23.10.05 개발일지

```

```
