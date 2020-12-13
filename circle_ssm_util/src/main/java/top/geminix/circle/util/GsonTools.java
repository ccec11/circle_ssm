package top.geminix.circle.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author 郑明亮
 * @Time：2016年2月2日 下午2:15:38
 * @version 1.0
 */
public class GsonTools {
 
	/**
	 * @param src  要转换成json格式的 对象
	 * @return
	 */
	public static String createJsonString(Object src) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(src);
		return jsonString;
	}
 
 
	/**
	 * @param jsonString
	 * @param type 指定对象的类型 ，即 T.class
	 * @return
	 */
	public static <T> T getObject(String jsonString, Class<T> type) {
		T t = null;
		try {
			Gson gson = new Gson();
			t = gson.fromJson(jsonString, type);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return t;
	}
 
	/**得到 一个List<T>集合
	 * @param jsonString
	 * @param type  T的类型
	 * @return
	 */
	public static <T> List<T> getList(String jsonString, Class<T> type) {
		List<T> list = new ArrayList<T>();
		Gson gson = new Gson();
		list = gson.fromJson(jsonString, new TypeToken<List<T>>() {
		}.getType());
		return list;
 
	}
 
	/**
	 * 得到一个List<T> 的集合
	 * @param jsonString json字符串
	 * @param type  数组的类型 ，即T[].class
	 * @return
	 */
	public static <T> List<T> StringTolist(String jsonString, Class<T[]> type) {
		T[] list = null;
		try {
			Gson gson = new Gson();
			list = gson.fromJson(jsonString, type);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
 
		return Arrays.asList(list);
 
	}
	/**把json字符串转换为 String 集合
	 * @param jsonString
	 * @return
	 */
	public static List<String> getStrings(String jsonString) {
		List<String> list = new ArrayList<String>();
		Gson gson = new Gson();
		new TypeToken<List<String>>(){}.getType();
		list = gson.fromJson(jsonString, new TypeToken<List<String>>() {
		}.getType());
		return list;
 
	}
 
	/**
	 * 将json数据解析为Map<String,Object>集合
	 * @param jsonString 
	 * @return
	 */
	public static List<Map<String, Object>> getMaps(String jsonString) {
 
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Gson gson = new Gson();
		list = gson.fromJson(jsonString,
				new TypeToken<List<Map<String, Object>>>() {
				}.getType());
 
		return list;
 
	}
 
	
}