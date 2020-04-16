private void add(int p, int val) {
    // System.out.println("add to BIT " + p);
    for (; p <= n; p += (p & (-p))) bit[p] += val;
}