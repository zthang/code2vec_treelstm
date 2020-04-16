public BigInteger readBigInteger() {
    try {
        return new BigInteger(ns());
    } catch (NumberFormatException e) {
        throw new InputMismatchException();
    }
}