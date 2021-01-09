package fil.coo;

public class MainStudent {

	public static void main(String[] args) {
		Student s=new Student("Mathilde","11800272");
		Student s2 = new Student("Pierre","11758532");
		System.out.println("Premier étudiant :"+ s.get_Name()+ "son numéro est :"+ s.get_Id());
		System.out.println("Deuxième étudiant :"+ s2.get_Name()+ "son numéro est :"+ s2.get_Id());
	}

}
