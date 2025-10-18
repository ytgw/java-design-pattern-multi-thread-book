public class Line {
    private final Point startPoint;
    private final Point endPoint;

    public Line(int startX, int startY, int endX, int endY) {
        this.startPoint = new Point(startX, startY);
        this.endPoint = new Point(endX, endY);
    }

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getStartX() { return startPoint.getX(); }
    public int getStartY() { return startPoint.getY(); }
    public int getEndX() { return endPoint.getX(); }
    public int getEndY() { return endPoint.getY(); }

    public String toString() {
        return "[ Line: " + startPoint + "-" + endPoint + " ]";
    }
}
