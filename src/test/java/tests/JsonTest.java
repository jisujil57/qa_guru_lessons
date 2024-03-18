package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.pojo.HomePojo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class JsonTest {

    private static final ClassLoader CLASS_LOADER = JsonTest.class.getClassLoader();
    private static final String JSON_FILE = "home.json";

    @Test
    @DisplayName("Проверка содержимого файла json")
    void testJsonParsingWithFileInputStream() throws Exception {

        String[] expectedBedroomNames = {"Master Bedroom", "Guest Bedroom", "Kids Bedroom"};
        HomePojo expectedHome = new HomePojo("123 Main St", expectedBedroomNames, 2, 150.5);

        try (InputStream stream = CLASS_LOADER.getResourceAsStream(JSON_FILE)) {
            ObjectMapper objectMapper = new ObjectMapper();
            HomePojo jsonHome = objectMapper.readValue(stream, HomePojo.class);

            assertEqualHomeObjects(expectedHome, jsonHome);
        }
    }

    private void assertEqualHomeObjects(HomePojo expected, HomePojo actual) {
        Assertions.assertEquals(expected.getAddress(), actual.getAddress());
        Assertions.assertEquals(expected.getArea(), actual.getArea());
        Assertions.assertEquals(expected.getBathrooms(), actual.getBathrooms());
        Assertions.assertArrayEquals(expected.getBedroomNames(), actual.getBedroomNames());
    }
}
