package org.example;

import java.time.LocalDate;

public class MaterialManager {
    public static void main(String[] args) {
        Material[] materials = new Material[10];

        Meat meat1 = new Meat("m1", "thịt lợn 1", LocalDate.now().minusDays(2), 18, 5);
        Meat meat2 = new Meat("m2", "thịt lợn 2", LocalDate.now().plusDays(1), 24, 5);
        Meat meat3 = new Meat("m3", "thịt lợn 3", LocalDate.now().minusDays(4), 55, 5);
        Meat meat4 = new Meat("m4", "thịt lợn 4", LocalDate.now().plusDays(2), 154, 5);
        Meat meat5 = new Meat("m5", "thịt lợn 1", LocalDate.now().minusDays(6), 100, 5);

        materials[0] = meat1;
        materials[2] = meat2;
        materials[3] = meat3;
        materials[4] = meat4;
        materials[5] = meat5;

        CrispyFlour crispyFlour1 = new CrispyFlour("f1", "bột 1", LocalDate.now().minusDays(2), 10, 5);
        CrispyFlour crispyFlour2 = new CrispyFlour("f2", "bột 2", LocalDate.now().minusDays(2), 14, 5);
        CrispyFlour crispyFlour3 = new CrispyFlour("f3", "bột 3", LocalDate.now().minusMonths(6), 15, 5);
        CrispyFlour crispyFlour4 = new CrispyFlour("f4", "bột 4", LocalDate.now().minusDays(2), 12, 5);
        CrispyFlour crispyFlour5 = new CrispyFlour("f5", "bột 5", LocalDate.now().minusDays(2), 19, 5);

        materials[1] = crispyFlour1;
        materials[6] = crispyFlour2;
        materials[7] = crispyFlour3;
        materials[8] = crispyFlour4;
        materials[9] = crispyFlour5;

        double realCost = getRealPrice(materials[7]);
        System.out.println(realCost);

        Meat m = (Meat) materials[5];
        System.out.println(m.getRealMoney());
    }

    public static double getRealPrice(Material material){
        LocalDate now = LocalDate.now();
        LocalDate expiryDate;
        if (material instanceof CrispyFlour){
            CrispyFlour flour = (CrispyFlour) material;
            expiryDate = flour.getExpiryDate();
            if (expiryDate.minusMonths(2).isBefore(now)){
                return material.getCost() *  0.6;
            } else if (expiryDate.minusMonths(4).isBefore(now)) {
                return material.getCost() *  0.8;
            } else {
                return material.getCost() *  0.95;
            }
        } else {
            Meat meat = (Meat) material;
            expiryDate = meat.getExpiryDate();

            if (expiryDate.minusDays(2).isBefore(now)){
                return material.getCost() * 0.7;
            }else {
                return material.getCost() *  0.9;
            }
        }
    }
}
