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
        String res = null;

        return res;
    }
}
