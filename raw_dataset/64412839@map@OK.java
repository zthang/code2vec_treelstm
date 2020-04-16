public <A1, B1, C1> Triple<A1, B1, C1> map(Function<A, A1> mapA, Function<B, B1> mapB, Function<C, C1> mapC) {
    return new Triple<>(mapA.apply(this.a), mapB.apply(this.b), mapC.apply(this.c));
}