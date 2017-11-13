package ru.lammax.education.lections.siaod.lec1.stacks;

import java.util.Iterator;

public class StackOfStringsIterator<Item> implements Iterable<Item> {

   private Node first = null;
   int size = 0;

   private class Node {
      Item item;
      Node next;
   }


   void push(Item item) {
      size++;
      Node oldFirst = first;
      first = new Node();
      first.item = item;
      first.next = oldFirst;
   }

   Item pop() {
      size--;
      Item item = first.item;
      first = first.next; //gc works here
      return item;
   }

   boolean isEmpty() {
      return first == null;
   }

   public Iterator<Item> iterator() { return new ListIterator();}

   private class ListIterator implements Iterator<Item> {
      private Node current = first;

      public boolean hasNext() { return current != null; }
      public void remove() {}
      public Item next() {
         Item item = current.item;
         current = current.next;
         return item;
      }
   }

}
