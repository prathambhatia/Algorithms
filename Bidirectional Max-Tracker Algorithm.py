class Solution:
    def trap(self, height: List[int]) -> int:

    """
    Bidirectional Max-Tracker Algorithm

    Computes the maximum trapped water between bars of varying heights in a given array using a two-pointer approach.
     Returns:
        int: The total amount of trapped water.
        Time Complexity , Space Complexity = O(N),O(1)))
    """
        if not height: return 0

        l, r = 0, len(height) - 1
        leftMax, rightMax = height[l], height[r]
        res = 0

        while l < r:
            if leftMax < rightMax:
                l += 1
                leftMax = max(leftMax, height[l])
                res += leftMax - height[l]
            else:
                r -= 1
                rightMax = max(rightMax, height[r])
                res += rightMax - height[r]

        return res
