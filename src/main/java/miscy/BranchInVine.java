package miscy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BranchInVine implements RequestHandler<GatewayRequest, GatewayResponse>{

	   public GatewayResponse handleRequest(GatewayRequest input, Context context) {
	        context.getLogger().log("Input: " + input);
	        String inputt;
	        try {
	        	if(input!=null) {
	        		JsonObject jsonObject = new JsonObject();
	        		jsonObject.addProperty("fulfillmentText", "Hey there! :) Fullfillment here");
	        		jsonObject.addProperty("body",input.getBody());
	        		 inputt = jsonObject.toString();
	        		 JsonParser parser = new JsonParser();
	        			JsonElement jsonTree = parser.parse(input.getBody());
	        			inputt=jsonTree.getAsString();
	        	}else {
	        		inputt = "input is null";
	        	}
	        	return new GatewayResponse(200, inputt, GatewayResponse.HEADERS_JSON);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new GatewayResponse(400, e.getMessage(), GatewayResponse.HEADERS_TEXT);
	        }
	    }
	   
	   public HashMap getJsonString() {
		   try {
				BufferedReader serverData = new BufferedReader(new FileReader("json_string_file.json"));
				//String serverOutput = (String) serverData.readLine();
				String serverOutput;
				StringBuffer responseFromServer = new StringBuffer("");
				while (true) {
					serverOutput = serverData.readLine();
					responseFromServer.append(serverOutput);
					if (serverOutput == null || serverOutput == "" || serverOutput.equals("")) {
						break;
					}
				}
				
				 Gson gson = new Gson();
				    HashMap json = gson.fromJson(serverData, HashMap.class);
				    System.out.println(json);
				return  json;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	   }
}