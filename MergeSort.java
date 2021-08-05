package code;

import given.AbstractArraySort;

import java.lang.reflect.Array;

/*
 * Implement the merge-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 * You may need to create an Array of K (Hint: the auxiliary array). 
 * Look at the previous assignments on how we did this!
 * 
 */

public class MergeSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  // Add any fields here
  K[] auxArr;
  public MergeSort() {
    name = "Mergesort";
    // Initialize anything else here
  }

  @Override
  public void sort(K[] inputArray) {
    // TODO: Implement the merge-sort algorithm
   auxArr = (K[]) new Comparable[inputArray.length];
   mergeSort(inputArray,0,inputArray.length-1);
  }

  // Public since we are going to check its output!
  public void merge(K[] inputArray, int lo, int mid, int hi) {
    // TODO: Implement the merging
    int lotmp = lo;
    int midtmp = mid+1;
    int hitmp = hi;
    for(int i = lo;i<=hi;i++){
      auxArr[i]=inputArray[i];
    }
    int k = lo;

    while(k<=hi){
    if(lotmp<=mid && (midtmp>hi || compare((K)auxArr[lotmp],(K)auxArr[midtmp])<=0)){
      inputArray[k]=(K)auxArr[lotmp];
      lotmp++;
      k++;
    }else{
      inputArray[k]=(K)auxArr[midtmp];
      midtmp++;
      k++;
    }
    }
  }
  
  // Feel free to add more methods
  public void mergeSort(K[] inputArray, int lo, int hi){
    if(lo<hi) {
      int mid = (lo + hi) / 2;
      mergeSort(inputArray,lo,mid);
      mergeSort(inputArray,mid+1,hi);
      merge(inputArray,lo,mid,hi);
    }
  }
}
