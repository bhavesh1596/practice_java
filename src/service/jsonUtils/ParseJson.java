package service.jsonUtils;

import com.google.gson.Gson;

public class ParseJson {
    public static void main(String args[]) {
        String jsonString = "{\n" +
                "  \"params\": {\n" +
                "    \"param\": [\n" +
                "      {\n" +
                "        \"name\": \"param1\",\n" +
                "        \"value\": \"val1\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"param2\",\n" +
                "        \"value\": \"val2\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"param3\",\n" +
                "        \"value\": \"val3\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}\n";
        Gson gson = new Gson();
        gson.fromJson(jsonString,Object.class);
    }


}
