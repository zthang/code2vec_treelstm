boolean dfs(ETourism.City from) {
    visited = true;
    for (ETourism.City city : neighbor) {
        if (city == from)
            continue;
        if (city.visited || city.dfs(this))
            cyclic = true;
    }
    return cyclic;
}