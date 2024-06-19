package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Salaire {
    private Double salaireNet;
    private Double salaireBrut;

    public Double getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireNet(Double salaireNet) {
        this.salaireNet = getSalaireBrut()-((getSalaireBrut()*20)/100);
    }
}
