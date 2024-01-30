package com.example.Esercizio8.Controllers;

/*import Entities.Car;
import Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/createCar")
    public Car createCar(@RequestBody Car car) {
        Car ca1 = carRepository.saveAndFlush(car);
        return ca1;
    }

    @GetMapping("/getAll")
    public List<Car> listCar() {
        List<Car> listCars = carRepository.findAll();
        return listCars;
    }

    @GetMapping("/getCar/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return carRepository.findById(id);
    }

    @PatchMapping("/updateType/{id}")
    public Car updateTypeCar(@PathVariable long id, @RequestBody Car updatedCar) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            Car existingCar = optionalCar.get();

            // Aggiorna solo se il nuovo tipo non è nullo
            if (updatedCar.getType() != null) {
                existingCar.setType(updatedCar.getType());
            }

            // Aggiungi altri aggiornamenti se necessario

            // Salva l'auto aggiornata nel repository
            return carRepository.saveAndFlush(existingCar);
        }

        // Se l'ID non è stato trovato, restituisci null o un nuovo CarEntity vuoto, a seconda delle tue esigenze
        return null;
    }


    @DeleteMapping("/deleteCar/{id}")
    public void deleteCar(@PathVariable Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}*/

import com.example.Esercizio8.Entities.Car;
import com.example.Esercizio8.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/create")
    private Car createCar(@RequestBody Car carEntity) {
        Car carSaved = carRepository.saveAndFlush(carEntity);
        return carSaved;
    }

    @GetMapping("/allcars")
    private List<Car> getAll() {
        List<Car> allCars = carRepository.findAll();
        return allCars;
    }

    @GetMapping("/car/{id}")
    private Car getCar(@PathVariable long id) {
        if(carRepository.existsById(id)) {
            Car savedCar = carRepository.getById(id);
            return savedCar;
        } else {
            return new Car();
        }
    }

    @DeleteMapping("/delcar/{id}")
    public ResponseEntity<String> deleteSingle(@PathVariable long id) {
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return ResponseEntity.ok("Car deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Car with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/delcars")
    private void deleteAll() {
        carRepository.deleteAll();
    }

    @PatchMapping("/typeup/{id}")
    private Car updateType(@PathVariable long id, @RequestParam String newType) {
        if(carRepository.existsById(id)) {
            Car carToPatch = carRepository.getById(id);
            carToPatch.setType(newType);
            carRepository.saveAndFlush(carToPatch);
            return carToPatch;
        } else {
            return new Car();
        }
    }

}
