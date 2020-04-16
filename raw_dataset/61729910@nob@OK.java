public int nob(long x) {
    if (x == 0)
        return 1;
    return (int) Math.floor(Math.log(x) / Math.log(2)) + 1;
}