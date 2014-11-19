package com.yarvan.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.yarvan.config.DD;
import com.yarvan.sqlite.DatabaseHelper.TableCreateInterface;

public class TableHospital implements TableCreateInterface{
	//从DD中找到表名
	public static String tableName = DD.DBTableName.HOSPITAL;
	//定义各字段名
	public static String _id = "_id";//系统生成
	public static String id = "id";//sql主键
	public static String address = "address";//医院地址
	public static String name = "name";//医院名字
	/*
	 * 单子模式
	 * */
	private TableHospital(){
		super();
	}
	public static TableHospital getInstance(){
		return new TableHospital();
	}
	//创建数据表
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE IF NOT EXISTS "+TableHospital.tableName
				+" ("
				+"_id integer primary key autoincrement, "
				+TableHospital.id+" TEXT, "
				+TableHospital.address+" TEXT, "
				+TableHospital.name+" TEXT "
				+");";
		db.execSQL(sql);
	}
	//更新数据表
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(oldVersion < newVersion){
			String sql = "DROP TABLE IF EXISTS " + TableHospital.tableName;
			db.execSQL(sql);
			this.onCreate(db);
		}
	}

}
