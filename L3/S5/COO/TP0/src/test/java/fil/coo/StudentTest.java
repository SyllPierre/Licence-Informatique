package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	protected Student c1;
	protected Student c2;
	@Before
	public void init() {
		c1 = new Student("arthur","11705157");
		c2= new Student("jijouh","1170451");
	}
	@Test
	public void testStudent() {

	}

	@Test
	public void testGet_Name() {
		assertTrue(c1.get_Name().equals("arthur"));
		assertFalse(c2.get_Name().equals("arthur"));
	}

	@Test
	public void testGet_Id() {
		assertTrue(c1.get_Id().equals("11705157"));
		assertFalse(c2.get_Name().equals("arthur"));
	}

	@Test
	public void testSet_Name() {
		assertTrue(c1.get_Name().equals("arthur"));
		c1.set_Name("thomas");
		assertTrue(c1.get_Name().equals("thomas"));
	}
	@Test
	public void testSet_Id(){
		assertTrue(c1.get_Id().equals("11705157"));
		c1.set_Id("11705160");
		assertTrue(c1.get_Id().equals("11705160"));
	}



	@Test
	public void testEquals() {
		assertFalse(c1.equals(c2));
	}

}
