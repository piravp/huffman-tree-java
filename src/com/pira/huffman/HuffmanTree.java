package com.pira.huffman;
import java.util.ArrayList;
import java.util.Stack;

public class HuffmanTree {
	public ArrayList<Node> duplicateList = new ArrayList<Node>();
	//Stack[] bitStack = new Stack[]{};	//TODO: Stack or Vector?
	Stack<Integer>[] bitStack;
	
	public HuffmanTree(){
		String s = "Mississippi River";
		s = s.toLowerCase();
		HuffmanHelper hh = new HuffmanHelper(s);
		//System.out.println(Node.nodeList.get(0));
		
		//Node addedNodes = Node.addNodes(Node.nodeList.get(0), Node.nodeList.get(1));
		//System.out.println(addedNodes.toString());
		
		
		//joinList();
		createHuffmanTree();
	}
	

	public void createHuffmanTree(){
		// initializing variables
		duplicateList = Node.nodeList;
		Node secondLeast=null;
		Node smallest=null;
		initBitStack();
		

		while(duplicateList.size()!=1){

			
			// returns index and min-values
			int[] result = Node.findTwoSmallestNodes(duplicateList);
			
			secondLeast    	= duplicateList.get(result[0]);	// changed from Node.nodeList to duplicateList (16:10)
			smallest		= duplicateList.get(result[2]);
			
			//temp
			System.out.println("Index of second smallest " + result[0] + ", smallest index: " + result[2]);
			
			Node newNode2 = Node.addNodes(secondLeast, smallest);
			
			secondLeast.setRightChild(newNode2);
			doLeft(result[0]);						// only guarantees that it's correct first round
			smallest.setLeftChild(newNode2);
			doRight(result[2]);						// only guarantees that it's correct first round
			
			//Node.nodeList.get(result[0]).setRightChild(newNode2); 	// belongs to change: changed from Node.nodeList to duplicateList (16:10)
			//Node.nodeList.get(result[2]).setLeftChild(newNode2);		// belongs to change: changed from Node.nodeList to duplicateList (16:10)
			
			//System.out.println("UNSORTED LIST:" );
			//Node.printAllNodes(duplicateList);
			//System.out.println("\nRight child to " + duplicateList.get(result[0]) + "(second least): " + duplicateList.get(result[0]).getRightChild());
			
			duplicateList.set(result[0], newNode2);
			duplicateList.remove(result[2]);
			
			
			
			// sorting needed to ensure that merging goes smoothly at next iteration
			Node.sortNodes(duplicateList);
			System.out.println("SORTED LIST:" );
			Node.printAllNodes(duplicateList);
			System.out.println("\n");
			
		}
		printtt();

	}
	
	public void doLeft(int index){
		
		bitStack[index].add(1);
		
	}
	
	public void doRight(int index){
		
		bitStack[index].add(0);
		
	}
	
	public void initBitStack(){
		bitStack = (Stack<Integer>[]) new Stack[Node.nodeList.size()];	
		
		for (int n = 0; n < bitStack.length; n++)
			bitStack[n] = new Stack<Integer>();
		
	}
	
	public void printtt(){
		for (int i = 0; i < bitStack.length; i++) {
			for (int j = 0; j < bitStack[i].size(); j++) {
				
			}
		}
		
		//System.out.println(bitStack[0].pop());
		
		
	}
	
	
	

	
}
