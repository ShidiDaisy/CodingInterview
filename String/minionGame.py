# https://www.hackerrank.com/challenges/the-minion-game/problem
# Kevin and Stuart want to play the 'The Minion Game'.
#
# Game Rules
#
# Both players are given the same string, S.
# Both players have to make substrings using the letters of the string S.
# Stuart has to make words starting with consonants.
# Kevin has to make words starting with vowels.
# The game ends when both players have made all possible substrings.
#
# Scoring
# A player gets +1 point for each occurrence of the substring in the string S.
#
# For Example:
# String S = BANANA
# Kevin's vowel beginning word = ANA
# Here, ANA occurs twice in BANANA. Hence, Kevin will get 2 Points.

if __name__ == '__main__':

    S = input()
    n = len(S)

    # consonents
    stuart = 0

    # vowels
    kevin = 0

    # Iterate every element in the string
    for i in range(n):
        if S[i] in ['A', 'E', 'I', 'O', 'U']:
            # count the occurrence from this element : n-i
            kevin += n-i
        else:
            stuart += n-i

    if kevin > stuart:
        print("Kevin {}".format(kevin))
    elif stuart > kevin:
        print("Stuart {}".format(stuart))
    else:
        print("Draw")