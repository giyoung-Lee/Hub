M, N = map(int, input().split())


def sieve_of_eratosthenes(max_num):
    is_prime = [True] * (max_num + 1)
    p = 2
    while p * p <= max_num:
        if is_prime[p]:
            for i in range(p * p, max_num + 1, p):
                is_prime[i] = False
        p += 1
    return [p for p in range(2, max_num + 1) if is_prime[p]]


def print_primes_in_range(M, N):
    if M > N:
        return
    primes = sieve_of_eratosthenes(N)
    list_ = []
    for prime in primes:
        if prime >= M:
            print(prime)
            
            
print_primes_in_range(M, N)