package GeekTrust;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Syed Ali.
 * @createdAt 26/09/2021, Sunday, 20:03
 */
public class Geektrust {

	private static Map<String, String> kingDoms = new HashMap<>();


	public static void main(String[] args) {
		String fileName = args[0];
		if (fileName != null) {
			try {
				Stream<String> stream = Files.lines(Paths.get(fileName));
				List<String> messages = stream.collect(Collectors.toList());
				decrypt(messages);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid File Name...");
		}
	}

	private static void preProcess() {
		kingDoms.put("SPACE", "GORILLA");
		kingDoms.put("LAND", "PANDA");
		kingDoms.put("WATER", "OCTOPUS");
		kingDoms.put("ICE", "MAMMOTH");
		kingDoms.put("AIR", "OWL");
		kingDoms.put("FIRE", "DRAGON");
	}

	public static void decrypt(List<String> messages) {
		// To set pre data.
		preProcess();

		List<String> wonKingDoms = new ArrayList<>();
		for (String message : messages) {
			String[] values = message.split(" ");
			if (values.length > 0) {

				String kingDom = values[0];
				char[] encryptedMessage = values[1].toCharArray();
				char[] secret = kingDoms.get(kingDom).toCharArray();
				int rotate = secret.length;
				int[] freq = new int[27];
				for (char item : secret) {
					freq[item - 'A']++;
				}

				for (char value : encryptedMessage) {
					int decryptedChar = value - 'A' - rotate;
					decryptedChar = decryptedChar < 0 ? 26 + decryptedChar : decryptedChar;
					freq[decryptedChar]--;
				}

				boolean secretMessageFound = true;
				for (char c : secret) {
					if (freq[c - 'A'] > 0) {
						secretMessageFound = false;
						break;
					}
				}
				if (secretMessageFound) wonKingDoms.add(kingDom);
			}
		}

		if (wonKingDoms.size() > 2) {
			System.out.print("SPACE ");
			for (String wonKingDom : wonKingDoms) {
				System.out.print(wonKingDom + " ");
			}
			System.out.println();
		}
	}
}
