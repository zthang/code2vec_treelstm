void solve() {
    int T = in.nextInt();
    while (T-- > 0) {
        int n = in.nextInt();
        String s = in.nextString();
        boolean[] inc = new boolean[n - 1];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            inc[i] = s.charAt(i) == '<';
            if (inc[i])
                count++;
        }
        List<Segment> incSegs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = i;
            while (i < n - 1 && inc[i]) {
                i++;
            }
            if (start < i) {
                incSegs.add(new Segment(start, i == n - 1 ? i : --i));
            }
        }
        List<Segment> decSegs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = i;
            while (i < n - 1 && !inc[i]) {
                i++;
            }
            if (start < i) {
                decSegs.add(new Segment(start, i == n - 1 ? i : --i));
            }
        }
        int[] llis = new int[n];
        int[] hlis = new int[n];
        int num = 1;
        for (int i = 0; i < incSegs.size(); i++) {
            for (int j = incSegs.get(i).l; j <= incSegs.get(i).h; j++) {
                hlis[j] = num++;
            }
        }
        num = n;
        for (int i = decSegs.size() - 1; i >= 0; i--) {
            for (int j = decSegs.get(i).l; j <= decSegs.get(i).h; j++) {
                hlis[j] = num--;
            }
        }
        num = 1;
        for (int i = incSegs.size() - 1; i >= 0; i--) {
            for (int j = incSegs.get(i).l; j <= incSegs.get(i).h; j++) {
                llis[j] = num++;
            }
        }
        num = n;
        for (int i = 0; i < decSegs.size(); i++) {
            for (int j = decSegs.get(i).l; j <= decSegs.get(i).h; j++) {
                llis[j] = num--;
            }
        }
        printArray(llis);
        printArray(hlis);
    }
}