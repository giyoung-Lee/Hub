n = int(input())

int_ = 'int'
ans = ''

while True:
    if n == 0:
        break

    n -= 4
    ans += 'long '

print(ans+int_)