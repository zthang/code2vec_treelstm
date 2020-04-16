static void func(int source) {
    ans[source] = 0;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(source);
    while (q.size() != 0) {
        int z = q.poll();
        for (int c : arr[z]) {
            if (ans[c] > ans[z] + 1) {
                ans[c] = ans[z] + 1;
                q.add(c);
                count[c] = 1;
            } else if (ans[c] == ans[z] + 1)
                count[c]++;
        }
    }
}