package trie;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CompactTrieTest {
 
	private Trie t;

	
	@Before 
	public void before() {
		this.t = new Trie();
	}

	@Test
	public void addTest() {
		assertFalse(this.t.contains("test"));
        t.add("test");
        assertTrue(this.t.contains("test"));
	}
	
	@Test
	public void containsTest() {
		t.add("test1");
        t.add("test2");
        t.add("test3");
        assertTrue(this.t.contains("test1"));
        assertTrue(this.t.contains("test2"));
        assertTrue(this.t.contains("test3"));
        assertFalse(this.t.contains("test4"));
	}

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(trie.CompactTrieTest.class);
    }

}
