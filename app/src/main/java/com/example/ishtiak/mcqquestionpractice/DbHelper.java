package com.example.ishtiak.mcqquestionpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ishtiak on 6/21/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    //database name
    private static final String DATABASE_NAME = "dbishtiak";
    //task table name
    private static final String TABLE_QUEST = "quest";

    //task table Column names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "optionaA";
    private static final String KEY_OPTB = "optionaB";
    private static final String KEY_OPTC = "optionaC";

    private SQLiteDatabase dbase;


    public DbHelper(Context contex) {
        super(contex, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";


        db.execSQL(sql);
        addQuestion();

    }

    private void addQuestion() {
        Question q1 = new Question("BCC ?", "Bangladesh Computer Coucil", "Bangladesh Cricket Council",
                "Bangladesh Cricket Committee", "Bangladesh Cricket Council");
        this.addQuestion(q1);
        Question q2 = new Question("What is JVM?", "Jakarta Virtual Matchine", "Java Virtual Matcine", "Java Virtual Matchine",
                "Java Virtual Machine");
        this.addQuestion(q2);
        Question q3 = new Question("Who is Rahman Sujon?", "Web developer", "Java Developer", "Android Developer",
                "Android Developer");
        this.addQuestion(q3);
        Question q4 = new Question("What is Java ?", "Java is a programming Lang.", "Java is programmer home",
                "Java is Coffee", "Java is a programming Lang.");
        this.addQuestion(q4);
        Question q5 = new Question("what SQLiteDatabase?", "database", "software",
                "nothing", "database");
        this.addQuestion(q5);

        Question q6 = new Question("What is JVM?", "Jakarta Virtual Matchine", "Java Virtual Matcine", "Java Virtual Matchine",
                "Java Virtual Matchine");
        this.addQuestion(q6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }


    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }


    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }


}
