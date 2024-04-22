import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest extends Service {
    public ServiceTest(){}


    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }


    @Test
    public void testSetY1() {
        String x = "hi";

        setP1Location(x);

        assertEquals(x, getP1Location());
    }

    @Test
    public void testSetY2() {
        String x = "hi";

        setP2Location(x);

        assertEquals(x, getP2Location());

    }
}