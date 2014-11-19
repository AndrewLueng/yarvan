package com.yarvan.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.yarvan.config.DD;
import com.yarvan.sqlite.DatabaseHelper.TableCreateInterface;

public class TableServiceShop implements TableCreateInterface{
	//从DD中找到表名
	public static String tableName = DD.DBTableName.SERVICE_SHOP;
	//定义各字段名
	public static String _id = "_id";//系统生成
	public static String id = "id";//sql主键
	public static String address = "address";//服务点地址
	public static String contact_way = "contact_way";//服务点客服电话
	public static String shop_name = "shop_name";//服务点名
	/*
	 * 单子模式
	 * */
	private TableServiceShop(){
		super();
	}
	public static TableServiceShop getInstance(){
		return new TableServiceShop();
	}
	//创建数据表
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE "+TableServiceShop.tableName
				+" ("
				+"_id integer primary key autoincrement, "
				+TableServiceShop.id+" TEXT, "
				+TableServiceShop.address+" TEXT, "
				+TableServiceShop.shop_name+" TEXT, "
				+TableServiceShop.contact_way+" TEXT "
				+");";
		db.execSQL(sql);
	}
	//更新数据表
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(oldVersion < newVersion){
			String sql = "DROP TABLE IF EXISTS " + TableServiceShop.tableName;
			db.execSQL(sql);
			this.onCreate(db);
		}
	}

}
