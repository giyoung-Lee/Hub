n = int(input())

answer = '666'
count = 0

while True:

    if '666' in answer:
        count += 1
        if count == n:
            print(answer)
            break
        else:
            answer = str(int(answer)+1)

    else:
        answer = str(int(answer)+1)