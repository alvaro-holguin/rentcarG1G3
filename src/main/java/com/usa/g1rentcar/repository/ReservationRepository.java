package com.usa.g1rentcar.repository;

import com.usa.g1rentcar.model.Car;
import com.usa.g1rentcar.model.Client;
import com.usa.g1rentcar.model.Reservation;
import com.usa.g1rentcar.model.custom.CountCar;
import com.usa.g1rentcar.model.custom.CountClient;
import com.usa.g1rentcar.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public  List<CountCar> getTopCars(){
        List<CountCar>res=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationsByCar();
        for(int i=0;i<report.size();i++){
            res.add(new CountCar((Long)report.get(i)[1],(Car) report.get(i)[0]));
        }
        return res;
    }


    public  List<CountClient> getTopClients(){
        List<CountClient>res=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

}
