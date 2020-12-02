package mntanproject.pos.supplier;

import java.util.HashMap;


import com.google.gson.Gson;


public class TryFunction {

	public static void main(String[] args) {
		String params  = "name=martin&company=";
		
		paramToObject(params);
		
		//System.out.println(json);
	}

	public static void paramToObject(String param) {
		System.out.println("param: " + param);
		String[] splits = param.split("&");
		HashMap<String, String> mappedParam = new HashMap<String, String>();
		
		for (String string : splits) {
			String[] keyValue = null;
			keyValue = string.split("=");
			if(keyValue.length == 2) {
				mappedParam.put(keyValue[0], keyValue[1]);
			}
			
		}
		mappedParam.forEach((k,v) -> {System.out.println(k);});
		Gson gson = new Gson();
		String json = gson.toJson(mappedParam);
		Supplier supplier = gson.fromJson(json, Supplier.class);
		System.out.println("json: " + json);
		System.out.println("supplier: " + supplier.toString());
	}
}