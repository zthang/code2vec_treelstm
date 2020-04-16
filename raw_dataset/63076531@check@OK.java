long check(int f1, int f2, int f3) {
    long ans = 0;
    for (int i = 0; i < n; i++) {
        if (i % 3 == 0) {
            if (f1 == 1) {
                ans += mas[arr.get(i)][0];
            } else if (f1 == 2) {
                ans += mas[arr.get(i)][1];
            } else {
                ans += mas[arr.get(i)][2];
            }
        } else if (i % 3 == 1) {
            if (f2 == 1) {
                ans += mas[arr.get(i)][0];
            } else if (f2 == 2) {
                ans += mas[arr.get(i)][1];
            } else {
                ans += mas[arr.get(i)][2];
            }
        } else {
            if (f3 == 1) {
                ans += mas[arr.get(i)][0];
            } else if (f3 == 2) {
                ans += mas[arr.get(i)][1];
            } else {
                ans += mas[arr.get(i)][2];
            }
        }
    }
    return ans;
}