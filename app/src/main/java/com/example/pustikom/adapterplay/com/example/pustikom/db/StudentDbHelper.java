package com.example.pustikom.adapterplay.com.example.pustikom.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import com.example.pustikom.adapterplay.R;
import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;

/**
 * Created by Mikael on 11/11/2016.
 */
public class StudentDbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="college.db";
    public static final String DATABASE_VERSION="1";

    public StudentDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public StudentDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_STUDENT_TABLE =  "CREATE TABLE " + StudentContract.TABLE_NAME + " ("
                + StudentContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + StudentContract.COLUMN_STUDENT_NAME + " TEXT NOT NULL, "
                + StudentContract.COLUMN_STUDENT_NIM + " TEXT, "
                + StudentContract.COLUMN_STUDENT_MAIL + " TEXT, "
                + StudentContract.COLUMN_STUDENT_GENDER + " INTEGER, "
                + StudentContract.COLUMN_STUDENT_PHONE + " INTEGER);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_STUDENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //empty
    }

    public void insertStudent(SQLiteDatabase db, Student student) {
        ContentValues value = new ContentValues();
        value.put(StudentContract.COLUMN_STUDENT_NIM,student.getNoreg());
        value.put(StudentContract.COLUMN_STUDENT_NAME,student.getName());
        value.put(StudentContract.COLUMN_STUDENT_MAIL,student.getMail());
        value.put(StudentContract.COLUMN_STUDENT_GENDER,student.getGender());
        value.put(StudentContract.COLUMN_STUDENT_PHONE,student.getPhone());
        long id = db.insert(StudentContract.TABLE_NAME, null, value);

    }

    public void updateStudent(SQLiteDatabase db, Student student) {

        ContentValues value = new ContentValues();
        value.put(StudentContract.COLUMN_STUDENT_NIM, student.getNoreg());
        value.put(StudentContract.COLUMN_STUDENT_NAME, student.getName());
        value.put(StudentContract.COLUMN_STUDENT_MAIL, student.getMail());
        value.put(StudentContract.COLUMN_STUDENT_GENDER, student.getGender());
        value.put(StudentContract.COLUMN_STUDENT_PHONE, student.getPhone());
        String condition = StudentContract._ID + " = ?, ";
        String conditionArgs = (student.getId()+"");
        db.update(StudentContract.TABLE_NAME, value, condition, null);
    }


    public void deleteStudent(SQLiteDatabase db){
        db.delete(StudentContract.TABLE_NAME, StudentContract._ID + " = ?", null);
    }

    public void truncateStudent(SQLiteDatabase db){
        db.execSQL("DROP TABLE" + StudentContract.TABLE_NAME);
        db.execSQL("VACUUM");
    }

    private void fetchStudent() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                StudentContract._ID,
                StudentContract.COLUMN_STUDENT_NAME,
                StudentContract.COLUMN_STUDENT_NIM,
                StudentContract.COLUMN_STUDENT_MAIL,
                StudentContract.COLUMN_STUDENT_PHONE,
                StudentContract.COLUMN_STUDENT_GENDER };

        // Perform a query on the Student Contract
        Cursor cursor = db.query(
                StudentContract.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order

    }
}
