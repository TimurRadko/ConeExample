package com.epam.cone.model;

public class Cone {
    private final Point point;
    private final double radius;
    private final double height;

    public Cone(Point point, double radius, double height) {
        this.point = point;
        this.radius = radius;
        this.height = height;
    }

    public Point getPoint() {
        return point;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cone cone = (Cone) o;

        if (Double.compare(cone.radius, radius) != 0) {
            return false;
        }
        if (Double.compare(cone.height, height) != 0) {
            return false;
        }
        return point.equals(cone.point);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = point.hashCode();
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("The cone with the center with coordinates (%s) have radius=%.1f and height=%.1f}",
                point.toString(), radius, height);
    }
}