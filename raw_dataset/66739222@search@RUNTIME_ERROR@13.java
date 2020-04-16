    private static int search(int[] a, int[] hops, int i, int ch) {
        int chN = a[i] % 2;
        if (chN != ch) return 1;

        if (hops[i] != -2) return hops[i] + 1;

        int minH = -1;
        if (i - a[i] >= 0) {
            if (i == a[i] - i){
                hops[i] = -1;
                return -1;
            }
            minH = search(a, hops, i - a[i], ch);
        }
        if (i + a[i] < a.length) {
            if (a[i] + i == i) {
                hops[i] = -1;
                return -1;
            }
            int rightMin = search(a, hops, i + a[i], ch);
            if (rightMin != -1 && minH != -1)
                minH = min(minH, rightMin);
            else {
                if (rightMin != -1) {
                    minH = rightMin;
                }
            }
        }
        hops[i] = minH;

        return hops[i] == -1 ? -1 : hops[i] + 1;
    }