import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {

    LocalizationService sut = new LocalizationServiceImpl();

    @BeforeEach
    public void started() {
        System.out.println("Test started");
    }

    @BeforeAll
    public static void startedAll() {
        System.out.println("All tests started");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("All tests finished");
    }
    @BeforeEach
    public void finished() {
        System.out.println("Test finished");
    }

    @ParameterizedTest
    @EnumSource(Country.class)
    public void testLocalRussian() {
        String expected = "Добро пожаловать";

        String result = sut.locale(Country.RUSSIA);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @EnumSource(Country.class)
    public void testLocalForeign() {
        String expected = "Welcome";

        String result = sut.locale(Country.USA);

        assertEquals(expected, result);
    }

}
