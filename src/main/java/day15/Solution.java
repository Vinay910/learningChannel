package day15;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class Solution {

	public static Node insert(Node head, int data) {

		Node new_node = new Node(data);
		//Node temp=head;
		if (head == null) {
			head = new_node;
		} else {
			while (head.next != null) {
				head = head.next;
			}
			if (head.next == null) {
				head.next =new_node;
			}
		}
		return head;

	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int N = sc.nextInt();

		while (N-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		display(head);
		sc.close();
	}
}
