package app;

import junit.framework.TestCase;

public class AuthorizationCodeExtractorTest extends TestCase {

    public void testExtract_shouldReturnCode_whenCodeIsPresentInUrl() {
        // Arrange
        String url = "https://example.com/callback?code=abcdef123456";

        // Act
        String result = AuthorizationCodeExtractor.extract(url);

        // Assert
        assertEquals("abcdef123456", result);
    }

    public void testExtract_shouldReturnNull_whenUrlIsNull() {
        // Arrange
        String url = null;

        // Act
        String result = AuthorizationCodeExtractor.extract(url);

        // Assert
        assertNull(result);
    }

    public void testExtract_shouldReturnNull_whenUrlDoesNotContainCode() {
        // Arrange
        String url = "https://example.com/callback?state=xyz123";

        // Act
        String result = AuthorizationCodeExtractor.extract(url);

        // Assert
        assertNull(result);
    }

    public void testExtract_shouldReturnNull_whenUrlHasInvalidSyntax() {
        // Arrange
        String url = "invalid-url";

        // Act
        String result = AuthorizationCodeExtractor.extract(url);

        // Assert
        assertNull(result);
    }
}
