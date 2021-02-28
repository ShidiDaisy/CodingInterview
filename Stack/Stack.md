## 栈可以解决的问题
1. 最近相关性：像洋葱一样，一层一层的结构
2. 先来后到

## Questions
### Valid Parentheses
* Amazon, JP Morgan 常考题

### [Min Stack](https://leetcode.com/problems/min-stack/)
* Design a stack that supports retrieving the minimum element in constant time.
* Amazon 常考题
#### 思路
* Push(): 每当push()新值进来时，如果小于等于min_stack栈顶值, 则一起push()到min_stack
* Pop(): 判断将pop()出去的元素是不是等于min_stack的栈顶元素。如果是，则一起pop出去。
* getMin(): 返回min_stack栈顶

### [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)
* Amazon 考题
#### Brute-force method 1
Use two pointer 

    for i -> 0, n-2
        for j -> i+1, n-1
            (i, j) -> lowest height between (i, j), area
            update max-area
* O(n^3)

#### Brute-force method 2
枚举一个棒子，分别找出它的左右边界

    for i -> 0, n-1:
        找到left bound. right bound,
        area = height[i] * (right - left)
        update max-area
        
#### Stack
* O(n) time

