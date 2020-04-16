long solve(ETourism.City from) {
    long max = 0;
    visited = true;
    for (ETourism.City city : neighbor) {
        if (city == from || city.visited)
            continue;
        max = Math.max(max, city.solve(this));
    }
    if (!cyclic)
        max += value;
    return max;
}