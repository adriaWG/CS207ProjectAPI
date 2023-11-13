import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class apionenote {
    public static void main(String[] args) throws Exception {
        // 1. 获取访问令牌
        String accessToken = "token_here";

        // 2. 构建 API 请求
        String apiUrl = "https://onenote.com/v1.0/Notes.Read";
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


        try {
            // 创建一个 BufferedWriter 对象来写入文件
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            // 写入字符串内容
            writer.write(responseJson);
            // 关闭文件
            writer.close();
            System.out.println("内容已成功写入文件：" + "output.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("写入文件时发生错误: " + e.getMessage());
        }






        }
}
