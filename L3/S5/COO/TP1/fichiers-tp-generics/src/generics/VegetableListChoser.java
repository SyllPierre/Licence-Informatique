package generics;

import scanner.*;
import java.util.*;

public class VegetableListChoser {
	
	public <T extends Vegetable> T chose(String string, List<T> list){
		System.out.println(string);
		if (list.isEmpty()){
			System.out.println("No elements in the list");
		}
		else{
			System.out.println("None-0");
			for(T el : list){
				System.out.println(el);
			}
		}
		int v = ScannerInt.readInt(list.size()+1);
		if( v == 0 ){
			return null;
		}
		else{
			return list.get(v-1);
		}
	}
    
    public static void main(String[] args) {
		List<Carrot> lCarrots = new ArrayList<Carrot>();
		lCarrots.add(new Carrot(1));
		lCarrots.add(new Carrot(2));
		lCarrots.add(new Carrot(3));

		List<Apple> lApples = new ArrayList<Apple>();
		lApples.add(new Apple(1));
		lApples.add(new Apple(2));
		lApples.add(new Apple(3));

		VegetableListChoser lcl = new VegetableListChoser();

		Carrot chosenCarrot = lcl.chose("which carrot ? ", lCarrots);
		System.out.println("You have chosen : " + chosenCarrot);

		// NE COMPILE PAS
		// Apple chosenApple = lcl.chose("which apple ? ",lApples);


    }
}
