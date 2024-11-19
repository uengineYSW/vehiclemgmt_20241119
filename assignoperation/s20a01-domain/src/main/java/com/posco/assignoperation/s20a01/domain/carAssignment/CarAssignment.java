package com.posco.assignoperation.s20a01.domain.carAssignment;

import com.posco.assignoperation.s20a01.domain.Period;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CarAssignment_table")
@Data
public class CarAssignment {

    @Id
    private Long id;

    private String requesterName;

    private String organization;

    private String employeeNumber;

    private String officeNumber;

    private String mobileNumber;

    private Date requestDate;

    private String approverInfo;

    private String approverPosition;

    private String usagePurpose;

    private String numberOfPassengers;

    private String routeSetting;

    private String remarks;

    private String passengerContact;

    private String attachedDocuments;

    private String cancellationReason;

    @Enumerated(EnumType.STRING)
    private UsageCategory usageCategory;

    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Enumerated(EnumType.STRING)
    private MainDepartment mainDepartment;

    @Enumerated(EnumType.STRING)
    private OperationSection operationSection;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @Enumerated(EnumType.STRING)
    private IncludeDriver includeDriver;

    @Enumerated(EnumType.STRING)
    private ProgressStage progressStage;

    @Embedded
    private Period period;

    public void cancelCarAssignment(CancelCarAssignmentCommand command) {
        // 비즈니스 로직 구현
    }
}
