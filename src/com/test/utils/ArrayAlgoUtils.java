package com.test.utils;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayAlgoUtils {

    public static int reverseInt(int num){
        int reverseNum = 0;
        int localNum = num;
        while(localNum!=0){
            reverseNum = reverseNum * 10 + localNum % 10;
            localNum/=10;
        }
        return reverseNum;
    }

    public static boolean checkIfPalindrome(int palindrome) {
        int reversePalindrome = reverseInt(palindrome);
        return reversePalindrome == palindrome;
    }

    public static int removeDuplicatesFromSortedArray(int[] sortedArrWithDuplicates) {
            int mod = 1;
            for(int i = 0; i < sortedArrWithDuplicates.length - 1; i++){
                if(sortedArrWithDuplicates[i]!=sortedArrWithDuplicates[i+1]){
                    sortedArrWithDuplicates[mod++] = sortedArrWithDuplicates[i+1];
                }
            }
            for(int i = 0; i < mod; i++){
                System.out.print(sortedArrWithDuplicates[i] + " ");
            }
            System.out.println();
            //Arrays.stream(sortedArrWithDuplicates).forEach(System.out::print);
            return mod;
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] s1 = new int[26];
        for(char letter : s.toCharArray()){
            System.out.println("");
            s1[letter - 'a']++;
        }

        for(char letter : t.toCharArray()){
            if(s1[letter - 'a']==0) return false;
            if(s1[letter - 'a'] > 0) s1[letter - 'a']--;
        }
        return true;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> group = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        //Arrays.stream(strs).forEach(System.out::println);
        String[] sortedStr = strs.clone();
        for (String s : sortedStr) {
            char[] str_arr = s.toCharArray();
            Arrays.sort(str_arr);
            String sorted_str = new String(str_arr);

            if(map.containsKey(sorted_str)){
                map.get(sorted_str).add(s);
            }else{
                map.put(sorted_str, new ArrayList<>(Arrays.asList(s)));
            }

        }
        group.addAll(map.values());
        return group;

    }

    public static String topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //Populate hashmap - num : frequency
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        //max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        for(int key : map.keySet()){
            maxHeap.add(key);
        }

        int res[] = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = maxHeap.poll();
        }
        return String.valueOf(res);
    }

    public static void quickSort(int[] nums) {
       quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left < right){
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }



    }

    private static int partition(int[] array, int left, int right) {
        int pivot = right;
        //as right most value will be pivot
        right = right - 1;
        while(left <= right){
           if(array[left] > array[pivot]){
               int temp = array[left];
               array[left] = array[right];
               array[right] = temp;
               right--;
           }else{
               left++;
           }
        }
        //final swap of pivot such that left values < pivot < right values
        int temp = array[left];
        array[left] = array[pivot];
        array[pivot] = temp;
        return left;
    }

    public static void swap(final int[] arr, final int pos1, final int pos2){
        final int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static boolean isPalindrome(String s1) {
        char[] arr = s1.toLowerCase().toCharArray();
        int left = 0;
        int right = s1.length() - 1;
        while(left < right){
            if((Character.isLetterOrDigit(arr[left]) && Character.isLetterOrDigit(arr[right]))
                    && arr[left++] != arr[right--]){
                return false;
            }else if(!Character.isLetterOrDigit(arr[left])){
                left++;
            }else if(!Character.isLetterOrDigit(arr[right])){
                right--;
            }else{
                left++; right--;
            }
        }
        return true;
    }

    public static void sortColors(int[] nums) {
        int n = nums.length;
        //edge cases - if no element or one element, no need to sort
        if(n <= 1) return;
        int start = 0;
        int end = n - 1;
        int i = 0;

        while(start <= end && i <= end){
            //0's move to start
            if(nums[i] == 0){
                //no need to store val and start behind i and hence 0s
                nums[start++] = 0;
                i++;
            }else if(nums[i] == 2){
                //2's move to end
                //end may have some diff value, store to i
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
                //no i++ as end val set to i may have some diff val
            }else{
                //1's ignore - i.e. if 0/2 arranged at start/end, 1 will be middle
                i++;
            }
        }
    }

    public static void insertionSort(int[] arrToSort) {
        //left hand - single element, right hand - all other elements
        //compare right hand cards to left
        int right = 1;
        while(right < arrToSort.length){
            int left = right - 1;
            int key = arrToSort[right];
            while(left > 0 && arrToSort[left] > key){
                arrToSort[left + 1] = arrToSort[left];
                left--;
            }
            arrToSort[left + 1] = key;
            right++;
        }
    }

    public static void mergeSort(int[] arrToSort, int left, int right) {
        if(left >= right) return;
        int mid = right - left / 2;
        merge(arrToSort, left, mid, right);
        mergeSort(arrToSort, left, mid);
        mergeSort(arrToSort, mid + 1, right);
    }
// 2  1  4  6  9  7
    private static void merge(int[] arrToSort, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - left;
    }
}
