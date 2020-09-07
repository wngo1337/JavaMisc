import java.util.Iterator;
import java.util.LinkedList;

public class testLinkedList {
	public static void main(String[] args) {
		LinkedList<String> stringList = new LinkedList<String>();
		stringList.add("fk");
		stringList.add("Manny");
		stringList.add("that");
		stringList.add("stupid");
		stringList.add("POS");
		
		Iterator<String> my_iterator = stringList.iterator();
		while (my_iterator.hasNext()) {
			System.out.print(my_iterator.next() + " ");
		}
	}
}