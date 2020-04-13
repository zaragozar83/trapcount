package com.riac.trapcount.controller;

import com.riac.trapcount.repository.RanchRepository;
import com.riac.trapcount.repository.model.RanchEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/ranches")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RanchController {

    private final RanchRepository ranchRepository;

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name) {
        return name.isEmpty() ? "Hey!" : "Hey, " + name;
    }

    @GetMapping
    public Flux<RanchEntity> getListRanch() {
        return ranchRepository.findAll();
    }
}
