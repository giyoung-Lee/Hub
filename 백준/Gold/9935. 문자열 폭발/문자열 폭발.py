st = input().rstrip()
dm = input().rstrip()

stack = []
dm_last = dm[-1]

for ch in st:
    stack.append(ch)
    if ch == dm_last and ''.join(stack[-len(dm):]) == dm:
        del stack[-len(dm):]

result = ''.join(stack)
if result:
    print(result)
else:
    print("FRULA")