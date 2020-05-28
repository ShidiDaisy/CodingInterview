# https://www.hackerrank.com/challenges/nested-list/problem
# Given the names and grades for each student in a Physics class of  students, store them in a nested list and print the name(s) of any
# student(s) having the second lowest grade.

if __name__ == '__main__':
    name_score_dict = {}
    for _ in range(int(input())):
        name = input()
        score = float(input())
        name_score_dict[name] = score
    sort_by_name = sorted(name_score_dict.items())
    second_lowest = sorted(set(name_score_dict.values()))[1]
    print("\n".join([name for name, score in sort_by_name if score == second_lowest]))