package SearchTrees;

public class StudiTreeDemo1 {

	public static void main(String[] args) {
		BinaryTree<Student> bt= new BinaryTree<Student>();
		bt.addValue(new Student("Kain Adamson", 1234567));
		bt.addValue(new Student("Abel Adamson", 1234568));
		bt.addValue(new Student("Debora Elonstochter", 1234565));
		bt.addValue(new Student("Jakob Isaakson", 1234584));
		bt.addValue(new Student("Maria Joachimtochter", 1234570));
		bt.addValue(new Student("Abel Adamson", 1234999));
		
		bt.printInOrder();
	}

}
