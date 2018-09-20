package appone.bmp.com.applog.Fragment;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class myDB extends SQLiteOpenHelper {
    private static final String dbname="db1";
    private static final int dbversion =1;
    private static final String tbname="tblog";
    private static final String create_table ="Create table "+tbname+"(" +
            "id TEXT(20) PRIMARY KEY," +
            "email TEXT(50)," +
            "password TEXT(50));";
    public myDB(Context context) {
        super(context, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);
    }
    public Cursor SelectData(){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String sql="Select * from "+tbname;
            Cursor cur = db.rawQuery(sql,null);

            return cur;

        }catch (Exception e){
            return null;
        }

    }
    public String [] SelectDataByVal(String strid){
        try {
            String [] data =null;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql=String.format("Select * from "+tbname+" where id=%s",strid.trim());
            Log.d("20SepV1","Sql ==> "+sql);
          //  SQLiteStatement stm = db.compileStatement(sql);
           // stm.bindString(1,email);
           Cursor cur = db.rawQuery(sql,null);
           if(cur !=null){
               if(cur.moveToFirst()){
                   data = new String[cur.getColumnCount()];
                   data[0] =cur.getString(cur.getColumnIndex("id"));
                   data[1] =cur.getString(cur.getColumnIndex("email"));
                   data[2] =cur.getString(cur.getColumnIndex("password"));
               }

           }
            cur.close();
            return data;
        }catch (Exception e){
            return null;
        }


    }
    public long InsertData(String id,String email,String pwd){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql="Insert Into "+tbname+"(id,email,password)"+"values(?,?,?)";
            SQLiteStatement stm = db.compileStatement(sql);
            stm.bindString(1,id);
            stm.bindString(2,email);
            stm.bindString(3,pwd);
            long r = stm.executeInsert();
            db.close();
            return r;

        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
