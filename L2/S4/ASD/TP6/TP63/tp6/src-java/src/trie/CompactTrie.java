package trie ;

import java.util.Map;
import java.util.HashMap;

public class CompactTrie {
    /** Children of a trie */
    private Map<String, CompactTrie> children;
    
    /** Boolean indicating whether this node is the end of a word */
    private boolean endOfWord;
    

    public CompactTrie () {
	this.children = new HashMap<String, CompactTrie>();
	this.endOfWord = false;
    }
    
    /**
    * Add a word in the trie
    * @param word the word witch must be add
    */
    public void add (String word) {
	/* End case */
	if (word.length()==0)
	    this.endOfWord = true;
	/* Recursion */
	else {
	    String key = "";
	    int i = 0;
	    for (String child : this.children.keySet()) {
		while ((i<child.length())&&(i<word.length())&&(word.charAt(i)==child.charAt(i))) {
		    i++;
		    key = child;
		}
	    }
	    if (i==0) {
		/* Case where the word is neither prefix or suffix of any word */
		/* We are going to add this word as a new son */
		this.children.put(word,new CompactTrie());
		this.children.get(word).endOfWord = true;
	    }
	    else if (i==key.length()) {
		/* Case where one of the sons is a prefix of the word */
		/* We are going to go deeper in that branch and add it */
		this.children.get(key).add(word.substring(i));
	    }
	    else {
		/* Case where a son and the word share a same prefix */
		/* We have to add the common prefix and continue down that branch */
		CompactTrie old = this.children.remove(key); /* Remove old branch and store it */
		this.children.put(key.substring(0,i),new CompactTrie()); /* Add the new branch with the common prefix */
		this.children.get(key.substring(0,i)).children.put(key.substring(i),old); /* Go down the new branch and put the old branch */
		this.children.get(key.substring(0,i)).add(word.substring(i)); /* Add the rest of the word to the new branch */
	    }
	}
    }
    

    /**
    * Check if the trie contains the word
    * @param word the word you want to check
    * @return True if the trie contains the word, False otherwise
    */
    public boolean contains (String word) {
	if (word.length()==0) 
	    return this.endOfWord;
	String key = "";
	int i = 0;
	for (String child : this.children.keySet()) {
	    i = 0;
	    while (i<child.length() && i<word.length() && (word.charAt(i) == child.charAt(i))) {
		i++;
		key = child;
	    }
	}
	if (i==0)
	    /* Case where the word is neither a prefix or suffix of a child */
	    /* In this case the word is obviously not in the Trie */
	    return false;
	else {
	    /* Case where a common prefix has been found between the word and a child */
	    /* Recursively continue the search onto that branch */
	    return this.children.get(key).contains(word.substring(i));
	}
    }

    /**
    * function which called in print
    * @param n, the first noode
    * @return the last node
    */
    private int print_node(int parent) {
	int child_id = parent+1;
	for (String child : this.children.keySet()) {
	    String color = this.children.get(child).endOfWord?"blue":"pink";
	    System.out.println(child_id+" [style=filled,color="+color+"];");
	    System.out.println(parent+" -> "+child_id+" [label=\""+child+"\"];");
	    child_id = this.children.get(child).print_node(child_id);
	}
	return child_id;
    }
    
    /**
    * display the description in dot format
    */
    public void print () {
	System.out.println("digraph G {");
	this.print_node(0);
	System.out.println("}");
    }
    
}
