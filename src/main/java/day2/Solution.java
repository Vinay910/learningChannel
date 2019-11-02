package day2;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double meal_cost = in.nextDouble();
        int tip_percent = in.nextInt();
        int tax_percent = in.nextInt();
        double meal_tip=(meal_cost*((double)tip_percent/100));
        double meal_tax=(meal_cost*((double)tax_percent/100));
        double total=meal_cost+meal_tip+meal_tax;
        System.out.println("The total meal cost is "+Math.round(total)+" dollars.");
        in.close();
    }
}