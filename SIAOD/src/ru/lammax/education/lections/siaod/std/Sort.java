package ru.lammax.education.lections.siaod.std;

import java.util.Random;

public class Sort {

   public static final int CUTOFF = 7;

   public static boolean less(Comparable v, Comparable w) {
      return v.compareTo(w) < 0;
   }

   public static void exch(Comparable[] a, int i, int j) {
      Comparable swap = a[i];
      a[i] = a[j];
      a[j] = swap;
   }

   public static void shuffle(Comparable[] a) {
      Random r = new Random();
      int N = a.length;
      for (int i = 0; i < N; i++) {
         int ri = r.nextInt(i + 1);
         Sort.exch(a, i, ri);
      }
   }

   public static boolean isSorted(Comparable[] a) {
      for (int i = 1; i < a.length; i++)
         if (less(a[i], a[i-1])) return false;
      return true;
   }

   public static boolean isSorted(Comparable[] a, int first, int last ) {
      for (int i = first+1; i < last+1; i++)
         if (less(a[i], a[i-1])) return false;
      return true;
   }

}
