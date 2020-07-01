package adubolazov.quiz.string.archiver;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringArchiver {
	
	public static String archive(String input) {
		if(input == null || !input.matches("\\D+")) {
			return input;
		} else {
			return Arrays.stream(input.split("(?<=(.))(?!\\1)"))
					.map(StringArchiver::transform)
					.collect(Collectors.joining());
		}
	}

	private static String transform(String token) {
		return token.length() == 1 ? token : Integer.toString(token.length()) + token.charAt(0);
	}
}
