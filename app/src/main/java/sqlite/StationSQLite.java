package sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 24/05/2015.
 */
public class StationSQLite extends SQLiteOpenHelper {

    private static final String TABLE_STATIONS = "table_stations";
    private static final String COL_idStation ="idStation";
    private static final String COL_nomStation ="nomStation";
    private static final String COL_idLigne="idLigne";

    private static final String CREATE_BDD = "CREATE TABLE "+ TABLE_STATIONS + " ("+COL_idLigne+" INTEGER PRIMARY" +
            "KEY AUTOINCREMENT, "+ COL_nomStation+ " TEXT NOT NULL, "+ COL_idStation + " TEXT NOT NULL);";

    public StationSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super (context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+TABLE_STATIONS+";");
        onCreate(db);
    }
}
