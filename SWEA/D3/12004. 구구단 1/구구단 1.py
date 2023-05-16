T = int(input())

for test_case in range(1, T+1):
    a = int(input())
    answer = 'No'

    for i in range(1, 10):
        for j in range(1, 10):
            if i * j == a:
                answer = 'Yes'


    print(f"#{test_case} {answer}")
