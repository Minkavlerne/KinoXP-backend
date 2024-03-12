package org.example.kinoxpbackend.kino.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookedSeat {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int Id;

    @CreationTimestamp
    public LocalDateTime created_at;
}
