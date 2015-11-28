package kk.play.fragments;

import java.sql.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CyclesSalesDBHandler extends SQLiteOpenHelper{
	
	private static final String DATABASE_NAME = "KeshriSpares";
	private static final int DATABASE_VERSION = 1;


	private static final String SALES_TABLE_NAME = "sales";
	private static final String ITEM_TABLE_NAME = "cycles";

	private static final String salesId = "sales_id";

	private static final String QUANTITY = "quantity";
	private static final String itemId = "item_id";
	private static final String DATE = "date";
	private static final String TIME = "time";


	private static final String CREATE_SALES_TABLE = "create table "
			+ SALES_TABLE_NAME + "("+  salesId +" integer primary key autoincrement,"
			+itemId +" int(50), "
			+ QUANTITY + " int(5), "+DATE+" DATETIME DEFAULT CURRENT_DATE, "
			+ TIME+" DATETIME DEFAULT CURRENT_TIME,"
			+ "foreign key ("+itemId + ") references "+ITEM_TABLE_NAME+"("+itemId+")"
			+");";

private SQLiteDatabase db;
	
	public CyclesSalesDBHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_SALES_TABLE);
		Log.d("Query2", CREATE_SALES_TABLE);

		
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + SALES_TABLE_NAME);
		onCreate(db);
		
	}
	
	/*public int getCountofCycle(int itemId) {
		db = this.getReadableDatabase();

		String count = null;
		String selectQuery = "SELECT " + QUANTITY + " FROM " + SALES_TABLE_NAME
				+ " WHERE " + itemId + "=?";
		Cursor c = db.rawQuery(selectQuery, new String[] { "" + itemId });
		if (c.moveToFirst()) {
			count = c.getString(c.getColumnIndex(QUANTITY));
		}

		c.close();
		return Integer.parseInt(count);
	}

	public boolean updateQuantity(int id,int quantity, boolean flag) {

		db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(itemId, id);
		values.put(QUANTITY, quantity);

		if(db.insert(SALES_TABLE_NAME, null, values)>0)//primary key of inserted quantity,-1 if not inserted
			return true;
		return false;
//		db.close();
	}*/


}
