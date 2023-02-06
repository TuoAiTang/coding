package lc_9_palindrome_number

func isPalindrome(x int) bool {
    x1 := x
    if x < 0 {
        return false
    }
    if x == 0 {
        return true
    }
    if x % 10 == 0 {
        return false
    }
    x2 := 0
    for x != 0 {
        x2 = 10 * x2 + x % 10
        x /= 10
    }
    return x1 == x2
}