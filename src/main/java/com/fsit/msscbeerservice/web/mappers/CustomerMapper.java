package com.fsit.msscbeerservice.web.mappers;

import com.fsit.msscbeerservice.domain.Beer;
import com.fsit.msscbeerservice.domain.Customer;
import com.fsit.msscbeerservice.web.model.CustomerDto;
import org.mapstruct.Mapper;

/**
 * Created by: seanbowen on 2022-07-14
 * Architecting Solutions. Simply.
 */
@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Beer customerDtoToCustomer(CustomerDto customerDto);
}
