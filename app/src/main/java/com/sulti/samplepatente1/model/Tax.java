package com.sulti.samplepatente1.model;

import java.util.Date;

/**
 * Created by juanj on 19/2/2017.
 */

public class Tax {
    private Date date;
    private Long amount;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tax(Date date, Long amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
