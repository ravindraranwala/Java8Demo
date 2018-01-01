package org.pearson.com.chapter.three;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatting {

	public static void main(String[] args) {
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
		// System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));
	}

}
