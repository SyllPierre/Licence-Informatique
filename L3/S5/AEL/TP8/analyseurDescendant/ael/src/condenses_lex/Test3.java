package condenses_lex;

import java.io.StringReader;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("mot ? > ");
		while (input.hasNextLine()) {
			String word = input.nextLine();
			Exo2 parser = new Exo2(new StringReader(word));
			try {
				parser.parse();
				System.out.println("OK");
			} catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
				//throw e;
			}
			System.out.print("mot ? > ");
		}
		input.close();
	}

}
