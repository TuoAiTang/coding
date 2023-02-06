package lc_22_generate_parentheses


func generateParenthesis(n int) []string {
	var res []string
	dfs("", 0, 0, n, &res)
	return res
}

func dfs(path string, open, close, n int, res *[]string) {
	if open > n {
		return
	}
	if close > open {
		return
	}
	if open == close && close == n {
		*res = append(*res, path)
	}
	dfs(path+"(", open+1, close, n, res)
	dfs(path+")", open, close+1, n, res)
}