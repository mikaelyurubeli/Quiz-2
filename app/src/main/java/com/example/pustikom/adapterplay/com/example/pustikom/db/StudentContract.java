package com.example.pustikom.adapterplay.com.example.pustikom.db;

import android.provider.BaseColumns;

/**
 * Created by Mikael on 11/11/2016.
 */
public class StudentContract implements BaseColumns{
    public static final String TABLE_NAME = "Student";
    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_STUDENT_NAME ="name";
    public static final String COLUMN_STUDENT_NIM ="nim";
    public static final String COLUMN_STUDENT_MAIL ="mail";
    public static final String COLUMN_STUDENT_GENDER ="gender";
    public static final String COLUMN_STUDENT_PHONE ="phone";
}
