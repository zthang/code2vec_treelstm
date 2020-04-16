public static void print(int curr, int prev, ArrayList<Integer>[] tree, int comb, int[] color) {
    if (comb == FS || comb == FT) {
        color[curr] = 1;
    } else if (comb == SF || comb == ST) {
        color[curr] = 2;
    } else {
        color[curr] = 3;
    }
    for (int next : tree[curr]) {
        if (next == prev)
            continue;
        if (comb == FS) {
            print(next, curr, tree, ST, color);
        } else if (comb == FT) {
            print(next, curr, tree, TS, color);
        } else if (comb == SF) {
            print(next, curr, tree, FT, color);
        } else if (comb == ST) {
            print(next, curr, tree, TF, color);
        } else if (comb == TF) {
            print(next, curr, tree, FS, color);
        } else if (comb == TS) {
            print(next, curr, tree, SF, color);
        }
    }
}