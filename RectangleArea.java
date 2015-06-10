/**
 * Created by yhf on 15/6/10.
 */

/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.

                         G,H 2 2
               E,F  -2 -2
      C,D 2 2
A,B -2 - 2
*/
public class RectangleArea {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C <= E || G <= A || D <= F || H <= B) {
            System.out.println(1);
            return (C - A) * (D - B) + (G - E) * (H - F);
        }

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }

    public static void main(String[] args) {
        int area = computeArea(0, 0, 0, 0, -1, -1, 1, 1);
    }
}
