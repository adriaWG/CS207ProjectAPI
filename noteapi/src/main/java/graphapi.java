import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

    public class graphapi {
        public static void main(String[] args) {


            
            try {
                // 定义 Graph API 终结点 URL
                String graphApiUrl = "https://graph.microsoft.com/User.Read"; // 这是一个示例，获取当前用户信息

                // 替换下面的YOUR_ACCESS_TOKEN为您获得的 Access Token
                String accessToken = "access_token_here";

                // 创建 URL 对象
                URL url = new URL(graphApiUrl);

                // 打开连接
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // 设置请求方法为 GET
                connection.setRequestMethod("GET");

                // 设置 Authorization 标头以包括 Access Token
                connection.setRequestProperty("Authorization", "Bearer " + accessToken);

                // 获取响应代码
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // 读取响应
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // 打印响应
                    System.out.println(response.toString());
                } else {
                    // 处理错误
                    System.out.println("HTTP Request Failed with error code: " + responseCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


