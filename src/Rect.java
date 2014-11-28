public class Rect {

    private int x0, y0, x1, y1;

    public Rect(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public long getArea() {
        int dx = x1 - x0;
        int dy = y1 - y0;
        return dx * dy;
    }

    public static Rect normalize(int x0, int y0, int x1, int y1) {
        int dx = x1 - x0;
        int dy = y1 - y0;
        if (dx < 0) {
            int temp = x0;
            x0 = x1;
            x1 = temp;
        }
        if (dy < 0) {
            int temp = y0;
            y0 = y1;
            y1 = temp;
        }
        return new Rect(x0, y0, x1, y1);
    }

    public static Rect getIntersection(Rect r0, Rect r1) {
        int xlow, xhigh, ylow, yhigh;
        // get x coordinates
        if (r1.x0 > r0.x0) {
            xlow = r1.x0;
        } else {
            xlow = r0.x0;
        }
        if (r1.x1 > r0.x1) {
            xhigh = r0.x1;
        } else {
            xhigh = r1.x1;
        }
        // get y coordinates
        if (r1.y0 > r0.y0) {
            ylow = r1.y0;
        } else {
            ylow = r0.y0;
        }
        if (r1.y1 > r0.y1) {
            yhigh = r0.y1;
        } else {
            yhigh = r1.y1;
        }
        return new Rect(xlow, ylow, xhigh, yhigh);
    }
}
