private static int getMinThreads(int[][] nums) {
    if (nums == null || nums.length == 0)
        return 0;
    int res = 1;
    Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (int[] n : nums) minHeap.offer(n);
    int[] first = minHeap.poll();
    while (!minHeap.isEmpty()) {
        int[] cur = minHeap.poll();
        int curTotalTime = (first[1] <= cur[0] ? 0 : (first[1] - cur[0])) + cur[1];
        if (curTotalTime >= 10) {
            res++;
            first = cur;
        } else {
            first[1] = Math.max(cur[0] + curTotalTime, first[1]);
        }
    }
    return res <= 5 ? res : -1;
}