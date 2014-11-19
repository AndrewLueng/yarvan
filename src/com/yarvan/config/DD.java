package com.yarvan.config;

public class DD {
	/**
	 * 请求方式对应的url
	 * @author Andrew
	 */
	public interface method{
		//用户注册
		public final static String REGISTER = "/register";
		//用户登录
		public final static String LOGIN = "/login";
		//服务预约
		public final static String SERVICE_APP = "/service_app";
		//服务预约取消
		public final static String SERVICE_CANCEL = "/service_cancel";
		//服务信息（发布、取消）
		public final static String SERVICE_INFO = "/service_info";
		//医院挂号
		public final static String REG = "/reg";
		//取消挂号
		public final static String REG_CANCEL = "/reg_cancel";
		//兼职预约
		public final static String PARTTIME_APP = "/parttime_app";
		//兼职预约取消
		public final static String PARTTIME_CANCEL = "/parttime_cancel";
		//兼职信息（发布、取消）
		public final static String PARTTIME_INFO = "/parttime_info";
		//医生账号申请
		public final static String APPLY = "/apply";
		//医生申请确认
		public final static String APPLY_VALIDATE = "/apply_validate";
		//医生账号登录
		public final static String DOCTOR_LOGIN = "/doctor_login";
		//在线查询
		public final static String QUERY = "/query";
		//轮询
		public final static String CHECK4DATE = "/checkForDate";
	}
	/**
	 * model全名
	 * @author Andrew
	 */
	public interface ModelName{
		public final String USER = "com.yarvan.model.User";
		public final String DOCTOR = "com.yarvan.model.Doctor";
		public final String HOSPITAL = "com.yarvan.model.Hospital";
		public final String PARTTIME_APP = "com.yarvan.model.Parttime_appointment";
		public final String PARTTIME_INFI = "com.yarvan.model.Parttime_appointment_info";
		public final String QUERY = "com.yarvan.model.Query";
		public final String REGISTRATION = "com.yarvan.model.Registration";
		public final String SERVICE_APP = "com.yarvan.model.Service_appointment";
		public final String SERVICE_INFO = "com.yarvan.model.Service_appointment_info";
		public final String SERVICE_ITEM = "com.yarvan.model.Service_item";
		public final String SERVICE_SHOP = "com.yarvan.model.Service_shop";
		public final String STAFF = "com.yarvan.model.Staff";
		public final String TIME_PERIOD = "com.yarvan.model.Time_period";
		public final String YARVAN = "com.yarvan.model.Yarvan";
		public final String SQL_REG = "com.yarvan.model.SQLite_registration";
	}
	/**
	 * SQLite的表名
	 * @author Andrew
	 */
	public interface DBTableName{
		public final String TIME_PERIOD = "Time_period";
		public final String SERVICE_ITEM = "Service_item";
		public final String SERVICE_SHOP = "Service_shop";
		public final String SERVICE_INFO = "Service_info";
		public final String PARTTIME_INFO = "Parttime_info";
		public final String REGISTATION = "Registation";
		public final String HOSPITAL = "hospital";
	}
	/**
	 * 广播动作
	 * @author Andrew
	 *
	 */
	public interface BroadCastAction{
		public final String SERVICE_APP = "com.yarvan.SERVICE_APP_RECEIVER";
		public final String PARTTIME_APP = "com.yarvan.PARTTIME_APP_RECEIVER";
		public final String LOG = "com.yarvan.LOG_RECEIVER";
		public final String REG = "com.yarvan.REG_RECEIVER";//注意这是挂号
		public final String APPLY = "com.yarvan.APPLEY_RECEIVER";
	}
}
