package ru.lammax.education.lections.siaod.lec2.elementary_sorts;

import ru.lammax.education.lections.siaod.std.Sort;

public class ShellSort {

   public static void sort(Comparable[] a) {

      int N = a.length;

      int h = 1;
      while (h < N/3) h = 3*h + 1;

      while (h >= 1) {
         // h-sort the array
         for (int i = h; i < N; i++) {
            for (int j = i; j >= h && Sort.less(a[j], a[j-h]); j -= h)
               Sort.exch(a, j, j-h);
         }

         h = h/3;

      }

   }

}
