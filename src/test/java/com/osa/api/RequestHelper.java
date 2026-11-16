package com.osa.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.math.BigDecimal;

import com.osa.utility.Utilities;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import io.restassured.path.json.config.JsonPathConfig;

public class RequestHelper {
	Response res=null;
	public void getResponse(Response res) {
		this.res=res;
	}
	public HashMap<String,List<UsersValues>> verifyResponse(DataTable dataTable) {
		List<List<String>>data= dataTable.cells();
		HashMap<String,List<UsersValues>> userInput=new HashMap<String,List<UsersValues>>();
		List<UsersValues> validation=new ArrayList<UsersValues>();
		List<UsersValues> body=new ArrayList<UsersValues>();
		for(int i=0; i<data.size(); i++) {
			if(data.get(i).get(0).toLowerCase().equals("val")) {
				validation.add(new UsersValues(data.get(i).get(1).toString(),data.get(i).get(2).toString()));
			}else if(data.get(i).get(0).toLowerCase().equals("bod")){
				body.add(new UsersValues(data.get(i).get(1).toString(),data.get(i).get(2).toString()));
			}
		}
		userInput.put("val", validation);
		userInput.put("bod", body);
		return userInput;
	 }
	public  void verifyAPIRes(String xpath,String expectedValue) {
		Object actualValue = res.getBody().jsonPath()
			.using(new JsonPathConfig().numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL))
			.get(xpath);
		if (actualValue instanceof Number) {
			String expectedNumber = new BigDecimal(expectedValue).stripTrailingZeros().toPlainString();
			String actualNumber = new BigDecimal(actualValue.toString()).stripTrailingZeros().toPlainString();
			Utilities.verifyStatu(expectedNumber, actualNumber);
		} else {
			Utilities.verifyStatu(expectedValue, actualValue == null ? null : actualValue.toString());
		}
	}


}
