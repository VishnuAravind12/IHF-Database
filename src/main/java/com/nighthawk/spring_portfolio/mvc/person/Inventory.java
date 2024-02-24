package com.nighthawk.spring_portfolio.mvc.person;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Crops> cropsList;
    private List<SoilAdditives> soilAdditivesList;
    private int farmArea;
    // Similar to FRQ 3 we have an array list that a player holds in their inventory
    // this also allows us for us to add and change elements as they
    // go through out the game ensuring more flexibility, we are also looping
    // through the various elements and being able to get a more
    // in-depth amount of player stats

    public Inventory(int farmArea) {
        cropsList = new ArrayList<>();
        soilAdditivesList = new ArrayList<>();
        this.farmArea = farmArea;
    }

    public void addCrop(Crops crop) {
        cropsList.add(crop);
    }

    public void removeCrop(Crops crop) {
        cropsList.remove(crop);
    }

    public void addSoilAdditive(SoilAdditives soilAdditive) {
        soilAdditivesList.add(soilAdditive);
    }

    public void removeSoilAdditive(SoilAdditives soilAdditive) {
        soilAdditivesList.remove(soilAdditive);
    }

    public int getEconValue() {
        int totalEconValue = 0;
        for (Crops crop : cropsList) {
            totalEconValue += crop.econValue(farmArea);
        }
        return totalEconValue;
    }

    public int getGrowthStage() {
        int totalGrowthStage = 0;
        for (Crops crop : cropsList) {
            totalGrowthStage += crop.growthStage();
        }
        return totalGrowthStage;
    }

    public int getProfitValue() {
        int totalProfitValue = 0;
        for (Crops crop : cropsList) {
            totalProfitValue += crop.profitValue(farmArea);
        }
        return totalProfitValue;
    }

    public int getWaterUsage() {
        int totalWaterUsage = 0;
        for (Crops crop : cropsList) {
            totalWaterUsage += crop.waterUsage(farmArea);
        }
        return totalWaterUsage;
    }

    public int getCost() {
        int totalCost = 0;
        for (SoilAdditives soilAdditive : soilAdditivesList) {
            totalCost += soilAdditive.cost(farmArea);
        }
        return totalCost;
    }

    public int getEcoEffect() {
        int totalEcoEffect = 0;
        for (SoilAdditives soilAdditive : soilAdditivesList) {
            totalEcoEffect += soilAdditive.ecoEffect(farmArea);
        }
        return totalEcoEffect;
    }

    public int getGrowthEffect() {
        int totalGrowthEffect = 0;
        for (SoilAdditives soilAdditive : soilAdditivesList) {
            totalGrowthEffect += soilAdditive.growthEffect(farmArea);
        }
        return totalGrowthEffect;
    }

    public int getProfitEffect() {
        int totalProfitEffect = 0;
        for (SoilAdditives soilAdditive : soilAdditivesList) {
            totalProfitEffect += soilAdditive.profitEffect(farmArea);
        }
        return totalProfitEffect;
    }

    public int userProfit() {
        return getProfitValue() * getProfitEffect() - getCost();
    }

    public int userEco() {
        return getEconValue() * getEcoEffect();
    }

    public int userGrowth() {
        return getGrowthStage() * getGrowthEffect();
    }

    public int userWater() {
        return getWaterUsage();
    }

}
