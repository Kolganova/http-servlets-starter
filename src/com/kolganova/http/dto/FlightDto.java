package com.kolganova.http.dto;

import lombok.*;

@Value
@Builder
public class FlightDto {
    Long id;
    String description;

}
