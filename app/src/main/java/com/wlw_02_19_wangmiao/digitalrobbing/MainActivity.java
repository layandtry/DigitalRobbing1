package com.wlw_02_19_wangmiao.digitalrobbing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * 当己方在操作的时候，那么这个时候就不允许敌方操作
     * 因此，我需要添加一个状态变量，己方为true，敌方为false
     * 这个游戏需要决定谁先来，这个需要做一个类似抢地主的效果，来确定state的状态
     * 不过目前的先实现最基本的功能就好。
     */
    boolean state = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Owner_add_one = (Button)findViewById(R.id.owner_add_one);
        Button Owner_add_two = (Button)findViewById(R.id.owner_add_two);
        Button Other_add_one = (Button)findViewById(R.id.other_add_one);
        Button Other_add_two = (Button)findViewById(R.id.other_add_two);
        final TextView show_grade = (TextView)findViewById(R.id.grade_show);

        if (state == true){
            Other_add_one.setEnabled(false);
            Other_add_two.setEnabled(false);
        Owner_add_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_grade.setText("" + sum(1));
            }
        });

        Owner_add_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_grade.setText(""+ sum(2));
            }
        });
        Other_add_one.setEnabled(true);
        Other_add_two.setEnabled(true);

        }else{
        Owner_add_one.setEnabled(false);
        Owner_add_two.setEnabled(false);

        Other_add_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_grade.setText("" + sum(1));
            }
        });

        Other_add_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_grade.setText("" + sum(2));
            }
        });
            Owner_add_one.setEnabled(true);
            Owner_add_two.setEnabled(true);

        }
    }

    public int sum(int num){
        int sum1 = 0;
        sum1 = num + sum1;
        return sum1;
    }

    public int fab(int num1){
         if (num1 == 0)
         {
             return 0;
         }
        if (num1 == 1)
        {
              return 1;
         }
         return fab(num1 - 1) + fab(num1 - 2);

    }
}
