public void dualUnion(int a, int b, int c, int d) {
    a = find(a);
    b = find(b);
    c = find(c);
    d = find(d);
    // System.out.println("Unioning "+a+" and "+b+" subtracted "+costChoice(a)+" and "+costChoice(b));
    if (a != b) {
        minSize -= costChoice(a);
        minSize -= costChoice(b);
        union(a, b);
        union(c, d);
        minSize += costChoice(a);
    // System.out.println("Added in "+costChoice(a));
    }
}