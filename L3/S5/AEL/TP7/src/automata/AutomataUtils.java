package automata;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
/**
 * 
 * @author Bruno.Bogaert (at) univ-lille.fr
 *
 */
public class AutomataUtils {

	/**
	 * Extends automaton a, so that it accepts also this word. 
	 * Created states are prefixed by 'q_'  
	 * @param word : word to be accepted
	 * @param a : target automaton
	 */
	public static void addSingleton(String word, AutomatonBuilder a) {
		addSingleton(word, a, "q");
	}

	/**
	 * Extends automaton a so that it accepts also this word.
	 * Created states are prefixed by namePrefix followed by '_' 
	 * @param word : word to be accepted
	 * @param a : target automaton
	 * @param namePrefix : prefix to use for state names.
	 */
	public static void addSingleton(String word, AutomatonBuilder a, String namePrefix) {
		int len = word.length();
		namePrefix += "_";
		String name = "";
		a.addNewState(namePrefix + "epsilon");
		a.setInitial(namePrefix + "epsilon");
		for(int i=0; i<len; i++) {
			a.addNewState(namePrefix + name + word.charAt(i));
			a.addTransition(namePrefix + ((name=="") ? "epsilon" : name), word.charAt(i), namePrefix + name + word.charAt(i));
			name += word.charAt(i);
		}	
		a.setAccepting(namePrefix + ((name=="") ? "epsilon" : name));
	}

	/**
	 * Extends automaton a so that it accepts also this finite language
	 * created states are prefixed by namePrefix followed by '_'  
	 * @param finiteLanguage : set of words to be accepted
	 * @param a : target automaton
	 */	
	public static void addFiniteSet(Iterable<String> finiteLanguage, AutomatonBuilder a) {
		int nb = 0;
		Iterator<String> it = finiteLanguage.iterator();
		while(it.hasNext()) {
			addSingleton(it.next(), a, "q" + nb); 
			nb++;
		}
	}

	/**
	 * Extends automaton a so that it accepts also language denoted by exp
	 * created states are prefixed by namePrefix followed by '_'  
	 * @param exp : flat regular expression (only letters and *)
	 * @param a : target automaton
	 */
	public static void addFlatExp(String exp, AutomatonBuilder a) {
		addFlatExp(exp, a, "q");
	}
	
	/**
	 * Extends automaton a so that it accepts also language denoted by exp
	 * created states are prefixed by namePrefix followed by '_'  
	 * @param exp : flat regular expression (only letters and *)
	 * @param a : target automaton
	 * @param namePrefix : prefix to use for state names.
	 */
	public static void addFlatExp(String exp, AutomatonBuilder a, String namePrefix) {
		int len =exp.length();
		namePrefix += "_";
		String name = "";
		boolean etoile = false;
		List<String> pile = new ArrayList<String>();
		a.addNewState(namePrefix + "epsilon");
		pile.add("epsilon");
		a.setInitial(namePrefix + "epsilon");
		for(int i=0; i<len; i++) {
			if(i == len-1 || exp.charAt(i+1) != '*') {
				name += exp.charAt(i);
				a.addNewState(namePrefix + name);
				for(String st : pile) {
					a.addTransition(namePrefix + st, exp.charAt(i), namePrefix + name);
				}
				etoile = false;
				pile.clear();
				pile.add(name);
			}
			else {
				name += exp.charAt(i);
				name += exp.charAt(i+1);
				if(etoile) {
					a.addNewState(namePrefix + name);
					for(String st : pile) {
						a.addTransition(namePrefix + st, exp.charAt(i), namePrefix + name);
					}
					pile.add(name);
				}
				a.addTransition(namePrefix + pile.get(pile.size()-1), exp.charAt(i), namePrefix + pile.get(pile.size()-1));
				etoile = true;
				i++;
			}
		}
		a.setAccepting(namePrefix + name);
	}

	/**
	 * Transpose automaton
	 * Note : mirror is cleared before the operation. 
	 * 
	 * @param original : automaton to be transposed
	 * @param mirror : receive the transposed automaton 
	 */
	public static void transpose(Automaton original, AutomatonBuilder mirror) {
		mirror.clear();
		for(State state : original.getStates()) {
			mirror.addNewState(state.getName());
		}
		for(State state : original.getAcceptingStates()) {
			mirror.setInitial(state.getName());
		}
		for(State state : original.getInitialStates()){
			mirror.setAccepting(state.getName());
		}
		for(Character c : original.usedAlphabet()) {
			for(State s1 : original.getStates()) {
				for(State s2 : original.getTransitionSet(s1, c)) {
					mirror.addTransition(s2.getName(), c, s1.getName());
				}
			}
		}
	}

	/**
	 * Determinization of nfa automaton. 
	 * Note : dfa is cleared before the operation.
	 * @param nfa : non deterministic automaton (to be determinize)
	 * @param dfa : receive determinization result
	 */
	public static void determinize(Automaton nfa, AutomatonBuilder dfa) {
		// For each computed state set from nfa, a corresponding state has to be created in dfa
		// map represents relationship  between nfa state set (key) and created dfa state (value) 
		Map<Set<State>, State> map = new HashMap<Set<State>, State>();
				
		// stack todo contains state sets whose transitions have not yet been computed
		Stack<Set<State>> todo = new Stack<Set<State>>(); 
		
		dfa.clear();

		Set<State> startSet = nfa.getInitialStates();

		// create matching state in DFA
		State start = dfa.addNewState(startSet.toString()); // state creation
		map.put(startSet, start);  // record relationship in map

		dfa.setInitial(start); // start is the unique initial state of dfa

		todo.push(startSet); // put it in todo list.

		while (! todo.isEmpty()) {
			Set<State> fromSet = todo.pop(); // pick a state from todo list
			
			for(Character c : nfa.usedAlphabet()) {
				Set<State> tr = nfa.getTransitionSet(fromSet, c);
				if(!map.containsKey(tr)) {
					State newState = dfa.addNewState(tr.toString());
					map.put(tr, newState);
					todo.push(tr);
				}
				dfa.addTransition(map.get(fromSet), c, map.get(tr));;
			}
		}
		for (Set<State> qSet : map.keySet()) {	// foreach computed state set
			for(State st : nfa.getAcceptingStates()) {
				if(qSet.contains(st)) {
					dfa.setAccepting(map.get(qSet));
				}
			}
		}
	}
	
	/**
	 * @param a an automaton non minimalise
	 * @param dest the minimalise
	 */
	public static void minimalise(Automaton a, AutomatonBuilder dest) {
		dest.clear();
		AutomatonBuilder tmp = new NDAutomaton();
		transpose(a, tmp);
		determinize(tmp, dest);
		transpose(dest, tmp);
		determinize(tmp, dest);
		
	}
	
	/*
	 * Écriture de la représentation graphviz de l'automate dans un fichier
	 * 
	 */
	private static void dotToFile(Automaton a, String fileName) {
		File f = new File(fileName);
		try {
			PrintWriter sortieDot = new PrintWriter(f);
			sortieDot.println(a.toGraphviz());
			sortieDot.close();
		} catch (IOException e) {
			System.out.println("création du fichier " + fileName + " impossible");
		}
	}
	
	public static void main(String[] argd) throws StateException {
		List<String> maList = new ArrayList<String>();
		maList.add("abc");
		maList.add("def");
		AutomatonBuilder a = new NDAutomaton();
		addSingleton("hello",  a);
		dotToFile(a, "automate-hello.dot");
		
		AutomatonBuilder b = new NDAutomaton();
		addFiniteSet(maList, b);
		dotToFile(b, "automate-fin.dot");
		
		AutomatonBuilder c = new NDAutomaton();
		addFlatExp("10*1*0*1",  c);
		dotToFile(c, "automate-exp.dot");
		
		AutomatonBuilder d = new NDAutomaton();
		transpose(c, d);
		dotToFile(d, "automate-tr.dot");
		
		AutomatonBuilder e = new NDAutomaton();
		determinize(b, e);
		dotToFile(e, "automate-detfin.dot");
		
		AutomatonBuilder f = new NDAutomaton();
		determinize(c, f);
		dotToFile(f, "automate-detexp.dot");
		
		AutomatonBuilder g = new NDAutomaton();
		minimalise(c, g);
		dotToFile(g, "automate-minexp.dot");
		
		AutomatonBuilder h = new NDAutomaton();
		minimalise(b, h);
		dotToFile(h, "automate-minfin.dot");
	}
	
}
