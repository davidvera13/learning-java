package io.warehouse13.learning;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		// In this challenge, you should write a program that validates email addresses, based on a set of predefined rules.
		//An email address should be formatted as username@domain.
		//The username part of the email address can contain alphanumeric characters, so lowercase a to z, upper case A to Z, digits 0 to 9, dots or periods, underscores, and hyphens or dashes (-).
		//The domain part of the email address can contain alphanumeric characters and digits, as well as periods or dashes, such as xyz.com, or abc-xyz.org, but could also be xyz.edu.uk for example.
		// Your program should:
		//Use regular expressions and the Pattern class to compile the pattern.
		//Use the Matcher class to match the entered email address against the compiled pattern.
		//For valid email addresses, display the username and the domain name, using one of the group methods.
		//Use the examples shown here, or ones of your own invention, to test your code.

		List<String> emails = List.of(
				"john.boy@valid.com",
				"john.boy@invalid",
				"jane.doe-smith@valid.co.uk",
				"jane_Doe1976@valid.co.uk",
				"bob-1964@valid.net",
				"bob!@invalid.com",
				"elaine@valid-test.com.au",
				"elaineinvalid1983@.com",
				"david@valid.io",
				"david@invalid..com");

		Pattern pattern;

		// pattern= Pattern.compile("(.+)@(.+)");
		// all are valids
		// checkPattern(pattern, emails);

		//pattern= Pattern.compile("([\\p{Alnum}_.-]+)@(.+)");
		// pattern= Pattern.compile("([\\w.-]+)@(.+)");
		// removes "bob!@invalid.com",
		// checkPattern(pattern, emails);

		//pattern =
		//		Pattern.compile("([\\w.-]+)@(([\\w-]+\\.)+[\\w-]{2,})");
		// removes "bob!@invalid.com",
		//checkPattern(pattern, emails);

		Pattern emailPattern =
				Pattern.compile("([\\w.-]+)@(([\\w-]+\\.)+[\\w-]{2,})");

		emails.forEach(email -> {
			Matcher eMatcher = emailPattern.matcher(email);
			boolean matched = eMatcher.matches();
			System.out.print(email + " is " + (matched ? "VALID " : "INVALID "));
			if (matched) {
				System.out.printf("[username=%s, domain=%s]%n",
						eMatcher.group(1),
						eMatcher.group(2));
			} else {
				System.out.println();
			}
		});
	}

	private static void checkPattern(Pattern pattern, List<String> emails) {
		emails.forEach(email -> {
			Matcher matcher = pattern.matcher(email);
			matcher.results().forEach(matchResult ->
					System.out.printf("username -> %s, domain -> %s%n", matchResult.group(1), matchResult.group(2)));
			System.out.println(email + " > " + matcher.matches());
			System.out.println("-------");
		});
	}
}
