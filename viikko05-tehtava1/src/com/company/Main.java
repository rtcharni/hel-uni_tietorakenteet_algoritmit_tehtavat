package com.company;

public class Main {

    public static void main(String[] args) {
	    String sana = "saippuakauppias";
	    int a = 17;
	    int n = 931663099;

//	    long longTotal = 0;
//	    int intTotal = 0;
//        for (int i = 1; i <= sana.length(); i++) {
//            longTotal += (Math.pow(a, sana.length() - i)) * ((int)sana.charAt(i - 1));
//            intTotal  += (Math.pow(a, sana.length() - i)) * ((int)sana.charAt(i - 1));
//        }
//
//        System.out.println(longTotal);
//        System.out.println(intTotal);

	    long h = 0;
        for (int i = 0; i < sana.length(); i++) {
            h = (h * a + sana.charAt(i)) % n;
        }
        System.out.println(h);

//        h = 0
//        for i = 0 to k-1
//        h = (h*A+c[i])%N;
    }
}
