package com.hopsoft.brew.ingredients.enums;

public enum YeastForm {
        LIQUID("Liquid"),
        DRY("Dry");

        private final String yeastForm;

        YeastForm(String yeastForm){
            this.yeastForm = yeastForm;
        }

        public String getYeastForm(){
            return yeastForm;
        }
    }