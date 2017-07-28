import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Satheesh Palani
 * Computes the min/max values of a multi-node Tree
 */

// Sample Input:
//   8
//  /\ \
// 5  6  7
// /\  /\
// 4 3 2 9
// /
// 1

// Output for the above Input Tree:
// Min Tree Val: 1
// Max Tree Val: 9

public class MinMaxTree {
	
	private List<MinMaxTree> childNodes; // Tree has the list of child nodes
	private int nodeVal;                 // and has single integer value element
	
	private static int minVal = 0;  // static datastore to store min/max values across recursion calls
	private static int maxVal = 0;
	
	// Getters and Setters
	public List<MinMaxTree> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<MinMaxTree> nodes) {
		this.childNodes = nodes;
	}
	public int getNodeVal() {
		return nodeVal;
	}
	public void setNodeVal(int val) {
		this.nodeVal = val;
	}
	
	// Method to return the min value of parsed tree
	public int getMinTreeVal() {
		return minVal;
	}
	
	// Method to return the max value of parsed tree
	public int getMaxTreeVal() {
		return maxVal;
	}
	
	private static void initTree(int initVal){
		// The tree has now fully built, store the root element as 
		// min/max values before returning root
		minVal = initVal;
		maxVal = initVal;
	}
	
	// Entry point to the program. It builds the tree and prints all
	public static void main(String[] args){
		MinMaxTree root = MinMaxTree.buildTree();
		root.processTree(root); // process the tree and computes the min/max values
		
		System.out.println("Min & Max values of Multi-Node Tree:");
		System.out.println("Min Tree Val: "+root.getMinTreeVal());
		System.out.println("Max Tree Val: "+root.getMaxTreeVal());
	}
	
	// Recursive method to parse all nodes and computes min/max values accordingly
	public void processTree(MinMaxTree parent){
	
		if (parent == null)
			return;
		
		int tempVal = parent.getNodeVal(); // if the parent is not null, fetch the value
		
		// find the min and values for each node value
		if(tempVal < minVal)
			minVal = tempVal;
		if(tempVal > maxVal)
			maxVal = tempVal;
		
		if(parent.getChildNodes() == null) // if no child then quit the recursion loop
			return;
		
		// if parent has child-nodes then fetch child-nodes and 
		// call parseTree recursively for each childNode
		for(MinMaxTree node : parent.getChildNodes())
			processTree(node);
		
	}
	
	//  8
	//  /\ \
	// 5  6  7
	// /\  /\
	// 4 3 2 9
	// /
	// 1
	// This method builds the above specified sample tree
	public static MinMaxTree buildTree(){
		MinMaxTree thirdLevelEle = new MinMaxTree();
		thirdLevelEle.setNodeVal(1);
		thirdLevelEle.setChildNodes(null);
		
		List<MinMaxTree> thirdLevelList = new ArrayList<>();
		thirdLevelList.add(thirdLevelEle);
		
		MinMaxTree secondLevelLeft = new MinMaxTree();
		secondLevelLeft.setNodeVal(4);
		secondLevelLeft.setChildNodes(thirdLevelList);
		
		MinMaxTree secondLevelRight = new MinMaxTree();
		secondLevelRight.setNodeVal(3);
		secondLevelRight.setChildNodes(null);
		
		MinMaxTree secondLevelMidLeft = new MinMaxTree();
		secondLevelMidLeft.setNodeVal(2);
		secondLevelMidLeft.setChildNodes(null);
		
		MinMaxTree secondLevelMidRight = new MinMaxTree();
		secondLevelMidRight.setNodeVal(9);
		secondLevelMidRight.setChildNodes(null);
		
		List<MinMaxTree> secondLevelLeftList = new ArrayList<>();
		secondLevelLeftList.add(secondLevelLeft);
		secondLevelLeftList.add(secondLevelRight);
		
		MinMaxTree firstLevelLeft = new MinMaxTree();
		firstLevelLeft.setNodeVal(5);
		firstLevelLeft.setChildNodes(secondLevelLeftList);
		
		List<MinMaxTree> secondLevelMidList = new ArrayList<>();
		secondLevelMidList.add(secondLevelMidLeft);
		secondLevelMidList.add(secondLevelMidRight);
		
		MinMaxTree firstLevelMid = new MinMaxTree();
		firstLevelMid.setNodeVal(6);
		firstLevelMid.setChildNodes(secondLevelMidList);
		
		MinMaxTree firstLevelRight = new MinMaxTree();
		firstLevelRight.setNodeVal(7);
		firstLevelRight.setChildNodes(null);
		
		List<MinMaxTree> firstLevelList = new ArrayList<>();
		firstLevelList.add(firstLevelLeft);
		firstLevelList.add(firstLevelMid);
		firstLevelList.add(firstLevelRight);
		
		MinMaxTree root = new MinMaxTree();
		root.setNodeVal(8);
		root.setChildNodes(firstLevelList);
		
		// call the private static "initTree" method after Tree has been built
		// to init min/max values of Tree then return the root to the caller
		initTree(root.getNodeVal());
		return root;
	}
}
