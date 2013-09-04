package com.github.notyy.reafactoring.distanceCalculator;

public class Ball {

    private int primaryForce;
    private int mass;
    private int delay;
    private int secondaryForce;

    public Ball(int mass, int primaryForce, int delay, int secondaryForce){
        this.primaryForce = primaryForce;
        this.mass = mass;
        this.delay = delay;
        this.secondaryForce = secondaryForce;
    }

    public double calcDistance(int time) {
        double result;
        double acc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if(secondaryTime > 0){
            double primaryVel = acc * delay;
            acc = (primaryForce + secondaryForce) / mass;
            result += primaryVel * secondaryTime + (0.5 * acc * secondaryTime * secondaryTime);
        }
        return result;
    }
}
