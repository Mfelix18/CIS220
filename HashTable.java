//Miguel Angel Felix Pacheco
//Chapter 6 Programming assigment 


// Class to represent the key-value pair (Item)
class Item {
    String key;  
    String value;  
    Item next;  

    // Constructor to initialize the key-value pair and set the next pointer to null
    public Item(String key, String value) {
        this.key = key;  
        this.value = value;  
        this.next = null;  
    }
}

// Class to represent a hash table 
class HashTable {
    private Item[] hashTable;  
    private int length;  

    // Constructor to initialize the hash table with a specified size
    public HashTable (int size) {
        this.length = size;  
        this.hashTable = new Item[length];  
    }

    // Hash method to get the index for a given key
    public int hash(String key) {
        int stringHash = 0;
        int multiplier = 13;

        for (int i = 0; i < key.length(); i++) {
            stringHash = stringHash * multiplier + key.charAt(i);
        }

        return stringHash;
    }

    // Method to Insert the specified key-value pair into the hash table
    public boolean hashInsert(String key, String value) {
        int bucketIndex = hash(key) % length;  

        Item currentItem = hashTable[bucketIndex];  
        Item previousItem = null;  

        while (currentItem != null) {  
            if (currentItem.key.equals(key)) {  
                currentItem.value = value;  
                return true;  
            }
            previousItem = currentItem;  
            currentItem = currentItem.next;
        }

        Item newItem = new Item(key, value);  
        if (hashTable[bucketIndex] == null) {  
            hashTable[bucketIndex] = newItem;  
        } else {
            previousItem.next = newItem;  
        }
        return true;  
    }

    // Method to search for the specified key and return the corresponding value
    public String hashGet(String key) {
        int bucketIndex = hash(key) % length;  
        Item item = hashTable[bucketIndex];  

        while (item != null) {  
            if (item.key.equals(key)) {  
                return item.value;  
            }
            item = item.next;  
        }

        return null;  
    }

    // Method to remove the key-value pair from the hash table
    public boolean hashRemove(String key) {
        int bucketIndex = hash(key) % length;  
        Item currentItem = hashTable[bucketIndex];  
        Item previousItem = null;  

        while (currentItem != null) {  
            if (currentItem.key.equals(key)) {  
                if (previousItem == null) {  
                    hashTable[bucketIndex] = currentItem.next;  
                } else {  
                    previousItem.next = currentItem.next;  
                }
                return true;  
            }
            previousItem = currentItem;  
            currentItem = currentItem.next;
        }

        return false;  
    }

    // Method to print the entire hash table, showing each bucket and its key-value pairs
    public void printTable() {
        for (int i = 0; i < length; i++) {  
            System.out.print("Bucket " + i + ": ");  
            Item currentItem = hashTable[i];  
            if (currentItem == null) {  
                System.out.println("empty");  
            } else {
                while (currentItem != null) {  
                    System.out.print("[" + currentItem.key + "=" + currentItem.value + ", hash=" + hash(currentItem.key) + "] ");
                    currentItem = currentItem.next;  
                }
                System.out.println();  
            }
        }
    }

    // Main method for testing the HashTable class
    public static void main(String[] args) {
        HashTable table = new HashTable(5);

        // Insert initial key-value pairs
        table.hashInsert("keyA1", "value1");
        table.hashInsert("keyB2", "value2");
        table.hashInsert("keyC3", "value3");
        table.hashInsert("keyD23", "value23");
        table.hashInsert("keyE45", "value45");
        table.hashInsert("keyF52", "value52");

        // Display hash table
        System.out.println("Hash Table Contents:");
        table.printTable();

        // Remove keyF52
        if (table.hashRemove("keyF52")) {
            System.out.println("keyF52 removed successfully.");
        } else {
            System.out.println("keyF52 not found.");
        }

        // Try to get non-existing key keyZ6
        String valueZ6 = table.hashGet("keyZ6");
        if (valueZ6 == null) {
            System.out.println("keyZ6 not found.");
        } else {
            System.out.println("keyZ6 = " + valueZ6);
        }

        // Get existing key keyC3
        String valueC3 = table.hashGet("keyC3");
        if (valueC3 == null) {
            System.out.println("keyC3 not found.");
        } else {
            System.out.println("keyC3 = " + valueC3);
        }

        // Insert more keys
        table.hashInsert("keyG18", "value18");
        table.hashInsert("keyH7", "value7");
        table.hashInsert("keyI33", "value33");

        // Update keyD23
        table.hashInsert("keyD23", "newvalue23");

        // Final table output
        System.out.println("Updated Hash Table Contents:");
        table.printTable();
    }
}