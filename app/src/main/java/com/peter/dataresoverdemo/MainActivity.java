package com.peter.dataresoverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.peter.dataresoverdemo.Student.Student;
import com.peter.dataresoverdemo.biz.StudentBiz;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText name, age, num;
    private Button add, search, update, del;
    private RadioGroup genderGroup;
    public SQLiteOpenHelper sqLiteOpenHelper;
    public SQLiteDatabase sqLiteDatabase;
    public String gender = "男";
    private ListView stuListView;
    private List<Student> studentList = new ArrayList<>();
    private StudentBiz studentBiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @SuppressLint("InflateParams")
    public void initView() {
        studentBiz = new StudentBiz(this);
        genderGroup = findViewById(R.id.gender_group);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        num = findViewById(R.id.num);
        add = findViewById(R.id.add);
        search = findViewById(R.id.search);
        update = findViewById(R.id.update);
        del = findViewById(R.id.del);
        stuListView = findViewById(R.id.stu_list);
        View stuHeaderView = LayoutInflater.from(this).inflate(R.layout.stu_list_header, null);
        stuListView.addHeaderView(stuHeaderView);
        // 监听选项切换事件
        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // 必须将该值赋值给一个RadioButton对象 否则会报错
                RadioButton radioButton = findViewById(i);
                gender = radioButton.getText().toString();
            }
        });
        add.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String nameStr = name.getText().toString();
        String ageStr = age.getText().toString();
        String numStr = num.getText().toString();
        String[] params = getParams(nameStr, ageStr, numStr);
        switch (view.getId()) {
            case R.id.add:
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", nameStr);
                contentValues.put("age", ageStr);
                contentValues.put("gender", gender);
                studentBiz.addStudent(contentValues);
                break;
            case R.id.search:
                break;
            case R.id.del:
                break;
            case R.id.update:
                Toast.makeText(this, "请输入参数", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public String[] getParams(String nameStr, String ageStr, String numStr) {
        String[] params = new String[2];
        if (!nameStr.equals("")) {
            params[0] = "name";
            params[1] = nameStr;
        } else if (!ageStr.equals("")) {
            params[0] = "age";
            params[1] = ageStr;
        } else  if (!numStr.equals("")) {
            params[0] = "num";
            params[1] = numStr;
        }
        return params;
    }

    public int getInt(String str) {
        int i;
        if (!str.equals("")) {
            i = Integer.parseInt(str);
        } else {
            i = -1;
        }
        return i;
    }
}