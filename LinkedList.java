// Miguel Angel Felix Pacheco
// Chpt4 PA

public class LinkedList {
    
    // Node inner class representing a node in the linked list
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Head of the linked list
    private Node head;
    
    // Constructor to initialize an empty list
    public LinkedList() {
        head = null;
    }
    
    // Method to display the linked list
    public void display() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Method to append a node with the given data to the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    // Method to prepend a node with the given data to the beginning of the list
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    // Method to insert a node with the given data after a specified node
    public void insertAfter(Node prevNode, int data) {
        if(prevNode == null) {
            System.out.println("Previous node is null.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }
    
    // Method to remove the head node from the list
    public void removeHead() {
        if(head != null) {
            head = head.next;
        }
    }
    
    // Method to remove the node after a given node
    public void removeAfter(Node node) {
        if(node != null && node.next != null) {
            node.next = node.next.next;
        }
    }
    
    // Method to search for a node with the specified data; returns the node if found, else returns null
    public Node search(int data) {
        Node current = head;
        while(current != null) {
            if(current.data == data)
                return current;
            current = current.next;
        }
        return null;
    }
    
    // Method to sort the linked list in ascending order using bubble sort
    public void sort() {
        if(head == null || head.next == null) return;
        boolean swapped;
        do {
            Node current = head;
            Node prev = null;
            Node next = head.next;
            swapped = false;
            while(next != null) {
                if(current.data > next.data) {
                    // Swap current and next nodes
                    if(prev == null) { // Swapping involves the head node
                        current.next = next.next;
                        next.next = current;
                        head = next;
                        prev = next;
                    } else {
                        prev.next = next;
                        current.next = next.next;
                        next.next = current;
                        prev = next;
                    }
                    swapped = true;
                } else {
                    prev = current;
                    current = next;
                }
                next = current.next;
            }
        } while(swapped);
    }
    
    // Method that sums the data values of each node and returns the sum as an int.
    public int sumDataValues() {
        int sum = 0;
        Node current = head;
        while(current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
    
    // Main method to execute the list operations as specified in the assignment.
    public static void main(String[] args) {
        // Create a new LinkedList instance
        LinkedList list = new LinkedList();
        
        // Display the initial (empty) list
        System.out.println("Initial list:");
        list.display();
        
        // Sum and display the sum of node values in the empty list (should be 0)
        System.out.println("Sum of node values: " + list.sumDataValues());
        
        // Append nodes with data values 10 and 20 to the linked list
        list.append(10); // List: 10
        list.append(20); // List: 10 -> 20
        
        // Prepend a node with data value 30 to the linked list
        list.prepend(30); // List: 30 -> 10 -> 20
        
        // Insert a node with data value 40 after the head node (30)
        list.insertAfter(list.head, 40); // List: 30 -> 40 -> 10 -> 20
        
        // Insert a node with data value 50 at the end of the linked list
        list.append(50); // List: 30 -> 40 -> 10 -> 20 -> 50
        
        // Insert a node with data value 60 after the node with data value 10
        Node node10 = list.search(10);
        if (node10 != null) {
            list.insertAfter(node10, 60); // List becomes: 30 -> 40 -> 10 -> 60 -> 20 -> 50
        } else {
            System.out.println("Node with value 10 not found.");
        }
        
        // Insert a node with data value 70 after the node with data value 40
        Node node40 = list.search(40);
        if (node40 != null) {
            list.insertAfter(node40, 70); // List becomes: 30 -> 40 -> 70 -> 10 -> 60 -> 20 -> 50
        } else {
            System.out.println("Node with value 40 not found.");
        }
        
        // Display the list after all insertions
        System.out.println("List after insertions:");
        list.display();
        
        // Remove the head node
        list.removeHead(); // Removes 30. New head is 40.
        
        // Remove the node after the node with data value 70
        Node node70 = list.search(70);
        if (node70 != null) {
            list.removeAfter(node70); // Removes the node after 70 (which is 10)
        } else {
            System.out.println("Node with value 70 not found.");
        }
        
        // Display the list after removals
        System.out.println("List after removals:");
        list.display();
        
        // Search for the node with data value 50 and display if found or not found
        Node search50 = list.search(50);
        if (search50 != null) {
            System.out.println("Node with value 50 found.");
        } else {
            System.out.println("Node with value 50 not found.");
        }
        
        // Search for the node with data value 15 and display if found or not found
        Node search15 = list.search(15);
        if (search15 != null) {
            System.out.println("Node with value 15 found.");
        } else {
            System.out.println("Node with value 15 not found.");
        }
        
        // Sort the list and display the sorted list
        list.sort();
        System.out.println("Sorted list:");
        list.display();
        
        // Sum and display the sum of the node values after all operations
        System.out.println("Sum of node values: " + list.sumDataValues());
    }
}
