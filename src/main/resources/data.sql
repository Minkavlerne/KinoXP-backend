USE kinoxp;

INSERT INTO movies (Title, Description, PosterBase64, PosterURL, TrailerURL, AgeLimit, Duration)
VALUES
    ('The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 'base64data1', 'https://example.com/poster1.jpg', 'https://youtube.com/trailer1', 18, '02:22:00'),
    ('The Godfather', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 'base64data2', 'https://example.com/poster2.jpg', 'https://youtube.com/trailer2', 18, '02:55:00'),
    ('Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', 'base64data3', 'https://example.com/poster3.jpg', 'https://youtube.com/trailer3', 17, '02:34:00'),
    ('The Dark Knight', 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.', 'base64data4', 'https://example.com/poster4.jpg', 'https://youtube.com/trailer4', 13, '02:32:00'),
    ('Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.', 'base64data5', 'https://example.com/poster5.jpg', 'https://youtube.com/trailer5', 13, '02:28:00');

INSERT INTO category (created, updated, name) VALUES
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Action'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Comedy'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Drama'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Science Fiction'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Fantasy'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Horror'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Romance'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Thriller'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Documentary'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Animation'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Mystery'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Family'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Adventure'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Crime'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Historical'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Musical'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'War'),
      (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Biography');

INSERT INTO theater (created, updated, name) VALUES
     (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Sal 1'),
     (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Sal 2'),
     (CURRENT_TIMESTAMP(6), CURRENT_TIMESTAMP(6), 'Sal 3');

INSERT INTO movie_category (movie_id, category_id) VALUES
    (1, 3),
    (1, 7),
    (2, 3),
    (2, 15),
    (3, 3),
    (3, 7),
    (4, 1),
    (4, 3),
    (4, 7),
    (5, 3),
    (5, 4),
    (5, 7);

