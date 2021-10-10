package com.greatelearning.driver;

import java.util.ArrayList;

public class LongestPath {
	
	static class Node {
		int data;
		Node left;
		Node right;
	}
	
	static Node newNode(int data) {
		Node temp = new Node();
		
		temp.data = data;
		temp.left = null;
		temp.right = null;
		
		return temp;
	}
	
	public static ArrayList<Integer> findlongestPath(Node root) {
		
		if(root == null) {
			ArrayList<Integer> output = new ArrayList <Integer>();
			return output;
		}
		//Recursive call on Right node
		ArrayList <Integer> rightNodeList = findlongestPath(root.right);
		
		//Recursive call on Left node
		ArrayList <Integer> leftNodeList = findlongestPath(root.left);
		
		//Check the size of the left and right nodes and add roots to respective list
		if(rightNodeList.size()<leftNodeList.size()) {
			leftNodeList.add(root.data);
		}
		else {
			rightNodeList.add(root.data);
		}
		//Check size of left and right node whichever is bigger return the List
		return (leftNodeList.size() > rightNodeList.size() ? leftNodeList:rightNodeList);
	}

	public static void main(String[] args) {
		//Add Values to the BST
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);
		
		//Call Method findLongestPath get the resultList
		ArrayList <Integer> resultList = findlongestPath(root);
		
		int resultListSize = resultList.size();
		//Print the Longest Path from the resultList
		System.out.print("Longest Path");
		for(int i=resultListSize-1;i>=0;i--) {
			System.out.print( " --> " + resultList.get(i));	
		}
	}
}
