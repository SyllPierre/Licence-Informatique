import org.junit.*;
import static org.junit.Assert.*;

publiv class DateTest{
  @test
  public void testTomorrow(){
    Date d1 = new Date(1, Month.avril,2017);
    Date d2 = new Date(30, Month.avril,2017);
    Date d3 = new Date (31, Month.december,2017);

    assertEquals(new Date(2,Month.avril,2017), d1.tomorrow());
  }
}
