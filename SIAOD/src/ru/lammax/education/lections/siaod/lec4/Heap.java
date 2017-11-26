package ru.lammax.education.lections.siaod.lec4;

import ru.lammax.education.lections.siaod.std.Sort;

import java.util.Arrays;

public class Heap<Key extends Comparable<Key>> {

   private int N = 0;
   private Comparable[] pq;

   public Heap(Comparable[] pq) {
      //lets make a safe copy
      this.pq = (Key[]) new Comparable[pq.length + 1];
      this.pq[0] = 0;
      for (int k = 0; k < pq.length; k++) {
         this.pq[k +1] = pq[k];
      }
      this.N = pq.length;
   }

   public void sort() {

      //make heap from any array, bottom-up method
      for (int k = N/2; k >= 1; k--) {
         sink(k);
      }

      //lets heap-sort it
      while (N > 1) {
         Sort.exch(pq, 1, N--);
         sink(1);
      }
   }

   private void sink(int k) {
      while (2*k <= N) {
         int j = 2*k;
         if (j < N && Sort.less(pq[j], pq[j+1])) j++;
         if (!Sort.less(pq[k], pq[j])) break;
         Sort.exch(pq, k, j);
         k = j;
      }
   }

   @Override
   public String toString() {
      //better to override for pleasant view
      return "Heap{" +
              "pq=" + Arrays.toString(pq) +
              '}';
   }
}
