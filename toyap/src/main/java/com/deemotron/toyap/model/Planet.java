package com.deemotron.toyap.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Planet", description = "Planet entity definition")
public class Planet {

    @ApiModelProperty(position = 1)
    private String planetName;

    @ApiModelProperty(position = 2)
    private double mass; // in kilograms

    @ApiModelProperty(position = 3)
    private double radius; // in meters

    @ApiModelProperty(position = 4)
    private double surfaceGravity;

    @ApiModelProperty(position = 5)
    private double yourWeightOnPlanet;
}
