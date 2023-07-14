import java.util.Random;

public class DoublyLinkedListCustom implements MyListInterface {
    private Node head;
    private Node tail;
    private int size;

    //TODO implement methods

    @Override
    public void addFirst(int item) {
        //Create a new node
        Node newNode = new Node(item);
        //Check if list is empty
        if(isEmpty()) {
            head = tail = newNode;
            // head will be pointing to previous element - null
            head.setPrevious(null);
            // tail will be pointing to the next element - null
            tail.setNext(null);
        } else {
            //add newNode at the beginning => head will be pointing to the previous node - newNode
            head.setPrevious(newNode);
            //newNode pointing to next node - head
            newNode.setNext(head);
            //newNode becomes now new head
            head = newNode;
        }
        size++;
        System.out.println("New node added first: " + item);
    }



    @Override
    public void addLast(int item) {
        //Create a new node
        Node newNode = new Node(item);
        //Check if list is empty
        if(isEmpty()) {
            head = tail = newNode;
            // head will be pointing to previous element - null
            head.setPrevious(null);
            // tail will be pointing to the next element - null
            tail.setNext(null);
        } else {
            //add new node at the end => tail will be pointing to the next node - newNode
            tail.setNext(newNode);
            //newNode pointing to previous node - tail
            newNode.setPrevious(tail);
            //newNode becomes now new tail
            tail = newNode;
        }
        size++;
        System.out.println("New node added last: " + item);
    }


    //Method to add an element at particular index
    //1. index is out of the boundaries
    //2. list is empty -> index must be 0, otherwise -> the node will be out of the boundaries
    //3. index = 0 -> insert before head
    //4. index = size -> insert after tail
    //5. general case
    @Override
    public void addAtIndex(int index, int item) {
        //Create a new node
        Node newNode = new Node(item);
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of the boundaries.");
        }

        else if (head == null) {
            head = newNode;
            tail = newNode;
            System.out.println("List is empty, the added node has index = 0.");

        } else if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            System.out.println("Since index = 0, the node was inserted before head.");

        } else if (index == size) {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
            System.out.println("Since index = size, the node was inserted after the tail.");

        } else {
            Node current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            if(current.getNext() != null) {
                current.getNext().setPrevious(newNode);
            }
            current.setNext(newNode);
            newNode.setPrevious(current);
            System.out.println("The node " + item + " was inserted at the index " + index);
        }
        size++;
    }


    @Override
    public void addElementAtRandomIndex(int value) {
        Node newNode = new Node(value);
        Random random = new Random();

        int index = random.nextInt(size+1);// +1 -> since random index can be the number after tail
        addAtIndex(index,value); //use previous function
    }


    //Method to remove first item
    //1. []
    //2. [1]
    //3. [1,2]
    @Override
    public Node removeFirst() {
        if(isEmpty()){
            throw new IllegalArgumentException("You can't remove first node from an empty list.");
        }
        else if(head == tail){
            head = tail = null;
            size = 0;
            System.out.println("The only node in the list was removed.");
        }else {
            head = head.getNext();
            System.out.println("The first node in the list was removed.");
        }
        size--;
        return null;
    }


    //Method to remove last item
    //1. []
    //2. [1]
    //3. [1,2,3]
    @Override
    public Node removeLast() {

        if(isEmpty()){
            throw new IllegalArgumentException("You can't remove last node from an empty list");
        }

        else if(head == tail) {
            head = tail = null;
            size = 0;
            System.out.println("The only node in the list was removed. The list is empty now.");

        }else {

            Node item = head;
            while (item.getNext() != tail) {
                item = item.getNext();
            }
            //remove link to last node
            item.setNext(null);
            //remove link to previous node
            item.setPrevious(tail);
            //set new tail
            tail = item;
            System.out.println("The last node in the list was removed.");
        }
        size--;
        return null;
    }



    @Override
    public Node removeAtIndex(int index) {
        Node item = head;

        if(isEmpty()){
            throw new IllegalArgumentException("You can't remove node at index from an empty list.");

        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of the boundaries.");

        } else if (index == 0) {
            removeFirst();
        } else if (index == size) {
            removeLast();
        } else {
            for (int i = 0; i < index-1; i++) {
                item = item.getNext();
            }
            Node removedNode = item.getNext();
            item.setNext(removedNode.getNext());
            if (removedNode.getNext()!= null) {
                removedNode.getNext().setPrevious(item);
            }
        }
        size--;
        return null;
    }

    @Override
    public int getSize() {
        System.out.println("The size of doubly linked list is " + size);
        return size;
    }




    @Override
    public boolean isEmpty() { //DONE!
        return head == null || tail == null;
    }


    @Override
    public void printList() {
        Node item = head;
        System.out.print("Double linked list: [ ");
        while (item != null) {
            System.out.print(item.getValue());
            if (item != tail ) {
                System.out.print(", ");
            }
            item = item.getNext();
        }
        System.out.println(" ] ");

    }

    @Override
    public void printListBackwards() {
        if (head == null) {
            System.out.println("[] : the list is empty.");
            return;
        }

        Node item = head;
        while (item.getNext() != null) {
            item = item.getNext();
        }

        System.out.print("Double linked list backwards: [");

        while (item != null) {
            System.out.print(item.getValue());
            if (item.getPrevious() != null) {
                System.out.print(", ");
            }
            item = item.getPrevious();
        }
         System.out.println("]");
    }

    @Override
    public int get(int index) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public void removeDuplicates() {
        if (head == null) {
            System.out.println("[] : the list is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            Node checkDuplicates = current.getNext(); // this node will be used to compare and remove duplicates

            while (checkDuplicates != null) {
                if (current.getValue() == checkDuplicates.getValue()) {// duplicate element found -> remove duplicate node
                    Node next = checkDuplicates.getNext();
                    System.out.println("The duplicated value was removed.");

                    if (checkDuplicates.getNext() != null) {
                        checkDuplicates.getNext().setPrevious(checkDuplicates.getPrevious());//update links to the next node,  if duplicate node was removed
                    }

                    if (checkDuplicates.getPrevious() != null) { //also update links to the previous node, if duplicate node was removed
                        checkDuplicates.getPrevious().setNext(checkDuplicates.getNext());
                    } else {
                        head = checkDuplicates.getNext(); //in case checkDuplicates has no previous node -> its head of the list
                    }
                    checkDuplicates = next; //continue loop after removung duplicate node/nodes
                } else {
                    checkDuplicates = checkDuplicates.getNext();//if current node is no duplicate -> move to the next node
                }
            }
            current = current.getNext();
        }
    }

    @Override
    public void reverseList() {
        if (head == null) {
            System.out.println("[] : the list is empty, impossible to reverse.");
            return;
        }
        if (head.getNext() == null) {
            System.out.println("The list has only one node, no need to reverse.");
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            Node next = current.getNext();
            current.setNext(previous);// change the next link of the current node to the prev
            current.setPrevious(next);// change the prev link of the current node to the next

            previous = current;
            current = next;// move to the next node
        }
        head = previous;// update the head links to the last node
        System.out.println("Reverse List was created ");
    }


    @Override
    public DoublyLinkedListCustom copyList() {

        DoublyLinkedListCustom newList = new DoublyLinkedListCustom();

        Node current = head;

        while (current != null) {
            newList.addFirst(current.getValue());
            current = current.getNext();
        }
        return newList;
    }

    @Override
    public void clear() {
        head = null;
        System.out.println("The List was cleared. The List now is empty: ");
    }

    @Override
    public boolean insertAfter(int key, int data) {
        Node newNode = new Node(data);

        Node current = head;

        while (current != null) {
            if (current.getValue() == key) {
                newNode.setNext(current.getNext());
                newNode.setPrevious(current);

                if (current.getNext() != null) {
                    current.getNext().setPrevious(newNode);
                }
                current.setNext(newNode);
                System.out.println("The node " + data+ " was successfully inserted after node " + key);
                return true;
            }
            current = current.getNext();
        }
        System.out.println("No node with value " + data + " was inserted after node " + key + " ,as node" + key +" is not part of the current List");

        return false;
    }

    @Override
    public Node deleteKey(int key) {
        Node current = head;

        while (current != null) {
            if (current.getValue() == key) {
                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                } else {
                    head = current.getNext(); // node to delete is the head
                }
                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                }
                System.out.println("Node with value " + key + " was deleted from the current List.");
                return current;
            }
            current = current.getNext();
        }
        System.out.println("No node with value " + key + " was deleted, as this node is not part of the current List.");
        return null;
    }
    }
