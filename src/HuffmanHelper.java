import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
/**
 * This is a helper class. The constructor takes a string and creates a node for each unique string. 
 * @author Piraveen
 * 
 */
public class HuffmanHelper {
	// map consisting of uniqueString:frequency
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public HuffmanHelper(String s){
		String[] s_splitted = s.split("");
		ArrayList<String> sAsList = new ArrayList<String>(Arrays.asList(s_splitted));
		
		// create a map with string:frequency
		doCount(sAsList);
		
		Set<String> keySet = map.keySet();											// get the unique keys
		String[] uniqueKeys = keySet.toArray(new String[keySet.size()]);			// create an array
		

		

		//TODO: Function that creates all the nodes at once
		
		// create a node for each unique character then put into list
		for (String string : uniqueKeys) {
			int frequency = map.get(string);

			
			Node n = new Node(string, frequency);
			Node.nodeList.add(n);
			
		}
		
		// print all nodes available
		Node.printAllNodes(Node.nodeList);
		
		// sort nodes in descending order
		Node.sortNodes(Node.nodeList);
		System.out.println();
		Node.printAllNodes(Node.nodeList);
		
		System.out.println();
		System.out.println();
		System.out.println("------ \t HuffmanTree-class: -------");
	}
	
	


	// count occurrence of each letter
	public void doCount(ArrayList<String> liste){
		int j;
		
		for (int i = 0; i < liste.size(); i++) {
			// check if string already exists
			if(!map.containsKey(liste.get(i))){
				// check frequency of the given string
				j = Collections.frequency(liste, liste.get(i));	
				
				// underscore instead of blank space
				if(liste.get(i).equals(" "))
					map.put("_", j);	
				else
					map.put(liste.get(i), j);	// (char, frequency)
			}
			
		}

		
		//return map;
	}

	
}
