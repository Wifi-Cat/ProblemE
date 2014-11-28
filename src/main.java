import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vance Miller on 11/28/2014.
 */
public class Main {
    public static void main(String[] args) {
        // not sure what the exact format of input is...
        Scanner sc = new Scanner(System.in);
        int numRects = sc.nextInt();
        Rect[] rects = new Rect[numRects];
        // read all the rects
        for (int i = 0; i < numRects; i++) {
            int x0 = sc.nextInt(), y0 = sc.nextInt(), x1 = sc.nextInt(), y1 = sc.nextInt();
            rects[i] = Rect.normalize(x0, y0, x1, y1);
        }

        // compute the intersection rectangles over each of these rectangles
        List<Rect> intersections = new LinkedList<Rect>();
        for (int i = 0; i < rects.length; i++) {
            for (int j = i + 1; j < rects.length; j++) {
                if (rects[i] == rects[j]) {
                    continue;
                }
                Rect intersection = Rect.getIntersection(rects[i], rects[j]);
                if (intersection.getArea() > 0) {
                    intersections.add(intersection);
                }
            }
        }

        // now find how many share the same intersections
        int[] intersectionCounts = new int[intersections.size()];

        // initialize to ones
        for (int i = 0; i < intersectionCounts.length; i++) {
            intersectionCounts[i] = 1;
        }
        // loop over all the rectangles
        for (Rect r0 : intersections) {
            for (Rect r1 : intersections) {
                if (r0 == r1) {
                    continue;
                }
                if (r0.equals(r1)) {
                    intersectionCounts[intersections.indexOf(r0)]++;
                }
            }
        }

        // find the max intersection count (if no intersections exist the loop will not run)
        int max = 0;
        for (int i = 0; i < intersectionCounts.length; i++) {
            if (max < intersectionCounts[i]) {
                max = intersectionCounts[i];
            }
        }
        // the max intersection count excludes the original layer, so add one to get the final result
        System.out.println(max + 1);
    }
}
