public static void solve() {
    int n = Integer.parseInt(in.next());
    int target = Integer.parseInt(in.next());
    int[] z = new int[n];
    for (int i = 0; i < n; i++) {
        z[i] = Integer.parseInt(in.next());
    }
    Arrays.sort(z);
    int ptr1 = 0;
    int ptr2 = n - 1;
    int wind = z[ptr1] + z[ptr2];
    if (wind == target) {
        System.out.println(ptr1 + "-" + ptr2);
    } else {
        while (ptr1 < ptr2 && wind != target) {
            if (wind > target) {
                wind -= z[ptr2--];
                wind += z[ptr2];
            } else {
                wind -= z[ptr1++];
                wind += z[ptr1];
            }
        }
        if ((ptr1 != 0 || ptr2 != n - 1) && ptr2 != ptr1) {
            System.out.println(ptr1 + "-" + ptr2);
        } else {
            System.out.println(-1);
        }
    }
}