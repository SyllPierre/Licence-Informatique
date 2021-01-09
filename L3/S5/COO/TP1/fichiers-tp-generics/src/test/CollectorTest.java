package generics;

import static org.junit.Assert.*;

import org.junit.Test;

public class CollectorTest {

	@Test
	public void testCollector() {
		Collector<Carrot> carrotCollector1 = new Collector<Carrot>("carrot-collector-1");
		assertNotNull(carrotCollector1);
	}

	@Test(expected=AlreadyCarryingException.class)
	public void testTake() throws AlreadyCarryingException {
		Collector<Carrot> c = new Collector<Carrot>("c");
		Carrot carrot = new Carrot(1);
		c.take(carrot);
		Carrot carrot2 = new Carrot(2);
		c.take(carrot2);
	}

	@Test
	public void testGetCarriedObject() {
		Collector<Carrot> c = new Collector<Carrot>("c");
		assertNull(c.getCarriedObject());
	}
	
	@Test
	public void testGetCarriedObject2() throws AlreadyCarryingException{
		Collector<Carrot> c = new Collector<Carrot>("c");
		Carrot carrot = new Carrot(1);
		c.take(carrot);
		assertNotNull(c.getCarriedObject());
	}

	@Test
	public void testGiveTo() throws AlreadyCarryingException {
		Collector<Carrot> c = new Collector<Carrot>("c");
		Collector<Carrot> c2 = new Collector<Carrot>("c2");
		Carrot carrot = new Carrot(1);
		c.take(carrot);
		c.giveTo(c2);
		//On redonne une carotte à c pour vérifier qu'elle a bien donné la première
		Carrot carrot2 = new Carrot(2);
		c.take(carrot2);
	}

	@Test
	public void testDrop() throws AlreadyCarryingException{
		Collector<Carrot> c = new Collector<Carrot>("c");
		Carrot carrot = new Carrot(1);
		c.take(carrot);
		c.drop();
		assertNull(c.getCarriedObject());		
	}

}
