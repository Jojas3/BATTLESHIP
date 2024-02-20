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
    public void testSetX1() {
        int x = 7;

        setX1(x);

        assertEquals(x, getX1());

    }

    @Test
    public void testSetY1() {
        String x = "hi";

        setY1(x);

        assertEquals(x, getY1());
    }

    @Test
    public void testSetX2() {
        int x = 6;

        setX2(x);

        assertEquals(x, getX2());
    }

    @Test
    public void testSetY2() {
        String x = "hi";

        setY2(x);

        assertEquals(x, getY2());

    }
}