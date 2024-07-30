n, m = map(int, input().split(":"))


def gcd(a, b):
    while b:
        a, b = b, a % b
    return a


temp = gcd(n, m)
print(str(int(n / temp)) + ":" + str(int(m / temp)))