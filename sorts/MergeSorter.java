/*
This class extends the sorter class and sorts an array using mergesort
@author Lia Chin-Purcell
@version 10/5/17
**/
import java.util.Scanner;
import java.util.InputMismatchException;

class MergeSorter extends Sorter{

  /*Sorts the array using merge sort
  @param array the array to sort
  */
  @SuppressWarnings("unchecked")
  @Override
  public <E extends Comparable<E>> void sort(E[] array){
    E[] aux = (E[])new Comparable[array.length / 2];
    merge(array, aux, 0, array.length);
  }

  private <E extends Comparable<E>> void merge(E[] array, E[] aux, int left, int right){
    int mid = left + ((right - left) / 2);
    if(mid - left > 1){
      merge(array, aux, left, mid);
    }
    if(right - mid > 1){
      merge(array, aux, mid, right);
    }

    System.arraycopy(array, left, aux, 0, mid - left);
    int i = 0;
    int k = left;
    int j = mid;
    while(i < mid - left && j < right){
      if(aux[i].compareTo(array[j]) < 0){
        array[k] = aux[i];
        i++;
      }
      else{
        array[k] = array[j];
        j++;
      }
      k++;
    }
    while (i < mid - left){
      array[k] = aux[i];
      i++;
      k++;
    }

    while (j < right){
      array[k] = array[j];
      j++;
      k++;
    }
  }

  /**
  Main method
  */

  public static void main(String[] args){
    MergeSorter ms = new MergeSorter();
    Scanner sc = new Scanner(System.in);
    int arraySize = 0;

    System.out.println("testing merge sort.");
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

    int time = ms.timeSort(arraySize);
    System.out.println("Array of size " + arraySize + " took " + time + "ms to sort.");
  }

}
