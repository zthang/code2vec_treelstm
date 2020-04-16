static int getcolor(int c1, int c2) {
    TreeSet<Integer> ad = new TreeSet<>();
    ad.add(c1);
    ad.add(c2);
    if (!ad.contains(1))
        return 1;
    if (!ad.contains(2))
        return 2;
    return 3;
}