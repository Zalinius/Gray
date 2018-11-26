package com.zalinius.utilities;

public class EbbMath {

    public static double oscillate(double amp, double x, double delta, double period, double x0){
        return amp * Math.sin((Math.PI*2 / period) * delta) + x0;
    }
}
