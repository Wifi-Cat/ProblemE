import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vance Miller on 11/28/2014. :PPPPPPPP
 * Sarah  rusty
 * maxdaum Gay Master lmao XD
 */

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numRects;

		while ((numRects = sc.nextInt()) != -1) {
			List<Rect> rects = new LinkedList<Rect>();

			// read all the rects
			for (int i = 0; i < numRects; i++) {
				int x0 = sc.nextInt(), y0 = sc.nextInt(), x1 = sc.nextInt(), y1 = sc
						.nextInt();
				rects.add(Rect.normalize(x0, y0, x1, y1));
			}

			// count layers
			int[] counts = new int[rects.size() * 4 * 2];

			for (int i = 0; i < rects.size(); i++) {
				// for the points in the outer rectangle
				Rect r0 = rects.get(i);
				Point p0 = r0.p0;
				Point p1 = r0.p1;
				Point[] tests = new Point[8];
				int index = 0;
				for (double dx = -0.5; dx < 1; dx += 1) {
					tests[index++] = new Point(p0.x + dx, p0.y);
					tests[index++] = new Point(p1.x + dx, p1.y);
				}
				for (double dy = -0.5; dy < 1; dy += 1) {
					tests[index++] = new Point(p0.x, p0.y + dy);
					tests[index++] = new Point(p1.x, p1.y + dy);
				}
				for (int j = 0; j < tests.length; j++) {
					// for each test point,
					Point test = tests[j];
					for (int k = 0; k < rects.size(); k++) {
						// count the number of rectangles that contain test
						Rect r1 = rects.get(k);
						if (r1.inRect(test)) {
							counts[i * 4 * 2 + j]++;
						}
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
		sc.close();
	}
}