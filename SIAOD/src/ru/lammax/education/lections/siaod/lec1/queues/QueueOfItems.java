package ru.lammax.education.lections.siaod.lec1.queues;

public class QueueOfItems<Item> {

   private Node first, last;

   private class Node {
      Item item;
      Node next;
   }

   public QueueOfItems() {
   }

   void enqueue(Item item) {
      Node oldlast = last;
      Node last = new Node();
      last.item = item;
      last.next = null;
      if (isEmpty()) first = last;
      else oldlast.next = last;
   }

   Item dequeue() {
      Item item = first.item;
      first = first.next;
      if (isEmpty()) last = null;
      return item;
   }

   boolean isEmpty() {
      return first == null;
   }

}
