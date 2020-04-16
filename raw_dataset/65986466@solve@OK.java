public void solve() {
    makeset();
    int n = in.ni();
    int[] vis = new int[26];
    for (int i = 0; i < n; ++i) {
        char[] arr = in.ns().toCharArray();
        int parent = arr[0] - 'a';
        for (int j = 0; j < arr.length; ++j) {
            union(parent, arr[j] - 'a');
            vis[arr[j] - 'a']++;
        }
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < 26; ++i) {
        if (vis[i] == 0)
            continue;
        // out.println(i+" ->"+ find(i));
        map.put(find(i), 1);
    }
    out.println(map.size());
}