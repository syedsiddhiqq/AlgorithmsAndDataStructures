package HackerRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2020, Sunday, 08:29
 */
public class DynamicArray {
	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		int sequence,lastAnswer = 0;
		List<List<Integer>> sequences = new ArrayList<>();
		List<Integer> lastAnswers = new ArrayList<>();
		for (int i = 0; i < n; i++) sequences.add(new ArrayList<>());

		for (List<Integer> query : queries) {
			sequence = (query.get(1) ^ lastAnswer)%n;
			System.out.println(sequence);
			if(query.get(0) == 1){
				sequences.get(sequence).add(query.get(2));
			}else if(query.get(0) == 2){
				List<Integer> sequenceArr = sequences.get(sequence);
				lastAnswer = sequenceArr.get(query.get(2)%sequenceArr.size());
				lastAnswers.add(lastAnswer);
			}
		}
		return lastAnswers;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int q = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(
						Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
								.map(Integer::parseInt)
								.collect(toList())
				);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> result = dynamicArray(n, queries);

		bufferedWriter.write(
				result.stream()
						.map(Object::toString)
						.collect(joining("\n"))
						+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}
