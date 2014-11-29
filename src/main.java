package NotSewDifficult;

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
        int numRects;
        
        while ((numRects = sc.nextInt()) != -1) {
            List<Rect> rects = new LinkedList<Rect>();
            
            // read all the rects
            for (int i = 0; i < numRects; i++) {
                int x0 = sc.nextInt(), y0 = sc.nextInt(), x1 = sc.nextInt(), y1 = sc.nextInt();
                rects.add(Rect.normalize(x0, y0, x1, y1));
            }
            
            // compute the intersection rectangles over each of these rectangles
            List<Rect> intersections = new LinkedList<Rect>();
            for (int i = 0; i < rects.size(); i++) {
                Rect r0 = rects.get(i);
                for (int j = i + 1; j < rects.size(); j++) {
                    Rect r1 = rects.get(j);
                    // what do here?
                    Rect intersect = Rect.getIntersection(r0, r1);
                    if (intersect.getArea() > 0) {
                        intersections.add(intersect);
                    }
                }
            }
            
            // for each point in the input, check how many rectangles it's inside of
            int[] counts = new int[rects.size() * 4];
            for (int i = 0; i < counts.length; i++) {
                counts[i] = 1; // always at least one quilt piece down
            }
            for (int i = 0; i < rects.size(); i++) {
                Rect r0 = rects.get(i);
                for (int j = i + 1; j < rects.size(); j++) {
                    Rect r1 = rects.get(j);
                    if (r0.inRect(r1.p0)) {
                        counts[i * 2]++;
                    }
                    if (r0.inRect(r1.p1)) {
                        counts[i * 2 + 1]++;
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < counts.length; i++) {
                if (max < counts[i]) {
                    max = counts[i];
                }
            }
            System.out.println(max);
        }
    }
}