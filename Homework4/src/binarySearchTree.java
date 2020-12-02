import java.util.ArrayList;
import java.util.Collections;

public class binarySearchTree {
		public node root; 
		public int count; 
		public int singles; 
		public ArrayList<Integer> list;  
		public int startIndex; 

		public binarySearchTree() {
			root = null;
			list = new ArrayList<Integer>();
		}


		public void addNode(int n) {
			assert !found(n) : "This node with the value of " + n + " already exists"; // pre-condition

			// CREATE A TEMPORARY NODE
			node temp = new node(n);
			
			System.out.println("The node with value of " + n + " has been ADDED to the Binary Search Tree. ");
			
			// array list
			list.add(n);
			Collections.sort(list);
			System.out.println("Binary Search Tree Node Values: " + getList());
			
			count++;

			if (root == null) {
				root = temp;
			}


			else { 
				node trv = root; 
				while (true) { 
					// test 1: travel to the left
					if (temp.value < trv.value) { // if its less than the current root value
						if (trv.left != null) { // if there is something there run while loop again
							trv = trv.left;
						}

						else {

							trv.left = temp; // that spot is temp which is the new node
							break;
						}
					}

					// test 2: travel to the right

					else { // if the temp value is greater than the root

						if (trv.right != null) { // if there is something there run while loop again
							trv = trv.right;
						} else {
							trv.right = temp; // that spot is temp which is the new node
							break;
						}
					}
				}
			}

		

		}

		public void deleteNode(int num) {
			assert found(num) && !isEmpty() : "The node with the value of " + num + " doesn't exist"; 
			System.out.println("The node with value of " + num + " has been REMOVED to the Binary Search Tree. ");
			list.remove(Integer.valueOf(num)); 
			Collections.sort(list);
			System.out.println("Binary Search Tree Node Values: " + getList());

			node toBeRemoved = root;
			node parent = null;
			boolean found = false;
			count--;

		

			while (!found && toBeRemoved != null) {
				if (num == toBeRemoved.value) {
					found = true;
				} else {
					parent = toBeRemoved;
					if (num > toBeRemoved.value) {
						toBeRemoved = toBeRemoved.right;
					} else {
						toBeRemoved = toBeRemoved.left;
					}
				}
			}

			if (!found) {
				count++;
				System.out.println("Node isn't found !");
				return;
			}

			if (toBeRemoved.left == null || toBeRemoved.right == null) {
				node child;
				if (toBeRemoved.left == null) {
					child = toBeRemoved.right;
				} else {
					child = toBeRemoved.left;
				}

				if (parent == null) {
					root = child;
				} else if (parent.left == toBeRemoved) {
					parent.left = child;
				} else {
					parent.right = child;
				}
				return;
			}
			node smallestParent = toBeRemoved;
			node smallest = toBeRemoved.right;
			while (smallest.left != null) {
				smallestParent = smallest;
				smallest = smallest.left;
			}

			toBeRemoved.value = smallest.value;
			if (smallestParent == toBeRemoved) {
				smallestParent.right = smallest.right;
			} else {
				smallestParent.left = smallest.right;
			}

		}


		public void inOrderRecursive(node travel) {

			if (travel != null) {
				inOrderRecursive(travel.left);
				// System.out.println(travel.value);
				System.out.println(startIndex + ". " + travel.toString());
				startIndex++;
				inOrderRecursive(travel.right);
			}
		}


		public boolean isEmpty() {
			return root == null;
		}

		public boolean found(int num) { 
			node n = root;
			boolean found = false;


			while (!found && n != null) {
				if (num == n.value) {
					found = true; 
				} else {
					if (num > n.value) {
						n = n.right;
					} else {
						n = n.left;
					}
				}
			}

			if (!found) {
				return found; 
			}
			else {
				return found; 
			}
		}

		public void CountNodes() {
			System.out.println("Number of nodes: " + count);
		}

		public void countsingleParent(node trv) {

			if (trv != null) {

				countsingleParent(trv.left); 

				if ((trv.left == null && trv.right != null) || (trv.right == null && trv.left != null)) {
					singles++;
					System.out.println("singles parent node is: " + trv.toString());
				}
				countsingleParent(trv.right); 
			}
		}
		
		public void displayInOrder() { 
			assert !isEmpty() : "There are no nodes that exist";
			startIndex = 1;
			inOrderRecursive(root); 
		}

		// SETTERS AND GETTERS 

		/**
		 * @return the list
		 */
		public ArrayList<Integer> getList() {
			return list;
		}

		/**
		 * @param list the list to set
		 */
		public void setList(ArrayList<Integer> list) { 
			this.list = list;
		}
}
