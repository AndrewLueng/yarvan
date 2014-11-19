package com.yarvan.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.yarvan.config.DD;
import com.yarvan.sqlite.DatabaseHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteUtil {
	/*----------------------二级接口（直接面向Serivce）-----------------------*/
	/**
	 * 插入新发布的兼职信息
	 * @param db
	 * @param pai
	 * @return 插入行id
	 */
	public static long insertParttimeInfo(DatabaseHelper dbh, Object pai)throws 
	NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		SQLiteDatabase db = dbh.getWritableDatabase();
		long result = insertInto(db, pai, DD.DBTableName.PARTTIME_INFO);
		db.close();
		return result;
	}
	/**
	 * 插入最新发布的服务预约信息
	 * @param dbh
	 * @param sai
	 * @return
	 */
	public static long insertServiceInfo(DatabaseHelper dbh, Object sai) throws 
	IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		SQLiteDatabase db = dbh.getWritableDatabase();
		long result = insertInto(db, sai, DD.DBTableName.SERVICE_INFO);
		db.close();
		return result;
	}
	/**
	 * 插入服务时间段
	 * @param dbh
	 * @param tp
	 * @return
	 */
	public static long insertTimePeriod(DatabaseHelper dbh, Object tp) throws
	IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		SQLiteDatabase db = dbh.getWritableDatabase();
		long result = insertInto(db, tp, DD.DBTableName.TIME_PERIOD);
		db.close();
		return result;
	}
	/**
	 * 插入服务项目
	 * @param dbh
	 * @param si
	 * @return
	 */
	public static long insertServiceItem(DatabaseHelper dbh, Object si) throws
	IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		SQLiteDatabase db = dbh.getWritableDatabase();
		long result = insertInto(db, si, DD.DBTableName.SERVICE_ITEM);
		db.close();
		return result;
	}
	/**
	 * 插入可挂号医院
	 * @param dbh
	 * @param hospital
	 * @return
	 */
	public static long insertHospital(DatabaseHelper dbh, Object hospital) throws
	IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		SQLiteDatabase db = dbh.getWritableDatabase();
		long result = insertInto(db, hospital, DD.DBTableName.HOSPITAL);
		db.close();
		return result;
	}
	/**
	 * 插入服务中心
	 * @param dbh
	 * @param shop
	 * @return
	 */
	public static long insertServiceShop(DatabaseHelper dbh, Object shop) throws
	IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		SQLiteDatabase db = dbh.getWritableDatabase();
		long result = insertInto(db, shop, DD.DBTableName.SERVICE_SHOP);
		db.close();
		return result;
	}
	/**
	 * 插入挂号表
	 * @param dbh
	 * @param registration
	 * @return
	 */
	public static long insertRegistration(DatabaseHelper dbh, Object registration) throws
	IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		SQLiteDatabase db = dbh.getWritableDatabase();
		long result = insertInto(db, registration, DD.DBTableName.REGISTATION);
		db.close();
		return result;
	}
	/**
	 * 更新兼职信息（主要是count和is_app）
	 * @param dbh
	 * @param map
	 * @return
	 */
	public static int updateParttimeInfo(DatabaseHelper dbh, Map<String, String> map){
		SQLiteDatabase db = dbh.getWritableDatabase();
		int result = updateTable(db, map, DD.DBTableName.PARTTIME_INFO);
		db.close();
		return result;
	}
	/**
	 * 更新服务预约信息（主要是count和is_app）
	 * @param dbh
	 * @param map
	 * @return
	 */
	public static int updateServiceInfo(DatabaseHelper dbh, Map<String, String> map){
		SQLiteDatabase db = dbh.getWritableDatabase();
		int result = updateTable(db, map, DD.DBTableName.SERVICE_INFO);
		db.close();
		return result;
	}
	/**
	 * 通过id号删除医院信息
	 * @param dbh
	 * @param id
	 * @return
	 */
	public static int deleteFromHospital(DatabaseHelper dbh, String id){
		SQLiteDatabase db = dbh.getWritableDatabase();
		int result = deleteFrom(db, DD.DBTableName.HOSPITAL, id);
		db.close();
		return result;
	}
	/**
	 * 删除对应id的兼职信息
	 * @param dbh
	 * @param id
	 * @return
	 */
	public static int deleteFromParttimeInfo(DatabaseHelper dbh, String id){
		SQLiteDatabase db = dbh.getWritableDatabase();
		int result = deleteFrom(db, DD.DBTableName.PARTTIME_INFO, id);
		db.close();
		return result;
	}
	/**
	 * 删除对应id的服务信息
	 * @param dbh
	 * @param id
	 * @return
	 */
	public static int deleteFromServiceInfo(DatabaseHelper dbh, String id){
		SQLiteDatabase db = dbh.getWritableDatabase();
		int result = deleteFrom(db, DD.DBTableName.SERVICE_INFO, id);
		db.close();
		return result;
	}
	/**
	 * 删除对应id号的服务项目
	 * @param dbh
	 * @param id
	 * @return
	 */
	public static int deleteFromServiceItem(DatabaseHelper dbh, String id){
		SQLiteDatabase db = dbh.getWritableDatabase();
		int result = deleteFrom(db, DD.DBTableName.SERVICE_ITEM, id);
		db.close();
		return result;
	}
	/**
	 * 删除对应id号的分中心服务点
	 * @param dbh
	 * @param id
	 * @return
	 */
	public static int deleteFromServiceShop(DatabaseHelper dbh, String id){
		SQLiteDatabase db = dbh.getWritableDatabase();
		int result = deleteFrom(db, DD.DBTableName.SERVICE_SHOP, id);
		db.close();
		return result;
	}
	/**
	 * 删除对应id号的时间段信息
	 * @param dbh
	 * @param id
	 * @return
	 */
	public static int deleteFromTimePeriod(DatabaseHelper dbh, String id){
		SQLiteDatabase db = dbh.getWritableDatabase();
		int result = deleteFrom(db, DD.DBTableName.TIME_PERIOD, id);
		db.close();
		return result;
	}
	/**
	 * 删除对应id号的挂号信息
	 * @param dbh
	 * @param id
	 * @return
	 */
	public static int deleteFromRegistration(DatabaseHelper dbh, String id){
		SQLiteDatabase db = dbh.getWritableDatabase();
		int result = deleteFrom(db, DD.DBTableName.REGISTATION, id);
		db.close();
		return result;
	}
	/**
	 * 查找所有医院信息
	 * @param dbh
	 * @return
	 */
	public static Cursor queryHospital(DatabaseHelper dbh){
		SQLiteDatabase db = dbh.getReadableDatabase();
		Cursor cursor = queryFor(db, DD.DBTableName.HOSPITAL, null, null);
		db.close();
		return cursor;
	}
	/**
	 * 通过id查找医院
	 * @param dbh
	 * @param id
	 * @return
	 */
	public static Cursor queryHospitalById(DatabaseHelper dbh, String id){
		SQLiteDatabase db = dbh.getReadableDatabase();
		Cursor cursor = queryFor(db, DD.DBTableName.HOSPITAL, "id=?", new String[]{id});
		db.close();
		return cursor;
	}
	/**
	 * 查找剩余数量不为0的兼职信息
	 * @param dbh
	 * @return
	 */
	public static Cursor queryParttimeInfo(DatabaseHelper dbh){
		SQLiteDatabase db = dbh.getReadableDatabase();
		Cursor cursor = queryFor(db, DD.DBTableName.PARTTIME_INFO, "count!=", new String[]{"0"});
		db.close();
		return cursor;
	}
	/**
	 * 查找剩余数量不为0的服务信息
	 * @param dbh
	 * @return
	 */
	public static Cursor queryServiceInfo(DatabaseHelper dbh){
		SQLiteDatabase db = dbh.getReadableDatabase();
		Cursor cursor = queryFor(db, DD.DBTableName.SERVICE_INFO, "count!=", new String[]{"0"});
		db.close();
		return cursor;
	}
	/**
	 * 查找所有服务项目
	 * @param dbh
	 * @return
	 */
	public static Cursor queryServiceItem(DatabaseHelper dbh){
		SQLiteDatabase db = dbh.getReadableDatabase();
		Cursor cursor = queryFor(db, DD.DBTableName.SERVICE_ITEM, null, null);
		db.close();
		return cursor;
	}
	/**
	 * 查找所有分中心服务点
	 * @param dbh
	 * @return
	 */
	public static Cursor queryServiceShop(DatabaseHelper dbh){
		SQLiteDatabase db = dbh.getReadableDatabase();
		Cursor cursor = queryFor(db, DD.DBTableName.SERVICE_SHOP, null, null);
		db.close();
		return cursor;
	}
	/**
	 * 查找所有时间段
	 * @param dbh
	 * @return
	 */
	public static Cursor queryTimePeriod(DatabaseHelper dbh){
		SQLiteDatabase db = dbh.getReadableDatabase();
		Cursor cursor = queryFor(db, DD.DBTableName.TIME_PERIOD, null, null);
		db.close();
		return cursor;
	}
	/**
	 * 查找所有挂号信息
	 * @param dbh
	 * @return
	 */
	public static Cursor queryRegistration(DatabaseHelper dbh){
		SQLiteDatabase db = dbh.getReadableDatabase();
		Cursor cursor = queryFor(db, DD.DBTableName.REGISTATION, null, null);
		db.close();
		return cursor;
	}
	/*----------------------一级接口----------------------*/
	/**
	 * 将model插入sqlite中
	 * @param db
	 * @param model
	 * @param tableName
	 * @return 插入行id
	 */
	public static long insertInto(SQLiteDatabase db, Object model, String tableName)throws 
	NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		ContentValues values = BaseUtils.model2ContentValues(model);
		return db.insert(tableName, null, values);
	}
	/**
	 * 更新sql
	 * @param db
	 * @param contentValues 包含id及其他需要更新的信息
	 * @param tableName
	 * @return
	 */
	public static int updateTable(SQLiteDatabase db, Map<String, String> map, String tableName){
		ContentValues contentValues = BaseUtils.map2ContentValues(map);
		if(!contentValues.containsKey("id")) return -1;
		return db.update(tableName, contentValues, "id=?", new String[]{contentValues.get("id")+""});
	}
	/**
	 * 根据id号和tableName进行删除操作
	 * @param db
	 * @param tableName
	 * @param id
	 * @return
	 */
	public static int deleteFrom(SQLiteDatabase db, String tableName, String id){
		return db.delete(tableName, "id=?", new String[]{id});
	}
	/**
	 * 查询操作，返回结果id降序排列
	 * @param db
	 * @param tableName
	 * @param selection
	 * @param selectionArgs
	 * @return
	 */
	public static Cursor queryFor(SQLiteDatabase db, String tableName, String selection,
			String[] selectionArgs){
		Cursor cursor = db.query(tableName, null, selection, selectionArgs, null, null, "_id DESC");
		cursor.moveToFirst();
		return cursor;
	}
}
