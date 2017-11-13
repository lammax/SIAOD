package ru.lammax.education.lections.siaod.lec2.elementary_sorts;

import ru.lammax.education.lections.siaod.std.Sort;

import java.util.Random;

public class ShuflleSort {

   public void shuffle(Comparable[] a) {
      Random r = new Random();
      int N = a.length;
      for (int i = 0; i < N; i++) {
         int ri = r.nextInt(i + 1);
         Sort.exch(a, i, ri);
      }
   }

}
