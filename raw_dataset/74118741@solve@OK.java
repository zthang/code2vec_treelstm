public static void solve() throws IOException {
    Reader sc = new Reader();
    OutputStream outputStream = System.out;
    PrintWriter out = new PrintWriter(outputStream);
    int t = sc.nextInt();
    while (t-- > 0) {
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        LinkedList<Integer>[] arr = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new LinkedList<>();
        }
        for (int i = 1; i <= n; i++) {
            int k = sc.nextInt();
            // System.out.println(k+" i "+i);
            for (int j = 1; j <= k; j++) {
                arr[i].add(sc.nextInt());
            }
            // System.out.println(arr[i]+" "+i);
            boolean take = false;
            Iterator<Integer> itr = arr[i].iterator();
            while (itr.hasNext()) {
                int next = (int) itr.next();
                if (!set.contains(next)) {
                    set.add(next);
                    take = true;
                    break;
                }
            }
            // System.out.println(set+" "+i+" "+n);
            if (!take) {
                list.add(i);
            }
        }
        int q = 0;
        if (list.size() != 0)
            q = list.get(0);
        int p = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                p = i;
                break;
            }
        }
        // System.out.println(list);
        if (set.size() == n)
            out.println("OPTIMAL");
        else {
            out.println("IMPROVE");
            out.println(q + " " + p);
        }
    }
    out.close();
}