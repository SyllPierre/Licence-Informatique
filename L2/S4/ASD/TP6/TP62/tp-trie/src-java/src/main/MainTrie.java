package main;
import trie.Trie ;

import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;

public class MainTrie {
   
    public static void main (String args[]) throws FileNotFoundException{
    
        System.setOut(new PrintStream(new File("trie.dot")));
        Trie t = new Trie();
        for(int i = 0; i < args.length; i++){
            t.add(args[i]);
        }
        t.print();

    }

}