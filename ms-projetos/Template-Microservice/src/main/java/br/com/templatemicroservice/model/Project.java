package br.com.templatemicroservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "projects")
public class Project extends BaseEntity{

    @Column(name = "organization")
    @Enumerated(EnumType.STRING)
    private Organization organization;

    @Column(name = "business_unit")
    private String businessUnit;

    @Column(name = "owner")
    private String owner;

    @Column(name = "region_type")
    private String regionType;

    @Column(name = "credential")
    @Enumerated(EnumType.STRING)
    private Credential credential;

    @Column(name = "ict_enterprise")
    private String ictEnterprise;

    @Column(name = "owner_foxconn")
    private String ownerFoxconn;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_nickname")
    private String projectNickname;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "cost")
    private Double cost;
}
