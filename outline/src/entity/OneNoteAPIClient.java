package entity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.util.Scanner;

public class OneNoteAPIClient {
    // OneNote API endpoint and application credentials
    private static final String API_ENDPOINT = "https://graph.microsoft.com/v1.0/me/onenote/pages";
    private static final String CLIENT_ID = "a526481a-064e-477f-bc0d-54f88ef4c7b5";
    private static final String CLIENT_SECRET = "GA78Q~_fkY2ST-BFg_Fut0cRAjeJOSiybN.0xaBu";
    private static final String REDIRECT_URI = "https://login.microsoftonline.com/common/oauth2/nativeclient";
    private static final String AUTHORIZATION_ENDPOINT = "https://login.microsoftonline.com/83ec03fd-2dce-4eb5-a0a8-3098bfe12b57/oauth2/v2.0/authorize";
    private static final String TOKEN_ENDPOINT = "https://login.microsoftonline.com/83ec03fd-2dce-4eb5-a0a8-3098bfe12b57/oauth2/v2.0/token";
    private static final String SCOPE = "https://graph.microsoft.com/.default";

    // Function to obtain access token using Authorization Code Flow
    private static String getAccessToken() throws IOException {
        // Construct the authorization URL
        String authorizationUrl = AUTHORIZATION_ENDPOINT +
                "?client_id=" + CLIENT_ID +
                "&redirect_uri=" + REDIRECT_URI +
                "&response_type=code" +
                "&scope=" + SCOPE;

        System.out.println("Please visit the following URL to login and grant permissions:");
        System.out.println(authorizationUrl);

        // Prompt user to enter the authorization code received after login
        System.out.print("Enter the url after login to extract the AuthorizationCode: ");
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        String authorizationCode=AuthorizationCodeExtractor.extract(url);
        System.out.println("AuthorizationCode:"+authorizationCode);

        // Exchange authorization code for an access token
        HttpPost httpPost = new HttpPost(TOKEN_ENDPOINT);
        String requestBody = "grant_type=authorization_code" +
                "&client_id=" + CLIENT_ID +
                "&client_secret=" + CLIENT_SECRET +
                "&redirect_uri=" + REDIRECT_URI +
                "&code=" + authorizationCode;
        httpPost.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_FORM_URLENCODED));

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpResponse response = httpClient.execute(httpPost);

            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println("Response Reason: " + response.getStatusLine().getReasonPhrase());

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

    // Use access token to create a note
    private static void createNote() throws IOException {
        String accessToken = getAccessToken();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("responsebody.txt"))) {
            writer.write(accessToken);
            System.out.println("Note data written to responsebody.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Build your note data here
        String noteData = "<html><head><title>Sample Page</title></head><body><p>Hello, OneNote!</p></body></html>";

        // Send request to create a note
        HttpPost httpPost = new HttpPost(API_ENDPOINT);
        httpPost.setHeader("Authorization", "Bearer " + accessToken);
        httpPost.setHeader("Content-Type", "text/html");
        httpPost.setEntity(new StringEntity(noteData, ContentType.APPLICATION_XML));

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpResponse response = httpClient.execute(httpPost);

            // Handle response
            if (response.getStatusLine().getStatusCode() == 201) {
                System.out.println("SUCCESS Creating Note");
            } else {
                System.err.println("Failed to create Note: " + response.getStatusLine().getReasonPhrase());
            }
        }
    }

    public static void main(String[] args) {
        try {
            createNote();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
