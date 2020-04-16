static void perm(int[] arr, int u, boolean[] used) {
    if (u == arr.length) {
        // System.out.println(Arrays.toString(arr));
        int count = 0;
        boolean[][] edg = new boolean[7][7];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                continue;
            for (int j = 0; j < graph[i].size(); j++) {
                int to = graph[i].get(j);
                if (arr[to] != 0) {
                    if (arr[i] < arr[to])
                        continue;
                    int less = arr[to];
                    int gt = arr[i];
                    if (!edg[less][gt]) {
                        edg[less][gt] = true;
                        count++;
                    }
                }
            }
        }
        // if(count == 15) System.out.println(Arrays.toString(arr));
        best = Math.max(best, count);
        return;
    }
    for (int i = 0; i < 7; i++) {
        // if(!used[i] || i == 0) {
        arr[u] = i;
        // used[i] = true;
        perm(arr, u + 1, used);
    // used[i] = false;
    // }
    }
}