package lc_303_range_sum_query_immutable

type NumArray struct {
	nums []int
	sums []int
}


func Constructor(nums []int) NumArray {
	sums := make([]int, len(nums)+1)
	for i := 0; i < len(nums); i++ {
		sums[i+1] = sums[i] + nums[i]
	}
	return NumArray{
		nums: nums,
		sums: sums,
	}
}


func (this *NumArray) SumRange(left int, right int) int {
	return this.sums[right+1] - this.sums[left]
}


/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(left,right);
 */
