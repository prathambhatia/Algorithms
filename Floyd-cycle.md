## Floyd's Cycle Detection Algorithm

Floyd's Cycle Detection Algorithm is an efficient technique to detect cycles in a sequence or linked list. This algorithm uses two pointers, often referred to as the "tortoise" (slow) and the "hare" (fast). The slow pointer moves one step at a time while the fast pointer moves two steps at a time. If there is a cycle, the fast pointer will eventually meet the slow pointer inside the cycle.

### Steps of the Algorithm:
1. **Initialize Pointers**: Set both `slow` and `fast` pointers to the beginning of the list.
2. **Move Pointers**: Move the `slow` pointer one step and the `fast` pointer two steps in each iteration.
3. **Detect Cycle**: If the `slow` pointer and `fast` pointer meet, a cycle is detected.
4. **Find Entry Point**:
    - Reset the `slow` pointer to the beginning of the list.
    - Move both pointers one step at a time. The point where they meet again is the entry point of the cycle.

### Mathematical Justification:

Given:
- \( P \): Distance from the start to the beginning of the cycle.
- \( C \): Length of the cycle.
- \( X \): Distance from the beginning of the cycle to the meeting point.

From the diagram and the equations:
\[ 
2(P + C - X) = P + 2C - X 
\]
\[ 
P + 2C - X = P + C 
\]

Simplifying, we get:
\[ 
P = X 
\]

This implies that when the slow pointer is reset and both pointers move one step at a time, they will meet at the beginning of the cycle.

### Example:
Given a list `[1, 3, 4, 2, 2]`, the algorithm will detect the cycle at node with value `2`.
