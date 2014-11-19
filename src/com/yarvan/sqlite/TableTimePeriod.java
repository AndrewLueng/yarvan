package com.yarvan.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.yarvan.config.DD;
import com.yarvan.sqlite.DatabaseHelper.TableCreateInterface;

public class TableTimePeriod implements TableCreateInterface{
	//从DD中找到表名
	public static String tableName = DD.DBTableName.TIME_PERIOD;
	//定义各字段名
	public static String _id = "_id";//系统生成
	public static String id = "id";//time_period中的主键
	public static String time_period = "time_period";//时间段
	/*
	 * 单子模式
	 * */
	private TableTimePeriod(){
		super();
	}
	public static TableTimePeriod getInstance(){
		return new TableTimePeriod();
	}
	//创建数据表
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE IF NOT EXISTS "+TableTimePeriod.tableName
				+" ("
				+"_id integer primary key autoincrement, "
				+TableTimePeriod.id+" TEXT, "
				+TableTimePeriod.time_period+" TEXT "
				+");";
		db.execSQL(sql);
	}
	//更新数据表
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(oldVersion < newVersion){
			String sql = "DROP TABLE IF EXISTS " + TableTimePeriod.tableName;
			db.execSQL(sql);
			this.onCreate(db);
		}
	}

}
