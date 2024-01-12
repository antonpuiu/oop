package lab2.task3;

public class Polygon {
    private Point[] points;

    public Polygon() {
        this(0);
    }

    public Polygon(int n) {
        points = new Point[n];
    }

    public Polygon(float[] points) {
        this(points.length / 2);

        if (points.length % 2 != 0)
            throw new RuntimeException("Odd number of points");

        int point = 0;

        for (int i = 0; i < points.length - 1; i += 2)
            this.points[point++] = new Point(points[i], points[i+1]);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(points[0]);

        for (int i = 1; i < points.length; i++)
            builder.append(" " + points[i].toString());

        return builder.toString();
    }
}
