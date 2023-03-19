
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class GeoServiceImplTest {


    GeoServiceImpl sut = new GeoServiceImpl();



    @BeforeEach
    public void started() {
        System.out.println("Тест стартовал");
    }

    @BeforeAll
    public static void startedAll() {
        System.out.println("Все тесты стартовали");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Все тесты закончены");
    }

    @AfterEach
    public void finished() {
        System.out.println("Тест закончен");
    }

    @ParameterizedTest
    @MethodSource("sourceByIP")
    public void paramTestByIp(String ip, Location expected) {

        Location result = new GeoServiceImpl().byIp(ip);

        //assertEquals(expected, result);
        Assertions.assertEquals(expected.getCity(), result.getCity());
    }


    public static Stream<Arguments> sourceByIP() {
        return Stream.of(
                Arguments.of("127.0.0.1", new Location(null, null, null, 0)),
                Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32)),
                Arguments.of("172.", new Location("Moscow", Country.RUSSIA, null, 0)),
                Arguments.of("96.", new Location("New York", Country.USA, null, 0)));
        //Arguments.of("1.1.1.1", new Location(null, null,null, 0)));
    }

    @Test
    public void testByCoordinates() {

        Class<RuntimeException> exeptExetionClass = RuntimeException.class;

        Executable executable = () -> sut.byCoordinates(0, 0);

        assertThrows(exeptExetionClass, executable);
    }
}

