package com.spring.mysql.JavaOneToMany.controllers;

import com.spring.mysql.JavaOneToMany.configuration.dtos.candidateDtos.CandidateDto;
import com.spring.mysql.JavaOneToMany.configuration.dtos.careerDtos.CareerDto;
import com.spring.mysql.JavaOneToMany.entities.Career;
import com.spring.mysql.JavaOneToMany.services.CareerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/career")
public class CareerController {
    @Autowired
    private CareerService careerService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CareerDto> save (@RequestBody CareerDto careerDto)
    {
        Career career = modelMapper.map(careerDto, Career.class);
        if(career.equals(null))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        this.careerService.save(career);
        return ResponseEntity.ok().body(careerDto);
    }
    @GetMapping
    public ResponseEntity<List<CareerDto>> findAll ()
    {
        List<CareerDto> careerDtos = this.careerService.findAll()
                .stream().map(career -> modelMapper.map(career,CareerDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(careerDtos);
    }
    @GetMapping("/{careerId}")
    public ResponseEntity<CareerDto> findById (@PathVariable(name = "careerId") Long careerId)
    {
        Optional<Career> career= this.careerService.findById(careerId);
        if(career.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CareerDto careerDto = this.modelMapper.map(career.get(), CareerDto.class);
        return ResponseEntity.ok().body(careerDto);
    }
    @DeleteMapping("/{careerId}")
    public void deleteById (@PathVariable(name = "careerId")Long careerId)
    {
        this.careerService.deleteById(careerId);
    }
    @PutMapping("/update/{careerId}")
    public ResponseEntity<CareerDto> update (@PathVariable(name = "careerId")Long careerId, @RequestBody CareerDto careerDto)
    {
        Optional<Career> career = this.careerService.findById(careerId);
        Career newCareer = this.modelMapper.map(careerDto, Career.class);
        if (career.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        this.careerService.update(careerId, newCareer);
        return ResponseEntity.ok().body(careerDto);
    }
    @GetMapping("/getByCareer/{careerId}")
    public ResponseEntity<List<CandidateDto>> listCandidateByCareerId (@PathVariable(name = "careerId") Long careerId)
    {
        List<CandidateDto> candidateDtos = this.careerService.listCandidateByCareerId(careerId)
                .stream().map(candidate -> modelMapper.map(candidate,CandidateDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(candidateDtos);
    }
}
