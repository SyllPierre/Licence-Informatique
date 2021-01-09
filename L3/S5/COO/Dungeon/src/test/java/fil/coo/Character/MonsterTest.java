package fil.coo.Character;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.Rooms.Room;





public class MonsterTest extends CharTest{
	public Char createChar() {
		
		this.r = new Room(2,0);
		this.s = 10;
		this.l = 20;
		this.g = 30;
		return new Monster(this.s,this.l,this.g,this.r);
	}
	
	@Test
	public void attackTest() {
		int life_player = 20;
		Player p = new Player(10, life_player ,10, r);
		Monster m = this.r.getListMonster().get(0);
		int s_m = m.getStrength();
		m.attack(p);
		if ((life_player - s_m) < 0){
			assertTrue(p.isDead());
		}
		else{
			assertFalse(p.isDead());
		}
	}
}
