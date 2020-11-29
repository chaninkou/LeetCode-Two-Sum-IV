package leetcode653;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CheckIfTwoSumInBST {
	// O(N) time and space
	// Use hashset to store all the node and check k - current node to check hashset.
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        return dfs(root, set, k);
    }
    
    private boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null){
            return false;
        }
        
        if(set.contains(k - root.val)) {
            return true;
        }
        
        set.add(root.val);
        
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
    
	// O(N) time and space
	// Use inorder to get sorted array from bst and go on
	public boolean findTarget2(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        
        inorder(root, nums);
        
        for(int i = 0, j = nums.size()-1; i<j;){
            if(nums.get(i) + nums.get(j) == k){
                return true;
            }
            
            if(nums.get(i) + nums.get(j) < k){
                i++;
            }
            else{
                j--;    
            }
        }
        return false;
    }
    
    private void inorder(TreeNode root, List<Integer> nums){
        if(root == null){
            return;
        }
        
        inorder(root.left, nums);
        
        nums.add(root.val);
        
        inorder(root.right, nums);
    }
}
