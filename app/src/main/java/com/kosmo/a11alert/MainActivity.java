package com.kosmo.a11alert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onBtn1Clicked(View v){
        //버튼 1 : 기본형
        MyAlert.AlertShow(MainActivity.this, "아이디를 입력해 주세요.", "알림");
    }
    public void onBtn2Clicked(View v){
        //버튼 2 : 상단 없애고 내용만
        MyAlert.AlertShow(MainActivity.this, "패스워드를 입력해 주세요.");
    }

    /*
    AlertDialog 창을 띄우는 절차
    1. AlertDialog.Builder 객체생성
    2. 생성자 함수를 통한 설정(타이틀, 메세지, 아이콘 등)
    3. 2에서 생성한 객체를 통한 create()메소드 호출
    4. show() 메소드 호출을 통해 경고창 띄움
     */
    public void onBtn3Clicked(View v){
        //버튼 3 : 확인 혹은 취소 버튼에 리스너 부착 후 동작할 내용정의
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        /*
        AlertDialog.Builder 객체는 디자인패턴 중 빌더패턴이 적용되어 있어
        생성자를ㄹ 체인(Chain)형태로 호출하여 초기화 할 수 있다.
         */
        builder.setMessage("앱을 종료하시겠습니까?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("알림")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Yes클릭 시 -1 반환됨
                        Toast.makeText(getApplicationContext(),
                                "Yes is " + Integer.toString(id),
                                Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //No 클릭 시 -2 반환됨됨
                        Toast.makeText(getApplicationContext(),
                                "No is " + Integer.toString(id),
                                Toast.LENGTH_SHORT).show();
                        //dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
