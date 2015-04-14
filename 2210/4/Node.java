
public class Node {
	
	DictEntry d;
	Node left;
	Node right;
	public Node(DictEntry d, Node leftChild, Node rightChild)
	{
		
		this.d = d;
		this.left = leftChild;
		this.right = rightChild;
	}
	public Node(DictEntry d)
	{
		
		this.d = d;
		this.left = new Node(new DictEntry("", "", 1), null, null);
		this.right = new Node(new DictEntry("", "", 1), null, null);
	}
	public Node getLeft() {
		if(left == null){
			return new Node(new DictEntry("", "", 1), null, null);
		}
		return left;
	}
	public void setLeft(Node leftChild) {
		this.left = leftChild;
	}
	public Node getRight() {
		if(right == null){
			return new Node(new DictEntry("", "", 1), null, null);
		}
		return right;
	}
	public void setRight(Node rightChild) {
		this.right = rightChild;
	}
	public String word(){
		
		String a = d.word();
		return a;
		
		
	}
	public DictEntry getDictEntry() {
		return d;
	}
	public void setDictEntry(DictEntry d) {
		this.d = d;
	}
	public String defintion(){
		return d.defintion(); 
		
	}
	public int type(){
		return d.type(); 
	}
	
	
}
