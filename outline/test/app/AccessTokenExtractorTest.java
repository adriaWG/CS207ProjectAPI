package app;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccessTokenExtractorTest {

    @Test
    public void testAccessTokenExtractor() {
        // Arrange
        String jsonString = "{\"access_token\":\"your_access_token_value\",\"other_key\":\"other_value\"}";

        // Act
        String accessToken = AccessTokenExtractor.accessTokenExtractor(jsonString);

        // Assert
        assertNotNull(accessToken);
        assertEquals("your_access_token_value", accessToken);
    }

    @Test
    public void testAccessTokenExtractorTokenNotFound() {
        // Arrange
        String jsonString = "{\"other_key\":\"other_value\"}";

        // Act
        String accessToken = AccessTokenExtractor.accessTokenExtractor(jsonString);

        // Assert
        assertNull(accessToken);
    }

    @Test
    public void testAccessTokenExtractorInvalidJson() {
        // Arrange
        String invalidJsonString = "invalid_json_string";

        // Act
        String accessToken = AccessTokenExtractor.accessTokenExtractor(invalidJsonString);

        // Assert
        assertNull(accessToken);
    }
}
