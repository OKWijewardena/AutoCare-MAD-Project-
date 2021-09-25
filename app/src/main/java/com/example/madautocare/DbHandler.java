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

    private  static final  int VERSION = 3;
    private static  final String DB_NAME = "AutoCare";

    private static  final String TABLE_NAME = "AddItems";
    private static  final String TABLE_NAME2 = "OrderItems";

    //Supplier Database Name
    private static  final String TABLE_NAME_Suppliers= "Suppliers";

    //Sales Database Name
    private static  final String TABLE_NAME_Sales= "Sales";

    private static  final String ITEMCODE = "ItemCode";
    private static  final String ITEMNAME = "ItemName";
    private static  final String ITEMPRICE = "ItemPrice";
    private static  final String ITEMQUANTITY = "ItemQuantity";
//    private static  final String ITEMIMAGE = "ItemImage";

    //Supplier Database Table Columns
    private static  final String SuppliersName = "SuppliersName";
    private static  final String SuppliersEmail = "SuppliersEmail";
    private static  final String SuppliersPassword = "SuppliersPassword";
    private static  final String SuppliersPhoneNumber = "SuppliersPhoneNumber";


    //Customer database Service details
    private static final String TABLE_NAME_CUS = "vehicle_details";
    private static final String ID = "Vehicle_ID";
    private static final String TYPE = "Vehicle_Type";

    private static final String KM= "Km_per_day";
    private static final String NAME = "UserName";
    private static final String EMAIL = "Email";
    private static final String DATE = "Date";


    //Supplier Database Table Columns
    private static  final String CustomerName = "CustomerName";
    private static  final String CustomerEmail = "CustomerEmail";
    private static  final String CustomerBillType = "CustomerBillType";
    private static  final String CustomerPhoneNumber = "CustomerPhoneNumber";
    private static  final String CustomerBillAmount = "CustomerBillAmount";


    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    // table Add Items
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Items
        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" "+
                "("
                +ITEMCODE+" TEXT,"
                +ITEMNAME+" TEXT,"
                +ITEMPRICE+" TEXT,"
                +ITEMQUANTITY+" TEXT"+
                ");";
        db.execSQL(TABLE_CREATE_QUERY);

        //Supplier
        String TABLE_CREATE = "CREATE TABLE "+TABLE_NAME_Suppliers+" "+
                "("
                +SuppliersName+" TEXT,"
                +SuppliersEmail+" TEXT,"
                +SuppliersPassword+" TEXT,"
                +SuppliersPhoneNumber+
                ");";

        db.execSQL(TABLE_CREATE);


        //service details
        String TABLE_CREATE_Q = "CREATE TABLE "+TABLE_NAME_CUS+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +TYPE + " TEXT,"
                +KM+" INTEGER,"
                +NAME + " TEXT,"
                +EMAIL + " TEXT,"
                +DATE+ " TEXT"+
                ");";
        db.execSQL(TABLE_CREATE_Q);




        //Sales
        String TABLE_CREATE_SALES = "CREATE TABLE "+TABLE_NAME_Sales+" "+
                "("
                +CustomerName+" TEXT,"
                +CustomerEmail+" TEXT,"
                +CustomerBillType+" TEXT,"
                +CustomerBillAmount+" TEXT,"
                +CustomerPhoneNumber+" TEXT"+
                ");";

        db.execSQL(TABLE_CREATE_SALES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE_QUERY);

        onCreate(db);

        //Supplier
        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME_Suppliers;
        db.execSQL(DROP_TABLE);
        onCreate(db);


        //service details
        String DROP_TABLE_Q = "DROP TABLE IF EXISTS "+ TABLE_NAME_CUS;
        db.execSQL(DROP_TABLE_Q);
        onCreate(db);

        //Sales
        String DROP_TABLE_SALES = "DROP TABLE IF EXISTS " + TABLE_NAME_Sales;
        db.execSQL(DROP_TABLE_SALES);

        onCreate(db);
    }

    //Check Supplier name
    public boolean CheckSupplierName(String SupplierName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Supplers where SupplersName = ?",new String[] {SupplierName});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //Check Supplier password
    public boolean CheckSupplierPassword(String SupplierName,String SupplierPassword){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Suppliers where SuppliersName = ? and SuppliersPassword = ?",new String[] {SupplierName,SupplierPassword});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //Check Customer name
    public boolean CheckCustomerName(String CustomerName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from customer where username = ?",new String[] {CustomerName});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //Check Customer password
    public boolean CheckCustomerPassword(String CustomerName,String CustomerPassword){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from customer where username = ? and password = ?",new String[] {CustomerName,CustomerPassword});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
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

    //service details add
    public void add_cus(VehicleDetailsModel vehicleDetailsModel){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TYPE,vehicleDetailsModel.getVehicleType());
        contentValues.put(KM, vehicleDetailsModel.getKm());
        contentValues.put(NAME,vehicleDetailsModel.getUsername());
        contentValues.put(EMAIL,vehicleDetailsModel.getEmail());
        contentValues.put(DATE,vehicleDetailsModel.getDate());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME_CUS,null,contentValues);
        // close database
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
    public void deleteItem(String code){
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

    // Get supplier single data
    public supplier_modle getSingleSupplier(String code){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME_Suppliers,new String[]{SuppliersName,SuppliersEmail,SuppliersPassword, SuppliersPhoneNumber},
                SuppliersName + "= ?",new String[]{String.valueOf(code)}
                ,null,null,null);

        supplier_modle supplier;
        if(cursor != null){
            cursor.moveToFirst();
            supplier = new supplier_modle(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
            return supplier;
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

    //Add the Suppliers
    public void additem(supplier_modle add){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(SuppliersName,add.getSuppliers_Name());
        contentValues.put(SuppliersEmail,add.getSuppliers_Email());
        contentValues.put(SuppliersPassword,add.getSuppliers_Password());
        contentValues.put(SuppliersPhoneNumber,add.getSuppliers_Phone_Number());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME_Suppliers,null,contentValues);
        // close database
        sqLiteDatabase.close();
    }

    // Get all suppliers into a list
    public List<supplier_modle> getallsuppliers(){

        List<supplier_modle> list = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME_Suppliers;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                // Create new sm object
                supplier_modle sm = new supplier_modle();


                sm.setSuppliers_Name(cursor.getString(0));
                sm.setSuppliers_Email(cursor.getString(1));
                sm.setSuppliers_Password(cursor.getString(2));
                sm.setSuppliers_Phone_Number(cursor.getString(3));

                list.add(sm);
            }while (cursor.moveToNext());
        }
        return list;
    }

    // Delete the Supplier
    public void deletesupplier(String email){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME_Suppliers,"SuppliersEmail = ?",new String[]{String.valueOf(email)});
        db.close();
    }

    public supplier_modle getSinglesupplier(String email){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME_Suppliers,new String[]{SuppliersName,SuppliersEmail,SuppliersPassword,SuppliersPhoneNumber},
                SuppliersEmail + "= ?",new String[]{String.valueOf(email)}
                ,null,null,null);

        supplier_modle update;
        if(cursor != null){
            cursor.moveToFirst();
            update = new supplier_modle(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
            return update;
        }
        return null;
    }

    // Update a single Supplier
    public int updateSinglesupplier(supplier_modle updated){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(SuppliersName,updated.getSuppliers_Name());
        contentValues.put(SuppliersEmail, updated.getSuppliers_Email());
        contentValues.put(SuppliersPassword,updated.getSuppliers_Password());
        contentValues.put(SuppliersPhoneNumber,updated.getSuppliers_Phone_Number());

        int status = db.update(TABLE_NAME_Suppliers,contentValues,SuppliersEmail +" =?",
                new String[]{String.valueOf(updated.getSuppliers_Email())});

        db.close();
        return status;
    }

    // Count Suppliers
    public int countsuppliers(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME_Suppliers;

        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }

    //Add the Sales
    public void addsales(sales_modle add){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CustomerName,add.getCustomerName());
        contentValues.put(CustomerEmail,add.getCustomerEmail());
        contentValues.put(CustomerBillType,add.getCustomerBillType());
        contentValues.put(CustomerPhoneNumber,add.getCustomerPhoneNumber());
        contentValues.put(CustomerBillAmount,add.getCustomerBillAmount());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME_Sales,null,contentValues);
        // close database
        sqLiteDatabase.close();
    }
}
