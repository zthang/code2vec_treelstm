private long computeCost(int[] costColours) {
    long temoCost = 0l;
    for (int i = 0; i < costColours.length; i++) {
        if (costColours[i] == 0) {
            temoCost += cost1[i];
        } else if (costColours[i] == 1) {
            temoCost += cost2[i];
        } else if (costColours[i] == 2) {
            temoCost += cost3[i];
        } else {
            System.out.println("Something is wrong");
        }
    }
    return temoCost;
}