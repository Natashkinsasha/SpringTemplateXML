package by.natashkinsasha.springtemplatexml.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "waybill")
public class Waybill {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private WaybillStatus status;

    @ManyToOne
    @JoinColumn(name = "responsible_person_id")
    private User responsiblePerson;

    @ManyToOne
    @JoinColumn(name = "checked_by")
    private User checkedBy;

    @ManyToOne
    @JoinColumn(name = "registered_by")
    private User registeredBy;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }

    public WaybillStatus getStatus() { return status; }
    public void setStatus(WaybillStatus status) { this.status = status; }


    public User getResponsiblePerson() { return responsiblePerson; }
    public void setResponsiblePerson(User responsiblePerson) { this.responsiblePerson = responsiblePerson; }

    public User getCheckedBy() { return checkedBy; }
    public void setCheckedBy(User checkedBy) { this.checkedBy = checkedBy; }

    public User getRegisteredBy() { return registeredBy; }
    public void setRegisteredBy(User registeredBy) { this.registeredBy = registeredBy; }


}
