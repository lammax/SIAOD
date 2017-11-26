package ru.lammax.education.lections.siaod.lec4;

import ru.lammax.education.lections.siaod.std.Sort;

public class MaxPQ<Key extends Comparable<Key>> {
   private Key[] pq;
   private int N = 0;

   public MaxPQ(int capacity) {
      pq = (Key[]) new Comparable[capacity + 1];
   }

   public boolean isEmpty() {
      return N == 0;
   }

   public void insert(Key x) {
      pq[++N] = x;
      swim(N);
   }

   public Key delMax() {
      Key max = pq[1];
      Sort.exch(pq, 1, N--);
      sink(1);
      pq[N+1] = null;
      return max;
   }

   private void swim(int k) {
      while (k > 1 && Sort.less(pq[k/2], pq[k])) {
         Sort.exch(pq, k, k/2);
         k = k/2;
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


}
