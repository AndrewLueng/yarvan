package com.yarvan.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.yarvan.config.DD;
import com.yarvan.sqlite.DatabaseHelper.TableCreateInterface;

public class TableServiceItem implements TableCreateInterface{
	//从DD中找到表名
	public static String tableName = DD.DBTableName.SERVICE_ITEM;
	//定义各字段名
	public static String _id = "_id";//系统生成
	public static String id = "id";//Service_item中的主键
	public static String item_info = "item_info";//项目简介
	public static String item_name = "item_name";//项目名称
	/*
	 * 单子模式
	 * */
	private TableServiceItem(){
		super();
	}
	public static TableServiceItem getInstance(){
		return new TableServiceItem();
	}
	//创建数据表
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE "+TableServiceItem.tableName
				+" ("
				+"_id integer primary key autoincrement, "
				+TableServiceItem.id+" TEXT, "
				+TableServiceItem.item_info+" TEXT, "
				+TableServiceItem.item_name+" TEXT "
				+");";
		db.execSQL(sql);
	}
	//更新数据表
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(oldVersion < newVersion){
			String sql = "DROP TABLE IF EXISTS " + TableServiceItem.tableName;
			db.execSQL(sql);
			this.onCreate(db);
		}
	}

}
