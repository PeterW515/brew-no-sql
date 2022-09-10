package com.hopsoft.brew.ingredients.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Grain {

    @Id
    private String id;

    private String grainName;


}
