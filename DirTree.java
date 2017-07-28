import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Satheesh Palani
 * Parses all the sub-nodes of the multi-node tree and prints their names in below format
 * Required Format:
 * --root
 *   --subdir1
 *     --subSubDir
 *       -innerFile
 *     --outerFile
 *   --subDir2
 *     --file
 *    
 */
// Input Tree:
//   10
//  / \ \
// 5   6  7
// /\  /\
// 4 3 1 9
// /
// 2

//Output for the above input Tree in a formatted Tree Structure:
//--10
//  --5
//    --4
//      --2
//    --3
//  --6
//    --1
//    --9
//  --7

public class DirTree {
	private List<DirTree> childNodes;
	private String name;
	private static int recLevel=0;
	
	// Getters and Setters
	public List<DirTree> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<DirTree> nodes) {
		this.childNodes = nodes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Recursive method to print all the tree nodes
	public void printTree(DirTree parent){
	
		if (parent == null)
			return;
		else
			printNode(parent.getName(), recLevel); // if the parent is not null, then print and proceed furter
		
		if(parent.getChildNodes() == null) // if no child then quit the recursion loop
			return;
		
		recLevel++; // if the parent has childNodes then increment the tree depth
		
		for(DirTree node : parent.getChildNodes())
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
		DirTree root = buildTree();
		System.out.println("Formatted Tree View:");
		root.printTree(root);
	}
	
	// It builds the above specified tree as in Line 18 to 25
	public static DirTree buildTree(){ // Build a sample Tree
		DirTree thirdLevelEle = new DirTree();
		thirdLevelEle.setName("2");
		thirdLevelEle.setChildNodes(null);
		
		List<DirTree> thirdLevelList = new ArrayList<>();
		thirdLevelList.add(thirdLevelEle);
		
		DirTree secondLevelLeft = new DirTree();
		secondLevelLeft.setName("4");
		secondLevelLeft.setChildNodes(thirdLevelList);
		
		DirTree secondLevelRight = new DirTree();
		secondLevelRight.setName("3");
		secondLevelRight.setChildNodes(null);
		
		DirTree secondLevelMidLeft = new DirTree();
		secondLevelMidLeft.setName("1");
		secondLevelMidLeft.setChildNodes(null);
		
		DirTree secondLevelMidRight = new DirTree();
		secondLevelMidRight.setName("9");
		secondLevelMidRight.setChildNodes(null);
		
		List<DirTree> secondLevelLeftList = new ArrayList<>();
		secondLevelLeftList.add(secondLevelLeft);
		secondLevelLeftList.add(secondLevelRight);
		
		DirTree firstLevelLeft = new DirTree();
		firstLevelLeft.setName("5");
		firstLevelLeft.setChildNodes(secondLevelLeftList);
		
		List<DirTree> secondLevelMidList = new ArrayList<>();
		secondLevelMidList.add(secondLevelMidLeft);
		secondLevelMidList.add(secondLevelMidRight);
		
		DirTree firstLevelMid = new DirTree();
		firstLevelMid.setName("6");
		firstLevelMid.setChildNodes(secondLevelMidList);
		
		DirTree firstLevelRight = new DirTree();
		firstLevelRight.setName("7");
		firstLevelRight.setChildNodes(null);
		
		List<DirTree> firstLevelList = new ArrayList<>();
		firstLevelList.add(firstLevelLeft);
		firstLevelList.add(firstLevelMid);
		firstLevelList.add(firstLevelRight);
		
		DirTree root = new DirTree();
		root.setName("10");
		root.setChildNodes(firstLevelList);
		
		return root;
	}
}
