# 유클리드 호제법을 이용해 최대 공약수를 구한뒤, 최소공약수를 구함
A, B = map(int, input().split())
res = A*B

while B:
    if A > B:
        A, B = B, A
    B %= A

print(res//A)