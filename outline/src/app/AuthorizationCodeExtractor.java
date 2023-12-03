package app;

import java.net.URI;
import java.net.URISyntaxException;

public class AuthorizationCodeExtractor {
    public static String extract(String url) {

        try {
            URI uri = new URI(url);
            String query = uri.getQuery();
            String[] params = query.split("&");
            String code = null;

            for (String param : params) {
                if (param.startsWith("code=")) {
                    code = param.substring(5);
                    break;
                }
            }

            return code;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}