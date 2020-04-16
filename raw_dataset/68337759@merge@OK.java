ArrayList<pair> merge(ArrayList<pair> a) {
    ArrayList<pair> m = new ArrayList<>();
    for (int i = 0; i < a.size(); i++) {
        pair p = a.get(i);
        if (m.size() == 0)
            m.add(p);
        else {
            pair p1 = m.get(m.size() - 1);
            if (p1.F == p.F)
                p1.S++;
            else
                m.add(p);
        }
    }
    m.add(base);
    a.clear();
    return m;
}