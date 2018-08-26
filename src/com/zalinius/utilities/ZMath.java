package com.zalinius.utilities;

public class ZMath {

    public static double clamp(double value, double leftBoundary, double rightBoundary){
        assert (leftBoundary <= rightBoundary);
        double clampedValue = value;
        
        if(value < leftBoundary)
        	clampedValue = leftBoundary;
        else if(value > rightBoundary)
        	clampedValue = rightBoundary;

        return clampedValue;
    }

    public static double oscillate(double amp, double x, double delta, double period, double x0){
        return amp * Math.sin((Math.PI*2 / period) * delta) + x0;
    }
}
