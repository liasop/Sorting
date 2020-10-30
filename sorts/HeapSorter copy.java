/*
This class extends the sorter class and sorts an array using heapsort
@author Lia Chin-Purcell
@version 10/5/17
**/
import java.util.Scanner;
import java.util.InputMismatchException;

class Heapsort extends Sorter{

  /** Sorts the array using heap sort
  *   @param array the array to sort
  */
  public <E extends Comparable<E>> void sort(E[] array){
    E temp;
    makeheap(array, array.length);
    for(int i = array.length - 1; i >= 0; i--){
      temp = array[0];
      array[0] = array[i];
      array[i] = temp;

      sink(array, i, 1);
    }
  }

  private <E extends Comparable<E>> void makeheap(E[] array, int heapSize){
    if(heapSize > array.length){
      heapSize = array.length;
    }

    for(int i = heapSize / 2; i >= 0 ; i--){
      sink(array, heapSize, i);
    }

  }

  private static <E extends Comparable<E>> void sink(E[] array, int heapSize, int i){
    int largest, l, r;
    E temp;

    while(i <= heapSize){
      l = 2*i + 1;
      r = 2*i + 2;
      largest = i;

      if(l < heapSize && array[l].compareTo(array[largest]) > 0){
        largest = l;
      }
      if(r < heapSize && array[r].compareTo(array[largest]) > 0){
        largest = r;
      }

      if(largest != i){
        //swap
        temp = array[i];
        array[i] = array[largest];
        array[largest] = temp;

        i = largest;
      }
      else{
        break;
      }
    }
  }

  /**
  Main method
  */
  public static void main(String[] args){
    Heapsort hs = new Heapsort();
    Scanner sc = new Scanner(System.in);
    int arraySize = 0;

    System.out.println("testing heap sort.");
    while(true){
      try{
        System.out.println("please enter the array size:");
        arraySize = sc.nextInt();
        break;
      }
      catch(InputMismatchException exception){
        System.err.println("please print a number for the arraysize");
        sc.next();
        continue;
      }
    }
    int time = hs.timeSort(arraySize);
    System.out.println("Array of size " + arraySize + "took " + time + " ms to sort.");
  }
}
