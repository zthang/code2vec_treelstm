static boolean check(int k, ArrayList<Integer> cycle) {
    int m = cycle.size(), len = m / k;
    for (int i = 0; i < k; i++) {
        boolean flag = true;
        int color = c[cycle.get(i)], cur = i;
        for (int j = 0; j < len; j++) {
            if (c[cycle.get(cur)] != color)
                flag = false;
            cur = (cur + k) % m;
        }
        if (flag == true)
            return true;
    }
    return false;
}