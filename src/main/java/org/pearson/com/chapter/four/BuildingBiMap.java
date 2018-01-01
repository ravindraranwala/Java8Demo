package org.pearson.com.chapter.four;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildingBiMap {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("./src/main/resources/peopleWithGender.txt"));

				Stream<String> stream = reader.lines();) {

			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
				persons.add(p);
				return p;
			}).forEach(System.out::println);

		} catch (IOException ioe) {
			System.out.println(ioe);
		}

		Map<Integer, List<Person>> map = persons.stream().collect(Collectors.groupingBy(Person::getAge));
		map.forEach((age, list) -> System.out.println(age + " -> " + list));

		Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();

		persons.forEach(person -> biMap.computeIfAbsent(person.getAge(), HashMap::new).merge(person.getGender(),
				new ArrayList<>(Arrays.asList(person)), (l1, l2) -> {
					l1.addAll(l2);
					return l1;
				}));

		System.out.println("Bimap : ");
		biMap.forEach((age, m) -> System.out.println(age + " -> " + m));

	}

}
