public class DoubleNode<T> {
    private DoubleNode<T> next;
    private DoubleNode<T> prev;
    private T data;

    public DoubleNode() {
        this.next = null;
        this.prev = null;
        this.data = null;
    }

    public DoubleNode(T newData) {
        this.next = null;
        this.prev = null;
        this.data = newData;
    }

    public DoubleNode<T> getNext() {
        return this.next;
    }

    public DoubleNode<T> getPrev() {
        return this.prev;
    }

    public T getData() {
        return this.data;
    }

    public void setNext(DoubleNode<T> nextNode) {
        this.next = nextNode;
    }

    public void setPrev(DoubleNode<T> prevNode) {
        this.prev = prevNode;
    }

    public void setData(T newData) {
        this.data = newData;
    }
}

