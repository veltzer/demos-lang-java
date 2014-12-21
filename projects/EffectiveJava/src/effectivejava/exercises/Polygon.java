package effectivejava.exercises;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Polygon {
 private Point[] points;
 protected Polygon(PolygonBuilder builder) {
   List<Point> tempPoints = builder.accumulator;
   points = new Point[tempPoints.size()];
   points = builder.accumulator.toArray(points);
 }
 static PolygonBuilder builder() {
   return new PolygonBuilder();
 }
 static class PolygonBuilder implements Builder<Polygon> {
  private List<Point> accumulator = new LinkedList<Point>();
  public PolygonBuilder add(Point p) {
   accumulator.add(p);
   return this;
  }
  public PolygonBuilder point(int x, int y) {
   accumulator.add(Point.point(x, y));
   return this;
  }
  @Override
  public Polygon build() {
   return new Polygon(this);
  }
 }
 Polygon addPoint(Point p) {
   return new PolygonBuilder().add(p).build();
 }
 @Override public String toString() {
   return Arrays.deepToString(points);
 }
 public static void main(String[] args) {
  System.out.println(Polygon.builder().point(1, 2).point(3, 4).point(5, 6).build());
 }

}
