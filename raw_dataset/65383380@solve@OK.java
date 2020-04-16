public void solve(InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    int count = 0, cost = 0;
    ArrayList<Integer> array = new ArrayList<>();
    TreeMap<Integer, Integer> tm = new TreeMap<>();
    for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
        tm.put(a[i], i);
    }
    if (n > m || n == 2)
        out.println("-1");
    else {
        for (int i = 1; i < n; i++) {
            array.add(i);
            array.add(i + 1);
            count++;
            cost += a[i] + a[i - 1];
        }
        array.add(1);
        array.add(n);
        cost += a[n - 1] + a[0];
        count++;
        if (m - count > 0) {
            int c = 0;
            int value;
            int[] index = new int[2];
            for (Map.Entry em : tm.entrySet()) {
                c++;
                index[c - 1] = (int) em.getValue();
                if (c == 2)
                    break;
            }
            Arrays.sort(a);
            value = a[0] + a[1];
            for (int i = 0; i < m - count; i++) {
                array.add(index[0] + 1);
                array.add(index[1] + 1);
                // out.println(value[i]);
                cost += value;
            }
        }
        out.println(cost);
        int size = array.size();
        for (int i = 0; i < size - 1; i = i + 2) {
            out.print(array.get(i) + " ");
            out.println(array.get(i + 1));
        }
    }
}