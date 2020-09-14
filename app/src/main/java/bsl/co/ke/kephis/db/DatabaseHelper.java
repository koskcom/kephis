package bsl.co.ke.kephis.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Creating sqlite database and tables>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            db.execSQL(DataBaseAdapter.CREATE_TABLE_ADUSER);
            db.execSQL(DataBaseAdapter.CREATE_TABLE_USER);
            db.execSQL(DataBaseAdapter.CREATE_TABLE_FARM_INSPECTION);
            db.execSQL(DataBaseAdapter.CREATE_TABLE_C_BPARTNER);
            db.execSQL(DataBaseAdapter.CREATE_TABLE_FACILITY_INSPECTION);
            db.execSQL(DataBaseAdapter.CREATE_TABLE_PRODUCER_INSPECTION);
            db.execSQL(DataBaseAdapter.CREATE_TABLE_CONSIGNMENT_INSPECTION);
            db.execSQL(DataBaseAdapter.CREATE_TABLE_LOCAL_VARITIES);
            db.execSQL(DataBaseAdapter.CREATE_TABLE_COUNTY);
            db.execSQL(DataBaseAdapter.CREATE_TABLE_SUB_COUNTY);
            db.execSQL(DataBaseAdapter.CREATE_TABLE_COUNTRY);
        } catch (Exception er) {
            Log.e("Error", "exception");
        }
    }


    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.
    @Override
    public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
        System.out.println("Database being upgraded");
        // Log the version upgrade.

        // Upgrade the existing database to conform to the new version. Multiple
        // previous versions can be handled by comparing _oldVersion and _newVersion
        // values.
        // The simplest case is to drop the old table and create a new one.

        //Drop User Table if exist_db = databaseHelper.getReadableDatabase();
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_AD_USER);
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_login);
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_FARM_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_C_BPARTNER);
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_FACILITY_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_PRODUCER_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_CONSIGNMENT_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_LOCAL_VARITIES);
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_COUNTY);
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_SUB_COUNTY);
        _db.execSQL("DROP TABLE IF EXISTS " + DataBaseAdapter.TABLE_country);

        // Create tables again
        onCreate(_db);
    }


}