package com.reservation_system;


import com.reservation_system.model.AmenityType;
import com.reservation_system.model.Capacity;
import com.reservation_system.model.Reservation;
import com.reservation_system.model.User;
import com.reservation_system.repos.CapacityRepository;
import com.reservation_system.repos.ReservationRepository;
import com.reservation_system.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.HashMap;
import java.util.Map;

@EnableJpaAuditing
@SpringBootApplication
public class ReservationSystemApplication {

    private Map<AmenityType, Integer> initialCapacities =
            new HashMap<>() {
                {
                    put(AmenityType.GYM, 20);
                    put(AmenityType.POOL, 4);
                    put(AmenityType.SAUNA, 1);
                }
            };

    public static void main(String[] args) {
        SpringApplication.run(ReservationSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(
            UserRepository userRepository,
            CapacityRepository capacityRepository) {
        return (args) -> {
            userRepository.save(
                    new User("Tony Ho", "tonyho5689", bCryptPasswordEncoder().encode("12345")));

            for (AmenityType amenityType : initialCapacities.keySet()) {
                capacityRepository.save(new Capacity(amenityType, initialCapacities.get(amenityType)));
            }
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

