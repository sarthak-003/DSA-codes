class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        r,w,b=0,0,0
        for ele in nums:
            if ele == 0:
                r+=1
            elif ele == 1:
                w+=1
            else:
                b+=1
        for i in range(r):
            nums[i] = 0
        for i in range(r,w+r):
            nums[i] = 1
        for i in range(w+r,b+r+w):
            nums[i] = 2
        