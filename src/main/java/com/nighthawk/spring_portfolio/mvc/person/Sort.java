package com.nighthawk.spring_portfolio.mvc.person;

import java.util.ArrayList;

public class Sort {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[temp];
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for(int j = low; j <= high-1; j++) {
            if (arr[j]<pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return (i+1);
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partInd = partition(arr, low, high);
            quickSort(arr, low, partInd-1);
            quickSort(arr, partInd+1, high);
        }
    }
}
