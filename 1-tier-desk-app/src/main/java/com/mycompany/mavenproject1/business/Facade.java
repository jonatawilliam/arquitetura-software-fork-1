package com.mycompany.mavenproject1.business;

import com.mycompany.mavenproject1.data.Country;
import com.mycompany.mavenproject1.data.Customer;

import java.util.Set;

public class Facade {

    private CustomerBusiness customerBusiness;
    private CountryBusiness countryBusiness;

    public Facade() {
        customerBusiness = new CustomerBusiness();
        countryBusiness = new CountryBusiness();
    }

    public void create(Customer customer) throws Exception {
        customerBusiness.create(customer);
    }

    public Set<Customer> readAllCustomers() {
        return customerBusiness.readAll();
    }

    public void create(Country country) throws Exception {
       countryBusiness.create(country);
    }

    public Set<Country> readAllCountrys() {
        return countryBusiness.readAll();
    }
}
