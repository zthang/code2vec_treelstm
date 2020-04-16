public boolean isEven(BigInteger number) {
    return !number.testBit(1);
}