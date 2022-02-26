package com.leet_code.array;

/**
 * Given an array of integers nums, sort the array in ascending order.
 * https://leetcode.com/problems/sort-an-array/
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) return;

        int left = start;
        int right = end;
        int pivot = A[(start + end) / 2];
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
