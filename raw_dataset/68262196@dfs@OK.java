static void dfs(int node, ArrayDeque<Integer> nums) {
    int num = c[node];
    for (int i : child[node]) {
        ArrayDeque<Integer> tmp = new ArrayDeque<>();
        int j;
        for (j = 0; j < size[i] && num > 0; j++, num--) {
            tmp.add(nums.poll());
        }
        if (res[node] == 0 && num == 0)
            res[node] = nums.poll();
        for (; j < size[i]; j++) tmp.add(nums.poll());
        dfs(i, tmp);
    }
    if (res[node] == 0)
        res[node] = nums.poll();
}