/*
This class extends the sorter class and sorts an array using insertion
@author Lia Chin-Purcell
@version 10/5/17
**/
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

class InsertionSorter extends Sorter{

  /*Sorts the array using insertion sort
  @param array the array to sort
  */
  @Override
  public <E extends Comparable<E>> void sort(E[] array){
    int spot;
    E key;
    for(int i = 1; i < array.length; ++i){
      key = array[i];
      spot = binarySearch(array, i, key);
      System.arraycopy(array, spot, array, spot + 1, i - spot);
      array[spot] = key;
      }
    }



  private <E extends Comparable<E>> int binarySearch(E[] array, int length, E e){
    int low = 0;
    int high = length;
    int middle = -1;

    while(high >= low){
      middle = (low + high) / 2;
      if(array[middle].compareTo(e) == 0){
        return middle;
      }
      else if(array[middle].compareTo(e) > 0){
        high = middle - 1;
      }
      else if(array[middle].compareTo(e) < 0){
        low = middle + 1;
      }
      }
      return low;
    }


  /**
  Main method
  */

  public static void main(String[] args){
    InsertionSorter is = new InsertionSorter();
    Scanner sc = new Scanner(System.in);
    int arraySize = 0;

    System.out.println("testing insertion sort.");
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
    int time = is.timeSort(arraySize);
    System.out.println("Array of size " + arraySize + "took " + time + "ms to sort.");
  }

}
