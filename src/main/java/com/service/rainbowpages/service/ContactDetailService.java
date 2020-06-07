package com.service.rainbowpages.service;

import com.service.rainbowpages.modal.ContactDetail;

import java.util.List;


public interface ContactDetailService {

    ContactDetail saveContactDetails(ContactDetail contactDetail);

    void deleteById(Long id);

    ContactDetail getContactDetailById(Long id);

    List<ContactDetail> getAllContacts();

    ContactDetail getNameByContactNumber(String number);
}
