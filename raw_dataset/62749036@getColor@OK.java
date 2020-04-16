static int getColor(int c, int c1) {
    for (int i = 0; i < 3; i++) if (i != c && i != c1)
        return i;
    return -1;
}