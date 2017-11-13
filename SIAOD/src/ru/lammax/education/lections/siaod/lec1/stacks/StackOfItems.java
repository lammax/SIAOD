package ru.lammax.education.lections.siaod.lec1.stacks;

import java.util.NoSuchElementException;

public class StackOfItems<Item> {

   private Node first = null;
   int size = 0;

   private class Node {
      Item item;
      Node next;
   }

   public Item peek() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      return first.item;
   }

   public void push(Item item) {
      size++;
      Node oldFirst = first;
      first = new Node();
      first.item = item;
      first.next = oldFirst;
   }

   public Item pop() {
      size--;
      Item item = first.item;
      first = first.next; //gc works here
      return item;
   }

   boolean isEmpty() {
      return first == null;
   }

}
