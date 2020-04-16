HashMap<Integer, Integer> minCost(long[][] cost) {
    long min = LMAX;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (i != j && j != k && i != k) {
                    // System.out.println(i + "" + j + k);
                    long allcost = cost[0][i] + cost[1][j] + cost[2][k];
                    if (min >= allcost) {
                        min = allcost;
                        map.put(0, i);
                        map.put(1, j);
                        map.put(2, k);
                    }
                }
            }
        }
    }
    System.out.println(min);
    return map;
}