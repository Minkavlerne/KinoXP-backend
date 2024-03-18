package org.example.kinoxpbackend;

import org.example.kinoxpbackend.kino.entity.*;
import org.example.kinoxpbackend.kino.repository.*;
import org.example.kinoxpbackend.security.entity.Role;
import org.example.kinoxpbackend.security.entity.UserWithRoles;
import org.example.kinoxpbackend.security.repository.RoleRepository;
import org.example.kinoxpbackend.security.repository.UserWithRolesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootApplication
public class KinoXpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinoXpBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner importData(CategoryRepository categoryRepository, MovieRepository movieRepository, TheaterRepository theaterRepository, MovieShowRepository movieShowRepository, RoleRepository roleRepository, UserWithRolesRepository userWithRolesRepository, PasswordEncoder pwEncoder, SeatRepository seatRepository, BookingRepository bookingRepository) {
		return (args) -> {
			// import data here

			// User roles
			roleRepository.save(new Role("USER"));
			roleRepository.save(new Role("ADMIN"));

			String passwordUsedByAll = "test123";

			UserWithRoles user1 = new UserWithRoles("user", pwEncoder.encode(passwordUsedByAll), "user1@test.dk");
			UserWithRoles user2 = new UserWithRoles("admin", pwEncoder.encode(passwordUsedByAll), "user2@test.dk");
			user1.addRole(roleRepository.findById("USER").orElseThrow(() -> new NoSuchElementException("Role not found")));
			user2.addRole(roleRepository.findById("ADMIN").orElseThrow(() -> new NoSuchElementException("Role not found")));

			userWithRolesRepository.save(user1);
			userWithRolesRepository.save(user2);

			List<Category> categories = new ArrayList<>();
			categories.add(new Category("Action"));
			categories.add(new Category("Comedy"));
			categories.add(new Category("Drama"));
			categories.add(new Category("Horror"));
			categories.add(new Category("Romance"));
			categoryRepository.saveAll(categories);


			List<Movie> movies = new ArrayList<>();
			movies.add(new Movie("The Matrix", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", "posterbase64", "posterUrl", "trailerUrl", 16, LocalTime.of(2, 16, 10, 0), LocalDate.of(1999, 5, 7)));
			movies.add(new Movie("The Shawshank Redemption", "Two imprisoned men bond over a number of years", "posterbase64", "posterUrl", "trailerUrl", 16, LocalTime.of(2, 22, 10, 0), LocalDate.of(1995, 4, 28)));
			movies.add(new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", "posterbase64", "posterUrl", "trailerUrl", 16, LocalTime.of(2, 55, 10, 0), LocalDate.of(1972, 3, 24)));
			movies.add(new Movie("The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "posterbase64", "posterUrl", "trailerUrl", 16, LocalTime.of(2, 32, 10, 0), LocalDate.of(2008, 7, 18)));

			for (Movie movie: movies) {
				movie.setCategories(categories);
				movieRepository.save(movie);
			}

			List<Theater> theaters = new ArrayList<>();
			theaters.add(new Theater("Winter is coming"));
			theaters.add(new Theater("Fools spring"));
			theaters.add(new Theater("Summer"));
			theaterRepository.saveAll(theaters);

			for (Theater theater: theaters) {
				List<Seat> seats = new ArrayList<>();
				for (int seatRow = 0; seatRow < 10; seatRow++) {
					for (int seatNumber = 0; seatNumber < 10; seatNumber++) {
						seats.add(new Seat(seatRow, seatNumber, "NORMAL"));
					}
				}
				seatRepository.saveAll(seats);
				theater.setSeats(seats);
				theaterRepository.save(theater);
			}

		};
	}
}
