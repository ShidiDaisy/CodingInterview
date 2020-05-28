
if __name__ == '__main__':
    # N, M, P = map(int, input().strip().split())
    # array1 = numpy.array([input().strip().split() for _ in range(N)], int)
    # array2 = numpy.array([input().strip().split() for _ in range(M)], int)
    n = int(input())
    arr = map(int, input().split())
    runner_up = sorted(set(arr), reverse=True)[1]
    print(runner_up)
