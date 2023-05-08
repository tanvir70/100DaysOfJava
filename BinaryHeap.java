package swe.Heap;

import java.util.ArrayList;

public class BinaryHeap {
    private ArrayList<Integer> heap; // created a arraylist to store the heap data

    public BinaryHeap() {
        heap = new ArrayList<>(); //initialize the heap through constructor
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int peek() {
        if (heap.isEmpty()) {
            return -1;
        }
        return heap.get(0); // Min heap, return the 0th index , the root which is the minimum value in the heap.
    }

    public int remove() {
        if (heap.isEmpty()) {
            return -1;
        }

        int theMinValue = heap.get(0); // heap so it remove in the root , the min value will be removed
        int lastIndex = heap.size() - 1; // getting the size of heap so that we can track the last index
        heap.set(0, heap.get(lastIndex)); // when root is removed , the last item of the heap replace the root
        heap.remove(lastIndex); // removing the last index , because we put the last index value in the root

        heapifyDown(0); // we have changed the root, we need to check if the heap is in its structure or not
        return theMinValue;
    }

    public void add(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1); // we add a value in the last of the heap, we need to check if the heap is in its structure or not
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2; // this is the formula to find the parent in heap

        while (index > 0 && heap.get(index) < heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapifyDown(int index){
        int smallest = index;
        int leftLeaf = 2 * index + 1;
        int rightLeaf = 2 * index + 2;

        if ( leftLeaf < heap.size() && heap.get(leftLeaf) < heap.get(smallest)){
            smallest = leftLeaf;
        }

        if ( rightLeaf < heap.size() && heap.get(rightLeaf) < heap.get(smallest)){
            smallest = rightLeaf;
        }

        if ( smallest != index){
            swap(index,smallest);
            heapifyDown(smallest);
        }
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        System.out.println(heap.isEmpty()); // true

        heap.add(100);
        heap.add(140);
        heap.add(40);

        System.out.println(heap.peek()); // 40
        System.out.println(heap.remove()); // 40
        System.out.println(heap.peek()); // 100
        System.out.println(heap.remove()); // 100

        System.out.println(heap.isEmpty()); // false
    }

}
