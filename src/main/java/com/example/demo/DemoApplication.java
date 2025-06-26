package com.example.demo;

import com.example.demo.modal.Movie;
import com.example.demo.repository.MovieRepository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	final static String FILE_NAME = "/Movielist.csv";
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(MovieRepository repository) {
		return args -> {
			try (InputStreamReader reader = new InputStreamReader(
					Objects.requireNonNull(DemoApplication.class.getResourceAsStream(FILE_NAME)),
					StandardCharsets.UTF_8
			)) {
				final CSVReader csvReader = new CSVReaderBuilder(reader).build();
				final List<String[]> rows = csvReader.readAll();

				if (!rows.isEmpty()) {
					rows.remove(0); // Remove header row
				}

				rows.stream()
						.map(this::processRow) // Process each row
						.filter(Objects::nonNull) // Filter out invalid rows
						.forEach(repository::save); // Save valid movies

			} catch (IOException | CsvException e) {
				System.err.println("Error reading or parsing CSV file: " + e.getMessage());
			}
		};
	}

	private Movie processRow(String[] row) {
		if (Objects.isNull(row) || row.length == 0) {
			return null; // Skip empty rows
		}

		// Concatenate row elements if needed
		String concatenatedRow = row.length > 1
				? Arrays.stream(row).reduce((a, b) -> a + ", " + b).orElse("")
				: String.join(";", row);

		// Split into fields
		List<String> fields = Arrays.stream(concatenatedRow.split(";")).toList();

		// Validate and create Movie object
		if (fields.size() < 4) {
			return null;
		}

		return new Movie(
				UUID.randomUUID().toString(),
				fields.get(1), // Title
				Integer.parseInt(fields.get(0)), // Year
				fields.get(2), // Studio
				fields.get(3), // Producers
				fields.size() > 4 ? fields.get(4) : "no" // Winner
		);
	}
}
