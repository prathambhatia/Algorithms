class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:

        res = 0
        stack=  []
        heights.append(0)
        for i in range(len(heights)):
            while stack and heights[stack[-1]] > heights[i]:
                h = heights[stack.pop()]
                w = i if not stack else i-stack[-1]-1
                res = max(res , h*w)
            stack.append(i)
        return res
