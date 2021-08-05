package code;

import given.AbstractArraySort;

/*
 * Implement the c algorithm here. You can look at the slides for the pseudo-codes.
 * You do not have to use swap or compare from the AbstractArraySort here
 * 
 * You may need to cast any K to Integer
 * 
 */

public class CountingSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  //Add any fields here
  
  public CountingSort()
  {
    name = "Countingsort";
  }
  
  @Override
  public void sort(K[] inputArray) {
    
    if(inputArray == null)
    {
      System.out.println("Null array");
      return;
    }
    if(inputArray.length < 1)
    {
      System.out.println("Empty array");
      return;
    }   
    
    if(!(inputArray[0] instanceof Integer)) {
      System.out.println("Can only sort integers!");
      return;
    }

    int min = (Integer)findMin(inputArray);
    int max = (Integer)findMax(inputArray);
    int[] countArr = new int[max-min+1];
    for(int i = 0 ; i< inputArray.length ; i++){
      countArr[(Integer) inputArray[i] - min] ++;
    }
    int counter = 0;

    for(int i = 0 ; i< countArr.length ; i++){
      for(int j = 0 ; j< countArr[i] ; j++){
        inputArray[counter] = (K)(Integer)(i + min);
        counter++;
      }
    }

    //TODO:: Implement the counting-sort algorithm here
  }
  protected K findMin(K[] inputArray){
    K min = inputArray[0];
    for(int i=0; i<inputArray.length ; i++){
      if(inputArray[i].compareTo(min) < 0){
        min = inputArray[i];
      }
    }
    return min;
  }
  protected K findMax(K[] inputArray){
    K max = inputArray[0];
    for(int i=0; i<inputArray.length ; i++){
      if(inputArray[i].compareTo(max) > 0){
        max = inputArray[i];
      }
    }
    return max;
  }
}
