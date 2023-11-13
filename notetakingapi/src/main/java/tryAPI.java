import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class tryAPI{
    public static void main(String[] args) throws Exception {
        // 1. 获取访问令牌
        String accessToken = "ACCESS_TOKEN";

        // 2. 构建 API 请求
        String apiUrl = "https://graph.microsoft.com/v1.0/me/notes";
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);
        httpGet.setHeader("Authorization", "Bearer " + accessToken);

        // 3. 发送 API 请求并解析响应
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String responseJson = EntityUtils.toString(entity);

        // 解析响应
        // TODO: 根据响应的 JSON 数据提取所需的信息
        System.out.println(responseJson);
    }

}

