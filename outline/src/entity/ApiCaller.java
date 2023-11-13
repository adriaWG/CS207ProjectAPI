//package entity;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class ApiCaller {
//
//    // 获取API调用返回的文件内容
//    public static String callApiAndGetFileContent(String apiUrl, String accessToken) {
//        HttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(apiUrl);
//        httpGet.setHeader("Authorization", "Bearer " + accessToken);
//
//        try {
//            HttpResponse apiResponse = httpClient.execute(httpGet);
//            HttpEntity apiEntity = apiResponse.getEntity();
//
//            if (apiResponse.getStatusLine().getStatusCode() == 200) {
//                // 请求成功，返回文件内容
//                return EntityUtils.toString(apiEntity);
//            } else {
//                // 请求失败，返回错误信息
//                System.err.println("API Error: " + EntityUtils.toString(apiEntity));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭HttpClient连接等资源
//            httpClient.getConnectionManager().shutdown();
//        }
//
//        return null;
//    }
//
//    // 将文件内容保存到本地文件
//    public static void saveToFile(String filePath, String content) {
//        try (FileWriter writer = new FileWriter(filePath)) {
//            writer.write(content);
//            System.out.println("File saved successfully at: " + filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        // 假设在这里获取了访问令牌 accessToken
//
//        // 假设API的端点为 apiUrl
//        String apiUrl = "YOUR_RESOURCE_API_ENDPOINT";
//
//        // 调用API并获取文件内容
//        String fileContent = callApiAndGetFileContent(apiUrl, accessToken);
//
//        // 将文件内容保存到本地文件
//        String filePath = "path/to/save/file.txt";
//        saveToFile(filePath, fileContent);
//    }
//}
