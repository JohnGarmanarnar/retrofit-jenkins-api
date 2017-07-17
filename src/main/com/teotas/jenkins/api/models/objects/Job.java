package com.teotas.jenkins.api.models.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {
    private String name;
    private String url;
    private String color;
}
