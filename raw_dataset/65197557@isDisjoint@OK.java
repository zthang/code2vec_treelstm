public boolean isDisjoint(int a, int b) {
    return find(a) != find(b);
}