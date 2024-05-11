
/*
 * **
 *  * @project : DeliX
 *  * @created : 30/04/2024, 19:00
 *  * @modified : 30/04/2024, 19:00
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.delix.service.Impl;

import com.fsdm.pfe.delix.entity.DeliveryAddress;
import com.fsdm.pfe.delix.repository.DeliveryAddressRepo;
import com.fsdm.pfe.delix.service.DeliveryAddressService;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    DeliveryAddressRepo deliveryAddressRepo;

    public DeliveryAddressServiceImpl(DeliveryAddressRepo deliveryAddressRepo) {
        this.deliveryAddressRepo = deliveryAddressRepo;
    }

    @Override
    public void deleteDeliveryAddress(Long id) {
        deliveryAddressRepo.deleteById(id);
    }

    public DeliveryAddress loadDeliveryAddress(Long id) {
        return deliveryAddressRepo.findById(id).orElse(null);
    }

    @Override
    public DeliveryAddress saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressRepo.save(deliveryAddress);
    }

    @Override
    public DeliveryAddress updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressRepo.save(deliveryAddress);
    }
}