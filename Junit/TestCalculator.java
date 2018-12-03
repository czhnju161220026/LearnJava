package nju.cui;
import org.junit.*;

public class TestCalculator {
    private static Calculator calculator= new Calculator();
    @BeforeClass
    public static void beforeClass() {
        System.out.println("global");
    }
    @Before
    public  void setup() {
        System.out.println("on the test begin");
    }
    @After
    public void end() {
        System.out.println("on the test end");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("destory global");
    }
    @Test
    public  void testAdd() {
        Assert.assertEquals(5,calculator.add(2,3));
    }
    @Test
    public void testSub() {
        Assert.assertEquals(9,calculator.sub(10,1));
    }
    @Test
    public  void testMult() {
        Assert.assertEquals(15,calculator.multi(3,5));
    }
    @Test
    @Ignore("这是故意写错的，不用测试")
    public  void testDivide() {
        Assert.assertEquals(2,calculator.divide(10,2));
    }
}
