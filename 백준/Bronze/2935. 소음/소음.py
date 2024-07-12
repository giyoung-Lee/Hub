import sys
input = sys.stdin.readline

n = int(input())
symbol = input()
m = int(input())

if symbol[0] == '+':
    print(n+m)
elif symbol[0] == '*':
    print(n*m)