package kk.play.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CycleQuantityHandler extends SQLiteOpenHelper{
	private static final String TABLE_NAME="cycleQuant";
	private static final int version=1;
	private static final int _id=1;
	private static final int cycleId=1;
	private static final int QUANTITY=1;

	private static final String date="date";

	SQLiteDatabase db;
	
	private static final String CREATE_Quantity_TABLE = "create table "
			+ TABLE_NAME + "(" + _id + " integer primary key autoincrement,"
			+ cycleId + " varchar(50)," +QUANTITY + " int(5)," + date + " varchar(20)" + ");";

	
	public CycleQuantityHandler(Context context) {
		super(context, TABLE_NAME, null, version);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	int getCountofCycle(int id){
		db=this.getReadableDatabase();
		String count=null;
		String selectQuery = "SELECT lastchapter FROM "+TABLE_NAME+" WHERE itemId=?";
		Cursor c = db.rawQuery(selectQuery, new String[] { ""+id });
		if (c.moveToFirst()) {
		   count= c.getString(c.getColumnIndex("lastchapter"));
		}
		
		c.close();
		return Integer.parseInt(count);
	}
	
	public boolean updateQuantity(int id,boolean flag){
		if(flag){
			
		}
		else{
			
		}
		
		return true;
	}

}
