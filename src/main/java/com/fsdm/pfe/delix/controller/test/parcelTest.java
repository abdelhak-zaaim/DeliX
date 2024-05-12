/*
 * **
 *  * @project : DeliX
 *  * @created : 30/04/2024, 19:15
 *  * @modified : 30/04/2024, 19:15
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.delix.controller.test;

import com.fsdm.pfe.delix.entity.Address;
import com.fsdm.pfe.delix.entity.Customer;
import com.fsdm.pfe.delix.entity.DeliveryAddress;
import com.fsdm.pfe.delix.entity.Parcel;
import com.fsdm.pfe.delix.model.enums.ParcelStatus;
import com.fsdm.pfe.delix.service.Impl.AddressServiceImpl;
import com.fsdm.pfe.delix.service.Impl.CustomerServiceImpl;
import com.fsdm.pfe.delix.service.Impl.DeliveryAddressServiceImpl;
import com.fsdm.pfe.delix.service.Impl.ParcelServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class parcelTest {

   AddressServiceImpl addressService;
   DeliveryAddressServiceImpl deliveryAddressService;
   CustomerServiceImpl customerService;
   ParcelServiceImpl parcelService;

   public parcelTest(AddressServiceImpl addressService, DeliveryAddressServiceImpl deliveryAddressService, CustomerServiceImpl customerService, ParcelServiceImpl parcelService) {
      this.addressService = addressService;
      this.deliveryAddressService = deliveryAddressService;
      this.customerService = customerService;
      this.parcelService = parcelService;
   }

   @GetMapping("/test/parcel/add")
   public ResponseEntity<Parcel> addParcel() {
      String mySecret = System.getenv("EMAIL");
      System.out.println(mySecret+ " *******");
      Address address = new Address();
      address.setCity("fes");
      address.setCountry("Morocco");
      address.setState("Some Province");
      address.setStreet("marja");
      address.setZip("20000");
      address = addressService.saveAddress(address);

      DeliveryAddress deliveryAddress = new DeliveryAddress();
      deliveryAddress.setAddress("fes marja");

      deliveryAddress.setContactNumber("123456789");


      DeliveryAddress deliveryAddress1 = deliveryAddressService.saveDeliveryAddress(deliveryAddress);


      DeliveryAddress deliveryAddress2 = new DeliveryAddress();
      deliveryAddress2.setAddress("rue 1"); // Add this line

      deliveryAddress2 = deliveryAddressService.saveDeliveryAddress(deliveryAddress2);


      Parcel parcel = new Parcel();
      parcel.setStatus(ParcelStatus.IN_TRANSIT);
      parcel.setWeight(2);
      parcel.setHeight(3);
      parcel.setWeight(4);
      parcel.setPickupAddress(deliveryAddress2);
      Customer customer = customerService.loadCustomerById(1L);
      parcel.setSenderCustomer(customer);
      parcel.setReceiverAddress(deliveryAddress1);


      Parcel p = parcelService.saveParcel(parcel);
      return ResponseEntity.ok(p);
   }
}
