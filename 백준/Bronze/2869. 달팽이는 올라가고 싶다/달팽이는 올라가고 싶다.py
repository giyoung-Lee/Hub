import math

A, B, V = map(int, input().split())

temp = A - B
div = (V-B) / temp

print(math.ceil(div))