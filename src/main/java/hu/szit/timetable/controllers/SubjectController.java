package hu.szit.timetable.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hu.szit.timetable.models.Subject;
import hu.szit.timetable.repositoris.SubjectRepository;

@RestController
@RequestMapping(path="/api")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/subject")
    public @ResponseBody Iterable<Subject> index() {
        return subjectRepository.findAll();
    }

	@GetMapping("/subject/{id}")
	public @ResponseBody Subject show(@PathVariable Integer id) {
		return subjectRepository.findById(id).get();
	}
	@PostMapping(path="/subject")
	public Subject store(@RequestBody Subject chance) {
		Subject res = subjectRepository.save(chance);
		return res;
	}
	@PutMapping("/subject/{id}")
	public Subject update(@RequestBody Subject chance, @PathVariable Integer id) {
 
		Optional<Subject> orig = subjectRepository.findById(id);
		if(orig.isPresent()) {
			Subject origChance = orig.get();
			origChance.setName(chance.getName());


			return subjectRepository.save(origChance);
		}else {
			return chance;
		}
	}
	@DeleteMapping("/subject/{id}")
	public Subject delete(@PathVariable Integer id) {
		Optional<Subject> orig = subjectRepository.findById(id);
		subjectRepository.deleteById(id);
		return orig.get();
	}    

}
