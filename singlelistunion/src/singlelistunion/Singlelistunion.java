/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlelistunion;

/**
 *
 * @author KHELLO
 */

public class Singlelistunion {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        LinkedList A = new LinkedList(); 
		LinkedList B = new LinkedList(); 
		LinkedList unin = new LinkedList(); 
		LinkedList intersecn = new LinkedList(); 

		/*create a linked lits 10->15->5->20 */
		A.push(6); 
		A.push(3); 
		A.push(1); 
		A.push(20); 
                A.push(7);

		/*create a linked lits 8->4->2->10 */
		B.push(2); 
		B.push(6); 
		B.push(8); 
		B.push(3); 
                B.push(5); 

		intersecn.getIntersection(A.head, B.head); 
		unin.getUnion(A.head, B.head); 
 

		System.out.println("Intersection List is"); 
		intersecn.printList(); 

		System.out.println("Union List is"); 
		unin.printList(); 
	} 

        // TODO code application logic here
    }
    
class LinkedList { 
	Node head; // head of list 

	/* Linked list Node*/
	class Node { 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	/* Function to get Union of 2 Linked Lists */
	void getUnion(Node headA, Node headB) 
	{ 
		Node t1 = headA, t2 = headB; 

		// insert all elements of list1 in the result 
		while (t1 != null) { 
			push(t1.data); 
			t1 = t1.next; 
		} 

		// insert those elements of list2 
		// that are not present 
		while (t2 != null) { 
			if (!isPresent(head, t2.data)) 
				push(t2.data); 
			t2 = t2.next; 
		} 
	} 

	void getIntersection(Node headA, Node headB) 
	{ 
		Node result = null; 
		Node t1 = headB; 

		// Traverse list1 and search each 
		// element of it in list2. 
		// If the element is present in 
		// list 2, then insert the 
		// element to result 
		while (t1 != null) { 
			if (isPresent(headB, t1.data)) 
				push(t1.data); 
			t1 = t1.next; 
		} 
	} 

	/* Utility function to print list */
	void printList() 
	{ 
		Node temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 

        
	/* Inserts a node at start of linked list */
	void push(int new_data) 
	{ 
		/* 1 & 2: Allocate the Node & 
				Put in the data*/
		Node new_node = new Node(new_data); 

		/* 3. Make next of new Node as head */
		new_node.next = head; 

		/* 4. Move the head to point to new Node */
		head = new_node; 
	} 

	/* A utilty function that returns true 
	if data is present in linked list 
	else return false */
	boolean isPresent(Node head, int data) 
	{ 
		Node t = head; 
		while (t != null) { 
			if (t.data == data) 
				return true; 
			t = t.next; 
		} 
		return false; 
        }
}

