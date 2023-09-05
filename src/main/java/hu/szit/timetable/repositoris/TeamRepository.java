package hu.szit.timetable.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.szit.timetable.models.Team;
 
public interface TeamRepository extends JpaRepository<Team, Integer> {}

