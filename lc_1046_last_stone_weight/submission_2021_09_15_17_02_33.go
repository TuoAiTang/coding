package lc_1046_last_stone_weight


func lastStoneWeight(stones []int) int {
	mh := myHeap(stones)
	h := &mh
	heap.Init(h)

	for h.Len() > 1 {
		a, b := heap.Pop(h).(int), heap.Pop(h).(int)
		if a == b {
			continue
		}
		if a > b {
			heap.Push(h, a-b)
		} else {
			heap.Push(h, b-a)
		}
	}

	if h.Len() == 1 {
		return heap.Pop(h).(int)
	}

	return 0
}

type myHeap []int

func (m myHeap) Len() int {
	return len(m)
}

func (m myHeap) Less(i, j int) bool {
	return m[i] > m[j]
}

func (m myHeap) Swap(i, j int) {
	m[i], m[j] = m[j], m[i]
}

func (m *myHeap) Push(x interface{}) {
	*m = append(*m, x.(int))
}

func (m *myHeap) Pop() interface{} {
	x := (*m)[len(*m)-1]
	*m = (*m)[:len(*m)-1]
	return x
}
