import java.util.HashMap;

public class FindPairOfNums {

	public static void main(String[] args) {
		int [] nums = {0,1,1,2,3,3,4,4,5,5,7,6};
		int reqSum = 0; // pairs: 4,5 & 2,7 & 3,6
				
		// if the given nums are only single digits then use array of size 10 
		// for 0 to 9 nums to store the count. 
		// This solution assumes that the given array has any random nums
		System.out.println("### Finding pair of Numbers @ O(2N) ###");
		
		// Store each num instances in Map as <Num, Count> pair
		HashMap<Integer, Integer> flag = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			if(flag.containsKey(nums[i]))
				flag.put(nums[i], (flag.get(nums[i]))+1);
			else
				flag.put(nums[i], 1);
		}
		
		int currNum, targetNum=0;
		boolean pairFound=false;
		Integer count=0; // To fetch the num of hits per each number in the given input array
		for(int i=0; i<nums.length; i++){
			currNum = nums[i]; // Fetch the Current num
			targetNum = reqSum - currNum; // Find the required target number to get the reqSum
			if( (count=flag.get(targetNum)) != null ) { // check if the target is already in stored Map datastore
				
				// To handle zero special case, where sum=0 but array has {0,1,2}
				// the below will catch printing 0,0 pair
				if(count<=1 && currNum==targetNum)
					continue;
				
				// the target count is found, print the pair then remove the count instances of
				// currNum and targetNum so that duplicates shall be avoided
				// for instance, {3,4,5,4,6,7,5} Sum:9, output:{3,6, 4,5} - duplicate 4,5 ignored
				if(count>0){
					System.out.println("Pair of Nums:"+currNum + "," + targetNum);
					flag.remove(currNum);   // remove this and the below if you want to allow the duplicates
					flag.remove(targetNum);
					pairFound = true;
				}
			}
		}
		
		if(!pairFound)
			System.out.println("Warn: No Pair Found");
		
	}
}
