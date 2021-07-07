package com.torlov.cseeleven;

public class Drill4 {
    String phaseOfWater(int temp) {
        if (temp >= 100) {
            return "vapor";
        }

        else if (temp <= 0) {
            return "solid";
        }

        return "liquid";
    }

    int maxDifference(int first, int second, int third) {
        return Math.max(first, Math.max(second, third)) - Math.min(first, Math.min(second, third));
    }

    double ringArea(double innerRadius, double outerRadius) {
        return Math.PI * (Math.pow(outerRadius, 2) - Math.pow(innerRadius, 2));
    }
}
