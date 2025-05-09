package Arrays;

public class DynamicArray {

    int size; // Number of elements currently in the array
    int capacity=10;// Initial capacity of the array (can be overridden)
    Object[] array;

    //Default or non-parameterized constructor
    public DynamicArray(){
        this.array=new Object[capacity];
    }
    //parametrized constructor
    public DynamicArray(int capacity){
        this.capacity=capacity;
        this.array=new Object[capacity];
    }
    //The methods
    //1) Add method (adds element at the end of the array)
    public void add(Object data){
        if(size>=capacity){
            grow();//if size is more than the actual capacity increase the capacity
        }
        array[size]=data;
        size++;
    }
    //2) insert method (inserts element at any position)
    public void insert(int index,Object data){
        if(size>=capacity){
            grow();
        }
        //we need to shift all the elements after the given index to the right to make room for the new data
        for(int i=size;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=data;
        size++;
    }
    //3) Delete method (Deletes the first occurrence of the specified element)
    public void delete(Object data){
        for(int i=0;i<size;i++)//iterate over the elements to search the data to be deleted
        {
            if(array[i]==data){
                //shift all the elements to the left
                for(int j=0;j<size-i-1;j++)
                {
                    array[i+j]=array[i+j+1];
                }
                array[size-1]=null;
                size--;
                if(size <= (int)(capacity/3)) {
                    shrink();
                }
                break;
            }
        }
    }
    //4) search method (Searches for an element and returns its index)
    public int search(Object data){
        for(int i = 0;i<size;i++){
            if (array[i] == data) {
                return i;
            }
        }
        return -1;
    }
    //5) grow method (Doubles the capacity of the array when it is full)
    private void grow(){
        int newCapacity=(int)(capacity*2);
        Object[] newArray=new Object[newCapacity];

        for(int i=0;i<size;i++){
            newArray[i]=array[i];
        }
        capacity=newCapacity;
        array=newArray;
    }
    //6) Shrink method (Reduces the capacity of the array by half when mostly empty)
    private void shrink(){
        int newCapacity=(int)(capacity/2);
        Object[] newArray=new Object[newCapacity];

        for(int i=0;i<size;i++){
            newArray[i]=array[i];
        }
        capacity=newCapacity;
        array=newArray;
    }
    //7) isEmpty method (Checks if the array is empty)
    public boolean isEmpty(){
        return size==0;
    }

    //8) toString method (Returns a string representation of the array contents)
    public String toString(){
        String string = "";

        for(int i=0;i<capacity;i++){
            string += array[i] + ", ";
        }
        if(string != ""){
            string = "[ "+ string.substring(0,string.length()-2)+ " ]";
        }
        else{
            string="[]";
        }
        return string;
    }
}

