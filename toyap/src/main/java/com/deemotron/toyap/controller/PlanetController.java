package com.deemotron.toyap.controller;

import com.deemotron.toyap.model.Planet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "API to search Planets",
        description = "This API provides the capability to search Planet from a Planet Repository.", tags = { "Planets" })
public class PlanetController {
    
    @ApiOperation(value="Get a person weight on the Planet.", tags = { "Planets" })
    @GetMapping("/weight/for/me/on/{planetName}/{earthWeight}")
    public ResponseEntity<Planet> weightForMe(

        @ApiParam(value = "Planet Name", example = "MERCURY", required = true)
        @PathVariable String planetName, 
        
        @ApiParam(value = "Earth Weight", example = "175", required = true)
        @PathVariable double earthWeight) {
            
        com.deemotron.toyap.util.Planet planetEnum = 
            com.deemotron.toyap.util.Planet.valueOf(planetName.toUpperCase());
        Planet p = Planet.builder()
        .planetName(planetEnum.name())
        .mass(planetEnum.mass())
        .radius(planetEnum.radius())
        .surfaceGravity(planetEnum.surfaceGravity())
        .yourWeightOnPlanet(
            planetEnum.surfaceWeight(earthWeight) / com.deemotron.toyap.util.Planet.EARTH.surfaceGravity())
        .build();
        return ResponseEntity.ok(p);
    }
}
