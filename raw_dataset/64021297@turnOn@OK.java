void turnOn(int a, Edge d) {
    if (!on[find(a)]) {
        on[find(a)] = true;
        e[find(a)].add(d);
    }
}