package br.com.templatemicroservice.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column(name = "created_date_at")
    private Date createdDateAt;

    @Column(name = "updated_date_at")
    private Date updatedDateAt;

    // Método executado antes de inserir um novo registro
    @PrePersist
    protected void onCreate() {
        createdDateAt = new Date();
        updatedDateAt = new Date();
    }

    // Método executado antes de atualizar um registro existente
    @PreUpdate
    protected void onUpdate() {
        updatedDateAt = new Date();
    }
}
