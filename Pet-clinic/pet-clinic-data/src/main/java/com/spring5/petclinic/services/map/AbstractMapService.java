package com.spring5.petclinic.services.map;

import com.spring5.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(this.generateKey());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object not have ID");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public Map<Long,T> getData(){
        return this.map;
    }

    private Long generateKey(){
        if(map.size() == 0 && map.isEmpty()){
            return 1L;
        }
        return Collections.max(map.keySet()) + 1L;
    }

}
