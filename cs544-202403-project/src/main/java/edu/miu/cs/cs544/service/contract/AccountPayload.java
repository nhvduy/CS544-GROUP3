package edu.miu.cs.cs544.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountPayload implements Serializable {
    private Integer accountId;
    private  String name;
    private  String description;
    private Integer balance;
}
