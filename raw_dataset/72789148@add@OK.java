void add(int o) {
    o++;
    v1 = (v1 * s1 + o) % m1;
    v2 = (v2 * s2 + o) % m2;
    l++;
}