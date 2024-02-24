package com.nighthawk.spring_portfolio.mvc.person;

public class Glyphosate implements SoilAdditives {

    int cost = 100;
    int ecoEffect = -10;
    int growthEffect = 10;
    int profitEffect = -10;

    public Glyphosate() {
        this.cost = cost;
        this.ecoEffect = ecoEffect;
        this.growthEffect = growthEffect;
        this.profitEffect = profitEffect;
    }

    @Override
    public int cost(int area) {
        return 0;
    }

    @Override
    public int ecoEffect(int area) {
        return 0;
    }

    @Override
    public int growthEffect(int area) {
        return 0;
    }

    @Override
    public int profitEffect(int area) {
        return 0;
    }
}
