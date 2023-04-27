import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JSONParsingTraining {
    public static void main(String[] args) throws IOException, ParseException {

        String CONNECT_API_URL = "https://www.boredapi.com/api/activity";

        URL url = new URL(CONNECT_API_URL);
        URLConnection urlConnection = url.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

        String typeField = (String) jsonObject.get("type");
        System.out.println("The value of the type field is: " + typeField);

        reader.close();
    }
}
