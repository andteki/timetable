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

import hu.szit.timetable.models.Chance;
import hu.szit.timetable.repositoris.ChanceRepository;

@RestController
@RequestMapping(path="/api")
public class ChanceController {

    @Autowired
    ChanceRepository chanceRepository;

    @GetMapping("/chance")
    public @ResponseBody Iterable<Chance> index() {
        return chanceRepository.findAll();
    }

	@GetMapping("/chance/{id}")
	public @ResponseBody Chance show(@PathVariable Integer id) {
		return chanceRepository.findById(id).get();
	}
	@PostMapping(path="/chance")
	public Chance store(@RequestBody Chance chance) {
		Chance res = chanceRepository.save(chance);
		return res;
	}
	@PutMapping("/chance/{id}")
	public Chance update(@RequestBody Chance chance, @PathVariable Integer id) {
 
		Optional<Chance> orig = chanceRepository.findById(id);
		if(orig.isPresent()) {
			Chance origChance = orig.get();
			origChance.setDate(chance.getDate());
			origChance.setTeamId(chance.getTeamId());
			origChance.setSubjectId(chance.getSubjectId());
			origChance.setZoneId(chance.getZoneId());

			return chanceRepository.save(origChance);
		}else {
			return chance;
		}
	}
	@DeleteMapping("/chance/{id}")
	public Chance delete(@PathVariable Integer id) {
		Optional<Chance> orig = chanceRepository.findById(id);
		chanceRepository.deleteById(id);
		return orig.get();
	}    

}
