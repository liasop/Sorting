/*
This class extends the sorter class and sorts an array using quicksort
@author Lia Chin-Purcell
@version 10/5/17
**/
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

class QuickSorter extends Sorter{

  /*Sorts the array using quick sort
  @param array the array to sort
  */
  @Override
  public <E extends Comparable<E>> void sort(E[] array){
    partition(array, 0 , array.length);
  }

  private <E extends Comparable<E>> void partition(E[] array, int left, int right){
    int pivot = left;
    int i = left + 1;
    int j = right - 1;
    E temp;

    while(i <= j){
      while(i <= j && array[i].compareTo(array[pivot]) < 0){
        i++;
      }
      while(array[j].compareTo(array[pivot]) > 0 && j >= i){
        j--;
      }
      if(i <= j){
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        j--;
        i++;
      }
    }
    temp = array[pivot];
    array[pivot] = array[j];
    array[j] = temp;

    if(left < j){
      partition(array, left, j);
    }
    if(i < right){
      partition(array, j + 1, right);
    }
  }


  /**
  Main method
  */

  public static void main(String[] args){
    QuickSorter qs = new QuickSorter();
    Scanner sc = new Scanner(System.in);
    int arraySize = 0;

    System.out.println("testing quick sort.");
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
    int time = qs.timeSort(arraySize);
    System.out.println("Array of size " + arraySize + "took " + time + "ms to sort.");


  }

}
