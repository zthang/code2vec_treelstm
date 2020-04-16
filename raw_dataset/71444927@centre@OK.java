static void centre(int start) {
    build_sz(start, -1);
    int root = find_centroid(start, -1, sz[start]);
    // 
    dfs(root, -1, 0, -1);
    for (int i : all) {
        pair_cnt[max[i]]++;
    }
    int all_cnt = 0;
    for (edge i : gr[root]) {
        if (!killed[i.to])
            all_cnt += cnt[i.to];
    }
    Collections.sort(all, new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return -Integer.compare(max[o1], max[o2]);
        }
    });
    for (int i : all) {
        pair_cnt[max[i]] += (all_cnt - cnt[comp[i]]);
        cnt[comp[i]]--;
        all_cnt--;
    }
    all.clear();
    // 
    killed[root] = true;
    for (edge to : gr[root]) {
        if (!killed[to.to])
            centre(to.to);
    }
}