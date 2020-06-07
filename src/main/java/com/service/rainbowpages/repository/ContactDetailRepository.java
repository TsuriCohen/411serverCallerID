package com.service.rainbowpages.repository;

import com.service.rainbowpages.modal.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactDetailRepository extends JpaRepository<ContactDetail,Long> {

    ContactDetail getContactDetailByPhoneNumber(String phoneNumber);
}
