package com.yarvan.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.yarvan.config.DD;
import com.yarvan.sqlite.DatabaseHelper.TableCreateInterface;

public class TableServiceInfo implements TableCreateInterface{
	//从DD中找到表名
	public static String tableName = DD.DBTableName.SERVICE_INFO;
	//定义各字段名
	public static String _id = "_id";//系统生成
	public static String id = "id";//sql主键
	public static String count = "count";//服务剩余数量
	public static String date = "date";//服务信息日期
	public static String item_id = "item_id";//服务项目
	public static String shop_id = "shop_id";//所属服务中心
	public static String time_id = "time_id";//服务时间段
	public static String is_app = "is_app";//是否预约
	/*
	 * 单子模式
	 * */
	private TableServiceInfo(){
		super();
	}
	public static TableServiceInfo getInstance(){
		return new TableServiceInfo();
	}
	//创建数据表
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE "+TableServiceInfo.tableName
				+" ("
				+"_id integer primary key autoincrement, "
				+TableServiceInfo.id+" TEXT, "
				+TableServiceInfo.count+" TEXT, "
				+TableServiceInfo.item_id+" TEXT, "
				+TableServiceInfo.shop_id+" TEXT, "
				+TableServiceInfo.time_id+" TEXT, "
				+TableServiceInfo.is_app+" TEXT, "
				+TableServiceInfo.date+" TEXT "
				+");";
		db.execSQL(sql);
	}
	//更新数据表
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(oldVersion < newVersion){
			String sql = "DROP TABLE IF EXISTS " + TableServiceInfo.tableName;
			db.execSQL(sql);
			this.onCreate(db);
		}
	}

}
