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
	public CommandLineRunner importData(CategoryRepository categoryRepository, MovieRepository movieRepository, TheaterRepository theaterRepository, MovieShowRepository movieShowRepository, RoleRepository roleRepository, UserWithRolesRepository userWithRolesRepository, PasswordEncoder pwEncoder, SeatRepository seatRepository) {
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

			final List<Category> categories = new ArrayList<>();
			categories.add(new Category("Action"));
			categories.add(new Category("Drama"));
			categories.add(new Category("Comedy"));
			categories.add(new Category("Thriller"));
			categories.add(new Category("Horror"));
			categories.add(new Category("Romance"));
			categories.add(new Category("Sci-Fi"));
			categories.add(new Category("Fantasy"));

			final List<Movie> movies = new ArrayList<>();
			movies.add(new Movie("The Shawshank Redemption", "Two imprisoned", "base64", "url", "url", 18, LocalTime.parse("02:22:00")));
			movies.add(new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", "base64", "url", "url", 18, LocalTime.parse("02:22:00")));
			movies.add(new Movie("The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "base64", "url", "url", 18, LocalTime.parse("02:22:00")));
			movies.add(new Movie("The Avengers", "The heroes of earth take on the mighty Asguardian Loki", "base64", "url", "url", 18, LocalTime.parse("02:22:00")));
			movies.add(new Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", "base64", "url", "url", 18, LocalTime.parse("02:22:00")));

			for (Movie movie: movies) {
				movie.setCategories(new ArrayList<>(categories));
				movieRepository.save(movie);

				for (Category category: categories) {
					category.getMovies().add(movie);

					categoryRepository.save(category);
				}
			}



			final List<Theater> theaters = new ArrayList<>();
			theaters.add(new Theater("The big one"));
			theaters.add(new Theater("The medium one"));
			theaters.add(new Theater("The small one"));
			theaterRepository.saveAll(theaters);

			final List<MovieShow> movieShows = new ArrayList<>();
			movieShows.add(new MovieShow(Timestamp.valueOf("2024-03-10 12:30:00"), Timestamp.valueOf("2024-03-10 14:30:00"), movies.get(0), theaters.get(0)));
			movieShows.add(new MovieShow(Timestamp.valueOf("2024-03-10 15:30:00"), Timestamp.valueOf("2024-03-10 17:30:00"), movies.get(1), theaters.get(1)));
			movieShows.add(new MovieShow(Timestamp.valueOf("2024-03-10 18:30:00"), Timestamp.valueOf("2024-03-10 20:30:00"), movies.get(2), theaters.get(2)));
			movieShows.add(new MovieShow(Timestamp.valueOf("2024-03-10 21:30:00"), Timestamp.valueOf("2024-03-10 23:30:00"), movies.get(3), theaters.get(0)));
			movieShows.add(new MovieShow(Timestamp.valueOf("2024-03-10 12:30:00"), Timestamp.valueOf("2024-03-10 14:30:00"), movies.get(4), theaters.get(1)));
			movieShowRepository.saveAll(movieShows);


			final List<Seat> seats = new ArrayList<>();
			for (int theater = 0; theater < 3; theater++) {
				for (int i = 1; i <= 12; i++) {
					for (int j = 1; j <= 12; j++) {
						seats.add(new Seat(i, j, "NORMAL", theaters.get(theater)));
					}
				}
			}
			seatRepository.saveAll(seats);
		};
	}
}
