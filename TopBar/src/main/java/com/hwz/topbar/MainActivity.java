package com.hwz.topbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopBar topBar = (TopBar) findViewById(R.id.topbar);
        topBar.setTopBarClickListener(new TopBar.TopBarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "返回键点击了!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "前进键点击了!", Toast.LENGTH_SHORT).show();
            }
        });
//        topBar.setLeftIsVisible(false);
    }
}
