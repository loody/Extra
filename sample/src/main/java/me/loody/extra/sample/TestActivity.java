package me.loody.extra.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import me.loody.extra.Extra;
import me.loody.extra.anotation.ExtraParam;

public class TestActivity extends AppCompatActivity {
    @ExtraParam
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Extra.inject(this);
        if (!TextUtils.isEmpty(name)) {
            ((TextView) findViewById(R.id.tv_name)).setText(name);
        }
    }
}
