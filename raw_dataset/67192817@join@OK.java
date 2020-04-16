static void join(int i, int j) {
    i = find(i);
    j = find(j);
    if (i == j) {
        // System.out.println(dsu[0]+" "+dsu[1]+" "+dsu[2]);
        return;
    }
    if (dsu[i] > dsu[j]) {
        dsu[i] = j;
    } else {
        dsu[j] = i;
    }
// System.out.println(dsu[0]+" "+dsu[1]+" "+dsu[2]);
}