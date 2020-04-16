public boolean equals(Object obj) {
    // System.out.println("In equals");
    if (obj instanceof Pair) {
        Pair pp = (Pair) obj;
        return (pp.a == this.a && pp.b == this.b);
    } else {
        return false;
    }
}