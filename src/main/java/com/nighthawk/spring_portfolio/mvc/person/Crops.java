package com.nighthawk.spring_portfolio.mvc.person;

public interface Crops {
    int econValue(int area);

    int growthStage();

    int calculateGrowingSeason();

    int profitValue(int area);

    int waterUsage(int area);
}
