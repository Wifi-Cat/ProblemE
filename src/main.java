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
            // keep doing this until there are no rectangles left
            int thickestLayer = 0;
            while (rects.size() > 0) {
                List<Rect> tmp = new LinkedList<Rect>();
                for (int i = 0; i < rects.size(); i++) {
                    for (int j = i + 1; j < rects.size(); j++) {
                        Rect r0 = rects.get(i);
                        Rect r1 = rects.get(j);
                        if (r0.equals(r1)) {
                            continue;
                        }
                        // what do here?
                        Rect intersect = Rect.getIntersection(r0, r1);
                        if (intersect.getArea() > 0) {
                            tmp.add(intersect);
                        }
                    }
                }
                rects = tmp;
                thickestLayer++;
            }

            System.out.println(thickestLayer);
        }
    }
}
