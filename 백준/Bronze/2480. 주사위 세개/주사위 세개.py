n1, n2, n3 = map(int, input().split())

result = 0
if n1 == n2 == n3:
    result = 10000 + (n1*1000)
elif n1 == n2 != n3:
    result = 1000 + (n1*100)
elif n1 == n3 != n2:
    result = 1000 + (n1*100)
elif n2 == n3 != n1:
    result = 1000 + (n2*100)
else:
    result = max(n1, n2, n3) * 100

print(result)