package lc_33_search_in_rotated_sorted_array

func search(nums []int, target int) int {
    if len(nums) == 0 {
        return -1
    }

    l := 0
    r := len(nums) - 1
    for l <= r {
        mid := (l + r) / 2
        val := nums[mid]
        if val == target {
            return mid
        }

        inRight := val < nums[r]

        if inRight {
            if target > val {
                if target == nums[r] {
                    return r
                }
                if target < nums[r] {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            } else {
                r = mid - 1
            }
        } else {
            if target > val {
                l = mid + 1
            } else {
                if target == nums[l] {
                    return l
                }
                if target < nums[l] {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }
        }
    }
    return -1
}