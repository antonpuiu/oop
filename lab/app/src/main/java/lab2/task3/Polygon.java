package lab2.task3;

import utils.MainTask;

public class Polygon implements MainTask {
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
    public int getId() {
        return 2;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(points[0]);

        for (int i = 1; i < points.length; i++)
            builder.append(" " + points[i].toString());

        return builder.toString();
    }

    @Override
    public void main() {
        float[] numbers = {
            0, 1,
            3, 4,
            5, 6,
            1, 2
        };

        Polygon poly = new Polygon(numbers);

        System.out.println("Polygon: " + poly.toString());
    }
}
