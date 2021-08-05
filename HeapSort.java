package code;

import given.AbstractArraySort;

/*
 * Implement the heap-sort algorithm here. You can look at the slides for the pseudo-code.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class HeapSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  // Add any fields here

  public HeapSort() {
    name = "Heapsort";

    // Initialize anything else here
  }

  @Override
  public void sort(K[] inputArray) {
    // TODO: Implement the heap-sort algorithm
    heapify(inputArray);
    int k = inputArray.length-1;
    while(k>0){
    swap(inputArray,0,k);
    downheap(inputArray,0,k-1);
    k--;
    }
  }

  // Public since we are going to check its output!
  public void heapify(K[] inputArray) {
    // TODO: Heapify the array. See the slides for an O(n) version which uses
    for(int i = inputArray.length/2 ; i>=0 ; i--){
      downheap(inputArray,i,inputArray.length-1);
    }
  }
  
  // The below methods are given given as suggestion. You do not need to use them.
  // Feel free to add more methods

  protected void downheap(K[] inputArray, int i, int k) {
    // TODO: Implement the downheap method to help with the algorithm
    int leftChild = 2*i+1;
    int rightChild = 2*i+2;
    int maxElement = i;
    if(leftChild<=k && compare(inputArray[maxElement],inputArray[leftChild])<0){
      maxElement = leftChild;
    }
    if(rightChild<=k && compare(inputArray[maxElement],inputArray[rightChild])<0){
      maxElement = rightChild;
    }
    if(maxElement != i){
      swap(inputArray,maxElement,i);
      downheap(inputArray,maxElement,k);
    }
  }
}
