public void insert(int p) {
    p2 = p1;
    p1 = p;
    c++;
    if (p2 == 0)
        x = p1 * c;
    else
        x = ((p1 + p2) / 2d) * 1d * c;
}