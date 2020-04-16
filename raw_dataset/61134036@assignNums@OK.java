private void assignNums(int index, int[] nums, int[] used) {
    if (index == nums.length) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                usedTile[i][j] = false;
            }
        }
        num++;
        int a = 0;
        for (int node = 0; node < n; node++) {
            for (int e : adj[node]) {
                int n1 = nums[node];
                int n2 = nums[e];
                if (nums[node] <= nums[e]) {
                    if (!usedTile[n1][n2]) {
                        usedTile[n1][n2] = true;
                        a++;
                    }
                }
            }
        }
        if (a > ans) {
            ans = a;
        }
    } else {
        for (int i = 0; i < 6; i++) {
            if (used[i] == 2)
                continue;
            nums[index] = i;
            used[i]++;
            assignNums(index + 1, nums, used);
            used[i]--;
        }
    }
}