public static void solution() {
    Scanner Sc = new Scanner(System.in);
    int count = Sc.nextInt();
    for (int i = 0; i < count; i++) {
        HashSet<Integer> h = new HashSet<Integer>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        String s = "";
        StringTokenizer st = new StringTokenizer(s);
        boolean inserted = false;
        String toImprove = "";
        boolean addToImprove = true;
        int n = Sc.nextInt();
        int j;
        for (j = 0; j < n; j++) {
            a = new ArrayList<Integer>();
            int m = 0;
            inserted = false;
            int p = Sc.nextInt();
            for (int t = 0; t < p; t++) {
                a.add(Sc.nextInt());
            }
            a.sort(null);
            while (!inserted) {
                if (m < a.size() && h.contains(a.get(m))) {
                    m++;
                } else if (m >= a.size()) {
                    if (addToImprove == true) {
                        toImprove += (j + 1) + " ";
                        addToImprove = false;
                    }
                    break;
                } else {
                    inserted = true;
                    h.add(a.get(m));
                }
            }
        }
        if (toImprove == "") {
            System.out.println("OPTIMAL");
        } else {
            for (int k = j; k > 0; k--) {
                if (!h.contains(k)) {
                    toImprove += k;
                    break;
                }
            }
            System.out.println("IMPROVE");
            System.out.println(toImprove);
            toImprove = "";
        }
    }
}