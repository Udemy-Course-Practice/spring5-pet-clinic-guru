package com.spring5.petclinic.model;

import java.util.Set;

public class Vet extends Person {
    Set<Speciality> specialitys;

    public Set<Speciality> getSpecialitys() {
        return specialitys;
    }

    public void setSpecialitys(Set<Speciality> specialitys) {
        this.specialitys = specialitys;
    }
}
