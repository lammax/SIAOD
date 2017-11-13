package ru.lammax.education.lections.siaod.lec2.elementary_sorts;

import ru.lammax.education.lections.siaod.lec1.stacks.StackOfItems;

import java.util.Arrays;

public class ConvexHull {

   public StackOfItems<Point2D> convexHull(Point2D[] p) {

      int N = p.length;

      StackOfItems<Point2D> hull = new StackOfItems<>();

      Arrays.sort(p, Point2D.Y_ORDER);
      Arrays.sort(p, p[0].POLAR_ORDER);

      hull.push(p[0]);
      hull.push(p[1]);

      for (int i = 2; i < N; i++) {
         Point2D top = hull.pop();
         while (Point2D.ccw(hull.peek(), top, p[i]) <= 0) {
            top = hull.pop();
         }
         hull.push(top);
         hull.push(p[i]);
      }


      return hull;
   }


}
