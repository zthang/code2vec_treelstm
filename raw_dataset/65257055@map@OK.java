public <A1, B1> Pair<A1, B1> map(Function<A, A1> mapA, Function<B, B1> mapB) {
    return new Pair<A1, B1>(mapA.apply(this.a), mapB.apply(this.b));
}