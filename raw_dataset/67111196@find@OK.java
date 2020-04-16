void find(int comp) {
    TreeSet<Integer> aset = asc.get(comp);
    TreeSet<Integer> dset = desc.get(comp);
    while (true) {
        if (aset.size() == 0 || dset.size() == 0) {
            break;
        }
        int giver = aset.pollFirst();
        int taker = dset.pollFirst();
        if (tot[giver] >= 0) {
            break;
        }
        long abs = Math.abs(tot[giver]);
        if (abs <= tot[taker]) {
            tot[taker] -= abs;
            tot[giver] = 0;
            ans.add(new Edge(giver, taker, abs));
            if (tot[taker] > 0) {
                dset.add(taker);
            }
        } else {
            tot[giver] += tot[taker];
            ans.add(new Edge(giver, taker, tot[taker]));
            tot[taker] = 0;
            aset.add(giver);
        }
    }
}