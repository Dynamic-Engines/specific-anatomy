## Guiding Principles: 

    1. Worst Case Analysis: Our running time holds for evey input of length n.

        As opposed to:
            1. Average case analysis
            2. bench mark
        
        Both require domain knowledge

    2. Wont pay much attentions to constants factors and lower order terms

        Justification: 
            1. Eaiser
            2. Constants are dependent on architecture/compiler/programmer
            3. losses very little predecctive power

    3. Asymptotic Analysis: Focus on running time on large input size n

        Merge Sort 6n log n + 6n is better than Insertion Sort 1/2 n^2

        Justification:
            1. May be false for smaller input size(n < 90) but will hold for larger size
            2. Only big problems are interesting!

## Fast Algorithm: Worst case running time grows slowly with input size.

## Holy Grail: Linear running time or close to it.
