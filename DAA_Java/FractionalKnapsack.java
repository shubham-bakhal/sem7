import java.util.*;

class Item{
	int value, weight;
	Item(int x, int y){
		this.value = x;
		this.weight = y;
	}
}

class ItemComparator implements Comparator<Item>{
	@Override
	public int compare(Item a, Item b) {
		double r1 = (double)(a.value)/(double)(a.weight);
		double r2 = (double)(b.value)/(double)(b.weight);
		if (r1 < r2) return 1;
		else if(r1 > r2) return -1;
		else return 0;
	}
}

public class FractionalKnapsack {
	
	static double fractionalKnapsack(int W, Item[] arr, int n) {
		Arrays.sort(arr, new ItemComparator());
		
		int curWt = 0;
		int finalVal = 0;
		
		for(int i = 0; i < n; i++) {
			if(curWt + arr[i].weight <= W) {
				curWt += arr[i].weight;
				finalVal += arr[i].value;
			}else {
				int remain = W - curWt;
				finalVal += ((double)arr[i].value / (double)arr[i].weight)*(double)remain;
				break;
			}
		}
		return finalVal;
	}

	public static void main(String[] args) {
		
		int n = 3;
		int weight = 50;
		Item[] arr = {new Item(100,20), new Item(60,10), new Item(120,30)};
		double ans = fractionalKnapsack(weight, arr, n);
		System.out.println("The max value is : " + ans);
		
	}

}
