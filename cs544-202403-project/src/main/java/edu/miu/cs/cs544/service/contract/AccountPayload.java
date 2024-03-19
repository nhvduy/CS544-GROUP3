package edu.miu.cs.cs544.service.contract;
@Data
public class AccountPayload implements Serializable {
    private  String name;
    private  String description;
    private Integer balance;
}
