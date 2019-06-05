package BackTracking.EightQueen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private static final int QUEEN_COUNT = 4;

    public static void main(String[] args) {

        Solution solution = new Solution();
        List<List<Point>> target = solution.generate();

        System.out.println(target.size());

        for (List<Point> pointList : target)
            System.out.println(pointList);

    }

    private List<List<Point>> generate() {
        List<List<Point>> target = new ArrayList<>();
        List<Point> selectedPoints = new ArrayList<>();
        generate(target, selectedPoints, 0);

        return target;

    }

    private void generate(List<List<Point>> target, List<Point> selectedPoints, int index) {

        if (index >= QUEEN_COUNT) {
            target.add(new ArrayList<>(selectedPoints));
            return;
        }

        for (int i = 0; i < QUEEN_COUNT; i++) {
            Point point = new Point(index, i);
            if (checkIfValid(selectedPoints, point)) {
                selectedPoints.add(point);
                generate(target, selectedPoints, index + 1);
                selectedPoints.remove(point);
            }

        }
    }

    private boolean checkIfValid(List<Point> selectedPoints, Point p) {

        int x2 = p.getX();
        int y2 = p.getY();

        for (Point selectedPoint : selectedPoints) {

            int x1 = selectedPoint.getX();
            int y1 = selectedPoint.getY();

            if ((x1 == x2) || (y1 == y2) || Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                return false;
            }
        }

        return true;

    }

    class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
