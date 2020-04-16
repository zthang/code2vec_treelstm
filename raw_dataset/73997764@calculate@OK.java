void calculate() {
    // print(ans);
    if (size == 1) {
        Node x = leaves.pop();
        ans[x.index] = x.color;
    } else {
        Node x = leaves.pop();
        // System.out.println("popped " + (x.index + 1) + " with color " + x.color);
        if (x.degree != 1)
            throw new RuntimeException("sth wrong!");
        // only child of x
        Node y = x.children.iterator().next();
        // delete x from y
        Node.delete(x, y);
        size--;
        // y uses x in optimal subtree
        boolean linked = x.color > 0;
        if (y.degree == 1)
            leaves.push(y);
        if (linked) {
            y.color += x.color;
        }
        calculate();
        // from y
        int contribution = ans[y.index];
        if (linked)
            contribution -= x.color;
        ans[x.index] = x.color + Math.max(0, contribution);
    }
}