public static long check(int f1, int f2, int f3) {
    int i;
    long ans = 0;
    for (i = 0; i < n; i++) {
        if (i % 3 == 0) {
            if (f1 == 1) {
                ans += colorCosts[0][arr.get(i)];
            } else if (f1 == 2) {
                ans += colorCosts[1][arr.get(i)];
            } else {
                ans += colorCosts[2][arr.get(i)];
            }
        } else if (i % 3 == 1) {
            if (f2 == 1) {
                ans += colorCosts[0][arr.get(i)];
            } else if (f2 == 2) {
                ans += colorCosts[1][arr.get(i)];
            } else {
                ans += colorCosts[2][arr.get(i)];
            }
        } else {
            if (f3 == 1) {
                ans += colorCosts[0][arr.get(i)];
            } else if (f3 == 2) {
                ans += colorCosts[1][arr.get(i)];
            } else {
                ans += colorCosts[2][arr.get(i)];
            }
        }
    }
    return ans;
}