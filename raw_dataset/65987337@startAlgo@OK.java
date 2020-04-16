void startAlgo() {
    for (int i = 0; i < 26; i++) {
        HashSet<Integer> l = set[i];
        int prev = -1;
        for (int v : l) {
            if (prev != -1) {
                uni.mergeSets(prev, v);
            }
            prev = v;
        }
    }
    z.println(uni.size);
}