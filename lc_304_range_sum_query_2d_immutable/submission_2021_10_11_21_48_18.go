package lc_304_range_sum_query_2d_immutable

type NumMatrix struct {
	sums [][]int
}


func Constructor(matrix [][]int) NumMatrix {
	m := len(matrix)
	if m < 1 {
		return NumMatrix{}
	}

	n := len(matrix[0])

	// <m+1,n+1>
	// sums(i,j) 以i,j为右下角的矩阵元素总和
	// sums(row2,col2) = sum(i-1, j) + sum(i, j-1) - sum(i-1,j-1) + matrix[row2][col2]
	sums := make([][]int, m+1)
	for i := 0; i < m+1; i++ {
		sums[i] = make([]int, n+1)
	}

	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + matrix[i-1][j-1]
		}
	}

	return NumMatrix{
		sums: sums,
	}
}


func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	return this.sums[row2+1][col2+1] - this.sums[row1][col2+1] - this.sums[row2+1][col1] + this.sums[row1][col1]
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * obj := Constructor(matrix);
 * param_1 := obj.SumRegion(row1,col1,row2,col2);
 */