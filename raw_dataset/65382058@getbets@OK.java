static int getbets(int v) {
    if (v == 0)
        return 0;
    if (v > 2)
        return 2;
    return 1;
}