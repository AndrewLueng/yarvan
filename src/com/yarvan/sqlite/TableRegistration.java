package com.yarvan.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.yarvan.config.DD;
import com.yarvan.sqlite.DatabaseHelper.TableCreateInterface;

public class TableRegistration implements TableCreateInterface{
	//从DD中找到表名
	public static String tableName = DD.DBTableName.REGISTATION;
	//定义各字段名
	public static String _id = "_id";//系统生成
	public static String id = "id";//挂号预约号
	public static String department = "department";//科室
	public static String address = "address";//医院地址
	public static String registration_time = "registration_time";//挂号日期和时间
	public static String hospital_name = "hospital_name";//医院名称
	/*
	 * 单子模式
	 * */
	private TableRegistration(){
		super();
	}
	public static TableRegistration getInstance(){
		return new TableRegistration();
	}
	//创建数据表
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE "+TableRegistration.tableName
				+" ("
				+"_id integer primary key autoincrement, "
				+TableRegistration.id+" TEXT, "
				+TableRegistration.department+" TEXT, "
				+TableRegistration.registration_time+" TEXT, "
				+TableRegistration.hospital_name+" TEXT, "
				+TableRegistration.address+" TEXT "
				+");";
		db.execSQL(sql);
	}
	//更新数据表
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(oldVersion < newVersion){
			String sql = "DROP TABLE IF EXISTS " + TableRegistration.tableName;
			db.execSQL(sql);
			this.onCreate(db);
		}
	}

}
