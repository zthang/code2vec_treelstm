public void ensureValidity() throws IllegalArgumentException {
    if (this.b < this.a)
        throw new IllegalArgumentException("Second argument of range (" + this.a + ", " + this.b + ") must be larger than first");
}