import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class tryAPI{
    public static void main(String[] args) throws Exception {
        // 1. Get access token
        String accessToken = "ACCESS_TOKEN";

        // 2. Build an API request
        String apiUrl = "https://graph.microsoft.com/v1.0/me/notes";
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);
        httpGet.setHeader("Authorization", "Bearer " + accessToken);

        // 3. Send API request and parse the response
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String responseJson = EntityUtils.toString(entity);

        // Parse the response
        // TODO: Extract the required information based on the response JSON data
        System.out.println(responseJson);
    }
}
