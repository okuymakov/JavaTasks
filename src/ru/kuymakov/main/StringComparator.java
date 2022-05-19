package ru.kuymakov.main;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        int count1, count2;
        count1 = count2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'a') {
                count1++;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == 'a') {
                count2++;
            }
        }
        
        return count1 - count2;
    }

}
