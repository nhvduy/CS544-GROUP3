package edu.miu.cs.cs544.domain;

import edu.miu.cs.cs544.domain.constant.LocationType;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locationId;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    LocationType locationType;

    public Location(){}


}
