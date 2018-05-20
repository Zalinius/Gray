package com.company.utilities;

public class ZMath {

    public static double clamp(double value, double leftBoundary, double rightBoundary){
        assert (leftBoundary <= rightBoundary);

        if(value < leftBoundary)
            value = leftBoundary;
        else if(value > rightBoundary)
            value = rightBoundary;


        return value;
    }
}
