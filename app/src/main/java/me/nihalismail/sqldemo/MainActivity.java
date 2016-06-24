package me.nihalismail.sqldemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase myDataBase = this.openOrCreateDatabase("Cricketers", MODE_PRIVATE, null);
            myDataBase.execSQL("CREATE TABLE IF NOT EXISTS fab4(name VARCHAR,jersyNo INT[2])");
            myDataBase.execSQL("INSERT INTO fab4(name,jersyNo) VALUES('Virat Kohli',18)");
            myDataBase.execSQL("INSERT INTO fab4(name,jersyNo) VALUES('Steve Smith',49)");
            myDataBase.execSQL("INSERT INTO fab4(name,jersyNo) VALUES('Joe Root',23)");
            myDataBase.execSQL("INSERT INTO fab4(name,jersyNo) VALUES('Kane Williamson',41)");
            Cursor c=myDataBase.rawQuery("SELECT * FROM fab4",null);
            c.moveToFirst();
            //myDataBase.execSQL("DELETE FROM fab4 WHERE name ='Joe Root' LIMIT 1");
            //myDataBase.execSQL("DELETE from fab4 WHERE NAME='Joe Root'");
            int nameIndex=c.getColumnIndex("name");
            int jersyIndex=c.getColumnIndex("jersyNo");
            while (c!=null)
            {
                Log.i("MAVA-Name",c.getString(nameIndex));
                Log.i("MAVA-Jersy No",String.valueOf(c.getInt(jersyIndex)));
                c.moveToNext();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
