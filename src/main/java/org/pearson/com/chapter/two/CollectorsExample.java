package org.pearson.com.chapter.two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.pearson.com.chapter.two.model.Person;

/**
 *
 * @author José
 */
public class CollectorsExample {

	public static void main(String... args) {

		List<Person> persons = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("./src/main/resources/people.txt"));

				Stream<String> stream = reader.lines();) {

			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
				persons.add(p);
				return p;
			}).forEach(System.out::println);

		} catch (IOException ioe) {
			System.out.println(ioe);
		}

		Optional<Person> opt = persons.stream().filter(p -> p.getAge() >= 20).min(Comparator.comparing(Person::getAge));
		System.out.println(opt);

		Optional<Person> opt2 = persons.stream().max(Comparator.comparing(Person::getAge));
		System.out.println(opt2);

		// Map<Integer, List<Person>> map =
		// persons.stream().collect(Collectors.groupingBy(Person::getAge));
		// System.out.println(map);

		// Map<Integer, Long> map = persons.stream()
		// .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
		// System.out.println(map);

		// Map<Integer, List<String>> personMap = persons.stream().collect(
		// Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName,
		// Collectors.toList())));
		// System.out.println(personMap);

		// Map<Integer, Set<String>> personSortedSet =
		// persons.stream().collect(Collectors.groupingBy(Person::getAge,
		// Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new))));
		// System.out.println(personSortedSet);

		Map<Integer, String> map = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.joining(", "))));
		System.out.println(map);

	}
}
