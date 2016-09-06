package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String pattern="abba";
        String str="dog cat cat dog";
        System.out.println(isSamePattern(pattern,str));
    }
    //Given a pattern and a string str,find if str follows the same pattern.
    //Notes:You may assume pattern contains only lowercase letters,and str contains lowercase letters
    //separated by a single space.
    public static boolean isSamePattern(String pattern,String str){
        String[] strs=str.split(" ");
        if(pattern.length()!=strs.length) return false;
        Map<Character,String> map=new HashMap<>();
        Set<String> keyedWords=new HashSet<>();             //注意要反查，容易漏掉此步
        for (int i = 0; i < pattern.length(); i++) {
            char c=pattern.charAt(i);
            if(!map.containsKey(c)){
                if(keyedWords.contains(strs[i])) return false;
                map.put(c,strs[i]);
                keyedWords.add(strs[i]);
            }else if(!map.get(c).equals(strs[i])){
                    return false;
            }
        }
        return true;
    }
}
