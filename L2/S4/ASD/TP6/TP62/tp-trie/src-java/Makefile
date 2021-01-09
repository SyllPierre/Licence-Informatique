all: TrieMain MainTrie CompactTrieMain

classes/trie/Trie.class : src/trie/Trie.java
	javac -d classes -cp classes -sourcepath src src/trie/Trie.java

TrieMain : classes/TrieMain.class

MainTrie : classes/main/MainTrie.class

classes/TrieMain.class : src/TrieMain.java classes/trie/Trie.class
	javac -d classes -cp classes -sourcepath src src/TrieMain.java
	
classes/main/MainTrie.class : src/main/MainTrie.java classes/trie/Trie.class
	javac -d classes -cp classes -sourcepath src src/main/MainTrie.java

figure1 : classes/TrieMain.class
	java -cp classes TrieMain > test1.dot
	dot -Tpdf test1.dot -otest1.pdf

clean:
	rm -f test?.pdf test?.dot
	rm -f classes/*.class classes/trie/*.class

classes/trie/CompactTrie.class : src/trie/CompactTrie.java
	javac -d classes -cp classes -sourcepath src src/trie/CompactTrie.java

CompactTrieMain : classes/CompactTrieMain.class

classes/CompactTrieMain.class : src/CompactTrieMain.java classes/trie/CompactTrie.class
	javac -d classes -cp classes -sourcepath src src/CompactTrieMain.java

figure2 : classes/CompactTrieMain.class
	java -cp classes CompactTrieMain > test2.dot
	dot -Tpdf test2.dot -otest2.pdf

doc : src/trie/*.java
	cd src;\
	javadoc trie -d ../docs/trie
	
test1 : test/trie/*.java
	javac -classpath test-1.7.jar test/trie/TrieTest.java
	java -jar test-1.7.jar trie.TrieTest
	
test2 : test/trie/*.java
	javac -classpath test-1.7.jar test/trie/CompactTrieTest.java
	java -jar test-1.7.jar trie.CompactTrieTest
	
archiveExec : MainTrie
	jar cvfm MainTrie.jar manifestex docs test classes -C classes main
