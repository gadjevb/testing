package com.clouway.testing.task2;

public class ArrayMethods {

    public int getMinElement(int arr[]) throws NullPointerException { // returns the minimal element of the array
        int flag = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(flag > arr[i]){
                flag = arr[i];
            }
        }
        return flag;
    }

    public int getSumOfArrayElements(int arr[]) throws NullPointerException { // returns the sum of the elements in the array
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }

    public void printArray(int arr[]) throws NullPointerException { // prints all elements of the array
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public void sortArray(int arr[], int left, int right) throws NullPointerException {
        int temp = partition(arr,left,right);
        if(left < temp - 1){
            sortArray(arr,left,temp - 1);
        }
        if(temp < right) {
            sortArray(arr, temp, right);
        }
    }

    public void reverseArray(int arr[]) throws NullPointerException { // reversing the array
        int left = 0, right = arr.length - 1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private int partition(int mas[], int left, int right) throws NullPointerException { // partition and sorting in quickSort
        int i = left, j = right;
        int temp;
        int pos = mas[(left + right) / 2];
        while(i <= j){
            while(mas[i] < pos){
                i++;
            }
            while(mas[j] > pos){
                j--;
            }
            if(i <= j){
                temp = mas[i];
                mas[i] = mas[j];
                mas[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

}
