package com.example.demo.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Human implements Comparable<Human>{
    private Integer age;
    private Integer height;
    private String name;

    @Override
    public int compareTo(Human other) {
        int age =  Integer.compare(getAge(), other.getAge());

        if(age == 0)
            return getName().compareTo(other.getName());


        return age;
    }
}
