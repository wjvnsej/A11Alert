package com.kosmo.a11alert;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyAlert {

    //1번 경고창 : 타이틀, 내용, 확인버튼 있음
    public static void AlertShow(Context context, String msg, String title){
        //경고창을 띄우기 위해 AlertDialog.Builder 객체를 먼저 생성한다.
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //아이콘 설정(기본이미지사용)
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //제목(타이틀 설정)
        builder.setTitle(title);
        //안드로이드의 물리적 버튼인 back버튼을 눌렀을 때 동작방식결정
        builder.setCancelable(false);/*
            AlertDialog를 띄운 상태에서 Back버튼을 눌렀을 때 대화창이
            닫히지 않도록 해준다, true로 지정한 경우에는 back버튼을 누르거나
            여백을 누르면 대화창이 닫히게 된다.
        */
        //내용설정
        builder.setMessage("\n" + msg + "\n");
        //확인(Yes) 버튼
        builder.setPositiveButton("확인", null);
        //대화창 생성 및 화면에 띄워줌
        AlertDialog alert = builder.create();
        alert.show();

        //Alert창에서 출력되는 메세지를 정렬할 때 아래 코드를 사용(주석처리시 좌측정렬)
       // AlertDialog 의 가운데 정렬을 위한 setting
        // Must call show() prior to fetching text view
        TextView messageView = (TextView)alert.findViewById(android.R.id.message);
        //messageView.setGravity(Gravity.CENTER);
    }
    //2번경고창 : 내용만있음, 메소드 오버로딩됨
    public static void AlertShow(Context context, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //true로 설정했으므로 Back버튼이나 여백을 누를 때 창 닫힘
        builder.setCancelable(true);
        builder.setMessage("\n" + msg + "\n");
        builder.setPositiveButton("확인", null);

        AlertDialog alert = builder.create();
        alert.show();

        // AlertDialog 의 가운데 정렬을 위한 setting
        // Must call show() prior to fetching text view
        TextView messageView = (TextView)alert.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
    }
}
