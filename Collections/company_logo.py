# find the top three most common characters in the string.
import collections

if __name__ == '__main__':
    s = input()
    counter = collections.Counter(sorted(s)).most_common(3)
    for elem in counter:
        print("{} {}".format(elem[0], elem[1]))