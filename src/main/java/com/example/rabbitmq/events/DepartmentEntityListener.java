package com.example.rabbitmq.events;


import com.example.rabbitmq.entity.Department;
import com.example.rabbitmq.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class DepartmentEntityListener extends AbstractMongoEventListener<Department> {

    private final SequenceGeneratorService sequenceGenerator;

    @Autowired
    public DepartmentEntityListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Department> event) {
        if (event.getSource().getDepartmentId() < 1) {
            event.getSource().setDepartmentId(sequenceGenerator.generateSequence(Department.SEQUENCE_NAME));
        }
    }


}