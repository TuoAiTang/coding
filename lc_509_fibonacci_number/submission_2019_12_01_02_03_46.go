package lc_509_fibonacci_number

func fib(N int) int {
	if N < 2 {
		return N
	}

	first, second := 0, 1
	for i := 2; i <= N; i++ {
		first, second = second, first + second
	}
	return second
}