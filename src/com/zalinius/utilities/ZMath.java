package com.zalinius.utilities;

public class ZMath {

    public static double clamp(double value, double leftBoundary, double rightBoundary){
        assert (leftBoundary <= rightBoundary);

        if(value < leftBoundary)
            value = leftBoundary;
        else if(value > rightBoundary)
            value = rightBoundary;


        return value;
    }

    public static double oscillate(double amp, double x, double delta, double period, double x0){
        return amp * Math.sin((Math.PI*2 / period) * delta) + x0;
    }
}
