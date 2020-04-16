public BigInteger readBigInteger() {
    try {
        return new BigInteger(nextString());
    } catch (NumberFormatException e) {
        throw new InputMismatchException();
    }
}