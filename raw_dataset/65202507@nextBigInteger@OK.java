BigInteger nextBigInteger() {
    try {
        return new BigInteger(nextLine());
    } catch (NumberFormatException e) {
        throw new InputMismatchException();
    }
}