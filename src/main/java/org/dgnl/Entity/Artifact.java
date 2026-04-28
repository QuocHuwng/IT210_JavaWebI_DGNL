package org.dgnl.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 150, message = "Tên từ 5-150 ký tự")
    private String name;

    @NotBlank(message = "Origin không được để trống")
    private String origin;

    @NotNull(message = "Date không được để trống")
    @PastOrPresent(message = "Date không được là tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Artifact() {}

    public Artifact(Long id, String name, String origin, LocalDate date) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.date = date;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}