package entity;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordGrantExample {

    private static final String TOKEN_ENDPOINT = "https://login.microsoftonline.com/83ec03fd-2dce-4eb5-a0a8-3098bfe12b57/oauth2/v2.0/token";
    private static final String CLIENT_ID = "a526481a-064e-477f-bc0d-54f88ef4c7b5";
    private static final String CLIENT_SECRET = "GA78Q~_fkY2ST-BFg_Fut0cRAjeJOSiybN.0xaBu";
    private static final String USERNAME = "AdriaWang@74krws.onmicrosoft.com";
    private static final String PASSWORD = "Wangnanxin_toronto";
    private static final String SCOPE = "openid profile offline_access";

    public static void main(String[] args) {
        try {
            String accessToken = getAccessToken();
            System.out.println("Access Token: " + accessToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getAccessToken() throws IOException {
        HttpPost httpPost = new HttpPost(TOKEN_ENDPOINT);

        String requestBody = "grant_type=password" +
                "&client_id=" + CLIENT_ID +
                "&client_secret=" + CLIENT_SECRET +
                "&username=" + USERNAME +
                "&password=" + PASSWORD +
                "&scope=" + SCOPE;

        httpPost.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_FORM_URLENCODED));

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpResponse response = httpClient.execute(httpPost);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();
            }
        }
    }
}
//cannot get the access token using the username and password
//Access Token: {"error":"invalid_grant","error_description":"AADSTS50076: Due to a configuration change made by your administrator, or because you moved to a new location, you must use multi-factor authentication to access '00000003-0000-0000-c000-000000000000'. Trace ID: fe370167-0bac-4a7c-98c7-b1df1d63f801 Correlation ID: 1fe73093-c804-4bf8-9a91-990f23c719c3 Timestamp: 2023-11-25 19:49:04Z","error_codes":[50076],"timestamp":"2023-11-25 19:49:04Z","trace_id":"fe370167-0bac-4a7c-98c7-b1df1d63f801","correlation_id":"1fe73093-c804-4bf8-9a91-990f23c719c3","error_uri":"https://login.microsoftonline.com/error?code=50076","suberror":"basic_action"}