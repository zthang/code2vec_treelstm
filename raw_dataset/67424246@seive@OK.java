static void seive() {
    for (int i = 2; i < 101; i++) {
        if (!v[i]) {
            t++;
            l.add(i);
            for (int j = 2 * i; j < 101; j += i) v[j] = true;
        }
    }
}