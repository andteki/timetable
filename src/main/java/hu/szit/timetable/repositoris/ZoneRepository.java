package hu.szit.timetable.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.szit.timetable.models.Zone;
 
public interface ZoneRepository extends JpaRepository<Zone, Integer> {}

