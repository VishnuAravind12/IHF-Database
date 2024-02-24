package com.nighthawk.spring_portfolio.mvc.person;

public class Glyphosate implements SoilAdditives {

    int cost = (int) (Math.random() * 13) + 1;
    int ecoEffect = -10;
    int growthEffect = 10;
    int profitEffect = 2;

    public Glyphosate() {
        this.cost = cost;
        this.ecoEffect = ecoEffect;
        this.growthEffect = growthEffect;
        this.profitEffect = profitEffect;
    }

    @Override
    public int cost(int area) {
        int quantity = area;
        int unitCost = this.cost;
        int totalCost = unitCost * quantity;
        return totalCost;
    }

    @Override
    public int ecoEffect(int area) {
        int quantity = area;
        int unitEcoEffect = this.ecoEffect;
        int totalEcoEffect = unitEcoEffect * quantity;
        return totalEcoEffect;
    }

    @Override
    public int growthEffect(int area) {
        int quantity = area;
        int unitGrowthEffect = this.growthEffect;
        int totalGrowthEffect = unitGrowthEffect * quantity;
        return totalGrowthEffect;
    }

    @Override
    public int profitEffect(int area) {
        int quantity = area;
        int unitProfitEffect = this.profitEffect;
        int totalProfitEffect = unitProfitEffect * quantity;
        return totalProfitEffect;
    }
}
