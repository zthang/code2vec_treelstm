static void solve(int index, int mask) {
    if (index == arr.length) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((mask & 1 << i) != 0)
                sum += arr[i];
        }
        set.add(sum);
        return;
    }
    solve(index + 1, mask | 1 << index);
    solve(index + 1, mask);
}