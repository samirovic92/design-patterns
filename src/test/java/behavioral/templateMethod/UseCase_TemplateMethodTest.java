package behavioral.templateMethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase_TemplateMethodTest {

    @Test
    public void post_message_in_twitter() {
        // Given
        var twitter = new Twitter("Alice Persona", "12345");

        // When
        var success = twitter.post("Hello World");

        // Then
        assertTrue(success);
    }

    @Test
    public void post_message_in_facebook() {
        // Given
        var facebook = new FaceBook("Bob Persona", "123456");

        // When
        var success = facebook.post("Hello World");

        // Then
        assertTrue(success);
    }
}
