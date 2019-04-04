
public class Client {
	
	public static void main(String[] arg) {
		Trie trie = new Trie();
		trie.insert("jai");
		trie.insert("jayy");
		trie.insert("joy");
		trie.insert("jjjjjj");
		//trie.prettyPrint(trie.root);
		
		String key = "jay";
		System.out.println(key + " " + trie.search(key));

	}
}
