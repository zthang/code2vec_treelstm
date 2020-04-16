private int solve(Integer[] special) {
    int len = special.length;
    int min = d_1_to_n[V - 1];
    int min_max = 0;
    Arrays.sort(special, new Comparator<Integer>() {

        public int compare(Integer a, Integer b) {
            if (d_1_to_n[a] > d_1_to_n[b])
                return 1;
            if (d_1_to_n[a] < d_1_to_n[b])
                return -1;
            return 0;
        }
    });
    for (int i = 0; i < len - 1; i++) {
        int first = special[i];
        int second = special[i + 1];
        if (d_1_to_n[first] + d_n_to_1[second] + 1 >= min) {
            return min;
        } else if (d_1_to_n[first] + d_n_to_1[second] + 1 > min_max) {
            min_max = d_1_to_n[first] + d_n_to_1[second] + 1;
        }
    }
    return min_max;
}