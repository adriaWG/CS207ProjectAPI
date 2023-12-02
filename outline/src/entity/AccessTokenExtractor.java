package entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccessTokenExtractor {

    public String accessTokenExtractor(String jsonString) {

        try {
            // 读取JSON字符串
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);

            // 提取access_token对应的值
            JsonNode accessTokenNode = rootNode.get("access_token");

            if (accessTokenNode != null) {
                // 打印access_token的值
                return accessTokenNode.asText();
            } else {
                System.out.println("Access Token not found in JSON string.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
