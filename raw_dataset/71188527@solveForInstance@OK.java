private int[] solveForInstance(int n, String q) {
    int[] result = new int[n];
    int currentValue = 1;
    for (int index = 0; index < n; ) {
        while (index < n - 1 && q.charAt(index) == '<') {
            result[index] = currentValue++;
            index++;
        }
        int next = q.indexOf('<', index);
        if (next == -1)
            next = n - 1;
        for (int i = next; i >= index; --i) {
            result[i] = currentValue++;
        }
        index = next + 1;
    }
    return result;
}