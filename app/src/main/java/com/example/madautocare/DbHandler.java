package com.example.madautocare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private  static final  int VERSION = 1;
    private static  final String DB_NAME = "AutoCare";

    private static  final String TABLE_NAME = "AddItems";
    private static  final String TABLE_NAME2 = "OrderItems";

    private static  final String ITEMCODE = "ItemCode";
    private static  final String ITEMNAME = "ItemName";
    private static  final String ITEMPRICE = "ItemPrice";
    private static  final String ITEMQUANTITY = "ItemQuantity";
//    private static  final String ITEMIMAGE = "ItemImage";




    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    // table Add Items
    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" "+
                "("
                +ITEMCODE+" TEXT,"
                +ITEMNAME+" TEXT,"
                +ITEMPRICE+" TEXT,"
                +ITEMQUANTITY+" TEXT"+
                ");";
        db.execSQL(TABLE_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE_QUERY);

        onCreate(db);

    }
    // add details
    public void add(AddDbPass ad){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ITEMCODE,ad.getCode());
        contentValues.put(ITEMNAME,ad.getNames());
        contentValues.put(ITEMPRICE,ad.getPrice());
        contentValues.put(ITEMQUANTITY,ad.getQuantity());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        //close database
        sqLiteDatabase.close();

    }

    //get details
    public List<AddDbPass> getDetails(){
        List<AddDbPass> ge = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                AddDbPass getdata = new AddDbPass();

                getdata.setCode(cursor.getString(0));
                getdata.setNames(cursor.getString(1));
                getdata.setPrice(cursor.getString(2));
                getdata.setQuantity(cursor.getString(3));

                ge.add(getdata);

            }while(cursor.moveToNext());
        }


        return ge;
    }

    // Delete item
    public void deleteToDo(String code){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"ItemCode =?",new String[]{String.valueOf(code)});
        db.close();
    }

    // Get a single data
    public AddDbPass getSingleData(String code){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ITEMCODE,ITEMNAME,ITEMPRICE, ITEMQUANTITY},
                ITEMCODE + "= ?",new String[]{String.valueOf(code)}
                ,null,null,null);

        AddDbPass addDbPass;
        if(cursor != null){
            cursor.moveToFirst();
            addDbPass = new AddDbPass(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
            return addDbPass;
        }
        return null;
    }

    // Update
    public int updateSingleRow(AddDbPass addDbPass){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(ITEMCODE,addDbPass.getCode());
        contentValues.put(ITEMNAME,addDbPass.getNames());
        contentValues.put(ITEMPRICE,addDbPass.getPrice());
        contentValues.put(ITEMQUANTITY,addDbPass.getQuantity());


        int status = db.update(TABLE_NAME,contentValues,ITEMCODE +" =?",
                new String[]{String.valueOf(addDbPass.getCode())});

        db.close();
        return status;
    }
}
