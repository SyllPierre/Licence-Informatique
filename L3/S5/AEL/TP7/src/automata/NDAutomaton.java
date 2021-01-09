package automata;

import java.util.Collections;
import java.util.Set;

/**
 * 
 * Implémentation d'un automate non déterministe.
 * Version incomplète.
 * 
 * @author Bruno.Bogaert (at) univ-lille1.fr
 *
 */
public class NDAutomaton extends AbstractNDAutomaton implements Recognizer, AutomatonBuilder {


	@Override
	public boolean accept(String word) {
		if (word.length() == 0) {
			for (State s : initialStates) {
				if(isAccepting(s)) {
					return true;
				}
			}
		}
		else {
			Set<State> w = getTransitionSet(initialStates, word.charAt(0));
			for(int l=1; l<word.length(); l++) {
				w = getTransitionSet(w, word.charAt(l));
				if (w.isEmpty()) {
					return false;
				}
			}
			for(State s : w) {
				if(isAccepting(s)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	* Calcul de l'ensemble des états pouvant être obtenus depuis un ensemble d'états
	* @param fromSet : ensemble d'états
	* @param letter : lettre de l'alphabet
	* @return ensemble d'états pouvant être obtenus en lisant letter,
	* en partant de n'importe lequel des états de l'ensemble fromSet
	*/
	
	public Set<State> getTransitionSet(Set<State> fromSet, char letter) {
		Set<State> res = new PrintSet<State>();
		for(State from : fromSet) {
			Set<State> state = delta.get(new Key(from, letter));
			if(state != null) {
				for (State s : state) {
					res.add(s); 
				}
			}
		}
		return Collections.unmodifiableSet(res);
	}



}
