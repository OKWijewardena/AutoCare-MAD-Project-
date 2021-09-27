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

    //Supplier Store Name
    private static  final String TABLE_NAME = "AddItems";

    //Supplier Database Name
    private static  final String TABLE_NAME_Suppliers= "Suppliers";

    //Sales Database Name
    private static  final String TABLE_NAME_Sales= "Sales";

    private static  final String ITEMCODE = "ItemCode";
    private static  final String ITEMNAME = "ItemName";
    private static  final String ITEMPRICE = "ItemPrice";
    private static  final String ITEMQUANTITY = "ItemQuantity";

    //Supplier Database Table Columns
    private static  final String SuppliersName = "SuppliersName";
    private static  final String SuppliersEmail = "SuppliersEmail";
    private static  final String SuppliersPassword = "SuppliersPassword";
    private static  final String SuppliersPhoneNumber = "SuppliersPhoneNumber";




    //Customer database Service details
//    private static final String TABLE_NAME_CUS = "vehicle_details";
//    private static final String ID = "Vehicle_ID";
//    private static final String TYPE = "Vehicle_Type";
//
//    private static final String KM= "Km_per_day";
//    private static final String NAME = "UserName";
//    private static final String EMAIL = "Email";
//    private static final String DATE = "Date";




    //Supplier Database Table Columns
    private static  final String CustomerName = "CustomerName";
    private static  final String CustomerEmail = "CustomerEmail";
    private static  final String CustomerBillType = "CustomerBillType";
    private static  final String CustomerPhoneNumber = "CustomerPhoneNumber";
    private static  final String CustomerBillAmount = "CustomerBillAmount";






    //admin side customer bookings orders=========================================================


    // admin cus database table column names
    private static final String TABLE_NAME6="customer";

    private static final String NAME ="name";
    private static final String USERNAME ="username";
    private static final String EMAIL ="email";
    private static final String PHONE ="phoneNumber";
    private static final String PASSWORD="password";

    //admin bookings
    private static final String TABLE2_NAME7="booking";

    private static final String AID ="Vehicle_ID";
    private static final String ATYPE ="Vehicle_Type";
    private static final String AKM ="Km_per_day";
    private static final String ANAME ="UserName";
    private static final String AMAIL="Email";
    private static final String ADATE="Date";

    //admin complete bookings

    private static final String TABLE3_NAME8="complete_booking";

    private static final String CID ="Vehicle_ID";
    private static final String CTYPE ="Vehicle_Type";
    private static final String CKM ="Km_per_day";
    private static final String CNAME ="UserName";
    private static final String CMAIL="Email";
    private static final String CDATE="Date";


    //admin Order part

    private static final String TABLE4_NAME9="customer_order";

    private static final String OID ="order_Id";
    private static final String OCUSNAME ="customer_Name";
    private static final String OCUSEMAIL ="customer_Email";
    private static final String OITEMID ="item_Id";
    private static final String OITEMNAME ="item_Name";
    private static final String OQUN="Qun";
    private static final String ODATE="Date";


    //admin Order part

    private static final String TABLE5_NAME10="compleate_order";

    private static final String COID ="order_Id";
    private static final String COCUSNAME ="customer_Name";
    private static final String COCUSEMAIL ="customer_Email";
    private static final String COITEMID ="item_Id";
    private static final String COITEMNAME ="item_Name";
    private static final String COQUN="Qun";
    private static final String CODATE="Date";

    //admin side customer bookings orders=========================================================

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
//        String TABLE_CREATE_Q = "CREATE TABLE "+TABLE_NAME_CUS+" " +
//                "("
//                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
//                +TYPE + " TEXT,"
//                +KM+" INTEGER,"
//                +NAME + " TEXT,"
//                +EMAIL + " TEXT,"
//                +DATE+ " TEXT"+
//                ");";
//        db.execSQL(TABLE_CREATE_Q);





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

        //admin side customer bookings orders=========================================================

        String TABLE_CREATE_QUERY6="CREATE TABLE "+TABLE_NAME6+" "+"("
                +NAME+" TEXT,"
                +USERNAME+" TEXT,"
                +EMAIL+" TEXT,"
                +PHONE+" TEXT,"
                +PASSWORD+" TEXT"+
                ");";

        db.execSQL(TABLE_CREATE_QUERY6);

        String TABLE2_CREATE_QUERY7="CREATE TABLE "+TABLE2_NAME7+" "+"("
                +AID+" TEXT,"
                +ATYPE+" TEXT,"
                +AKM+" TEXT,"
                +ANAME+" TEXT,"
                +AMAIL+" TEXT,"
                +ADATE+" TEXT"+
                ");";

        db.execSQL(TABLE2_CREATE_QUERY7);


        String TABLE3_CREATE_QUERY8="CREATE TABLE "+TABLE3_NAME8+" "+"("
                +CID+" TEXT,"
                +CTYPE+" TEXT,"
                +CKM+" TEXT,"
                +CNAME+" TEXT,"
                +CMAIL+" TEXT,"
                +CDATE+" TEXT"+
                ");";

        db.execSQL(TABLE3_CREATE_QUERY8);


        String TABLE4_CREATE_QUERY9="CREATE TABLE "+TABLE4_NAME9+" "+"("
                +OID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +OCUSNAME+" TEXT,"
                +OCUSEMAIL+" TEXT,"
                +OITEMID+" TEXT,"
                +OITEMNAME+" TEXT,"
                +OQUN+" TEXT,"
                +ODATE+" TEXT"+
                ");";

        db.execSQL(TABLE4_CREATE_QUERY9);


        String TABLE5_CREATE_QUERY10="CREATE TABLE "+TABLE5_NAME10+" "+"("
                +COID+" INTEGER,"
                +COCUSNAME+" TEXT,"
                +COCUSEMAIL+" TEXT,"
                +COITEMID+" TEXT,"
                +COITEMNAME+" TEXT,"
                +COQUN+" TEXT,"
                +CODATE+" TEXT"+
                ");";

        db.execSQL(TABLE5_CREATE_QUERY10);

        //admin side customer bookings orders=========================================================


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
//        String DROP_TABLE_Q = "DROP TABLE IF EXISTS "+ TABLE_NAME_CUS;
//        db.execSQL(DROP_TABLE_Q);
//        onCreate(db);


        //Sales
        String DROP_TABLE_SALES = "DROP TABLE IF EXISTS " + TABLE_NAME_Sales;
        db.execSQL(DROP_TABLE_SALES);
        onCreate(db);





        //admin side customer bookings orders=========================================================


        String DROP_TABLE_QUERY6=" DROP TABLE IF EXISTS "+TABLE_NAME6;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY6);
        // create tables again
        onCreate(db);


        String DROP_TABLE_QUERY7=" DROP TABLE IF EXISTS "+TABLE2_NAME7;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY7);
        // create tables again
        onCreate(db);

        String DROP_TABLE_QUERY8=" DROP TABLE IF EXISTS "+TABLE3_NAME8;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY8);
        // create tables again
        onCreate(db);

        String DROP_TABLE_QUERY9=" DROP TABLE IF EXISTS "+TABLE4_NAME9;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY9);
        // create tables again
        onCreate(db);

        String DROP_TABLE_QUERY10=" DROP TABLE IF EXISTS "+TABLE5_NAME10;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY10);
        // create tables again
        onCreate(db);



        //admin side customer bookings orders=========================================================

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
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Suppliers where SuppliersName = ? and SuppliersPassword = ?",new String[]
                {SupplierName,SupplierPassword});
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
        Cursor cursor = sqLiteDatabase.rawQuery("select * from customer where username = ? and password = ?",new String[]
                {CustomerName,CustomerPassword});
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

    // Add customer order details
    public void addOrderParts(order_parts_model od){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(OID,od.getOrder_id());
        contentValues.put(OCUSNAME,od.getCustomer_Names());
        contentValues.put(OCUSEMAIL,od.getCustomer_Email());
        contentValues.put(OITEMID,od.getItem_id());
        contentValues.put(OITEMNAME,od.getItem_Names());
        contentValues.put(OQUN,od.getQun());
        contentValues.put(ODATE,od.getDates());

        //save to table
        sqLiteDatabase.insert(TABLE4_NAME9,null,contentValues);
        //close database
        sqLiteDatabase.close();

    }


    //service details add
    public void add_cus(VehicleDetailsModel vehicleDetailsModel){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        contentValues.put(CTYPE,vehicleDetailsModel.getVehicleType());
        contentValues.put(CKM, vehicleDetailsModel.getKm());
        contentValues.put(CNAME,vehicleDetailsModel.getUsername());
        contentValues.put(CMAIL,vehicleDetailsModel.getEmail());
        contentValues.put(CDATE,vehicleDetailsModel.getDate());

        //save to table
        sqLiteDatabase.insert(TABLE3_NAME8,null,contentValues);

        contentValues.put(ATYPE,vehicleDetailsModel.getVehicleType());
        contentValues.put(AKM, vehicleDetailsModel.getKm());
        contentValues.put(ANAME,vehicleDetailsModel.getUsername());
        contentValues.put(AMAIL,vehicleDetailsModel.getEmail());
        contentValues.put(ADATE,vehicleDetailsModel.getDate());

        //save to table
        sqLiteDatabase.insert(TABLE2_NAME7,null,contentValues);

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

    //Customer order delete
    public void deleteCustomerOrder(String code){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE4_NAME9,"customer_Email =?",new String[]{String.valueOf(code)});
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

    // Customer order get single data
    public order_parts_model getCustomerOrderSingleData(String code){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE4_NAME9,new String[]{OID,OCUSNAME,OCUSEMAIL,OITEMID,OITEMNAME,OQUN, ODATE},
                OCUSEMAIL + "= ?",new String[]{String.valueOf(code)}
                ,null,null,null);

        order_parts_model or;
        if(cursor != null){
            cursor.moveToFirst();
            or = new order_parts_model(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)
            );
            return or;
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

    //update customer order
    public int updateOrdrsSingleRow(order_parts_model or){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(OCUSNAME,or.getCustomer_Names());
        contentValues.put(OCUSEMAIL,or.getCustomer_Email());
        contentValues.put(OQUN,or.getQun());
        contentValues.put(ODATE,or.getDates());

        int status = db.update(TABLE4_NAME9,contentValues,OCUSEMAIL +" =?",
                new String[]{String.valueOf(or.getCustomer_Email())});

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

    // Get all sales into a list
    public List<sales_modle> getallsales(){

        List<sales_modle> list = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME_Sales;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                // Create new sm object
                sales_modle sm = new sales_modle();


                sm.setCustomerName(cursor.getString(0));
                sm.setCustomerEmail(cursor.getString(1));
                sm.setCustomerBillType(cursor.getString(2));
                sm.setCustomerBillAmount(cursor.getString(3));
                sm.setCustomerPhoneNumber(cursor.getString(4));

                list.add(sm);
            }while (cursor.moveToNext());
        }
        return list;
    }

    public int countsales(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT CustomerBillAmount FROM "+ TABLE_NAME_Sales;
        Cursor cursor = db.rawQuery(query,null);

        int sales = 0;
        if(cursor.moveToFirst()){
            do {
                String row=cursor.getString(0);
                int value=Integer.parseInt(row);
                sales=value+sales;
                return sales;
            }while (cursor.moveToNext());
        }
        return sales;
//        return query;
    }



    //admin side customer bookings orders=========================================================



    //add customer details

    public void addCustomer(AddCustomers cus){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(NAME,cus.getCusName());
        contentValues.put(USERNAME,cus.getCusUserName());
        contentValues.put(EMAIL,cus.getCusEmail());
        contentValues.put(PHONE,cus.getPhone());
        contentValues.put(PASSWORD,cus.getPPassword());

        //save to table

        sqLiteDatabase.insert(TABLE_NAME6,null,contentValues);
        //if you want you can close the database
        sqLiteDatabase.close();

    }

    //get all cus details

    public List<AddCustomers> getAllDetails(){
        List<AddCustomers> cus =new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME6;

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                AddCustomers addCustomers = new AddCustomers();

                addCustomers.setCusName(cursor.getString(0));
                addCustomers.setCusUserName(cursor.getString(1));
                addCustomers.setCusEmail(cursor.getString(2));
                addCustomers.setPhone(cursor.getString(3));
                addCustomers.setPassword(cursor.getString(4));

                cus.add(addCustomers);
            }while (cursor.moveToNext());
        }
        return cus;
    }

    //item delete
    public void deleteCus(String mail){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME6,EMAIL +" =?",
                new String[]{String.valueOf(mail)});
        sqLiteDatabase.close();
    }

    //customer count
    public int countCustomers(){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String query= "SELECT * FROM " + TABLE_NAME6;

        Cursor cursor= sqLiteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }


    //add booking details

    public void addBookings(booking booking){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(AID,booking.getVehicle_ID() );
        contentValues.put(ATYPE,booking.getVehicle_Type() );
        contentValues.put(AKM,booking.getKm_per_day() );
        contentValues.put(ANAME,booking.getUserName() );
        contentValues.put(AMAIL,booking.getEmail() );
        contentValues.put(ADATE,booking.getDate());

        //save to table

        sqLiteDatabase.insert(TABLE2_NAME7,null,contentValues);
        //if you want you can close the database
        sqLiteDatabase.close();

    }

    //get all BOOKING details

    public List<booking> getBookDetails(){
        List<booking> book =new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE2_NAME7;

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                booking booking = new booking();

                booking.setVehicle_ID(cursor.getString(0));
                booking.setVehicle_Type(cursor.getString(1));
                booking.setKm_per_day(cursor.getString(2));
                booking.setUserName(cursor.getString(3));
                booking.setEmail(cursor.getString(4));
                booking.setDate(cursor.getString(5));

                book.add(booking);
            }while (cursor.moveToNext());
        }
        return book;
    }

    //booking delete
    public void deletebooking(String mail){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(TABLE2_NAME7,EMAIL +" =?", new
                String[]{String.valueOf(mail)});
        sqLiteDatabase.close();
    }


    //add complete bookings

    public void CompleteBookings(booking book){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(CID,book.getVehicle_ID());
        contentValues.put(CTYPE,book.getVehicle_Type());
        contentValues.put(CKM,book.getKm_per_day());
        contentValues.put(CNAME,book.getUserName());
        contentValues.put(CMAIL,book.getEmail());
        contentValues.put(CDATE,book.getDate());

        //save to table

        sqLiteDatabase.insert(TABLE3_NAME8,null,contentValues);
        //if you want you can close the database
        sqLiteDatabase.close();

    }

    //get all Complete BOOKING details

    public List<booking> getCompleteBookDetails(){
        List<booking> book =new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE3_NAME8;

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                booking booking = new booking();

                booking.setVehicle_ID(cursor.getString(0));
                booking.setVehicle_Type(cursor.getString(1));
                booking.setKm_per_day(cursor.getString(2));
                booking.setUserName(cursor.getString(3));
                booking.setEmail(cursor.getString(4));
                booking.setDate(cursor.getString(5));

                book.add(booking);
            }while (cursor.moveToNext());
        }
        return book;
    }



    //get all orders

    public List<Order> getorderDetails(){
        List<Order> orders =new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE4_NAME9;

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Order order = new Order();



                order.setOid(cursor.getInt(0));
                order.setCusname(cursor.getString(1));
                order.setCusEmail(cursor.getString(2));
                order.setItemId(cursor.getString(3));
                order.setItemname(cursor.getString(4));
                order.setQun(cursor.getString(5));
                order.setDates(cursor.getString(6));

                orders.add(order);
            }while (cursor.moveToNext());
        }
        return orders;
    }

//    //add orders details
//
//    public void addorders(Order order){
//        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//
//        contentValues.put(OID,order.getOid());
//        contentValues.put(OCUSNAME,order.getCusname());
//        contentValues.put(OCUSEMAIL,order.getCusEmail());
//        contentValues.put(OITEMID,order.getItemId());
//        contentValues.put(OITEMNAME,order.getItemname());
//        contentValues.put(OQUN,order.getQun());
//        contentValues.put(ODATE,order.getDates());
//
//        //save to table
//
//        sqLiteDatabase.insert(TABLE4_NAME9,null,contentValues);
//        //if you want you can close the database
//        sqLiteDatabase.close();
//
//    }



    //oreder update
    public int updateOrder(Order order){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();


        contentValues.put(OCUSNAME,order.getCusname());
        contentValues.put(OCUSEMAIL,order.getCusEmail());
        contentValues.put(OITEMID,order.getItemId());
        contentValues.put(OITEMNAME,order.getItemname());
        contentValues.put(OQUN,order.getQun());
        contentValues.put(ODATE,order.getDates());

        int status=sqLiteDatabase.update(TABLE4_NAME9,contentValues,OID +" =?",new String[]{String.valueOf(order.getOid())});
        sqLiteDatabase.close();

        return status;
    }

    //order delete
    public void deleteOrders(int id){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(TABLE4_NAME9,OID +" =?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

    public int countOrders(){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String query= "SELECT * FROM " + TABLE4_NAME9;

        Cursor cursor= sqLiteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }

    //get all Compleate orders

    public List<Order> getComOrderDetails(){
        List<Order> orders =new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE5_NAME10;

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Order order = new Order();



                order.setOid(cursor.getInt(0));
                order.setCusname(cursor.getString(1));
                order.setCusEmail(cursor.getString(2));
                order.setItemId(cursor.getString(3));
                order.setItemname(cursor.getString(4));
                order.setQun(cursor.getString(5));
                order.setDates(cursor.getString(6));

                orders.add(order);
            }while (cursor.moveToNext());
        }
        return orders;
    }

    //add completeorders details

    public void addCompleteOrdes(Order order){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COID,order.getOid());
        contentValues.put(COCUSNAME,order.getCusname());
        contentValues.put(COCUSEMAIL,order.getCusEmail());
        contentValues.put(COITEMID,order.getItemId());
        contentValues.put(COITEMNAME,order.getItemname());
        contentValues.put(COQUN,order.getQun());
        contentValues.put(CODATE,order.getDates());

        //save to table

        sqLiteDatabase.insert(TABLE5_NAME10,null,contentValues);
        //if you want you can close the database
        sqLiteDatabase.close();

    }

    public int countCOrders(){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String query= "SELECT * FROM " + TABLE5_NAME10;

        Cursor cursor= sqLiteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }







    //admin side customer bookings orders=========================================================



}
