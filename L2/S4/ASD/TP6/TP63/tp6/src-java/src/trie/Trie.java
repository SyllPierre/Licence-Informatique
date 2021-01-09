package trie ;

import java.util.Map;
import java.util.TreeMap;

/**
 * Class that represents a Trie object as seen in algorithms and data structures
 * @author SYLLEBRANQUE Pierre - DESMAREST Mathilde
 * @version 1.0
 */
public class Trie {
    /** Children of a trie */
    private Map<Character, Trie> children;

    /** Boolean indicating whether this node is the end of a word */
    private boolean endOfWord;

    /**
     * Constructs this Trie object :
     * Initially, an empty Trie is a Trie that has no children and that is not the end of a word
     */
    public Trie () {
	this.children = new TreeMap<Character, Trie>();
	this.endOfWord = false;
    }

    /**
    * Add a word in the trie
    * @param word the word witch must be add
    */
    public void add (String word) {
	/* If this Trie doesn't contain this path, we create a new one */
	if (word.length()==0)
	    this.endOfWord = true;
	else {
	    if (!this.children.containsKey(word.charAt(0)))
		this.children.put(word.charAt(0), new Trie());
	    this.children.get(word.charAt(0)).add(word.substring(1));
	}
    }

    /**
     * Says whether this Trie contains a given word
     * @param word the word to test
     * @return <code>true</code> if this Trie contains the word, <code>false</code> otherwise
     */
    public boolean contains (String word) {
	char c = word.charAt(0);
	/* We have reached the end of the given word, check if its present */
	if (this.endOfWord) {
	    return this.children.containsKey(c);
	}
	else {
	    /* If the next letter of the word isn't any one of the children, the word is obviously not present in the Trie */
	    if (!this.children.containsKey(c)) {
		return false;
	    }
	    return this.children.get(c).contains(word.substring(1)); /* Otherwise continue recursively looking for the word */
	}
    }

    /**
     * Prints the node starting at a certain level
     * @param parent the index of the child's parent
     * @return the index of the last character of a word for a child
     */
    private int print_node (int parent) {
	int child = parent+1;
	for (Character c : this.children.keySet()) {
	    String color = this.children.get(c).endOfWord ? "blue" : "pink";
	    System.out.println(child + " [style=filled,color=" + color +"];");
	    System.out.println(parent+ " -> " + child + " [label=\"" + c + "\"];");
	    child = this.children.get(c).print_node(child);
	}
	return child;
    }
    
    /**
     * Prints the Trie in dot format
     */
    public void print () {
	System.out.println("digraph G {");
	this.print_node(0);
	System.out.println("}");
    }
}
