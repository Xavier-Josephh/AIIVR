package miscy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.LambdaMetafactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseJson {

	public static void main(String[] args) {
		
		LambdaMetafactory l = new LambdaMetafactory();
		
		BufferedReader serverData = null;
		try {
			serverData = new BufferedReader(new FileReader("json_string_file.json"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//String serverOutput = (String) serverData.readLine();
		String serverOutput;
		StringBuffer responseFromServer = new StringBuffer("");
		while (true) {
			try {
				serverOutput = serverData.readLine();
				responseFromServer.append(serverOutput);
				if (serverOutput == null || serverOutput == "" || serverOutput.equals("")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode actualObj = mapper.readTree(new String(responseFromServer));
			System.out.println(actualObj.get("queryResult").get("parameters").get("email"));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	}

}
