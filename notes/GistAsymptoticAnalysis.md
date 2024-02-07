### High Level Idea: 
    Suppress constant factors and lower-order terms. 
        1. As lower order terms are irrelevant for large inputs
        2. Constant factors are too system dependent

        for example: 6n log n + 6n = n log n

### Terminology:
    running time of merge sort is n log n
    where n is the input size (e.g., elements in an input array)

### NOTE: To be clear it is not said that lower order is not important, rather we are saying attention of higher order algorithmic approaches.

URL: https://www.youtube.com/watch?v=l-cNaKGc-yY&list=PLEAYkSg4uSQ37A6_NrUnTHEKp6EkAxTMa&index=10


### Big-OH:
    T(n) = O(f(n)), If and only if there exist constant c1n0 > 0 that
        t(n) <= c.f(n)
    for all n >= n0.

Warning: c1n0 constant dependent on n.