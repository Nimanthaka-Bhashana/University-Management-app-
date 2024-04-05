package com.example.mainactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Campus";  // Database name
    private static final int DB_VERSION = 1;          // Database version

    // Table name and column names for COURSE table
    private static final String TABLE_COURSE = "COURSE";
    private static final String COL_ID = "_Id";
    private static final String COL_COURSE_NAME = "courseName";
    public  static final String COL_COURSE_FEE = "courseFee";
    public static final String COL_START_DATE = "startingDate";
    public static final String COL_REGISTRATION_CLOSE_DATE = "registrationCloseDate";
    public static final String COL_MAX_PARTICIPANTS = "maxParticipants";
    public static final String COL_SELECTED_BRANCH = "selectedBranch";
    public static final String COL_SELECTED_DURATION = "selectedDuration";

    // Table name and column names for BRANCH table
    private static final String TABLE_BRANCH = "BRANCH";
    private static final String COL_BRANCH_ID = "_Id";
    public static final String COL_BRANCH_NAME = "branchName";
    public static final String COL_BRANCH_CODE = "branchCode";

    // Create table query for COURSE table
    private static final String CREATE_TABLE_COURSE = "CREATE TABLE " + TABLE_COURSE + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_COURSE_NAME + " TEXT,"
            + COL_COURSE_FEE + " TEXT,"
            + COL_START_DATE + " TEXT,"
            + COL_REGISTRATION_CLOSE_DATE + " TEXT,"
            + COL_MAX_PARTICIPANTS + " TEXT,"
            + COL_SELECTED_BRANCH + " TEXT,"
            + COL_SELECTED_DURATION + " TEXT);";

    // Create table query for BRANCH table
    private static final String CREATE_TABLE_BRANCH = "CREATE TABLE " + TABLE_BRANCH + "("
            + COL_BRANCH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_BRANCH_CODE + " TEXT,"
            + COL_BRANCH_NAME + " TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_COURSE);
            db.execSQL(CREATE_TABLE_BRANCH);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_BRANCH);
            onCreate(db);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert course details into the database
    public void insertDetails(String cName, String cFee, String sDate, String rCloseDate, String mParticipants, String sdBranch, String sDuration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_COURSE_NAME, cName);
        values.put(COL_COURSE_FEE, cFee);
        values.put(COL_START_DATE, sDate);
        values.put(COL_REGISTRATION_CLOSE_DATE, rCloseDate);
        values.put(COL_MAX_PARTICIPANTS, mParticipants);
        values.put(COL_SELECTED_BRANCH, sdBranch);
        values.put(COL_SELECTED_DURATION, sDuration);

        try {
            db.insert(TABLE_COURSE, null, values);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    // Retrieve all courses from the database
    public Cursor getAllCourses() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_COURSE, null, null, null, null, null, null);
    }

    // Retrieve course details from the database by course name
    public Cursor getCourseByName(String courseName) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                COL_COURSE_NAME,
                COL_COURSE_FEE,
                COL_START_DATE,
                COL_REGISTRATION_CLOSE_DATE,
                COL_MAX_PARTICIPANTS,
                COL_SELECTED_BRANCH,
                COL_SELECTED_DURATION
        };
        String selection = COL_COURSE_NAME + " = ?";
        String[] selectionArgs = {courseName};
        return db.query(TABLE_COURSE, projection, selection, selectionArgs, null, null, null);
    }

    // Update course details in the database
    public void updateCourse(String cName, String cFee, String sDate, String rCloseDate, String mParticipants, String sdBranch, String sDuration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_COURSE_FEE, cFee);
        values.put(COL_START_DATE, sDate);
        values.put(COL_REGISTRATION_CLOSE_DATE, rCloseDate);
        values.put(COL_MAX_PARTICIPANTS, mParticipants);
        values.put(COL_SELECTED_BRANCH, sdBranch);
        values.put(COL_SELECTED_DURATION, sDuration);

        String selection = COL_COURSE_NAME + " = ?";
        String[] selectionArgs = {cName};

        try {
            db.update(TABLE_COURSE, values, selection, selectionArgs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    // Delete course from the database by course name
    public void deleteCourseByName(String courseName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COL_COURSE_NAME + " = ?";
        String[] selectionArgs = {courseName};
        try {
            db.delete(TABLE_COURSE, selection, selectionArgs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    // Insert branch details into the database
    public boolean addBranch(String branchCode, String branchName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_BRANCH_CODE, branchCode);
        values.put(COL_BRANCH_NAME, branchName);
        long result = db.insert(TABLE_BRANCH, null, values);
        db.close();
        return result != -1;
    }

    // Retrieve all branches from the database
    public Cursor getAllBranches() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_BRANCH, null, null, null, null, null, null);
    }
}