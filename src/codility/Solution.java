package codility;

/**
 * @author Syed Ali.
 * @createdAt 18/09/2021, Saturday, 17:44
 */

import java.util.*;
import java.time.*;
import java.time.format.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

	private static class File implements Comparable<File> {
		String name;
		String city;
		String result;
		LocalDateTime date;

		File(String s) {
			String[] strs = s.split(", ");
			name = strs[0];
			city = strs[1];
			date = LocalDateTime.parse(strs[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}

		public void addResult(String r) {
			result = r + "." + name.split("\\.")[1];
		}

		@Override
		public int compareTo(File file) {
			return date.compareTo(file.date);
		}
	}

	public String solution(String S) {
		String[] files = S.split("\n");
		Map<String, File> lookUp = new HashMap<>();
		Map<String, Queue<File>> cityMap = new HashMap<>();
		for (String file : files) {
			File f = new File(file);
			lookUp.put(file, f);
			cityMap.computeIfAbsent(f.city, k -> new PriorityQueue<>()).add(f);
		}

		for (String city : cityMap.keySet()) {
			int total = cityMap.get(city).size();
			int length = 0;

			int temp = total;
			while (temp > 0) {
				temp = temp / 10;
				++length;
			}

			Queue<File> q = cityMap.get(city);
			int count = 0;
			while (!q.isEmpty()) {
				File f = q.poll();
				count++;
				String c = count + "";
				int required = length - c.length();
				while (required-- > 0) {
					c = 0 + c;
				}
				f.addResult(city + c);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String f : files) {
			File file = lookUp.get(f);
			sb.append(file.result);
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}