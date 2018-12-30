package com.wolfenterprisesllc.prisongourmet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 13;
    private static final String DATABASE_NAME = "Favorite_Things2";
    private final String TABLE_NAME = "Favorites_Recipies2";
    private final String RECIPIE_NAME = "Recipie_Name";
    private final String KEY_ID = "id";

    DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    DBHandler(Recipie recipie, Object o, Context context, int i) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RECIPIE_NAME + " TEXT " +
                ");";
        db.execSQL(query);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        //be sure to change version number when you do this
    }

    private Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME, null);
        //db.close();   ERROR: this crashes when put before te return statement
        // java.lang.IllegalStateException: attempt to re-open an already-closed object:
        // SQLiteDatabase: /data/user/0/com.wolfenterprisesllc.prisongourmet/databases/Favorite_Things2
    }

    public void addRecipie(String theRecipie) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RECIPIE_NAME, theRecipie);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void deleteRecipie(String deleteThis) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, RECIPIE_NAME + " = " + deleteThis, null);
        db.close();
    }
    public List<RecipieHolder> getAllRecipies() {
        SQLiteDatabase db = this.getWritableDatabase();
        List<RecipieHolder> holder = new ArrayList<>();
        Cursor cursor = getAllData();
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            ArrayList<String> mArrayList = new ArrayList<String>();
            RecipieHolder myHolder = new RecipieHolder();
            mArrayList.add(cursor.getString(1));
            myHolder.setRecipie(String.valueOf(mArrayList).replace("[","").replace("]",""));

            holder.add(myHolder);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();
        return holder;
    }

    public int updateRecipie(RecipieHolder theOtherHolder) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RECIPIE_NAME, theOtherHolder.getRecipie());
        db.close();
        return db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{String.valueOf(theOtherHolder.getRecipie())});
    }


}

/*
    public int getRecipieCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();
        return cursor.getCount();
    }
*/

/*
    public Cursor getRecipieData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
*/

