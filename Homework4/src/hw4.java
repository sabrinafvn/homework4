
public class hw4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TASK 1: INSTANTIATE A BINARY TREE

		binarySearchTree tree = new binarySearchTree();


		// TASK 2: ADD NODES TO THE BINARY TREE
		tree.addNode(6);
		tree.addNode(2);
		tree.addNode(3);
		tree.addNode(1);
		tree.addNode(8);
		tree.addNode(4);
		tree.addNode(15);
		tree.addNode(5);
		tree.addNode(11);
		tree.addNode(14);
		tree.addNode(9);
		tree.addNode(7);
		tree.addNode(12);
		tree.addNode(13);
		tree.addNode(15);

		// TASK 3: Display in Order

		System.out.println("Display the nodes in order: ");
		tree.displayInOrder();

		// TASK 4: Test Delete Node

		tree.deleteNode(3);
		System.out.println("Display the nodes in order: ");
		tree.displayInOrder();
		tree.deleteNode(12);

		System.out.println("Display the nodes in order: ");
		tree.displayInOrder();

	}
}
