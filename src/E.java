import java.util.ArrayList;
import java.util.Scanner;

public class E {
	private int numHouses;
	private int distance;
	private int coins;

	public E(int numHouses, int distance, int coins) {
		this.numHouses = numHouses;
		this.distance = distance;
		this.coins = coins;
	}

	public int getHouses() {
		ArrayList<ArrayList<Integer>> result = houseList(); // all info in here
		if (result.isEmpty()) {
			return -1;
		}
		result = satisfiesBoth(result);
		if (result.isEmpty()) {
			return -1;
		}
		if (result.size() > 1) {
			result = sameDistance(result);
		}
		return getIndex(result);
		
		// if arraylist empty return -1
	}
	
	private ArrayList<ArrayList<Integer>> houseList() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= numHouses; i++) {
			ArrayList<Integer> houseInfo = new ArrayList<Integer>();
			houseInfo.add(i); // index
			houseInfo.add(sc.nextInt()); // distance
			houseInfo.add(sc.nextInt()); // coins
			result.add(houseInfo);
		}
		// sc.close();
		System.err.println(result.toString());
		return result;
	}

	// shows which house(s) are the min distance away
	private ArrayList<ArrayList<Integer>> satisfiesBoth(ArrayList<ArrayList<Integer>> houseList) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < houseList.size(); i++) {
			if (houseList.get(i).get(1) <= distance && houseList.get(i).get(2) >= coins) {
				result.add(houseList.get(i));
			}
		}
		// filter for min distance
		if (result.size() > 1) {
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).get(1) != getMinDistance(result)) {
					result.remove(i);
				}
			}
		}
		return result;
	}

	// shows which house(s) are min distance away and have most coin
	private ArrayList<ArrayList<Integer>> sameDistance(ArrayList<ArrayList<Integer>> houseList) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < houseList.size(); i++) {
			int maxCoins = getMaxCoins(houseList);
			if (houseList.get(i).get(2) == maxCoins) {
				result.add(houseList.get(i));
			}
		}
		if (result.isEmpty()) {
			return houseList;
		}
		return result;
	}

	// returns which house has the min index
	private int getIndex(ArrayList<ArrayList<Integer>> houseList) {
		int index = houseList.get(0).get(0);
		for (int i = 0; i < houseList.size(); i++) {
			if (houseList.get(i).get(0) < index) {
				index = houseList.get(i).get(0);
			}
		}
		return index;
	}

	// get min distance
	private int getMinDistance(ArrayList<ArrayList<Integer>> houseList) {
		int minDistance = distance;
		for (int i = 0; i < houseList.size(); i++) {
			if (houseList.get(i).get(1) < minDistance) {
				minDistance = houseList.get(i).get(1);
			}
		}
		return minDistance;
	}

	// get max coins
	private int getMaxCoins(ArrayList<ArrayList<Integer>> houseList) {
		int maxCoins = coins;
		for (int i = 0; i < houseList.size(); i++) {
			if (houseList.get(i).get(2) > maxCoins) {
				maxCoins = houseList.get(i).get(2);
			}
		}
		return maxCoins;
	}

	static Scanner sc = null;
	public static void main(String args[]) {
		sc = new Scanner(System.in);
		int numTests = sc.nextInt();
		for (int i = 0; i < numTests; i++) {
			E result = new E(sc.nextInt(), sc.nextInt(), sc.nextInt());
			System.out.println(result.getHouses());
		}
		sc.close();
	}
}
