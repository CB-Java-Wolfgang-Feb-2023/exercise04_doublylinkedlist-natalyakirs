public class Node {
    private int value; //stores data
    private Node next; // pointer to the next node
    private Node previous; // pointer to the previous node

    public Node(int value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}

