static void dfs(int index, int pc, int[] color) {
    int c = 0;
    BitSet bs = new BitSet(color.length + 1);
    bs.set(color[index]);
    if (pc >= 0)
        bs.set(pc);
    for (int i : graph[index]) {
        if (color[i] == -1) {
            if (color[index] == c || pc == c)
                c = bs.nextClearBit(0);
            color[i] = c++;
            bs.set(c - 1);
            dfs(i, color[index], color);
        }
    }
}