package generics;

import scanner.*;
import java.util.*;

public class ClonableVegetableListChoser {
	
	public <T extends Cloneable & Vegetable> T chose(String string, List<T> list){
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

		List<Cauliflower> lCauliflowers = new LinkedList<Cauliflower>();
		lCauliflowers.add(new Cauliflower(1));
		lCauliflowers.add(new Cauliflower(2));
		lCauliflowers.add(new Cauliflower(3));

		ClonableVegetableListChoser lclc = new ClonableVegetableListChoser();

		Carrot chosenCarrot = lclc.chose("which carrot ? ", lCarrots);
		System.out.println("you have chosen : " + chosenCarrot);

		Cauliflower chosenCauliflower = lclc.chose("which cauliflower ? ", lCauliflowers);
		System.out.println("you have chosen : " + chosenCauliflower);

		List<Rutabaga> lRutabagas = new ArrayList<Rutabaga>();
		lRutabagas.add(new Rutabaga(1));
		lRutabagas.add(new Rutabaga(2));
		lRutabagas.add(new Rutabaga(3));
		// NE COMPILE PAS :
		// Rutabaga chosenRutabaga = lclc.chose("which rutabaga ? ",lRutabagas);

		List<Apple> lApples = new ArrayList<Apple>();
		lApples.add(new Apple(1));
		// NE COMPILE PAS :
		// Apple chosenApple = lclc.chose("which apple ? ",lApples);

	}
}
