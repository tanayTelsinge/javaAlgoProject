package com.test.utils;
import java.util.HashSet;
import java.util.Set;

public class StringAlgoUtils {
    public static boolean areAllUniqueChars(String str) {
        Set<Character> set = new HashSet<>();
        for(char c : str.toCharArray()){
            if(set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    public static String URLify(String stringWithSpaces, int trueLength) {
        //need to do inplace
        //string has additional space at end to accomodate char when %20 is added
        char[] arr = stringWithSpaces.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
           if(arr[i] == ' '){
               spaceCount++;
           }
        }

        int tempIndex = trueLength - 1;
        for(int i = arr.length - 1; i >=0; i--){
            if(arr[tempIndex] == ' ') {
               arr[i] = '0';
               arr[i - 1] = '2';
               arr[i - 2] = '%';
               i = i - 2;
            }else{
                arr[i] = arr[tempIndex];
            }
            tempIndex--;
        }


        return new String(arr);
    }
}
