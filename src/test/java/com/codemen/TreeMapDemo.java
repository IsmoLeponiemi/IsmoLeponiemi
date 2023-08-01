package com.codemen;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String args[]) {
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		tm.put(10, "Chaitanya");
		tm.put(1, "Ajeet");
		tm.put(11, "Test");
		tm.put(9, "Demo");
		tm.put(3, "Anuj");
		// Get a set of the entries
		Set<Entry<Integer, String>> set = tm.entrySet();
		// Get an iterator
		Iterator<?> i = set.iterator();
		// Display elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
	}
}