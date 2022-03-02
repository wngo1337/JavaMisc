/**
This class represents a linked list Node that contains a Word object and a reference to the next node
in the list.
*/

public class Node {
    private Word word;
    private Node next;

    public Node(Word word, Node next) {
        this.word = word;
        this.next = next;
    }

    public Word getWord() {
        return word;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
