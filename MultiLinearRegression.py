import ast
import numpy as np

#Method 1: Numpy
A = np.array([[1, -2, 2], [1, -1, 0], [-1, 1, 1]])
b = np.array([5, -1, 5])

#使用linalg.inv求得方阵A的逆矩阵
A_inv = np.linalg.inv(A)

#X = A^-1 * B
X = np.matmul(A_inv, b)
print(X)

