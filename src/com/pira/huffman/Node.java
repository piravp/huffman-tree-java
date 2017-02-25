package com.pira.huffman;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Node {
	public static ArrayList<Node> nodeList = new ArrayList<Node>();
	
	String nodeName;
	int frequency;
	Node current;
	Node leftChild=null;;
	Node rightChild=null;
	
	public Node(String s, int frequency){
		this.nodeName = s;
		this.frequency = frequency;
	}
	
	@Override
	public String toString(){
		return nodeName +  Integer.toString(frequency);
	}
	
	public static void printAllNodes(ArrayList<Node> listOfAllNodes){
		for (Node node : listOfAllNodes) {
			System.out.print(node + "  ");
		}
	}
	
	
	public static void sortNodes(ArrayList<Node> unsortedNodeList){
		Collections.sort(unsortedNodeList, new Comparator<Node>(){
		     public int compare(Node node1, Node node2){
		         if(node1.frequency == node2.frequency)
		             return 0;
		         return node2.frequency < node1.frequency ? -1 : 1;
		     }
		});
	}
	

	public static Node addNodes(Node n1, Node n2){
		return new Node(n1.nodeName + n2.nodeName, n1.frequency + n2.frequency);
	}

	// UNUSED!
	public static Node findSmallestNodes(ArrayList<Node> minList){
		return Collections.min(minList, new Comparator<Node>(){
		     public int compare(Node node1, Node node2){
		         if(node1.frequency == node2.frequency)
		             return 0;
		         return node2.frequency > node1.frequency ? -1 : 1;
		     }
		});
	}
	
	
	public static int[] findTwoSmallestNodes(ArrayList<Node> arrayList){
		int min1 = arrayList.get(0).frequency;
		int min2 = arrayList.get(1).frequency;
		int index1 = 0;
		int index2 = 1;
		int swap = 0;

		for (int i = 2; i < arrayList.size(); i++) {
		    int current = arrayList.get(i).frequency;
		    if (current < min1) {
		        swap = min1;
		        min1 = current;
		        current = swap;
		        index1 = i;
		    }
		    if (current < min2) {
		        swap = min2;
		        min2 = current;
		        current = swap;
		        index2 = i;
		    }

		}

		System.out.println("Second smallest node " + arrayList.get(index1).toString() + ", and smallest one: " + arrayList.get(index2).toString());
		
		//TODO: Cleanup, trenger strengt tatt bare indexen, og ikke selve verdiene
		return new int[]{index2, min2, index1, min1};	//{indexForSecondLeast, secondLeastValue} and {indexForSmallest, smallestValue}
										//index:                 0            ,         1         ,          2         ,       3
		
		//Source: https://stackoverflow.com/questions/19883788/removing-the-smallest-2-elements-in-an-arraylist-in-java
	}
	
	
	
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}


	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}
	
}
