void dfs(int index) {
    if (index == (n + 1)) {
        chack_valid();
    } else {
        for (int i = 0; i <= 6; i++) {
            arr[index] = i;
            dfs(index + 1);
        }
    }
}