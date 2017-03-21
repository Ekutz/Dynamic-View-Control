# Dynamic-View-Control
## Add View
#### Basic Declare
```
// 동적으로 생성되는 뷰를 담을 레이아웃
LinearLayout linear;
// 아이디의 Prefix 값
final int viewPreId = 5350;
// 아이디의 구분 값
int viewNum = 0;
```

---
#### Add View
```
viewNum++;
// 새로운 뷰 선언(ex. 스피너)
Spinner newSpin = new Spinner(MainActivity.this);
// 새로 생성된 뷰의 아이디 할당
newSpin.setId(viewPreId+viewNum);
// 새로 생성된 뷰 설정
newSpin.setAdapter(adapter);
// 레이아웃에 새로 생성된 뷰를 삽입
linear.addView(newSpin, new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
```

---
#### Remove View
```
// 아이디 값을 기준으로 뷰 찾기(ex. 스피너)
Spinner removeSpinner = (Spinner) findViewById(viewPreId + viewNum);
// 레이아웃에서 뷰 제거
linear.removeView(removeSpinner);
```

---
