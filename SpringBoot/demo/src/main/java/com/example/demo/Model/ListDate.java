package com.example.demo.Model;

import org.springframework.stereotype.Component;

@Component
public class ListDate {
    private String id;
    private String selectOption;

    public ListDate() {
        super();
    }

    public String ListDate(String Object) {
        return Object;
    }

    public ListDate(String id, String selectOption) {
        this.id = id;
        this.selectOption = selectOption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelectOption() {
        return selectOption;
    }

    public void setSelectOption(String selectOption) {
        this.selectOption = selectOption;
    }

}
