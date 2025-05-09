package Arrays;

/**
 * Demo1(main) class to demonstrate the usage of the DynamicArray class.
 */
public class Demo1 {
    public static void main(String[] args) {

        // Initialize a new DynamicArray with initial capacity 5
        DynamicArray dynamicArray = new DynamicArray(5);

        // Add elements to the dynamic array
        dynamicArray.add("H");
        dynamicArray.add("A");
        dynamicArray.add("S");
        dynamicArray.add("I");
        dynamicArray.add("B");
        dynamicArray.add("A"); // Triggers internal resize if needed

        // Insert "X" at index 0
        dynamicArray.insert(0, "X");

        // PRINT ARRAY
        // Print the current contents of the dynamic array
        System.out.println(dynamicArray);

        // Delete the element "X" from the array
        dynamicArray.delete("X");

        // Print the array after deletion
        // No need to call toString() explicitly, it's invoked automatically
        System.out.println(dynamicArray);

        // Search for the element "S" and print the index
        System.out.println(dynamicArray.search("S"));

        // SIZE OF ARRAY
        // Print the current number of elements in the array
        System.out.println("Size: " + dynamicArray.size);

        // CAPACITY OF ARRAY
        // Print the current capacity of the underlying array
        System.out.println("Capacity: " + dynamicArray.capacity);

        // CHECK IF EMPTY
        // Print whether the array is empty
        System.out.println("Empty: " + dynamicArray.isEmpty());
    }
}
