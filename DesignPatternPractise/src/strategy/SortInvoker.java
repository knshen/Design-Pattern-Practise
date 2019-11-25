package strategy;

/**
 * 上下文对象
 * @author shen_k
 *
 */
public class SortInvoker {
	private SortStrategy quickSS = new QuickSortStrategy();
	private SortStrategy mergeSS = new MergeSortStrategy();
	private SortStrategy heapSS = new HeapSortStrategy();
	
	public void execSort(Object arr[]) {
		if(arr[0] instanceof Integer) {
			quickSS.sort(arr);
		} else if(arr[0] instanceof String) {
			mergeSS.sort(arr);
		} else {
			heapSS.sort(arr);
		}
	}
}
