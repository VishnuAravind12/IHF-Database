package com.nighthawk.spring_portfolio.mvc.person;

import java.lang.Math;

public class Corn implements Crops {
    @Override
    public int econValue() {
        return 1;
    }

    @Override
    public int growthStage() {
        // get week via request from FE
        double randNum = 2 + (Math.random() * 4); // generates a random number between 2 and 5
        int weekGrowthFactor = (int) (randNum);
        int developmentStage = 0;
        int initialWeek; // week when corn was placed
        int week;
        if (week - initialWeek == weekGrowthFactor) {
            developmentStage = developmentStage + 1;
        }
        return developmentStage;
    }

    @Override
    public int profitValue() {
        return 0;
    }

    @Override
    public int waterUsage() {
        return 0;
    }
}
