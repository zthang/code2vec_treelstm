public static void factorizeNumber(int x, IntegerList ans) {
    for (int i = 1; i * i <= x; i++) {
        if (x % i != 0) {
            continue;
        }
        ans.add(i);
        if (i * i != x) {
            ans.add(x / i);
        }
    }
}