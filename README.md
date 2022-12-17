search algorithm 


# A*

One the best algorithms to find the best path. In general A* is the improvement version of
Dijkstra’s search algorithm. It makes use of heuristics(educated guesses that help reduce 
the time taken to compute the result) to increase its performance and efficiency
(We will take about heuristics more).

## How does it work : 

A* goal is to find a path to our end node with the least cost, so A* will then explore the option
that has the least cost(f(x)), and repeat this process until we reach our end point.
To fine our cost we need two more value g and h,
The cost value (f(x)) of a point is computed by adding the distance from that point (g(X)) to our starting point, 
to the distance from that point to the ending point(h(x)):


```math
   f(n) = g(n) + h(n)
```
about h, this is  often referred to as the heuristic, There can be many ways to calculate this 'h'
which we will talk about it.


## Algorithm :

For A* algorithms we need to list openList and closeList. The OPEN set contains those nodes that are candidates for examining.
Initially, the OPEN set contains only one element: the starting position. 
The CLOSED set contains those nodes that have already been examined. 
Initially, the CLOSED set is empty.
There is a main loop that repeatedly pulls out the best node n in OPEN (the node with the lowest f value) and examines it. 
If n is the goal, then we’re done. Otherwise, node n is removed from OPEN and added to CLOSED.
Then, its neighbors n′ are examined. A neighbor that is in CLOSED has already been seen, so we don’t need to look at it.
A neighbor that is in OPEN is scheduled to be looked at, so we don’t need to look at it now.
Otherwise, we add it to OPEN, with its parent set to n.


```
   A* algorithm ->
   
   1. openList = []
   2. cloesList = []
   3. openLsit.add(start_node)
   
   
   4. while (until the openList get empty) :
        
        4.1. current = find the best node(with min f) from the list. 
        4.2. check if the current is the end node or not.
        4.3. remove the current node from openList.
        4.4. add the current to the closeLsit.
        4.5. find the list of neighbors.
        
        4.6. loop on the list of neighbors :
               4.6.1. compute both g and h for neighbor.
               4.6.2. add the neighbor to open list but first check if we dont have the neighbor on the list.
               
```

### Heuristic :
We can do either calculate the exact value of h which is certainly time-consuming, or we can
approximate the value of h using some heuristics which is less time-consuming. There are 3 waysn to 
approximate the value of h
#### 1. Manhattan Distance
Manhattan distance is a distance metric between two points in a N dimensional vector space.
It is the sum of the lengths of the projections of the line segment between the points onto the coordinate axes.
In simple terms, it is the sum of absolute difference between the measures in all dimensions of two points.

```math
     heuristic =  |x1-x2| + |y1-y2|
```

**we use manhattan distance when we don't allow moving in diagonals nodes.**

#### 2. Diagonal Distance
the maximum of absolute values of differences in the goal’s x and y coordinates 
and the current cell’s x and y coordinates respectively, i.e.,

```math 
    dx = abs(x1 - x2)
    dy = abs(y2 - y2)
    heuristic = D * (dx + dy) + (D2 - 2 * D) * min(dx, dy)
```
**we use diagonal distance when we are allowed to move in eight directions only**

#### 3. Euclidean Distance
Euclidean distance is the distance of our current node and our end node using distance formula.

```math 

    heuristic = sqrt ((x1 – x2)^2 + (y1 – y2)^2)
                     
```
**We use euclidean distance when we are allowed to mode in any directions.**

*For heuristic the (x1,y1) is our current node and (x2,y2) is our end node.*







