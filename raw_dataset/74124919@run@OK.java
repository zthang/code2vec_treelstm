public void run() {
    InputReader input = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int t = input.nextInt();
    while (t-- > 0) {
        int n = input.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) set.add(i);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = input.nextInt();
            int min = -1;
            while (j-- > 0) {
                int temp = input.nextInt();
                int flag = 0;
                if (min == -1 && set.contains(temp)) {
                    min = temp;
                } else if (min != -1) {
                    if (set.contains(temp)) {
                        min = Math.min(min, temp);
                    }
                }
            }
            if (min == -1) {
                list.add(i + 1);
            } else {
                set.remove(min);
            }
        }
        if (set.size() == 0) {
            System.out.println("OPTIMAL");
        } else {
            System.out.println("IMPROVE");
            int ans = 0;
            for (int a : set) {
                ans = a;
            }
            System.out.println(list.get(0) + " " + ans);
        }
    }
}