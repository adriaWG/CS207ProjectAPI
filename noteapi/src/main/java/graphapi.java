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
                String accessToken = "eyJ0eXAiOiJKV1QiLCJub25jZSI6Inh4WThoT3NsSGRMeUxiWXR5YnNYZWtmM3JDWUJjMVR3VWpoTkhjbGpyamsiLCJhbGciOiJSUzI1NiIsIng1dCI6IjlHbW55RlBraGMzaE91UjIybXZTdmduTG83WSIsImtpZCI6IjlHbW55RlBraGMzaE91UjIybXZTdmduTG83WSJ9.eyJhdWQiOiJodHRwczovL2dyYXBoLm1pY3Jvc29mdC5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC84M2VjMDNmZC0yZGNlLTRlYjUtYTBhOC0zMDk4YmZlMTJiNTcvIiwiaWF0IjoxNjk3NDEzNjczLCJuYmYiOjE2OTc0MTM2NzMsImV4cCI6MTY5NzQxNzU3MywiYWlvIjoiRTJGZ1lLaWRWVnZMOCtMaG04Y1BybnUvWnA2bkNRQT0iLCJhcHBfZGlzcGxheW5hbWUiOiJjc2MyMDdub3RlIiwiYXBwaWQiOiJhNTI2NDgxYS0wNjRlLTQ3N2YtYmMwZC01NGY4OGVmNGM3YjUiLCJhcHBpZGFjciI6IjEiLCJpZHAiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC84M2VjMDNmZC0yZGNlLTRlYjUtYTBhOC0zMDk4YmZlMTJiNTcvIiwiaWR0eXAiOiJhcHAiLCJvaWQiOiJjZDg1OWRiYy1hYjNkLTRkNjUtYjdmOC1lOGMzMzYyNzI0YTkiLCJyaCI6IjAuQWJjQV9RUHNnODR0dFU2Z3FEQ1l2LUVyVndNQUFBQUFBQUFBd0FBQUFBQUFBQURKQUFBLiIsInN1YiI6ImNkODU5ZGJjLWFiM2QtNGQ2NS1iN2Y4LWU4YzMzNjI3MjRhOSIsInRlbmFudF9yZWdpb25fc2NvcGUiOiJOQSIsInRpZCI6IjgzZWMwM2ZkLTJkY2UtNGViNS1hMGE4LTMwOThiZmUxMmI1NyIsInV0aSI6Ik1ZVUlQMUI5U2tDd1FNUmNSdFlzQUEiLCJ2ZXIiOiIxLjAiLCJ3aWRzIjpbIjA5OTdhMWQwLTBkMWQtNGFjYi1iNDA4LWQ1Y2E3MzEyMWU5MCJdLCJ4bXNfdGNkdCI6MTY5NTU0ODE0N30.wfjKK3qnCLdVwkrg0dVjVTJwE6eONNIPJMuotuOrbUrW0IlYmF1EZXel5sxdxIQnH_VQb5cNk0-f6MGO3-NLPXaTN-jk1auyChRu6yd1vq2rTHuRGwOwgGkj1E-hBxbn_CojZbHyV3pSPOa84MAVjveIPb8-mOO3GoJDG3IodL4nVqZIO1YzDCzq8TIvkcgCn4mKKA2cqtVfsQbf7Q_p9YYw2VFyCQT9MUchSlSAAFYbuHjxe4WaubT_jjQXjs9RKUV8O0vt959IengWivIrj596EK0C6afG91TT7aJAbonfOUe-RJAvPGpIPLGthQtMNHdd7_WjVS3jKBgGaNk0fQ";

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


