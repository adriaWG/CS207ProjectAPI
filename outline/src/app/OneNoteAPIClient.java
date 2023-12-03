package app;
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
    private static final String REDIRECT_URI = "https://login.microsoftonline.com/common/oauth2/nativeclient";
    private static final String AUTHORIZATION_ENDPOINT = "https://login.microsoftonline.com/83ec03fd-2dce-4eb5-a0a8-3098bfe12b57/oauth2/v2.0/authorize";
    private static final String TOKEN_ENDPOINT = "https://login.microsoftonline.com/83ec03fd-2dce-4eb5-a0a8-3098bfe12b57/oauth2/v2.0/token";
    private static final String SCOPE = "https://graph.microsoft.com/.default";

    // Function to obtain access token using Authorization Code Flow
    private static String getAccessTokenResponse() throws IOException {
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
        String authorizationCode= AuthorizationCodeExtractor.extract(url);
        System.out.println("AuthorizationCode:"+authorizationCode);

        // Exchange authorization code for an access token
        HttpPost httpPost = new HttpPost(TOKEN_ENDPOINT);
        String requestBody = "grant_type=authorization_code" +
                "&client_id=" + CLIENT_ID +
                //"&client_secret=" + CLIENT_SECRET +
                "&redirect_uri=" + REDIRECT_URI +
                "&code=" + authorizationCode;
        httpPost.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_FORM_URLENCODED));

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpResponse response = httpClient.execute(httpPost);

            System.out.println("authorization_Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println("authorization_Response Reason: " + response.getStatusLine().getReasonPhrase());

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
    private static void createNote(String title,String content) throws IOException {
        String accessTokenResponse = getAccessTokenResponse();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("accessTokenresponsebody.txt"))) {
            writer.write(accessTokenResponse);
            System.out.println("accessTokenresponse written to accessTokenresponsebody.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String accessToken= AccessTokenExtractor.accessTokenExtractor(accessTokenResponse);


        // Build your note data here
        String noteData = "<html><head><title>"+title+"</title></head><body><p>"+content+"</p></body></html>";

        // Send request to create a note
        HttpPost httpPost = new HttpPost(API_ENDPOINT);
        httpPost.setHeader("Authorization", "Bearer " + accessToken);
        httpPost.setHeader("Content-Type", "text/html");
        httpPost.setEntity(new StringEntity(noteData, ContentType.APPLICATION_XML));

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpResponse response = httpClient.execute(httpPost);

            System.out.println("creatnote_Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println("creatnote_Response Reason: " + response.getStatusLine().getReasonPhrase());

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                String resultString=result.toString();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("createNoteresponsebody.txt"))) {
                    writer.write(resultString);
                    System.out.println("createNoteresponse written to createNoteresponsebody.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Handle response
            if (response.getStatusLine().getStatusCode() == 201) {
                System.out.println("SUCCESS Creating Note");
            } else {
                System.err.println("Failed to create Note: " + response.getStatusLine().getReasonPhrase());
            }
        }
    }

    //This is the main method used to test the createNote function
    //Can also call the createNote Method at the event of "New" button
    //Personalized title and content
    public static void main(String[] args) {
        try {
            String title="SamplePage";
            String content="2023CSC207";
            createNote(title,content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
