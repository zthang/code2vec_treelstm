public LightWriter ans(int... n) {
    for (int n1 : n) {
        ans(n1);
    }
    return this;
}