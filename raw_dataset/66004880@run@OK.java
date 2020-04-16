public void run() throws Exception {
    int k = 0;
    TreeSet<Integer> ps = new TreeSet(new Comparator<Integer>() {

        @Override
        public int compare(Integer a, Integer b) {
            int abc = Integer.bitCount(a), bbc = Integer.bitCount(b);
            return ((abc >= bbc) ? -1 : 1);
        }
    });
    for (int n = nextInt(); n > 0; ps.add(encode(next())), n--) ;
    for (; ps.size() > 0; k++) {
        Integer fp = ps.pollFirst();
        Set<Integer> nps = new TreeSet(new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                return (((a & b) != 0) ? 0 : (a - b));
            }
        });
        for (Iterator<Integer> pi = ps.iterator(); pi.hasNext(); ) {
            Integer p = pi.next();
            if ((p & fp) != 0) {
                nps.add(p);
                pi.remove();
            }
        }
        for (Iterator<Integer> pi = ps.iterator(); pi.hasNext(); ) {
            if (nps.contains(pi.next())) {
                pi.remove();
            }
        }
    }
    println(k);
}