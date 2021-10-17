package com.eniso.regimi.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.eniso.regimi.models.User;
import com.eniso.regimi.services.SequenceGeneratorService;


@Component
public class UserModelListener extends AbstractMongoEventListener<User> {
/*
    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public UserModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<User> event) {
    	long idLong = Long.parseLong(event.getSource().getId());
        if (idLong < 1) {
        	
            event.getSource().setId(String.valueOf(sequenceGenerator.generateSequence(User.SEQUENCE_NAME)));
        }
    }
   */ 



}
