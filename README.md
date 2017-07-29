# Extra
-------
    A intent data injector for Android .

## Getting started
------------------

```Groovy
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
    	...
        classpath 'me.loody:extra-gradle-plugin:0.1.1'
    }
}
```
* Apply extra plugin in your `module/build.gradle`:

```  Groovy
apply plugin: 'com.android.application'
...
apply plugin: 'me.loody:extra'
```

or

```Groovy
dependencies {
    compile "me.loody:extra:0.1.1"
    annotationProcessor "me.loody:extra-compiler:0.1.1"
}
```

# Simple usage
-------

```java

Intent intent = new Intent(MainActivity.this, TestActivity.class);
intent.putExtra("n", "extra");
intent.putExtra("a", 11);
startActivity(intent);

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
        ((TextView) findViewById(R.id.tv_name)).setText(String.format("name=%1$s\nage=%2$d", TextUtils.isEmpty(name)?"":name, age));
    }
}


```

# Thanks
--------
This library is reference by [Router](https://github.com/chenenyu/Router) and uses some of its source code.

# License
---------

    Copyright 2017 loody

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.