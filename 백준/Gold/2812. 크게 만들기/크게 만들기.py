import sys
input = sys.stdin.readline

n, k = map(int, input().split())
data = input().strip()

deleted = 0
stack = []

for x in data:
    
    # 스택이 비어있지 않고 현재 원소가 스택의 top() 보다 크면
    while len(stack) > 0 and stack[-1] < x:
        # 더이상 삭제할 수 없다면 종료
        if deleted == k:
            break
        # 스택에서 pop() 수행
        else:
            stack.pop()
            deleted += 1
    stack.append(x)


for i in range(k - deleted):
    stack.pop()

print(''.join(stack))