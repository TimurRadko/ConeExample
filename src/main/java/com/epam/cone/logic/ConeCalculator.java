package com.epam.cone.logic;

import com.epam.cone.model.Cone;
import com.epam.cone.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeCalculator {
    private static final Logger LOGGER = LogManager.getLogger(ConeCalculator.class);

    public double getSurfaceArea(Cone cone) {
        double radius = cone.getRadius();
        double height = cone.getHeight();
        double formingLength = getFormingLength(radius, height);
        double result = Math.PI * radius * (formingLength + radius);
        LOGGER.info(String.format("The surface area of the cone (%s) is: %.2f", cone, result));
        return result;
    }

    public double getVolume(Cone cone) {
        double result = getVolumeFullCone(cone);
        LOGGER.info(String.format("The volume of the cone (%s) is: %.2f", cone, result));
        return result;
    }
    private double getVolumeFullCone(Cone cone) {
        double radius = cone.getRadius();
        double height = cone.getHeight();
        return (Math.PI * Math.pow(radius, 2) * height) / 3;
    }

    public boolean checkConeBaseLieOnAxisXZ(Cone cone) {
        Point point = cone.getPoint();
        double coordinateX = point.getCoordinateX();
        double coordinateZ = point.getCoordinateZ();
        boolean result = coordinateX == 0 && coordinateZ == 0;
        LOGGER.info(String.format("The cone is lie on the axis XZ: %s", result));
        return result;
    }

    public double volumeRatioAfterTruncated(Cone cone, double yCoordinateTruncatedPlane) {
        if (isPlanePassesThroughCone(cone, yCoordinateTruncatedPlane)) {
            LOGGER.warn("The truncated plane doesn't pass through the cone");
            return -1;
        }
        double volumeFullCone = getVolumeFullCone(cone);
        double volumeTruncatedCone = getVolumeTruncatedCone(cone, yCoordinateTruncatedPlane);
        double result = volumeTruncatedCone / volumeFullCone;
        LOGGER.info(String.format("The ratio of the volume of a truncated cone to the volume of the cone is: %.1f", result));
        return result;
    }

    private boolean isPlanePassesThroughCone(Cone cone, double yCoordinateTruncatedPlane) {
        Point point = cone.getPoint();
        double height = cone.getHeight();
        double coordinateY = point.getCoordinateY();
        return (yCoordinateTruncatedPlane < coordinateY || yCoordinateTruncatedPlane >
                coordinateY + height);
    }

    private double getVolumeTruncatedCone(Cone cone, double yCoordinateTruncatedPlane) {
        Point point = cone.getPoint();
        double radius = cone.getRadius();
        double height = cone.getHeight();
        double coordinateY = point.getCoordinateY();
        double heightTruncation = yCoordinateTruncatedPlane - coordinateY;
        double upperRadius = getUpperRadius(heightTruncation, radius, height);
        return (Math.PI * height * (Math.pow(radius, 2) +
                radius * upperRadius + Math.pow(upperRadius, 2))) / 3;
    }

    private double getUpperRadius(double heightTruncation, double radius, double height) {
        return (heightTruncation * radius) / height;
    }

    private double getFormingLength(double radius, double height) {
        return Math.hypot(radius, height);
    }
}
