# LeetCode
The purpose of LeetCode is to provide you hands-on training on real coding interview questions. 
The Online Judge gives you immediate feedback on the correctness and efficiency of your 
algorithm which facilitates a great learning experience.

## Approach to Solving Questions
### Thoughts before Coding
* Brute force way to approach the question
* Data structures that can be used
    * We need to map a value to another value? HASHMAP!
    * We need to keep track of a count of different elements? HASHMAP!
    * We need to have quick lookup for individual elements? HASHSET!
    * We need to model a network of people? GRAPHS!
    * Matching Brackets? STACK!
* Algorithms that can be used
    * Finding cycles? 2 POINTER APPROACH
    * Searching in sorted array? BINARY SEARCH
    * Finding shortest path between 2 nodes in a graph? BREATH FIRST SEARCH
    * Need a way to produce a path between 2 nodes? HASHMAP TO KEEP TRACK OF PREVIOUS ELEMENTS
    * Need to prevent overlapping recursive calls? MEMOIZATION
    * Save memory from our recursive stack? BOTTOM UP APPROACH
    * 2 Sorted Arrays? 2 POINTER APPROACH
* What can we do to improve our Brute Force Approach?
    * Can we use a different data structure to improve our runtime?
    * Should we use a different algorithm to improve our runtime?
* How do we approach dynamic programming problems?
    * First find the brute force recursive approach
    * Then look for overlapping recursive calls, and provide the top down memoization solution
    * Lastly, flip the solution around and find the bottom up approach
* Trade-offs between time and space?
    * Should we use HashMap/HashSet for quicker lookup?
    * Can we save previously seen values in a data structure?
    * Instead of using data structure, can we use a single value to represent the information we need?
    * Can we find an iterative approach instead of a recursive approach?
    
### Side Cases to Consider
- What if our input is null?
- What if our input is empty?
- Are there negative values?
- Will our additions overflow?
- Off by one errors?
- Is the value inside the boundary of allowed values?

### Answer
- Write a "Thoughts Before Coding"
    - Provide a general idea of the problem
        - What is the brute force solution?
        - Can we optimize on the brute force solution?
    - Is there many parts to the question?
        - Break down the question
    - Is this question similar to another question?
        - Can we use a similar approach to find the solution?
- Write our a semi-pseudocode explaining our solution to the problem
    - Validate our input   
    - What algorithm are we using?
    - What data structure will we be instantiating?
    - Any side cases to consider when implementing the code
        - Look out for off-by 1 errors
        - What are the terminating conditions of loops
    - For recursive implementations
        - What are the parameters?
        - What are the base cases?
        - What do we do in each of the recursive call?
- Write out "Time and Space Complexity"
    - Average case?
        - O(nlogn) for balanced binary tree  
    - Worst case?
        - O(n) for unbalanced binary tree       
    - Can we improve our time/space complexity by using a different algorithm or data structure?