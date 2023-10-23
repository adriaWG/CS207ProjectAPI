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
        String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IjlHbW55RlBraGMzaE91UjIybXZTdmduTG83WSIsImtpZCI6IjlHbW55RlBraGMzaE91UjIybXZTdmduTG83WSJ9.eyJhdWQiOiJodHRwczovL29uZW5vdGUuY29tIiwiaXNzIjoiaHR0cHM6Ly9zdHMud2luZG93cy5uZXQvODNlYzAzZmQtMmRjZS00ZWI1LWEwYTgtMzA5OGJmZTEyYjU3LyIsImlhdCI6MTY5NzQxNTYyMiwibmJmIjoxNjk3NDE1NjIyLCJleHAiOjE2OTc0MTk1MjIsImFpbyI6IkUyRmdZR2l3ZXBtZ2tCV1JHYXZZLzdSSjRyY1RBQT09IiwiYXBwaWQiOiJhNTI2NDgxYS0wNjRlLTQ3N2YtYmMwZC01NGY4OGVmNGM3YjUiLCJhcHBpZGFjciI6IjEiLCJpZHAiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC84M2VjMDNmZC0yZGNlLTRlYjUtYTBhOC0zMDk4YmZlMTJiNTcvIiwib2lkIjoiY2Q4NTlkYmMtYWIzZC00ZDY1LWI3ZjgtZThjMzM2MjcyNGE5IiwicmgiOiIwLkFiY0FfUVBzZzg0dHRVNmdxRENZdi1FclY0NDlUUzNqSy05TG40ZDRkYVljS2Q3SkFBQS4iLCJzdWIiOiJjZDg1OWRiYy1hYjNkLTRkNjUtYjdmOC1lOGMzMzYyNzI0YTkiLCJ0aWQiOiI4M2VjMDNmZC0yZGNlLTRlYjUtYTBhOC0zMDk4YmZlMTJiNTciLCJ1dGkiOiJSTkU0cUNFS0drV2J5UndaNjFkREFBIiwidmVyIjoiMS4wIn0.BAbB_LQiL11AEKcclTAW259LrYqwY3LdfvicqRNEbo-ivrGY8oe7H03yjUq6LEf_IoKBuQSeUPYOhfrUoxXRvrfo9MJmm_M5PfCUU-YkJu53K2nUI_RQVUbNJ56SCwxtKmKJwVt3yE2nJhVAxpas7KT52ounPzNE5bNokFVAMWrKsrem1wlBEuv-7m1fLfAWnUYQgOyrrbndud7EtFsKtPBvPZCqft9VffNpUELL8f3vQjZLIUF_z-jgoQdSo4aOivcuVQtEc5b97YPp_QPZl64Jrg0EatcDibKqyGamYbrwSDOo436QhSCIvsb68Pr3HRznTbUzEtVvF1dd58ehmw";

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
