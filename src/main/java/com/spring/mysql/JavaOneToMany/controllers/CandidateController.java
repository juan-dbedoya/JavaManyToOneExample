package com.spring.mysql.JavaOneToMany.controllers;

import com.spring.mysql.JavaOneToMany.configuration.dtos.candidateDtos.CandidateDto;
import com.spring.mysql.JavaOneToMany.entities.Candidate;
import com.spring.mysql.JavaOneToMany.services.CandidateServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidate")
public class CandidateController  {
    @Autowired
    private CandidateServices candidateServices;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CandidateDto> save (@RequestBody CandidateDto candidateDto)
    {
        Candidate candidate = this.modelMapper.map(candidateDto, Candidate.class);
        if(candidate.equals(null))
            return new ResponseEntity<CandidateDto>(HttpStatus.BAD_REQUEST);
        this.candidateServices.save(candidate);
        return ResponseEntity.ok().body(candidateDto);

    }
    @GetMapping
    public ResponseEntity<List<CandidateDto>> findAll ()
    {
        return ResponseEntity.ok().body(this.candidateServices.findAll()
                .stream().map(candidate -> modelMapper.map(candidate, CandidateDto.class))
                .collect(Collectors.toList()));
    }
    @GetMapping("/{candidateId}")
    public ResponseEntity<CandidateDto> findById (@PathVariable(name = "candidateId")Long candidateId)
    {
        Optional<Candidate> candidate = this.candidateServices.findById(candidateId);
        if(candidate.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CandidateDto candidateDto = modelMapper.map(candidate.get(),CandidateDto.class);
        return ResponseEntity.ok().body(candidateDto);
    }
    @DeleteMapping("/{candidateId}")
    public void deleteById (@PathVariable(name = "candidateId")Long candidateId)
    {
        this.candidateServices.deleteById(candidateId);
    }
    @PutMapping("/update/{candidateId}")
    public ResponseEntity<CandidateDto> update (@PathVariable(name = "candidateId") Long candidateId,@RequestBody CandidateDto candidateDto)
    {
        Optional<Candidate> candidate = this.candidateServices.findById(candidateId);
        Candidate newCandidate = this.modelMapper.map(candidateDto, Candidate.class);
        if(candidate.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        this.candidateServices.update(candidateId,newCandidate);
        return ResponseEntity.ok().body(candidateDto);
    }
}
