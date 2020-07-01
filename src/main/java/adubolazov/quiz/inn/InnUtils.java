package adubolazov.quiz.inn;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

public class InnUtils {

	private static final String BASE_SET = " _     _  _     _  _  _  _  _ \n" + 
										   "| |  | _| _||_||_ |_   ||_||_|\n" +
										   "|_|  ||_  _|  | _||_|  ||_| _|\n";

	private static Map<String, Integer> dictionary = invert(parse(BASE_SET, 10));

	private static boolean validate(@NotNull String innCode) {
		return innCode.length() == 84 && innCode.matches("[ _|\n]+") && innCode.charAt(27) == '\n' && innCode.charAt(55) == '\n'
				&& innCode.charAt(83) == '\n';
	}

	private static Map<Integer, String> parse(@NotNull String innCode, int stringLength) {
		AtomicInteger index = new AtomicInteger();
		return Arrays.stream(innCode.replaceAll("\n", "").split("(?<=\\G.{3})"))
			.collect(Collectors.groupingBy(c -> index.getAndIncrement() % stringLength, Collectors.joining()));
	}
	
	private static <V, K> Map<V, K> invert(Map<K, V> map) {
	    return map.entrySet().stream().collect(Collectors.toMap(Entry::getValue, Entry::getKey));
	}
	
	public static String parseInn(@NotNull String innCode) {
		if(validate(innCode)) {
			try {
				return new TreeMap<>(parse(innCode, 9)).values().stream()
					.map(d -> dictionary.get(d).toString())
					.collect(Collectors.joining()).replaceFirst("^0+(?!$)", "");
			} catch (Exception e) {
				throw new RuntimeException("Invalid value: " + innCode);
			}
		} else {
			throw new RuntimeException("Invalid value: " + innCode);
		}
	}
}
