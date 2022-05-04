package com.peter.dataresoverdemo.biz;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

import com.peter.dataresoverdemo.Student.Student;

public class StudentBiz {
    private ContentResolver contentResolver;

    public StudentBiz(Context context) {
        // 获取ContentResolver对象
        contentResolver = context.getContentResolver();
    }

    public void addStudent(ContentValues contentValues) {
        contentResolver.insert(Uri.parse("com.peter.provider"), contentValues);
    }
}
