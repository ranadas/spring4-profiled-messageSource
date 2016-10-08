package pl.dmichalski.model;


import lombok.*;

/**
 * Created by rdas on 08/10/2016.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private long customerId;
    private long version;
    @lombok.NonNull
    private String name;
    private long credit;
}
