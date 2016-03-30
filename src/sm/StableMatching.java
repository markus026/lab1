package sm;

import java.util.LinkedList;

public class StableMatching {
	private int pairs;
	private String[] names;
	private int[] married;
	private LinkedList<Integer>[] mensPref;
	private int[][] womensPref;
	private int[] matchings;
	private LinkedList<Integer> next = new LinkedList<Integer>();
	
	
	public StableMatching(int pairs) {
		this.pairs = pairs;
		names = new String[pairs * 2];
		married = new int[pairs * 2];
		mensPref = new LinkedList[pairs];
		for (int i = 0; i < pairs; i++) {
			mensPref[i] = new LinkedList<Integer>();
			next.add((i*2) + 1);
		}
		womensPref = new int[pairs][pairs];
		matchings = new int[pairs * 2];
	}

	public void setName(int personIndex, String name) {
		names[personIndex - 1] = name;
	}

	public void setPreference(int personIndex, String[] preferences) {
		for (int i = 0; i < preferences.length; i++) {
			int pref = Integer.parseInt(preferences[i]);
			if (personIndex % 2 == 1) {
				mensPref[(personIndex - 1) / 2].add(pref);
			} else if (personIndex % 2 == 0) {
				int preferredMan = pref / 2;
				womensPref[(personIndex - 1) / 2][preferredMan] = (i + 1);
			}
		}
	}

	public void match() {
		while (!next.isEmpty()) {
			int man = next.peek();
			int woman = mensPref[(man - 1) / 2].poll();
			if (married[woman - 1] == 0) {
				next.poll();
				matchings[man - 1] = woman;
				matchings[woman - 1] = man;
				married[woman - 1] = 1;
			} else if (womensPref[(woman - 1) / 2][man / 2] < womensPref[(woman - 1) / 2][matchings[woman - 1] / 2]) {
				next.poll();
				next.add(matchings[woman - 1]);
				matchings[man - 1] = woman;
				matchings[woman - 1] = man;
				married[woman - 1] = 1;
			}
		}

	}
	
	public String matchToString() {
		String out = "";
		for (int i = 0; i < pairs; i++) {
			if (i == (pairs - 1)) {
				out += names[i * 2] + " -- " + names[matchings[i * 2] - 1];
			} else {
				out += names[i * 2] + " -- " + names[matchings[i * 2] - 1] + "\n";
			}
		}
		return out;
	}
}
