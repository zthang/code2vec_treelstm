int rsq(int a, int b) {
    return rsq(b) - rsq(a - 1);
}