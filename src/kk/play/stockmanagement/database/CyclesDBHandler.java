package kk.play.stockmanagement.database;

import java.util.ArrayList;
import java.util.List;

import kk.play.stockmanagement.entity.Cycles;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CyclesDBHandler extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "KeshriSpares";
	private static final int DATABASE_VERSION = 1;

	private static final String TABLE_NAME = "cycles";
	private static final String TYPE = "type";

	private static final String itemId = "_id";
	private static final String NAME = "compName";
	private static final String IMAGE = "img";
	private static final String DESCRIPTION = "desc";
	private static final String COLOR = "color";
	private static final String SIZE = "size";
	private static final String QUANTITY = "quantity";

	private static final String CREATE_ITEM_TABLE = "create table "
			+ TABLE_NAME + "(" + itemId + " integer primary key autoincrement,"
			+ NAME + " varchar(50)," + IMAGE + " varchar(20)," + DESCRIPTION
			+ " varchar(100)," + COLOR + " varchar(10)," + SIZE + " int(5),"
			+ QUANTITY + " int(5)," + TYPE + " varchar(20)" + ");";

	SQLiteDatabase db;

	public CyclesDBHandler(Context context) {
		super(context, NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(CREATE_ITEM_TABLE);
		Log.d("Query", CREATE_ITEM_TABLE);
		// db.close();

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

		// Create tables again
		onCreate(db);
	}

	public List<Cycles> getCyclesByType(String type) {

		db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, new String[] { itemId, NAME,
				IMAGE, DESCRIPTION, QUANTITY, SIZE, COLOR }, TYPE + "=?",
				new String[] { type }, null, null, null);

		List<Cycles> cycleList = new ArrayList<Cycles>();
		// if(cursor!=null)//Empty DataBase Table
		// cursor.moveToFirst();
		while (cursor.moveToNext()) {
			Log.d("inside cursor", "msg" + 1);
			Cycles cycle = new Cycles();

			cycle.setId(Integer.parseInt(cursor.getString(0)));
			cycle.setNAME(cursor.getString(1));
			cycle.setIMAGE(cursor.getString(2));
			cycle.setDESCRIPTION(cursor.getString(3));
			cycle.setQUANTITY(Integer.parseInt(cursor.getString(4)));
			cycle.setSIZE(Integer.parseInt(cursor.getString(5)));
			cycle.setCOLOR(cursor.getString(6));

			cycleList.add(cycle);

		}
		db.close();
		return cycleList;

	}

	public boolean addNewCycle(Cycles cycle) {

		db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(NAME, cycle.getNAME());
		values.put(IMAGE, cycle.getIMAGE());
		values.put(COLOR, cycle.getCOLOR());
		values.put(DESCRIPTION, cycle.getDESCRIPTION());
		values.put(SIZE, cycle.getSIZE());
		values.put(QUANTITY, cycle.getSIZE());
		values.put(TYPE, cycle.getTYPE());
		Log.d(cycle.getNAME(), "msg" + cycle.getSIZE());

		if (db.insert(TABLE_NAME, null, values) > 0)
			return true;

		return false;

	}

	public int getCountofCycle(int id) {
		db = this.getReadableDatabase();
		String count = null;
		String selectQuery = "SELECT " + QUANTITY + " FROM " + TABLE_NAME
				+ " WHERE " + itemId + "=?";
		Cursor c = db.rawQuery(selectQuery, new String[] { "" + id });
		if (c.moveToFirst()) {
			count = c.getString(c.getColumnIndex(QUANTITY));
		}

		c.close();
		return Integer.parseInt(count);
	}

	public boolean updateQuantity(int id, boolean flag) {

		int count = getCountofCycle(id);
		int newValue = count;
		if (flag) {
			newValue = newValue + 1;
		} else {
			if (count == 0)
				return false;
			else
				newValue = newValue - 1;

		}
		ContentValues cv = new ContentValues();
		cv.put(QUANTITY, newValue);
		db.update(TABLE_NAME, cv, itemId + "= ?", new String[] { "" + id });

		return true;
	}
}
