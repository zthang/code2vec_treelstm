public boolean un(int x, int y) {
    x = par(x);
    y = par(y);
    return x == y;
}