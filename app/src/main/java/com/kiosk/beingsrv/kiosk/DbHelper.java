package com.kiosk.beingsrv.kiosk;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by BeingSrv on 01/10/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    // Database attributes
    public static final String DB_NAME = "Womenintech";
    public static final int DB_VERSION = 1;

    // Table attributes

    public static final String TABLE_NAME = "Data_Table";

    //Data Table
    public static final String KEY_FNAME ="First_Name";
    public static final String KEY_LNAME = "Last_Name";
    public static final String KEY_EMAIL = "Email_Address";
    public static final String KEY_CHECK = "Updates_Req";

    //paramters
    public String f_name ;
    public String l_name;
    public String e_mail;
    public String checked;
    public Context context;


    public DbHelper(Context context, String fname,String lname, String email,String checked) {
        super(context, DB_NAME, null, 1);
        this.context = context;
        f_name = fname;
        l_name=lname;
        e_mail=email;
        this.checked = email;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

        String DataTable = "create table if not exists " + TABLE_NAME + " ( " + BaseColumns._ID + " integer primary key autoincrement, "
                + KEY_FNAME + " text not null, "
                + KEY_LNAME + " text, "
                + KEY_EMAIL + " text, "
                + KEY_CHECK + " text);";

        db.execSQL(DataTable);
            Log.i("Executed inside", "table created");
        }
        catch (Exception e){
            Log.i("table creation ",e.getMessage().toString());
            Toast.makeText(context,"Tbable creation failed !!",Toast.LENGTH_SHORT).show();
        }

        try {
            String ROW1 = "INSERT INTO " + TABLE_NAME + " ("
                    + KEY_FNAME + ", " + KEY_LNAME + ", "
                    + KEY_EMAIL + ", "
                    + KEY_CHECK + ") Values ('" + f_name + "','" + l_name + "','" + e_mail + "','" + checked + "')";
            db.execSQL(ROW1);
            Log.i("Executed inside", "response accepted");
            Toast.makeText(context, " Response is Accepted !!", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Log.i("Error Insert",e.getMessage().toString());
            Toast.makeText(context,"OOps something went wrong !! Please retry !!",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i("Upgrade got executed","executed in uppgrade");
        Toast.makeText(context,"UPgrade !!",Toast.LENGTH_SHORT).show();

    }

    public void addEntry(UserData data ) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
}
