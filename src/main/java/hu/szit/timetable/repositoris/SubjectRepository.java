package hu.szit.timetable.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.szit.timetable.models.Subject;
 
public interface SubjectRepository extends JpaRepository<Subject, Integer> {}

