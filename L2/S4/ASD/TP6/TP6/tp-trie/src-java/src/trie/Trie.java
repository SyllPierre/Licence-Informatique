package trie ;
import java.util.*;

public class Trie {

   /**
    Un trie c'est :
        -entre 0 et 26 fils (trie)
        -un boolean
    */

    private Map<Character, Trie> fils;
    private boolean estMot;
    
    public Trie () {
        this.fils = new HashMap<Character, Trie>();
        this.estMot = false;
    }
    
    /**
    * Add a word in the trie
    * @param word the word witch must be add
    */
    public void add (String word) {
        if(word.length() != 0){
            Character c = (Character) word.charAt(0);
            if(this.fils.containsKey(c)){
                this.fils.get(c).add(word.substring(1));
            }
            else{
                this.fils.put(c, new Trie());
                this.fils.get(c).add(word.substring(1));
            }
        }
        else{
            this.estMot = true;
        }
    }


    /**
    * Check if the trie contains the word
    * @param word the word you want to check
    * @return True if the trie contains the word, False otherwise
    */
    public boolean contains (String word) {
        if(word.length() != 0){
     	    Character c = (Character) word.charAt(0);
            if(this.fils.containsKey(c)){
                return this.fils.get(c).contains(word.substring(1));
            }
            else{
                return false;
            }
        }
        else{
            return this.estMot;
        }
    }

    /**
    * function which called in print
    * @param n, the first noode
    * @return the last node
    */
    int print_impl(int n) {
        int a = n+1;
        System.out.println(n + "[style=filled,color="+ (this.estMot ? "blue" : "pink") + "]");
        Set<Character> keys = this.fils.keySet();
            for(Character c : keys){
                System.out.println(n+" -> "+a+"[label=\""+c+"\"];");
                a = this.fils.get(c).print_impl(a);
            }
        return a;
    
    }

    /**
    * display the description in dot format
    */
    public void print () {
        System.out.println("digraph G {");
        print_impl(0);
        System.out.println("}");
    }


}

