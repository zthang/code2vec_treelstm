long query_min(int L, int R) {
    if (L <= l && r <= R)
        return this.min;
    if (r <= L || R <= l)
        return Long.MAX_VALUE;
    push_down();
    return Math.min(lt.query_min(L, R), rt.query_min(L, R));
}