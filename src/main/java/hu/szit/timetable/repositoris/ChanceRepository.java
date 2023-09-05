package hu.szit.timetable.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.szit.timetable.models.Chance;
 
public interface ChanceRepository extends JpaRepository<Chance, Integer> {}

