import static org.junit.Assert.*;
import org.junit.Test;

import trie.CompactTrie;

/**
 * Test class for the CompactTrie
 */
public class CompactTrieTest {

  @Test
	public void testConstructor() {
		CompactTrie t = new CompactTrie();
		assertNotNull(t);
	}

	@Test
	public void testAdd() {
		CompactTrie t = new CompactTrie();
		assertFalse(t.contains("abc"));
		t.add("abc");
		assertTrue(t.contains("abc"));
	}

	@Test
	public void testContains() {
		CompactTrie testTrie = new CompactTrie();
		testTrie.add("coucou");
		assertTrue(testTrie.contains("coucou"));
		assertFalse(testTrie.contains("coucop"));
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(CompactTrieTest.class);
	}

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("CompactTrieTest");
	}
}
