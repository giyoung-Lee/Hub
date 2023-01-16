price = int(input())
n = int(input())

result = 0
for i in range(n):
    x, a = map(int, input().split())
    result += x * a

if result == price:
    print("Yes")
else:
    print("No")

