import static org.junit.Assert.*;
import org.junit.Test;

import trie.Trie;

/**
 * Test class for the Trie
 */
public class TrieTest {

  @Test
	public void testConstructor() {
		Trie t = new Trie();
		assertNotNull(t);
	}

	@Test
	public void testAdd() {
		Trie t = new Trie();
		assertFalse(t.contains("abc"));
		t.add("abc");
		assertTrue(t.contains("abc"));
	}

	@Test
	public void testContains() {
		Trie testTrie = new Trie();
		testTrie.add("coucou");
		assertTrue(testTrie.contains("coucou"));
		assertFalse(testTrie.contains("coucop"));
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(TrieTest.class);
	}

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("TrieTest");
	}
}
