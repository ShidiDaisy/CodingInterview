## Design a Circular Deque
https://leetcode-cn.com/problems/design-circular-deque/solution/shu-zu-shi-xian-de-xun-huan-shuang-duan-dui-lie-by/
1. fine variables for Circular Deque:
    * front: point to the first valid data at the head of the deque
    * rear: point to the next position of the last valid data. i.e. The position for insertLast
2. The Deque is empty (initially, front = rear = 0): front == rear;
3. The Deque is full: (rear + 1) % capacity == front
4. When insertLast: front not change, rear++ (moving right)
5. When deleteLast: front not change, rear-- (moving left), the original deleted element is waiting for be replaced by the new element. 
   (No need to really remove the element from the array. Just moving the pointer will do.)
6. When deleteFront: front++
7. Circular:
   * Moving right: front = (front - 1 + capacity) % capacity, rear = (rear - 1 + capacity) % capacity
   * Moving left, front = (front + 1) % capacity, rear = (rear + 1) % capacity

    