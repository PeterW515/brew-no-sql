package com.hopsoft.brew.ingredients.controller;

import com.hopsoft.brew.ingredients.assembler.HopModelAssembler;
import com.hopsoft.brew.ingredients.domain.Hop;
import com.hopsoft.brew.ingredients.exception.HopNotFoundException;
import com.hopsoft.brew.ingredients.service.api.HopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/ingredients/hops")
public class HopController {
    private static final Logger logger = LoggerFactory.getLogger(HopController.class);

    @Autowired
    HopService hopService;

    @Autowired
    HopModelAssembler hopModelAssembler;

    @GetMapping(value="/list")
    public @ResponseBody
    CollectionModel<EntityModel<Hop>> getAll(){
        List<EntityModel<Hop>> hops = hopService
                .findAll()
                .stream()
                .map(hopModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(hops, linkTo(methodOn(HopController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/hopId/{id}")
    public @ResponseBody
    EntityModel<Hop> getOne(@PathVariable String id) {
        Hop hop = hopService.findByHopId(id).orElseThrow(() -> new HopNotFoundException(id));
        return hopModelAssembler.toModel(hop);
    }

    @PostMapping(path="/hop")
    public @ResponseBody
    ResponseEntity<?> newHop(@RequestBody Hop newHop){
        EntityModel<Hop> entityModel = hopModelAssembler.toModel(hopService.saveHop(newHop));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/hopId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceHop(@RequestBody Hop newHop, @PathVariable String id){
        Hop updatedHop = hopService.findByHopId(id).map(hop -> {
            hop.setHopName(newHop.getHopName());
            hop.setAlphaAcidLowerBound(newHop.getAlphaAcidLowerBound());
            hop.setAlphaAcidUpperBound(newHop.getAlphaAcidUpperBound());
            hop.setNominalAlphaAcidPercent(newHop.getNominalAlphaAcidPercent());
            hop.setHopPurpose(newHop.getHopPurpose());
            hop.setNoble(newHop.isNoble());
            hop.setHopStorageIndex(newHop.getHopStorageIndex());
            hop.setFlavorProfile(newHop.getFlavorProfile());
            return hopService.saveHop(hop);
        }).orElseGet(()->{
            newHop.setId(id);
            return hopService.saveHop(newHop);
        });

        EntityModel<Hop> entityModel = hopModelAssembler.toModel(updatedHop);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/hopId/{id}")
    ResponseEntity<?> deleteHop(@PathVariable String id) {
        hopService.deleteByHopId(id);
        return ResponseEntity.noContent().build();
    }
}
