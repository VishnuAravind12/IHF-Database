package com.nighthawk.spring_portfolio.mvc.person;

import java.lang.Math;
import java.util.Random;

// Uses the interface element Crops to implement the Corn class like question 4
public class Corn implements Crops {

    int initialWeek;
    int week;
    int developmentStage;

    public Corn(int initialWeek, int week) {
        this.initialWeek = initialWeek;
        this.week = week;
    }

    @Override
    public int econValue(int area) {

        // creates a matrix of the size of the current week of the growing season then
        // populate it with random values between the growth state * waterusage/2 to
        // growth state * water usage and then pick a random value from the matrix.
        // Use of 2d arrays like question 1
        int growthStage = growthStage();
        int waterUsage = waterUsage(area);
        int growingSeason = calculateGrowingSeason();

        int[][] econValueMatrix = new int[growingSeason][growingSeason];

        Random random = new Random();

        for (int i = 0; i < growingSeason; i++) {
            for (int j = 0; j < growingSeason; j++) {
                int minValue = growthStage * waterUsage / 2;
                int maxValue = growthStage * waterUsage;
                econValueMatrix[i][j] = minValue + random.nextInt(maxValue - minValue + 1);
            }
        }

        int randomValue = econValueMatrix[random.nextInt(growingSeason)][random.nextInt(growingSeason)];
        return randomValue;
    }

    public int calculateGrowingSeason() {
        // Calculate growing season based on current week
        int currentWeek = getCurrentWeek(); // Replace with actual implementation
        int midPoint = 26; // Midpoint of the growing season
        int earlySeasonDebuff = 2; // Debuff for being too early in the season
        int lateSeasonDebuff = 1; // Debuff for being too late in the season

        if (currentWeek < midPoint) {
            return earlySeasonDebuff * (midPoint - currentWeek);
        } else {
            return lateSeasonDebuff * (currentWeek - midPoint);
        }
    }

    private int getCurrentWeek() {
        // Replace with actual implementation to get the current week
        return this.week;
    }

    @Override
    public int growthStage() {
        // get week via request from FE
        double randNum = 2 + (Math.random() * 4); // generates a random number between 2 and 5
        int weekGrowthFactor = (int) (randNum);
        int developmentStage = this.developmentStage;
        int initialWeek = this.initialWeek; // week when corn was placed
        int week = this.week;
        if (week - initialWeek == weekGrowthFactor) {
            developmentStage = developmentStage + 1;
        }
        return developmentStage;
    }

    @Override
    public int profitValue(int area) {
        int waterNeeded = waterUsage(area);
        int waterCost = 10; // 10 dollars allows for 1000 gallons of water
        int totalWaterCost = waterCost * waterNeeded;
        int baseCropProfit = 6134;
        int totalProfit = baseCropProfit - totalWaterCost;
        return totalProfit * area; // 134 dollars profit
    }

    @Override
    public int waterUsage(int area) {
        // 1 unit = 1000 gallons of water
        int waterNeeded = 600;
        return waterNeeded * area;
    }
}
