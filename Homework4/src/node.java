
public class node {
	// DATA MEMBERS: BINARY TREES HAVE A LEFT AND A RIGHT
		public Integer value;
		public node left;
		public node right;

		// EXPLICIT CONSTRUCTOR
		public node(int n) {
			value = n;
			left = null;
			right = null;
		}

		public String toString() { // when you print the objects
			return "Node value of: " + value + "";
		}
}
