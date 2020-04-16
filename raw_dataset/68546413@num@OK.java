public int num(int le, int ri) {
    if (le >= ri)
        return 0;
    prop();
    if (le >= r || ri <= l)
        return 0;
    if (le <= l && ri >= r) {
        return min != 0 ? 0 : numMin;
    }
    return left.num(le, ri) + right.num(le, ri);
}