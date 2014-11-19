package com.yarvan.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	//默认数据库名字
	private final static String DB_NAME = "yarvan.db";
	//默认版本号
	private final static int VERSION = 1; 
	public DatabaseHelper(Context context){
		super(context, DB_NAME, null, VERSION);
	}
	/**
	 * 构造方法
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		System.out.println("gzq");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建各个表
		System.out.println("into_create");
		TableServiceInfo.getInstance().onCreate(db);
		TableServiceItem.getInstance().onCreate(db);
		TableServiceShop.getInstance().onCreate(db);
		TableTimePeriod.getInstance().onCreate(db);
		TableParttimeInfo.getInstance().onCreate(db);
		TableRegistration.getInstance().onCreate(db);
		System.out.println("oncreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("into_up");
		if (oldVersion >= newVersion) {
			return ;
		}
		//更新各个表
		TableServiceInfo.getInstance().onUpgrade(db, oldVersion, newVersion);
		TableServiceItem.getInstance().onUpgrade(db, oldVersion, newVersion);
		TableServiceShop.getInstance().onUpgrade(db, oldVersion, newVersion);
		TableTimePeriod.getInstance().onUpgrade(db, oldVersion, newVersion);
		TableParttimeInfo.getInstance().onUpgrade(db, oldVersion, newVersion);
		TableRegistration.getInstance().onUpgrade(db, oldVersion, newVersion);
		System.out.println("onup");
	}
	/**
	 * 创建接口，让table调用创建表
	 * @author Andrew
	 *
	 */
	public static interface TableCreateInterface{
		public void onCreate(SQLiteDatabase db);
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
	}
}
