package miscy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class ParsingJson {

	public ParsingJson() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\xavier.joseph\\Desktop\\json.txt";
	    BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
	    Gson gson = new Gson();
	    HashMap<String, String> json = gson.fromJson(bufferedReader, HashMap.class);
	}

}
