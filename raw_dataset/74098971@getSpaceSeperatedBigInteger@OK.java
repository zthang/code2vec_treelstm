public String getSpaceSeperatedBigInteger(BigInteger[] nums) {
    return Stream.of(nums).map(BigInteger::toString).collect(Collectors.joining(" "));
}