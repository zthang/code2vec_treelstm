private void process(int[] parents, boolean[] found) {
    for (int i = 0; i < 26; i++) {
        if (!found[i])
            continue;
        ArrayList<Integer> al = new ArrayList();
        int j = i;
        while (parents[j] != j) {
            al.add(j);
            j = parents[j];
        }
        for (Integer now : al) parents[now] = j;
    }
}