package NotSewDifficult;

public class Rect {
    
    public Point p0, p1;
    
    public Rect(int x0, int y0, int x1, int y1) {
        this.p0 = new Point(x0, y0);
        this.p1 = new Point(x1, y1);
    }
    
    public long getArea() {
        int dx = p1.x - p0.x;
        int dy = p1.y - p0.y;
        long area = dx * dy;
        if (dx < 0 && dy < 0) {
            return -area;
        } else {
            return area;
        }
    }
    
    public boolean equals(Rect r) {
        return this.p0.x == r.p0.x && this.p0.y == r.p0.y && this.p1.x == r.p1.x && this.p1.y == r.p1.y;
    }
    
    @Override
    public String toString() {
        return "(" + p0.x + ", " + p0.y + ") (" + p1.x + ", " + p1.y + ")";
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
    
    public static int getArea(Point p1, Point p2) {
        return (p2.x - p1.x) * (p2.y - p1.y);
    }
    
    /**
     * Tests if point p is inside of this rectangle, including the edges
     * @param p
     * @return
     */
    public boolean inRect(Point p) {
        if (Rect.getArea(p, p1) < 1)// do they touch only at a corner?
            return false;
        return p0.x <= p.x && p.x <= p1.x && p0.y <= p.y && p.y <= p1.y;
    }
}