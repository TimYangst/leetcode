package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
public class Solution {
	    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	      ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
	      if (root == null) return rst;
	      Stack<TreeNode> current = new Stack<TreeNode>();
	      Stack<TreeNode> next = null;
	      current.push(root);
	      int level = 0;
	      while (current.size() > 0)
	      {
	    	  next = new Stack<TreeNode>();
	    	  ArrayList<Integer> ele = new ArrayList<Integer>();
	    	  while (current.size() >0)
	    	  {
	    		  TreeNode node =  current.pop();
	    		  ele.add(node.val);
	    		  if (level % 2 == 0) {
	    			  if (node.left != null) next.push(node.left);
	    			  if (node.right != null) next.push(node.right);
	    		  } else 
	    		  {
	    			  
	    			  if (node.right != null) next.push(node.right);
	    			  if (node.left != null) next.push(node.left);
	    		  }
	    	  }
	    	  rst.add(ele);
	    	  level ++;
	    	  current = next;
	      }
	      return rst;
	    }
	}