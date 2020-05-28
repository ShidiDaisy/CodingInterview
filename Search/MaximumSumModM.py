# /*Maximum Subarray Sum Modulo M
# * https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
# *
# * Find Maximum continuous subarray sum after modulo

# having maximum sum of elements modulo m.

# Return the maximum sum subarray mod m.
def maxSubarray(a, m):
    prefix = 0
    maxim = 0

    S = set()
    S.add(0)

    # Traversing the array.
    for i in range(len(a)):

        # Finding prefix sum.
        prefix = (prefix + a[i]) % m

        # Finding maximum of prefix sum.
        maxim = max(maxim, prefix)

        # Finding iterator poing to the first
        # element that is not less than value
        # "prefix + 1", i.e., greater than or
        # equal to this value.
        it = 0
        for i in S:
            if i >= prefix + 1:
                it = i
        if (it != 0) :
            maxim = max(maxim, prefix - it + m )

            # adding prefix in the set.
        S.add(prefix)

    return maxim

if __name__ == '__main__':

    # Driver Code
    arr = [3, 3, 9, 9, 5]
    n = 5
    m = 7
    print(maxSubarray(arr, m))