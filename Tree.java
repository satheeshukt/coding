import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Satheesh Palani
 * Tree parses all the sub-nodes and prints their names
 */

public class Tree {
	private List<Tree> childNodes;
	private String name;
	private static int recLevel=0;
	
	// Getters and Setters
	public List<Tree> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<Tree> nodes) {
		this.childNodes = nodes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Recursive method to print all the tree nodes
	public void printTree(Tree parent){
	
		if (parent == null)
			return;
		else
			printNode(parent.getName(), recLevel); // if the parent is not null, then print and proceed furter
		
		if(parent.getChildNodes() == null) // if no child then quit the recursion loop
			return;
		
		recLevel++; // if the parent has childNodes then increment the tree depth
		
		for(Tree node : parent.getChildNodes())
			printTree(node); // call the printTree recursively
		
		recLevel--; // Decrement so that the prev inc so that inc on the same level is cancelled
		
	}
	
	// Method to print a node at the given depth
	public void printNode(String name, int recLevel){
		for(int i=0; i<recLevel*2; i++){
			System.out.print(" ");
		}
		System.out.println("--"+name);
	}
	
	// Entry point to the program. It builds the tree and prints all
	public static void main(String[] args){
		Tree root = buildTree();
		root.printTree(root);
	}
	
	//  10
	//  /\ \
	// 5  6  7
	// /\  /\
	// 4 3 1 9
	// /
	// 2
	// It builds the above specified tree
	public static Tree buildTree(){ // Build a sample Tree
		Tree thirdLevelEle = new Tree();
		thirdLevelEle.setName("2");
		thirdLevelEle.setChildNodes(null);
		
		List<Tree> thirdLevelList = new ArrayList<>();
		thirdLevelList.add(thirdLevelEle);
		
		Tree secondLevelLeft = new Tree();
		secondLevelLeft.setName("4");
		secondLevelLeft.setChildNodes(thirdLevelList);
		
		Tree secondLevelRight = new Tree();
		secondLevelRight.setName("3");
		secondLevelRight.setChildNodes(null);
		
		Tree secondLevelMidLeft = new Tree();
		secondLevelMidLeft.setName("1");
		secondLevelMidLeft.setChildNodes(null);
		
		Tree secondLevelMidRight = new Tree();
		secondLevelMidRight.setName("9");
		secondLevelMidRight.setChildNodes(null);
		
		List<Tree> secondLevelLeftList = new ArrayList<>();
		secondLevelLeftList.add(secondLevelLeft);
		secondLevelLeftList.add(secondLevelRight);
		
		Tree firstLevelLeft = new Tree();
		firstLevelLeft.setName("5");
		firstLevelLeft.setChildNodes(secondLevelLeftList);
		
		List<Tree> secondLevelMidList = new ArrayList<>();
		secondLevelMidList.add(secondLevelMidLeft);
		secondLevelMidList.add(secondLevelMidRight);
		
		Tree firstLevelMid = new Tree();
		firstLevelMid.setName("6");
		firstLevelMid.setChildNodes(secondLevelMidList);
		
		Tree firstLevelRight = new Tree();
		firstLevelRight.setName("7");
		firstLevelRight.setChildNodes(null);
		
		List<Tree> firstLevelList = new ArrayList<>();
		firstLevelList.add(firstLevelLeft);
		firstLevelList.add(firstLevelMid);
		firstLevelList.add(firstLevelRight);
		
		Tree root = new Tree();
		root.setName("10");
		root.setChildNodes(firstLevelList);
		
		return root;
	}
}
