# Huffman Tree
![Huffman tree figure](huffman.png)

This is an implementation of the Huffman tree in Java.
Still work to do (see to-do list). 

## Huffman
Huffman coding is a type of encoding that is used for lossless data compression. The secret lies in the ability to represent frequent characters with the fewest bits.  
[Read more about Huffman coding.](https://en.wikipedia.org/wiki/Huffman_coding) 

## How it works
* Given a string, the code will map each unique character with its frequency. 
* There will be created a node for each character. 
* The node will be sorted in descending order and the two nodes with the least frequency will be merged into a new node. 
* This will continue until there is only one node left. 
* You now have a Huffman tree.
* Backtrack from the top (where left is 0 and right is 1) 

## To-Do
* [x] Create Huffman tree
* [ ] Backtrack to find the encoding for each character
