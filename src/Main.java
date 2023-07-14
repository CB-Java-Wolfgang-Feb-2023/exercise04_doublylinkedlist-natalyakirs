public class Main {
    public static void main(String[] args) {
        DoublyLinkedListCustom list = new DoublyLinkedListCustom();
        //TODO test all methods
        // don't forget to also check the head and tail references

        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printList();

        list.removeFirst();
        list.printList();

        list.removeLast();
        list.printList();

        list.addAtIndex(3, 5);
        list.printList();

        list.addElementAtRandomIndex(6);
        list.printList();

        list.removeAtIndex(2);
        list.printList();

        list.getSize();



        list.printListBackwards();

        list.addFirst(2);
       // list.addFirst(3);
        list.printList();

        list.removeDuplicates();
        list.printList();

        list.reverseList();

        list.copyList();
        list.printList();

        list.insertAfter(7,1);
        list.printList();

        list.deleteKey(3);
        list.printList();

        list.clear();
        list.printList();
    }
}