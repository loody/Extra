package me.loody.extra.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import java.util.ArrayList;

import me.loody.extra.Extra;
import me.loody.extra.annotation.ExtraParam;

public class TestActivity extends AppCompatActivity {
    @ExtraParam(value = "n")
    String name;
    @ExtraParam(value = "a")
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Extra.inject(this);
        if (!TextUtils.isEmpty(name)) {
            ((TextView) findViewById(R.id.tv_name)).setText(String.format("name=%1$s\nage=%2$d", name, age));
        }
    }
}
