package com.yarvan;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		//TODO
		this.deleteDatabase("test.db");
		TextView registerTextView = (TextView)findViewById(R.id.textView3);
		registerTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(Login.this,Register.class);
//				startActivity(intent);
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						
//						forTest();
					}
				}).start();
				
//				new Thread(new Runnable() {
//					
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						List<User> users = new ArrayList<User>();
//						User user = new User();
//						user.setId("1");
//						user.setPassword("1111");
//						users.add(user);
//						try {
//							JSONArray array = MyJSONUtils.toJSONArray(users);
//							HttpUtil.doPost(null, "User", array);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}).start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
//	public void forTest(){
//		DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext(), "test.db", null, 1);
//		SQLiteDatabase db = dbHelper.getWritableDatabase();
//		db.close();
//		Parttime_appointment_info pai = new Parttime_appointment_info();
//		pai.setId("3");
//		pai.setCount("5");
//		pai.setDate("2222/22/22");
//		ContentValues cv = new ContentValues();
//		cv.put("id", "3");
//		cv.put("count", "2");
//		try {
//			System.out.println("insert " + SQLiteUtil.insertParttimeInfo(dbHelper, pai));
//			System.out.println("update "+SQLiteUtil.updateTable(dbHelper.getWritableDatabase(), cv, DD.DBTableName.PARTTIME_INFO));
//			Cursor cursor = SQLiteUtil.queryFor(dbHelper.getWritableDatabase(), DD.DBTableName.PARTTIME_INFO, null, null);
//			while(!cursor.isAfterLast()){
//				System.out.println("cursor");
//				System.out.println(cursor.getString(cursor.getColumnIndex(TableParttimeInfo.count)));
//				cursor.moveToNext();
//			}
//			System.out.println("delete " + SQLiteUtil.deleteFrom(dbHelper.getWritableDatabase(), DD.DBTableName.PARTTIME_INFO, "1"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("eee");
//		}finally{
//			
//		}
//	}

}
