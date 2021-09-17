# LeetCode
The purpose of LeetCode is to provide you hands-on training on real coding interview questions. 
The Online Judge gives you immediate feedback on the correctness and efficiency of your 
algorithm which facilitates a great learning experience.

The mission of LeetCode is to help software engineers enhance their skills, 
expand their knowledge, and prepare for technical interviews. They have over 1800 
questions broken up into 3 skill levels: easy, medium, and hard. In addition, 
Premium members get access to problem sets based on company questions.

## Approach to Solving Questions
### Thoughts Before Coding
* Finding different approaches for the problem
    * Brute force approach
    * Optimization to the brute force approach
    * Optimized approach
* Finding the right data structure
    * We need to map a value to another value? HashMap!
    * We need a linear set of information? Array
    * We need to keep track of a count of different elements? HashMap!
    * We need to have quick lookup for individual elements? HashSet!
    * We need to model a network of people? Graph!
    * Matching Brackets? Stack!
    * We need to cache results? Array, Matrix, or Map
* Any algorithms that can be used
    * Finding cycles? 2 POINTER APPROACH
    * Searching in sorted array? BINARY SEARCH
    * Finding shortest path between 2 nodes in a graph? BREATH FIRST SEARCH
    * Need a way to produce a path between 2 nodes? HASHMAP TO KEEP TRACK OF PREVIOUS ELEMENTS
    * Need to prevent overlapping recursive calls? MEMOIZATION
    * Save memory from our recursive stack? BOTTOM UP APPROACH
    * 2 Sorted Arrays? 2 POINTER APPROACH
    * BFS or DFS?
* Optimizing time and space complexity
    * Can we use a different data structure to improve our runtime?
    * Should we use a different algorithm to improve our runtime?
    * Can we use a different data structure use less space?
* How do we approach dynamic programming problems?
    * First find the brute force recursive approach
    * Then look for overlapping recursive calls, 
        * Provide the top down memoization solution
    * Lastly, flip the solution around and find the bottom up approach
    * Can the bottom up approach be optimized?
        * 3D -> 2D
        * 2D -> 1D
        * 1D -> Constant Space
* Trade-offs between time and space?
    * Should we use HashMap/HashSet for quicker lookup?
    * Can we save previously seen values in a data structure?
    * Instead of using data structure, can we use a single value to represent the information we need?
    * Can we find an iterative approach instead of a recursive approach?
* Side Cases to Consider
   * What if our input is null?
   * What if our input is empty?
   * Are there negative values?
   * Will the constraints effect our answer?
   * Will our additions overflow?
   * Off by one errors?
   * Is the value inside the boundary of allowed values?

### Answer
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
    - For Tree Problems
        - What can we do at each of the nodes?
        - What do we do if the current node is null?
    - For Graph Problems
        - Do we need to create a representation of the graph?
        - BFS or DFS?
        - Accounting for cycles?
- Is the code optimized?
    - What can we do to optimize to code?
        
### Time and Space Complexity
- Average case?
- Worst case?    
- Is the answer optimized?
    - Can you get a better time and space complexity?
- Are you accounting for the time complexity in all of the methods inside the class?