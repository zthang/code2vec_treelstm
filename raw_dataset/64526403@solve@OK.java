public static void solve() throws NumberFormatException, IOException {
    String[] ss = br.readLine().trim().split(" ");
    int n = Integer.parseInt(ss[0]);
    int k = Integer.parseInt(ss[1]);
    HashSet<Integer>[] arr = new HashSet[n + 1];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = new HashSet<>();
    }
    for (int i = 0; i < k; i++) {
        ss = br.readLine().trim().split(" ");
        int a = Integer.parseInt(ss[0]);
        int b = Integer.parseInt(ss[1]);
        arr[a].add(b);
        arr[b].add(a);
    }
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 1; i <= n; i++) {
        set.add(i);
    }
    int ans = 0;
    while (!set.isEmpty()) {
        int ele = set.first();
        set.remove(ele);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(ele);
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            ArrayList<Integer> l = new ArrayList<>();
            for (int i : set) {
                if (arr[curr].contains(i)) {
                    continue;
                }
                queue.add(i);
                l.add(i);
            }
            for (int j = 0; j < l.size(); j++) {
                set.remove(l.get(j));
            }
        }
        ans++;
    }
    System.out.println(ans - 1);
}