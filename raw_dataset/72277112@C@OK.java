public static long C(int a, int b, long[][] s) {
    int m = (int) 1e9 + 7;
    if (s[a][b] >= 0) {
        return s[a][b];
    } else if (a < b | a < 0 | b < 0) {
        s[a][b] = 0;
        return 0;
    } else if (a == b | b == 0) {
        s[a][b] = 1;
        return 1;
    } else {
        return s[a][b] = (C(a - 1, b, s) % m + C(a - 1, b - 1, s) % m) % m;
    }
}