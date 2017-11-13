package ru.lammax.education.lections.siaod.lec3;

import ru.lammax.education.lections.siaod.lec2.elementary_sorts.InsertionSort;
import ru.lammax.education.lections.siaod.std.Sort;

public class MergeSort{

//   private static Comparable[] aux;

   private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
//      assert Sort.isSorted(a, lo, mid);
//      assert Sort.isSorted(a, mid+1, hi);

      int i = lo, j = mid + 1;

      for (int k = lo; k <= hi; k++) {
         if    (i > mid)                     aux[k] = a[j++];
         else  if (j > hi)                   aux[k] = a[i++];
         else if (Sort.less(a[j], a[i]))     aux[k] = a[j++];
         else                                aux[k] = a[i++];
      }

//      assert Sort.isSorted(aux, lo, hi);

   }

   private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

      if (hi <= lo + Sort.CUTOFF -1) {
         InsertionSort.sort(a);
         return;
      }

      if (hi <= lo) return;
      int mid = lo + (hi - lo) / 2;
      sort(aux, a, lo, mid);
      sort(aux, a, mid+1, hi);
//      if (!Sort.less(a[mid+1], a[mid])) return;
      //TODO: need to understand what happens here/ Doesn't work as in lecture given.
      merge(a, aux, lo, mid, hi);
   }

   public static void sort(Comparable[] a) {
      Comparable[] aux = new Comparable[a.length];
      for (int i = 0; i < a.length; i++)
         aux[i] = a[i];
      sort(a, aux, 0, a.length - 1);
   }

   public static void sortBU(Comparable[] a) {
      int N = a.length;
      Comparable[] aux = new Comparable[N];
      for (int sz = 1; sz < N; sz = sz+sz)
         for (int lo = 0; lo < N-sz; lo += sz+sz)
            merge(a, aux, lo, lo+sz+1, Math.min(lo+sz+sz-1, N-1));
   }

}