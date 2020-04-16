long query_max(int L, int R) {
    if (L <= l && r <= R)
        return this.max;
    if (r <= L || R <= l)
        return Long.MIN_VALUE;
    push_down();
    return Math.max(lt.query_max(L, R), rt.query_max(L, R));
}