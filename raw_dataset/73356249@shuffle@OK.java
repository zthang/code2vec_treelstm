private int shuffle(long x) {
    x += time;
    x += 0x9e3779b97f4a7c15L;
    x = (x ^ (x >>> 30)) * 0xbf58476d1ce4e5b9L;
    x = (x ^ (x >>> 27)) * 0x94d049bb133111ebL;
    return (int) (x ^ (x >>> 31));
}