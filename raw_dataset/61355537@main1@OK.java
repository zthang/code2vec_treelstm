void main1() throws NumberFormatException, IOException {
    n = input.nextInt();
    m = input.nextInt();
    vis = new boolean[7];
    shuff = new int[7];
    g = allocateArrayList(n);
    for (int i = 0; i < m; i++) {
        int x = input.nextInt() - 1;
        int y = input.nextInt() - 1;
        g[x].add(y);
        g[y].add(x);
    }
    for (int i = 0; i < 6; i++) {
        permutations(0, i);
    }
    out.println(max);
}