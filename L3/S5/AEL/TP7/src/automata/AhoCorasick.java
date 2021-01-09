package automata;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

/**
 *
 * Automate destiné à la recherche d'un ensemble de mots dans un texte.
 * Construit selon l'algorithme de AhoCorasick.
 *
 * @author Bruno.Bogaert (at) univ-lille1.fr
 *
 */
public class AhoCorasick extends NDAutomaton implements DeterministicAutomaton{

	private static String ROOT_NAME = "";

	private State root;        				// initial state
	private Map<State, State> repli;		// "fails" epsilon-transitions
	private Map<State, Set<String>> foundWords;		// found words on final states



	/**
	 * Construit l'automate à partir d'un ensemble non vide de mots non vides
	 *
	 * @param words
	 *            mots à rechercher
	 */
	public AhoCorasick(String... words) {
		this(Arrays.asList(words));
	}

	/**
	 * Construit l'automate à partir d'un ensemble non vide de mots non vides
	 *
	 * @param words
	 *            mots à rechercher
	 */
	public AhoCorasick(Collection<String> words) {
		// check words conformity
		for(String word : words) {
			for(char c : word.toCharArray()) {
				this.alphabet.add(c);
			}
		}
		// initialize structure
		repli = new HashMap<State, State>();
		foundWords = new HashMap<State, Set<String>>();

		// construct automaton
		root = this.addNewState(ROOT_NAME);
		this.setInitial(root);
		skeleton(words);
		addRegressTransitions();
	}

	/**
	 * Ensemble des mots reconnus quand l'état q est atteint
	 * @param q : état à tester
	 * @return ensemble des mots reconnus quand l'état q est atteint
	 */
	Set<String> getFoundWords(State q){
		if (isAccepting(q))
			return Collections.unmodifiableSet(foundWords.get(q));
		else
			return null;
	}

	public class Triplet<S1, S2, S3> {

	     private final S1 mot;
	     private final S2 l;
	     private final S3 etat;

	     public Triplet(S1 mot, S2 l, S3 etat) {
	         this.mot = mot;
	         this.l= l;
	         this.etat= etat;
	     }

	     public S1 getMot() { return mot; }
	     public S2 getL() { return l; }
	     public S3 getEtat() { return etat; }
	 }

	/**
	 * Fabrique le squelette (arbre) de l'automate
	 */
	private void skeleton(Collection<String> words) {
		ArrayDeque<Triplet<String, Integer , State>> file = new ArrayDeque<Triplet<String, Integer , State>>();
		for(String w : words) {
			Triplet<String, Integer , State> triplet = new Triplet<String, Integer , State>(w, 0, root);
			file.add(triplet);
		}
		while(!file.isEmpty()) {
			Triplet<String, Integer , State> current_triplet = file.poll();

			String mot = current_triplet.getMot();
			int l = current_triplet.getL();
			State current = current_triplet.getEtat();

			Set<State> q = super.getTransitionSet(current, mot.charAt(l));
			State s;
			if(q.isEmpty()) {
				s = addNewState(current, mot.charAt(l));
			}
			else {
				s = q.iterator().next();
			}
			if((l + 1) == mot.length()) {
				this.setAccepting(s);
				if(foundWords.get(s) == null) {
					foundWords.put(s, new HashSet<String>());
				}
				foundWords.get(s).add(mot);
			}
			else {
				file.add(new Triplet<String, Integer , State>(mot, l+1, s));
			}
		}
	}

	/**
	 * Fabrique un nouvel état accessible à partir du noeud parent par la lettre
	 * letter.
	 * Calcule également la relation de repli pour le nouvel état.
	 *
	 * @param parent
	 *            parent du nœud à créer
	 * @param letter
	 *            label de la transition entre parent et noeud à créer
	 * @return état créé
	 * @throws StateException
	 *
	 */
	private State addNewState(State parent, char letter) {
		State nouveau =  super.addNewState(parent.getName() + letter);
		this.addTransition(parent, letter, nouveau);
		State r = repli.get(parent);
		while(r != null && super.getTransitionSet(r, letter).isEmpty()) {
			r = repli.get(r);
		}
		if(r == null) {
			repli.put(nouveau, this.root);
		}
		else {
			State st = this.getTransition(r, letter);
			repli.put(nouveau, st);
			if(this.isAccepting(st)) {
				this.setAccepting(nouveau);
				foundWords.put(nouveau, foundWords.get(st));
			}
		}
		return nouveau;
	}

	/**
	 * Complète les transitions définies pour l'état q en utilisant la position
	 * de repli.
	 *
	 * @param q
	 */
	private void addRegressTransitions() {
		for(State u : this.getStates()) {
			State r = repli.get(u);
			for(char letter : this.alphabet) {
				if(!super.getTransitionSet(r, letter).isEmpty()) {
					if(super.getTransitionSet(u, letter).isEmpty()) {
						this.addTransition(u, letter, this.getTransition(r, letter));
					}
				}
			}
		}
	}

	@Override
	public Set<State> getTransitionSet(State s, char letter) {
		// Toutes les transitions non explicitement définies renvoient à l'état
		// initial
		Set<State> dest = super.getTransitionSet(s, letter);
		return dest.isEmpty() ? Collections.singleton(root) : dest;
	}




// ========== Specific or redefined methods for deterministic automaton  ============
	/**
	 * @see automata.DeterministicAutomaton#getInitialState()
	 */
	public State getInitialState() {
		Set<State> set = getInitialStates();
		if ( ! set.isEmpty()) {
			return set.iterator().next();
		} else {
			return null;
		}
	}
	/**
	 * @see automata.DeterministicAutomaton#getTransition(automata.State, char)
	 */
	public State getTransition(State s, char letter) throws StateException {
		Set<State> set = getTransitionSet(s, letter);
		if (! set.isEmpty()) {
			return set.iterator().next();
		} else {
			return null;
		}
	}
	/**
	 * @see automata.DeterministicAutomaton#getTransition(java.lang.String, char)
	 */
	public State getTransition(String name, char letter) throws StateException {
		return this.getTransitionSet(name, letter).iterator().next();
	}
	/**
	 * @see automata.DeterministicAutomaton#getTransition(java.lang.Integer, char)
	 */
	public State getTransition(Integer id, char letter) throws StateException {
		return this.getTransitionSet(id, letter).iterator().next();
	}
	@Override
	/**
	 * @see automata.AbstractNDAutomaton#setInitial(automata.State)
	 * @throws StateException if the unique initial state is already defined
	 */
	public void setInitial(State s) {
		if (super.getInitialStates().isEmpty())
			super.setInitial(s);
		else
			throw new StateException("initial state already defined");
	}
	/**
	 * @see automata.AbstractNDAutomaton#addTransition(automata.State, java.lang.Character, automata.State)
	 * @throws StateException if transition already defined
	 */
	@Override
	public void addTransition(State from, Character letter, State to) {
		if (super.getTransitionSet(from,letter).isEmpty())
			super.addTransition(from,letter, to);
		else
			throw new StateException("transition already defined");
	}



//==========       Graphviz generation methods      ============


	/*
	 * version avec un placement des nœuds adapté à la structure arborescente
	 * @see automata.AbstractAutomaton#writeGraphvizStates(java.io.Writer, boolean)
	 */
	@Override
	protected Writer writeGraphvizStates(Writer buff, boolean withNames) {
		PrintWriter out = new PrintWriter(buff);
		out.println("  rankdir = LR");
		Iterator<State> it = states.iterator();
		out.print("{rank=same; ");
		out.print(stateToGV(it.next(), withNames)); // root
		int rank = 0;
		while (it.hasNext()) {
			State s = it.next();
			if (s.getName().length() != rank) {
				rank++;
				out.println("}");
				out.print("{rank=same; ");
			}
			out.print(stateToGV(s, withNames));
		}
		out.println("}");
		return buff;
	}

	/*
	 * flèches pointillées pour représenter les replis (autres que ceux vers root)
	 */
	protected Writer writeGraphvizFails(Writer buff) {
		PrintWriter out = new PrintWriter(buff);
		for (Map.Entry<State,State> r : repli.entrySet()) {
			State to = r.getValue(), from= r.getKey();
			if (to != null && to != root)
				out.printf("    %d -> %d [style=dotted]\n",from.getId(), to.getId());
		}
		return buff;
	}
	/*
	 * transitions sans les transitions par défaut
	 * onlySkeleton ne conserve que les transitions du squelette
	 */
	protected Writer writeGraphvizWithoutDefaultTransitions(Writer buff, boolean onlySkeleton) {
		PrintWriter out = new PrintWriter(buff);
		for (State from : getStates()) {
			for (char letter : usedAlphabet()) {
				for (State dest : super.getTransitionSet(from, letter)) {
					// only super class view of transitions (exclude default transitions)
					if ((!onlySkeleton) || from.equals(root) || dest.getName().length() > from.getName().length()) {
						// is a skeleton transition iff dest name longer than from name
						out.printf("  %d -> %d [label = \"%s\"]\n",from.getId(),dest.getId(),letter);
					}
				}
			}
		}
		return buff;
	}

	protected Writer writeGraphvizWithoutDefault(Writer buff, boolean onlySkeleton, boolean withFails, boolean withNames) {
		PrintWriter out = new PrintWriter(buff);
		out.println("digraph Automaton { ");
		writeGraphvizStates(buff, withNames);
		writeGraphvizInitials(buff);
		writeGraphvizWithoutDefaultTransitions(buff, onlySkeleton);
		if (withFails)
			writeGraphvizFails(out);
		out.println("}");
		return buff;
	}
	protected Writer writeGraphvizWithoutDefault(Writer buff, boolean onlySkeleton, boolean withFails) {
		return writeGraphvizWithoutDefault(buff, onlySkeleton, withFails, true);
	}

	/**
	 * returns graphviz source without default (->root) transitions
	 * @return graphviz source without default transitions
	 */
	public String withoutDefaultToGraphviz() {
		StringWriter graph = new StringWriter();
		writeGraphvizWithoutDefault(graph, false, false);
		return graph.toString();
	}

	/**
	 * returns graphviz source of skeleton
	 * @param withNames if false, state names id's are displayed, instead of names
	 * @return graphviz source of skeleton
	 */
	public String skeletonToGraphviz(boolean withNames) {
		StringWriter graph = new StringWriter();
		writeGraphvizWithoutDefault(graph, true, false, withNames);
		return graph.toString();
	}
	/**
	 * returns graphviz source of skeleton, displaying state names
	 * @return graphviz source of skeleton
	 */
	public String skeletonToGraphviz() {
		return skeletonToGraphviz(true);
	}

	/**
	 * returns graphviz source of skeleton + "fail" epsilon-transitions, displaying state names
	 * @return graphviz source of skeleton + "fail" epsilon-transitions
	 */
	public String failsToGraphviz() {
		StringWriter graph = new StringWriter();
		writeGraphvizWithoutDefault(graph, true, true);
		return graph.toString();
	}

	/*
	 * Écriture de la représentation graphviz de l'automate dans un fichier
	 *
	 */
	private void dotToFile(String fileName) {
		File f = new File(fileName);
		try {
			PrintWriter sortieDot = new PrintWriter(f);
			sortieDot.println(failsToGraphviz());
			sortieDot.close();
		} catch (IOException e) {
			System.out.println("création du fichier " + fileName + " impossible");
		}
	}


	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("try");
		words.add("cry");
		words.add("create");
		words.add("at");
		AhoCorasick aho = new AhoCorasick(words);
		aho.dotToFile("aho.dot");
	}
}
