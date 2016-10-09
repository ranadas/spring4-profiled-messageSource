package pl.dmichalski.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.dmichalski.dao.GenericRepository;
import pl.dmichalski.model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by rdas on 09/10/2016.
 */
@RestController
public class CustomerController {

    @Autowired
    private GenericRepository genericRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAllCustomers() throws SQLException {
        System.out.println(genericRepository.getAllCustomers());
        return new ResponseEntity<>(genericRepository.getAllCustomers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cust", method = RequestMethod.GET)
    public ResponseEntity getCustomer(@RequestParam(name = "name", required = false, defaultValue = "") String name) throws SQLException {
        System.out.println("\nSearching for cus name = "+name+"\n\n");
        Optional<List<Customer>> customersWithNamesLike = genericRepository.getCustomersWithNamesLike(name);
        System.out.println("\n\n -- "+customersWithNamesLike.get());
        if (customersWithNamesLike.isPresent()) {
            if (customersWithNamesLike.get().size() > 0) {
                return new ResponseEntity<>(genericRepository.getCustomersWithNamesLike(name), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Not Found", HttpStatus.NO_CONTENT);
            }
        } else {
            return new ResponseEntity<>("SERver error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
