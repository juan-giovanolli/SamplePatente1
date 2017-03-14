package com.sulti.samplepatente1.model;

import java.util.Date;

/**
 * Created by juanj on 23/2/2017.
 */

public class Fine {
    private Date date;
    private Long amount;
    private String description;

    public Fine(Date date, Long amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
