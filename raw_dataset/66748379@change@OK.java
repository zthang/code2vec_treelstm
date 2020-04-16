void change(int L, int R, int v) {
    if (R <= l || r <= L)
        return;
    if (L <= l && r <= R) {
        this.max += v;
        this.min += v;
        this.sum += v * (r - l);
        this.lazy += v;
        return;
    }
    push_down();
    lt.change(L, R, v);
    rt.change(L, R, v);
    pop_up();
}