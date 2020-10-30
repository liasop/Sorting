/*
This class extends the sorter class and sorts an array using selectionsort
@author Lia Chin-Purcell
@version 10/5/17
**/
import java.util.Scanner;
import java.util.InputMismatchException;

class SelectionSorter extends Sorter{

  /** Sorts the array using selectionsort
  *   @param array the array to sort
  */
  public <E extends Comparable<E>> void sort(E[] array){
    int minIndex;
    E small;
    for(int i = 0; i < array.length - 1; i++){
      minIndex = i;
      for(int j = i + 1; j < array.length; j++){
        if(array[j].compareTo(array[minIndex]) < 0){
          minIndex = j;
        }
      }
      small = array[minIndex];
      array[minIndex] = array[i];
      array[i] = small;
    }
  }
  /**
  Main method
  */
  public static void main(String[] args){
    SelectionSorter ss = new SelectionSorter();
    Scanner sc = new Scanner(System.in);
    int arraySize = 0;

    System.out.println("testing selection sort.");
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
    int time = ss.timeSort(arraySize);
    System.out.println("Array of size " + arraySize + "took " + time + " ms to sort.");
  }

}
