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
        int intersectionCount = 1;
        while (intersections.size() > 0) {
            List<Rect> tmp = new LinkedList<Rect>();
            for (int i = 0; i < intersections.size(); i++) {
                for (int j = i + 1; j < intersections.size(); j++) {
                    Rect r0 = intersections.get(i);
                    Rect r1 = intersections.get(j);
                    if (r0.equals(r1)) {
                        tmp.add(r0);
                    } else {
                        Rect intersection = Rect.getIntersection(r0, r1);
                        if (intersection.getArea() > 0) {
                            tmp.add(intersection);
                        }
                    }
                }
            }
            intersections = tmp;
            intersectionCount++;
        }

        // the max intersection count excludes the original layer, so add one to get the final result
        System.out.println(intersectionCount);
    }
}
