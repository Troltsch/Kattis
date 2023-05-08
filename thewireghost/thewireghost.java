package Kattis.thewireghost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class thewireghost {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public enum Direction {
        Up,
        Right,
        Down,
        Left
    }

    public static Direction changeDirection(Direction currentDirection, char c) {

        switch (currentDirection) {

            case Down:
                if (c == 'C')
                    return Direction.Right;
                else
                    return Direction.Left;
            case Up:
                if (c == 'C')
                    return Direction.Left;
                else
                    return Direction.Right;

            case Left:
                if (c == 'C')
                    return Direction.Down;
                else
                    return Direction.Up;
            case Right:
                if (c == 'C')
                    return Direction.Up;
                else
                    return Direction.Down;
        }
        return null;
    }

    public static Point getNextPoint(Point currentPoint, long length, Direction currentDirection) {
        switch (currentDirection) {
            case Down:
                return new Point(currentPoint.x, currentPoint.y - length);
            case Up:
                return new Point(currentPoint.x, currentPoint.y + length);
            case Right:
                return new Point(currentPoint.x + length, currentPoint.y);
            case Left:
                return new Point(currentPoint.x - length, currentPoint.y);
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        String[] lineTokens = br.readLine().split(" ");
        long L = Long.parseLong(lineTokens[0]);
        long n = Long.parseLong(lineTokens[1]);

        var instructions = new ArrayList<Instruction>();
        for (int i = 0; i < n; ++i) {
            lineTokens = br.readLine().split(" ");
            long pos = Long.parseLong(lineTokens[0]);
            char d = lineTokens[1].charAt(0);

            Instruction instruction = new Instruction(pos, d);
            instructions.add(instruction);
        }

        Collections.sort(instructions, new InstructionComparator());

        Point currentPoint = new Point(0, 0);
        Direction currentDirection = Direction.Right;
        long prevPos = 0;
        var lines = new ArrayList<Line>();
        for (var instruction : instructions) {
            long l = instruction.pos - prevPos;
            char d = instruction.c;

            Point nextPoint = getNextPoint(currentPoint, l, currentDirection);

            Line line = new Line(currentPoint, nextPoint);
            lines.add(line);

            prevPos = instruction.pos;
            currentDirection = changeDirection(currentDirection, d);
            currentPoint = nextPoint;
        }

        // Rest Length
        long currentLength = L - instructions.get(instructions.size() - 1).pos;
        if (currentLength > 0) {
            Point nextPoint = getNextPoint(currentPoint, L - currentLength, currentDirection);
            Line line = new Line(currentPoint, nextPoint);
            lines.add(line);
        }

        for (int i = 0; i < lines.size(); ++i) {
            Line currentLine = lines.get(i);
            System.out.println("currentLine: " + currentLine.start.x + "," +
                    currentLine.start.y + " - "
                    + currentLine.end.x + "," + currentLine.end.y);

            for (int j = i + 1; j < lines.size(); ++j) {

                if (j - 1 == i)
                    continue;

                Line otherLine = lines.get(j);
                if (doLinesIntersect(currentLine, otherLine)) {
                    System.out.println("GHOST");

                    System.out.println("currentLine: " + currentLine.start.x + "," +
                            currentLine.start.y + " - "
                            + currentLine.end.x + "," + currentLine.end.y);
                    System.out.println("otherLine: " + otherLine.start.x + "," +
                            otherLine.start.y + " - "
                            + otherLine.end.x + "," + otherLine.end.y);

                    // return;
                }
            }
        }
        System.out.println("SAFE");
    }

    public static boolean doLinesIntersect(Line lineA, Line lineB) {
        double x1 = lineA.start.x;
        double y1 = lineA.start.y;
        double x2 = lineA.end.x;
        double y2 = lineA.end.y;
        double x3 = lineB.start.x;
        double y3 = lineB.start.y;
        double x4 = lineB.end.x;
        double y4 = lineB.end.y;

        double denominator = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);

        // If the denominator is zero, the lines are parallel and do not intersect
        if (denominator == 0) {
            return false;
        }

        double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denominator;
        double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / denominator;

        // If ua and ub are both between 0 and 1, the lines intersect
        if (ua >= 0 && ua <= 1 && ub >= 0 && ub <= 1) {
            return true;
        }

        return false;
    }

    public static class InstructionComparator implements Comparator<Instruction> {
        @Override
        public int compare(Instruction i1, Instruction i2) {
            return Long.compare(i1.pos, i2.pos);
        }
    }

    public static class Instruction {
        public Instruction(long pos, char c) {
            this.pos = pos;
            this.c = c;
        }

        long pos;
        char c;
    }

    public static class Line {
        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        Point start;
        Point end;
    }

    public static class Point {
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double x;
        double y;
    }
}
