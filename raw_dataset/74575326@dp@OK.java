public static double dp(int one, int two, int three) {
    if (one == 0 && two == 0 && three == 0)
        return 0;
    if (mem[one][two][three] > -0.5)
        return mem[one][two][three];
    double ans = 0;
    double d = (n * 1d) / (one + two + three);
    int c = 0;
    if (three > 0) {
        ans += (d + dp(one, two + 1, three - 1));
        c++;
    }
    if (two > 0) {
        ans += (d + dp(one + 1, two - 1, three));
        c++;
    }
    if (one > 0) {
        ans += (d + dp(one - 1, two, three));
        c++;
    }
    return mem[one][two][three] = ans / c;
}