long query_sum(int L, int R) {
    if (L <= l && r <= R)
        return this.sum;
    if (r <= L || R <= l)
        return 0;
    push_down();
    return lt.query_sum(L, R) + rt.query_sum(L, R);
}