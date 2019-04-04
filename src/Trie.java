import java.util.LinkedList;
import java.util.Queue;

public class Trie {
		
	private static class TrieNode{
		private final TrieNode[] childs;
		private final char val;
		boolean isEndOfWord;
		
		private TrieNode(char c) {
			childs = new TrieNode[26];
			for(int i=0;i<childs.length;i++) {
				childs[i] = null;
			}
			isEndOfWord = false;
			
			this.val = c;
		}
		
		private TrieNode addChild(char c) {
			TrieNode node = new TrieNode(c);
			childs[c-'a'] = node;
			return node;
		}
		
		private TrieNode getChild(char c) {
			return childs[c-'a'];
		}
		
		private boolean hasChild(char c) {
			return childs[c-'a'] != null;
		}
		
		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}
	
	public TrieNode root;
	
	public Trie() {
		root = new TrieNode(' ');
	}
	
	public void insert(String str) {
		TrieNode parent = root;
		for(int i=0;i<str.length();i++){
			if(parent.hasChild(str.charAt(i))) {
				parent = parent.getChild(str.charAt(i));
			}else {
				parent = parent.addChild(str.charAt(i));
			}
		}
		parent.isEndOfWord = true;
	}
	
	public boolean search(String key) {
		TrieNode current = root;
		for(int i =0;i<key.length();i++) {
			if(!current.hasChild(key.charAt(i))){
				return false;
			}
			current = current.getChild(key.charAt(i));
		}
		// Why can't I just live with key found and not the end of word?
		return current != null && current.isEndOfWord;
	}
	
	
	
	
	
	/**
	 * Utility method to print the tree.
	 * @param root
	 */
	public void prettyPrint(TrieNode root) {
		if(root == null) {
			return;
		}
		Queue<TrieNode> q = new LinkedList<TrieNode>();
		q.add(root);
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			TrieNode n = q.remove();
			sb.append(getNodePrintString(n));
			for(int i =0;i<n.childs.length;i++) {
				if(n.childs[i] != null) {
					q.add(n.childs[i]);
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	private String getNodePrintString(TrieNode node) {
			StringBuilder sb = new StringBuilder("Node[" + node.val + "] isEnd:" + node.isEndOfWord + " Childs: [" + node.childs[0]);
			for(int i=1;i<node.childs.length;i++) {
				sb.append(",");
				sb.append(node.childs[i]);
			}
			sb.append("]\n");
			return sb.toString();
	}
}
