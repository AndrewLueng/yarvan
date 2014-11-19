package com.yarvan.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.yarvan.config.DD;
import com.yarvan.sqlite.DatabaseHelper.TableCreateInterface;

public class TableParttimeInfo implements TableCreateInterface{
	//从DD中找到表名
	public static String tableName = DD.DBTableName.PARTTIME_INFO;
	//定义各字段名
	public static String _id = "_id";//系统生成
	public static String id = "id";//sql主键
	public static String count = "count";//兼职剩余数量
	public static String date = "date";//兼职信息日期
	public static String item_id = "item_id";//兼职服务项目
	public static String shop_id = "shop_id";//兼职所属服务中心
	public static String time_id = "time_id";//兼职时间段
	public static String is_app = "is_app";//是否预约
	/*
	 * 单子模式
	 * */
	private TableParttimeInfo(){
		super();
	}
	public static TableParttimeInfo getInstance(){
		return new TableParttimeInfo();
	}
	//创建数据表
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE IF NOT EXISTS "+TableParttimeInfo.tableName
				+" ("
				+"_id integer primary key autoincrement, "
				+TableParttimeInfo.id+" TEXT, "
				+TableParttimeInfo.count+" TEXT, "
				+TableParttimeInfo.item_id+" TEXT, "
				+TableParttimeInfo.shop_id+" TEXT, "
				+TableParttimeInfo.time_id+" TEXT, "
				+TableParttimeInfo.is_app+" TEXT, "
				+TableParttimeInfo.date+" TEXT "
				+");";
		db.execSQL(sql);
	}
	//更新数据表
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(oldVersion < newVersion){
			String sql = "DROP TABLE IF EXISTS " + TableParttimeInfo.tableName;
			db.execSQL(sql);
			this.onCreate(db);
		}
	}

}
