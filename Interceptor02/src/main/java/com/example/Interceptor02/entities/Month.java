package com.example.Interceptor02.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private long id;
    //@Column(name = "month_number")
    private int monthNumber;
    //@Column(name = "english_name")
    private String englishName;
    //@Column(name = "italian_name")
    private String italianName;
    //@Column(name = "german_number")
    private String germanName;
}

/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Month {

    private int monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;
}*/
