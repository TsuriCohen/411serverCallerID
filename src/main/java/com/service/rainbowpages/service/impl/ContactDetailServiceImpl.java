package com.service.rainbowpages.service.impl;

import com.service.rainbowpages.modal.ContactDetail;
import com.service.rainbowpages.repository.ContactDetailRepository;
import com.service.rainbowpages.service.ContactDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactDetailServiceImpl implements ContactDetailService {

    @Autowired
    ContactDetailRepository contactDetailRepository;

    @Override
    public ContactDetail saveContactDetails(ContactDetail contactDetail) {
        return contactDetailRepository.save(contactDetail);
    }

    @Override
    public void deleteById(Long id) {
        contactDetailRepository.deleteById(id);
    }

    @Override
    public ContactDetail getContactDetailById(Long id) {
        return contactDetailRepository.findById(id).get();
    }

    @Override
    public List<ContactDetail> getAllContacts() {
        return contactDetailRepository.findAll();
    }

    @Override
    public ContactDetail getNameByContactNumber(String number) {
         return contactDetailRepository.getContactDetailByPhoneNumber(number);
    }
}
