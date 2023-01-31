package com.spring5.petclinic.model;

import java.util.Set;

public class Vet extends Person {
    Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
