public static int count(int one, int two, int three) {
    if (one == 0 && two == 0 && three == 0)
        return 1;
    if (memm[one][two][three] != -1)
        return memm[one][two][three];
    int ans = 0;
    if (three > 0)
        ans += count(one, two + 1, three - 1);
    if (two > 0)
        ans += count(one + 1, two - 1, three);
    if (one > 0)
        ans += count(one - 1, two, three);
    return memm[one][two][three] = ans;
}