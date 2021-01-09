package fil.coo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GameTest {

	@Test
	public void testGame() {
		assertNotNull(new Game());
	}
	
	@Test
	public void TestGetAnObjectInList() {
		List<MockChoseable> list = new ArrayList<MockChoseable>();
		MockChoseable c1 = new MockChoseable(); 
		MockChoseable c2 = new MockChoseable(); 
		MockChoseable c3 = new MockChoseable(); 
		list.add(c1);
		list.add(c2);
		list.add(c3);
		assertEquals(getAnObject(list),c1);
	}
	
	/**
	 * Nous avons choisi de recréer une méthode getAnObject ici car nous ne voulons pas tester la fonction qui demande au joueur de choisir.
	 * ici, nous avons mis res=1 aléatoirement. De plus nous avons mis en commentaire les System.out.println.
	 * @param list the list we want to test
	 * @return a choseable
	 */
	private static <T extends Choseable> T getAnObject(List<T> list) {
		//int cpt = 1;
		int res = 0;
		T object = null;
		
		//for (Choseable item : list) {
			//System.out.print("Choice n°" + cpt + " : " );
			//item.display();
			//cpt++;
		//}
		//System.out.println("type 0 to quit");

		res = 1;
		if (res > 0) {
			object = list.get(res - 1);
		}
		if (res == 0){
			//System.out.println("You have chosen to quit\nEnd of the game");
			System.exit(0);
		}
		return object;
	}

}
