package trie ;
import java.util.*;



public class CompactTrie {

    private List<String> indices;
    private List<CompactTrie> nodes;
    private boolean isWord;

    public CompactTrie () {
        this.indices = new ArrayList<String>();
        this.nodes= new ArrayList<CompactTrie>();
        this.isWord = false;
    }

    /**
    * The 2nd constructor
    * @param str, a String
    * @param trie, a CompactTrie
    */
    public CompactTrie(String str, CompactTrie trie) {
        this.indices = new ArrayList<String>();
        this.nodes = new ArrayList<CompactTrie>();
        this.isWord = false;

        this.indices.add(str);
        this.nodes.add(trie);
    }

    /**
    * Give the common root
    * @param a, a String
    * @param b, a String
    * @retrun the common root
    */
    private String commonRoot(String a, String b){
        String res = "";
        if(a.isEmpty() || b.isEmpty())
            return res;  
        while(a.charAt(0) == b.charAt(0)){
            res += a.charAt(0);
            a = a.substring(1);
            b = b.substring(1);
            if(a.isEmpty() || b.isEmpty())
                return res;  
        }
        return res;
    }
    
    /**
    * Find the index in indices where we must add the word
    * @param word, a word
    * @return the index in indices where we must add the word
    */
    private int dicho(String word){
        int start = 0, end = this.indices.size();
        while(start<end){
            int mid = (start+end) / 2;
            String w = this.indices.get(mid);
            if(w.charAt(0) == word.charAt(0)){
                return mid;
            }
            if(w.compareTo(word)<0)
                start = mid+1;
            else
                end = mid;
        }
        return start;
    }

    /**
    * Add a word in the trie
    * @param word the word witch must be add
    */
    public void add (String word) {
        if(word.isEmpty()){
            this.isWord = true;
            return;
        }
        if(this.indices.isEmpty()){
            this.indices.add(word);    
            this.nodes.add(new CompactTrie());
            this.nodes.get(0).add("");
            return;
        }

        int pos = dicho(word);
        if(pos == this.indices.size()){
            this.indices.add(word);    
            this.nodes.add(new CompactTrie());
            this.nodes.get(pos).add("");
            return;
        }

        String nodeWord = this.indices.get(pos);
        String common = commonRoot(word, nodeWord);

        if(common.isEmpty()){
            this.indices.add(pos, word);    
            this.nodes.add(pos, new CompactTrie());
            this.nodes.get(pos).add("");
            return;
        }
        if(common.equals(nodeWord)){
            this.nodes.get(pos).add(word.substring(common.length()));
            return;
        }
        this.indices.set(pos, common);
        CompactTrie trie = this.nodes.get(pos);
        this.nodes.set(pos, new CompactTrie(nodeWord.substring(common.length()), trie));
        this.nodes.get(pos).add(word.substring(common.length()));
    }

    /**
    * Check if the trie contains the word
    * @param word the word you want to check
    * @return True if the trie contains the word, False otherwise
    */
    public boolean contains (String word) {
        if(word.isEmpty())
            return this.isWord;

        if(this.indices.isEmpty())
            return false;

        int pos = dicho(word);
        String nodeWord = this.indices.get(pos);
        if(word.startsWith(nodeWord))
            return this.nodes.get(pos).contains(word.substring(nodeWord.length()));
        return false;
    }

   
    /**
    * function which called in print
    * @param n, the first noode
    * @return the last node
    */
    int print_impl(int n) {
        int a = n+1;
        System.out.println(n + "[style=filled,color="+ (this.isWord ? "blue" : "pink") + "]");
        for(int i=0; i<this.indices.size(); ++i){
            System.out.println(n+" -> "+a+"[label=\""+this.indices.get(i)+"\"];");
            a = this.nodes.get(i).print_impl(a);
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

