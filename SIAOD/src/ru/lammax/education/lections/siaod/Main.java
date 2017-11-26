package ru.lammax.education.lections.siaod;

import ru.lammax.education.lections.siaod.lec1.stacks.ResizingArrayStackOfItems;
import ru.lammax.education.lections.siaod.lec1.stacks.StackOfStrings;
import ru.lammax.education.lections.siaod.lec2.elementary_sorts.InsertionSort;
import ru.lammax.education.lections.siaod.lec2.elementary_sorts.SelectionSort;
import ru.lammax.education.lections.siaod.lec2.elementary_sorts.ShellSort;
import ru.lammax.education.lections.siaod.lec3.MergeSort;
import ru.lammax.education.lections.siaod.lec4.Heap;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static boolean isOperand(String str)
    {
        return str.matches("[+\\-*/]");  //match a number with optional '-' and decimal.
    }

    public static Double makeEvaluation(Double first, Double second, Character operand) {
        Double res = 0d;
        switch (operand) {
            case '*':   res = first * second;
                        break;
            case '/':   res = first / second;
                        break;
            case '+':   res = first + second;
                break;
            case '-':   res = first - second;
                break;
            default:
                System.out.println("Unknown operand: " + operand);
        }
        return res;
    }

    private static void StackOfStrings(Scanner in, PrintStream out) {
        //to be or not to - be - - that - - - is
        StackOfStrings stack = new StackOfStrings();
        while(in.hasNext()) {
            String s = in.next();
            if ((s.equals("-"))) {
                out.print(stack.pop() + " ");
            } else {
                stack.push(s);
            }
        }
    }

    private static void Dijkstra(Scanner in, PrintStream out) {
    //        ( 1 + ( ( ( 2 + 3 ) * ( 4 * 5 ) ) * ( 9 / 3 ) ) )
    // = 301

        ResizingArrayStackOfItems<Double> stackVal = new ResizingArrayStackOfItems();
        ResizingArrayStackOfItems<Character> stackOper = new ResizingArrayStackOfItems();

        while(in.hasNext()) {
            String s = in.next();

            if ((s.equals("("))) {
                //do nothing
            } else if (isNumeric(s)) {
                stackVal.push(Double.parseDouble(s));
            } else if (isOperand(s)) {
                stackOper.push(s.charAt(0));
            } else if (s.equals(")")) {
                Double res = 0d;
                Double second = stackVal.pop();
                Double first = stackVal.pop();
                res = makeEvaluation(first, second, stackOper.pop());
                stackVal.push(res);
                System.out.println(res);
            }
        }
      out.println("Result = " + stackVal.pop());
    }

    private static Double[] getRandomArray(Scanner in) {
        int N = Integer.parseInt(in.next());
        Random r = new Random();

        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) a[i] = r.nextDouble();

        return a;
    }

    private static void Shell(Scanner in, PrintStream out) {

        Double[] a = getRandomArray(in);

        long currentMilliseconds = System.currentTimeMillis();
        ShellSort.sort(a);
        out.println(System.currentTimeMillis() - currentMilliseconds);

        for(int i = 0; i < a.length; i++ ) {
            out.println(a[i]);
        }
    }

    private static void Insertion(Scanner in, PrintStream out) {

        Double[] a = getRandomArray(in);

        long currentMilliseconds = System.currentTimeMillis();
        InsertionSort.sort(a);
        System.out.println(System.currentTimeMillis() - currentMilliseconds);

        for(int i = 0; i < a.length; i++ ) {
            out.println(a[i]);
        }
    }

    private static void Selection(Scanner in, PrintStream out) {

        Double[] a = getRandomArray(in);

        long currentMilliseconds = System.currentTimeMillis();
        SelectionSort.sort(a);
        System.out.println(System.currentTimeMillis() - currentMilliseconds);

        for(int i = 0; i < a.length; i++ ) {
            out.println(a[i]);
        }
    }

    private static void inOut(Scanner in, PrintStream out) {
        while(in.hasNext()) {
            out.println(in.next());
        }
    }

    private static void megreSort(Scanner in, PrintStream out){
        Double[] a = getRandomArray(in);

        long currentMilliseconds = System.currentTimeMillis();
        MergeSort.sort(a);
        System.out.println(System.currentTimeMillis() - currentMilliseconds);

        for(int i = 0; i < a.length; i++ ) {
            out.println(a[i]);
        }
    }

    private static void heapSort(Scanner in, PrintStream out){
        Double[] a = getRandomArray(in);
        out.println(Arrays.toString(a));

        long currentMilliseconds = System.currentTimeMillis();
        Heap<Double> h = new Heap(a);
        h.sort();
        out.println(System.currentTimeMillis() - currentMilliseconds);

        out.println(h.toString());
    }


    public static void main(String[] args) throws IOException {
        //to be or not to - be - - that - - - is
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

//        StackOfStrings(in, out);
//        megreSort(in, out);
        heapSort(in, out);

    }
}
