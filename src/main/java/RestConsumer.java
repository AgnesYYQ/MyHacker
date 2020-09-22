/// Added this line to build.gradle before you can import JSON libraries.
///     compile 'com.googlecode.json-simple:json-simple:1.1.1'
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class RestConsumer {
    /*
     * Complete the 'avgRotorSpeed' function below.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/iot_devices/search?status={statusQuery}&page={number}
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING statusQuery
     *  2. INTEGER parentId
     */
    public static int avgRotorSpeed(String statusQuery, int parentId) {
        int count = 0;
        int sum = 0;
        int average = 0;

        try {
            String urlPrefix = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=" + statusQuery + "&page=";
            URL url = new URL(urlPrefix + 1);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            JSONParser parse = new JSONParser();
            JSONObject jobj = (JSONObject)parse.parse(in);

            String page = (String) jobj.get("page");
            long perPage = (long) jobj.get("per_page");
            long total = (long) jobj.get("total");
            long totalPages = (long) jobj.get("total_pages");
            JSONArray data = (JSONArray) jobj.get("data");

            for (int i  = 0; i < data.size(); i++) {
                JSONObject item = (JSONObject) data.get(i);
                if (item.containsKey("parent") && item.get("parent") != null && (long)((JSONObject)item.get("parent")).get("id") == parentId ) {
                    count += 1;
                    JSONObject operatingParams = (JSONObject) item.get("operatingParams");
                    long rotorSpeed = (long) operatingParams.get("rotorSpeed");
                    sum += rotorSpeed;
                    System.out.println("[rotorSpeed]: " + rotorSpeed);
                }
            }
            System.out.println("total pages: " + totalPages);
            for (int j= 2; j <= totalPages; j++) {
                System.out.println("page number: " + j);
                url = new URL(urlPrefix + j);

                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP Error code : "
                            + conn.getResponseCode());
                }
                in = new InputStreamReader(conn.getInputStream());
                jobj = (JSONObject)parse.parse(in);
                data = (JSONArray) jobj.get("data");

                for (int i  = 0; i < data.size(); i++) {
                    JSONObject item = (JSONObject) data.get(i);
                    if (item.containsKey("parent") && item.get("parent") != null && (long)((JSONObject)item.get("parent")).get("id") == parentId ) {
                        count += 1;
                        JSONObject operatingParams = (JSONObject) item.get("operatingParams");
                        long rotorSpeed = (long) operatingParams.get("rotorSpeed");
                        sum += rotorSpeed;
                        System.out.println("[rotorSpeed]: " + rotorSpeed);
                    }
                }
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }

        if (count != 0) {
            average = sum / count;
        }
        System.out.println("[average] is " + average);
        return average;
    }

    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String statusQuery = bufferedReader.readLine();

        int parentId = Integer.parseInt(bufferedReader.readLine().trim());  */

        int result = avgRotorSpeed("RUNNING", 7);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close(); */
    }
}