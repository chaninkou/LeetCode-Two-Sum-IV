package leetcode653;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] input = {5,3,2,4,6,7};
		TreeNode root = new TreeNode(5);
		
		addTreeFromList(root, input);
		
		int target = 9;
		
		System.out.println("input: " + Arrays.toString(input) + " target: " + target);
		
		CheckIfTwoSumInBST solution = new CheckIfTwoSumInBST();
		
		System.out.println("Solution: " + solution.findTarget(root, target));
		
	}
	
	private static void addTreeFromList(TreeNode root, int[] input){
		for(int i = 0; i < input.length; i++){
			traverseAndAddNode(root, new TreeNode(input[i]));
		}
	}
	
	private static void traverseAndAddNode(TreeNode root, TreeNode nodeToAdd){		
		if(nodeToAdd.val < root.val){
			if(root.left == null){
				root.left = nodeToAdd;
			} else {
				traverseAndAddNode(root.left,nodeToAdd);
			}
		} else if (nodeToAdd.val > root.val){
			if(root.right == null){
				root.right = nodeToAdd;
			} else {
				traverseAndAddNode(root.right, nodeToAdd);
			}
		}
	}
}
