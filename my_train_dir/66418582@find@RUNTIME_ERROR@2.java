    public static int find(int[] parents, int loc) {
        if(parents[loc] != loc) {
            parents[loc] = find(parents, parents[loc]);
        }
        return parents[loc];
    }