

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return makeBT(nums, 0, nums.length - 1);
    }

	private TreeNode makeBT(int[] nums, int begin, int end) {
		if(begin > end) return null;
		int maxIndex = getMaxIndex(nums, begin, end);
		TreeNode root = new TreeNode(nums[maxIndex]);
		root.left = makeBT(nums, begin, maxIndex - 1);
		root.right = makeBT(nums, maxIndex + 1, end);				
		return root;
	}

	private int getMaxIndex(int[] nums, int begin, int end) {
		int maxIndex = begin;
		for (int i = begin + 1; i <= end; i++) {
			if(nums[i] > nums[maxIndex])
				maxIndex = i;			
		}
		return maxIndex;
	}
}