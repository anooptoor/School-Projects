
public class BinaryTree {
	Node root;
	int level;
	
	public BinaryTree (Node root){
		this.root = root; 
		level = 0; 
	}
	public BinaryTree (Node root, int level){
		this.root = root; 
		this.level = level;
		
	}
	/**
	 * Searches for word in Binary Tree
	 * @param word
	 * @return
	 */
	public Node search(String word){
		
		
		if(this.isEmpty() == true){
			
			return new Node(new DictEntry("", "", -1), null,null);  // return empty node
			
		}
		String r = root.word();
		 
		if(r.compareTo(word)  == 0)
			return root; 
		else if(r.compareTo(word)  > 0){
			
			BinaryTree l = new BinaryTree(root.getLeft());
			 
			return l.search(word); 
			
		}
		else{
			BinaryTree l = new BinaryTree(root.getRight());
			return l.search(word); 
		}
		
		
	}
	/**
	 * adds entry into binary search tree
	 * @param word
	 * @param definition
	 * @param type
	 * @throws DictionaryException
	 */
	public void add(String word, String definition, int type) throws DictionaryException {
		DictEntry a = new DictEntry(word, definition, type); 
		Node b = new Node(a, null, null); 
		
		if(this.isEmpty() == true){
			
			root = b;
			return; 
			 
		}
		String r = root.word();
		if(r.compareTo(word)  == 0){
			throw new DictionaryException();
		}
			
		else if(r.compareTo(word)  > 0){
			
			if(root.getLeft().word() == ""){
				root.setLeft(b);  //sets to left if left is empty
				
			}
			else{
				BinaryTree l = new BinaryTree(root.getLeft());
				l.add(word, definition, type);  //grabs subtree and adds to subtree
			}
			
		}
		else{
			
			if(root.getRight().word() == ""){
				//System.out.println("1"); 
				root.setRight(b);  // sets to right if empty
				//System.out.println(root.getRight().word());
				
			}
			else{
				//System.out.println("2"); 
				BinaryTree l = new BinaryTree(root.getRight());
				l.add(word, definition, type); // travereses right subtree
			}
		}
		
	}
	/**
	 * checks if Binary Tree is empty
	 * @return
	 */
	private boolean isEmpty() {
		if(root == null){
			
			return true; 
		}
		
		else if(root.getLeft().word().equals("") && root.getRight().word().equals("") && root.word().equals("")){
			
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * complex algorithm that deletes word
	 * @param word
	 * @throws DictionaryException
	 */
	public void delete(String word) throws DictionaryException {
		String r = root.word();
		String rL = root.getLeft().word();
		String rR = root.getRight().word();
		int s = r.compareTo(word);
		int sL = rL.compareTo(word); 
		int sR = rR.compareTo(word);
		if(this.isEmpty() == true){
			throw new DictionaryException(); 
		}
		// if this its at this delete else traverse right
		else if(s == 0){
			BinaryTree lef = new BinaryTree(root.getLeft());
			BinaryTree  rig = new BinaryTree(root.getRight());
			if(lef.isEmpty() && rig.isEmpty()){
				root = new Node(new DictEntry("", "", 1), null, null); 
			}
			else{
				Node n = next(word); 
				root.setDictEntry(n.getDictEntry());
				BinaryTree l = new BinaryTree(root.getRight());
				l.delete(root.word());
			}
				
		}
		else if( s > 0){
			if(sL == 0){
				BinaryTree lef = new BinaryTree(root.getLeft().getLeft());
				BinaryTree  rig = new BinaryTree(root.getLeft().getRight());
				if(lef.isEmpty() && rig.isEmpty()){
					root.setLeft(new Node(new DictEntry("", "", 1), null, null)); 
				}
				else{
					Node n = next(word); 
					root.getLeft().setDictEntry(n.getDictEntry());
					BinaryTree l = new BinaryTree(root.getLeft().getRight());
					l.delete(root.getLeft().word());
				}
				
			}
			else{
				BinaryTree l = new BinaryTree(root.getLeft());
				l.delete(word); 
			}
			
		}
		else if( s < 0){
			if(sR == 0){
				BinaryTree lef = new BinaryTree(root.getRight().getLeft());
				BinaryTree  rig = new BinaryTree(root.getRight().getRight());
				if(lef.isEmpty() && rig.isEmpty()){
					root.setRight(new Node(new DictEntry("", "", 1), null, null)); 
				}
				else{
					Node n = next(word); 
					root.getRight().setDictEntry(n.getDictEntry());
					BinaryTree l = new BinaryTree(root.getRight().getRight());
					l.delete(root.getRight().word());
				}
			}
			else{
				BinaryTree l = new BinaryTree(root.getRight());
				l.delete(word); 
			}
			
		}
		
		
		
	}
	/**
	 * finds next word based on input
	 * @param word
	 * @return
	 */
	public Node next(String word) {
		
		int i;
		Node rootParent = new Node(new DictEntry("", "", 1), null, null);
		
		Node roo = root; 
		//System.out.print(roo.word());
		DictEntry d = roo.getDictEntry();
		
		while (d.word().equals("") == false)
		{
			//checks until null node
			
			i = d.word().compareTo(word);
			
			if( i < 1){
				roo = roo.getRight();
			}
			else if (i >= 1)
			{
				rootParent = roo;
				
				roo = roo.getLeft();
			}
			
			
			
			d = roo.getDictEntry();
		}
		if (rootParent.getDictEntry() == null){
			return new Node(new DictEntry("", "", 1), null, null);
		}
		return rootParent;
		
		
		
	}
	/**
	 * find the 'last' or preceding word
	 * @param word
	 * @return
	 */
	public Node last(String word) {
		int i;
		Node rootParent = new Node(new DictEntry("", "", 1), null, null);
		Node roo = root;
		DictEntry d = roo.getDictEntry();
		
		while (d.word().equals("")== false)
		{
			//checks until null node
			
			i = d.word().compareTo(word);
			if( i > -1){
				roo = roo.getLeft();
			}
			else if (i <= -1)
			{
				rootParent = roo;
				
				
				roo = roo.getRight();
			}
			
			
			
				d = roo.getDictEntry();
				
				
		}
		if (rootParent.getDictEntry() == null){
			return new Node(new DictEntry("", "", 1), null, null);
		}
		return rootParent;
		
	} 
	
	

}
