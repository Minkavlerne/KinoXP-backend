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
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
			movies.add(new Movie("The Matrix", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", "posterbase64", "https://m.media-amazon.com/images/I/71PfZFFz9yL._AC_UF894,1000_QL80_.jpg", "trailerUrl", 16, LocalTime.of(2, 16, 10, 0), LocalDate.of(1999, 5, 7)));
			movies.add(new Movie("The Shawshank Redemption", "Two imprisoned men bond over a number of years", "posterbase64", "https://m.media-amazon.com/images/I/71715eBi1sL._AC_UF894,1000_QL80_.jpg", "trailerUrl", 16, LocalTime.of(2, 22, 10, 0), LocalDate.of(1995, 4, 28)));
			movies.add(new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", "posterbase64", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg", "trailerUrl", 16, LocalTime.of(2, 55, 10, 0), LocalDate.of(1972, 3, 24)));
			movies.add(new Movie("The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "posterbase64", "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg", "trailerUrl", 16, LocalTime.of(2, 32, 10, 0), LocalDate.of(2008, 7, 18)));
			movies.add(new Movie("Inception", "A thief who enters the dreams of others to steal their secrets from their subconscious gets a chance to redeem himself by planting an idea in the mind of a CEO.", "posterbase64", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg", "trailerUrl", 13, LocalTime.of(2, 28, 0, 0), LocalDate.of(2010, 7, 16)));
			movies.add(new Movie("Interstellar", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", "posterbase64", "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg", "trailerUrl", 10, LocalTime.of(2, 49, 0, 0), LocalDate.of(2014, 11, 7)));
			movies.add(new Movie("Pulp Fiction", "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", "posterbase64", "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,666,1000_AL_.jpg", "trailerUrl", 18, LocalTime.of(2, 34, 0, 0), LocalDate.of(1994, 10, 14)));
			movies.add(new Movie("Fight Club", "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.", "posterbase64", "https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,674,1000_AL_.jpg", "trailerUrl", 18, LocalTime.of(2, 19, 0, 0), LocalDate.of(1999, 11, 5)));
			movies.add(new Movie("Civil War", "Political involvement in the Avengers' affairs causes a rift between Captain America", "posterbase64", "https://m.media-amazon.com/images/M/MV5BYTYyODhlODktYjUzNC00NjUyLWI1MzYtNmI0MTY3YTUxYjY2XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg", "trailerUrl", 18, LocalTime.of(1, 49, 0, 0), LocalDate.of(2024, 4, 18)));


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

			List<MovieShow> movieShows = new ArrayList<>();
			movieShows.add(new MovieShow(Timestamp.valueOf("2024-03-18 12:00:00"), Timestamp.valueOf("2024-03-18 12:00:00"), movies.get(0), theaters.get(0)));
			movieShows.add(new MovieShow(Timestamp.valueOf("2024-03-18 12:00:00"), Timestamp.valueOf("2024-03-18 12:00:00"), movies.get(1), theaters.get(1)));
			movieShows.add(new MovieShow(Timestamp.valueOf("2024-03-18 12:00:00"), Timestamp.valueOf("2024-03-18 12:00:00"), movies.get(2), theaters.get(2)));
			movieShows.add(new MovieShow(Timestamp.valueOf("2024-03-18 12:00:00"), Timestamp.valueOf("2024-03-18 12:00:00"), movies.get(3), theaters.get(0)));
			movieShowRepository.saveAll(movieShows);

			List<Booking> bookings = new ArrayList<>();


			Random random = new Random();

			for (MovieShow movieShow: movieShows) {

				List<Seat> allSeats = movieShow.getTheater().getSeats();

				int numberOfSeatsToBook = random.nextInt(4) + 1;

				List<Seat> seatsToBook = IntStream.range(0, numberOfSeatsToBook).mapToObj(allSeats::get).toList();

				Booking booking = new Booking(movieShow, user1);
				booking.setSeats(seatsToBook);

				bookings.add(booking);
			}
			bookingRepository.saveAll(bookings);
		};
	}
}
