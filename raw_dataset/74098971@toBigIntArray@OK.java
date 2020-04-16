public BigInteger[] toBigIntArray(String s) {
    String[] nums = s.split("\\s");
    return IntStream.range(0, nums.length).boxed().map(index -> new BigInteger(nums[index])).toArray(size -> new BigInteger[size]);
}