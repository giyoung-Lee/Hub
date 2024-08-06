a, b = input().split()

a = a[::-1]
b = b[::-1]
temp = int(a)+int(b)
print(int(str(temp)[::-1]))