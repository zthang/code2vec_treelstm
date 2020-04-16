void insert(int x, int y) {
    node[t] = new ac();
    node[t].next = tab[x];
    node[t].v = y;
    tab[x] = t++;
}