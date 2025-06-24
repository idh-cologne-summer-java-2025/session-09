package SearchTrees;

import java.util.Comparator;

/**
 * Generischer Binär-Suchbaum für beliebige vergleichbare Objekte
 */
public class BinaryTree<T extends Comparable<T>> {

	/**
	 * Innere Klasse für die Knoten
	 */
	class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		T value;

		BinaryTreeNode(T value) {
			this.value = value;
		}

		boolean addValue(T newValue) {
			int cmp = compare(newValue, this.value);
			if (cmp == 0) {
				return false; // Wert bereits vorhanden
			} else if (cmp < 0) {
				if (left == null) {
					left = new BinaryTreeNode(newValue);
					return true;
				} else {
					return left.addValue(newValue);
				}
			} else {
				if (right == null) {
					right = new BinaryTreeNode(newValue);
					return true;
				} else {
					return right.addValue(newValue);
				}
			}
		}

		void printInOrder() {
			if (left != null)
				left.printInOrder();
			System.out.println(value + " ");
			if (right != null)
				right.printInOrder();
		}

		boolean contains(T searchValue) {
			int cmp = searchValue.compareTo(value);
			if (cmp == 0) {
				return true;
			} else if (cmp < 0) {
				return (left != null) && left.contains(searchValue);
			} else {
				return (right != null) && right.contains(searchValue);
			}
		}
	}

	private BinaryTreeNode root;

	public boolean addValue(T value) {
		if (root == null) {
			root = new BinaryTreeNode(value);
			return true;
		} else {
			return root.addValue(value);
		}
	}

	public boolean contains(T value) {
		return root != null && root.contains(value);
	}

	public void printInOrder() {
		if (root != null) {
			root.printInOrder();
		} else {
			System.out.println("(leer)");
		}
	}

	private Comparator<T> comparator;

	public BinaryTree() {
		this.comparator = null;
	}
	
	public BinaryTree(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@SuppressWarnings("unchecked")
    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        if (a instanceof Comparable<?> cmpA && b != null) {
            return ((Comparable<T>) cmpA).compareTo(b);
        }
        throw new IllegalArgumentException("Kein Comparator vorhanden und T ist nicht Comparable.");
    }
}
