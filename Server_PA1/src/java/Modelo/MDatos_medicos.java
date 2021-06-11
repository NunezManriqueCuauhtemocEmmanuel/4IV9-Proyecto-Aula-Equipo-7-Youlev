/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Conexion;
import java.util.Vector;
import java.sql.*;
/**
 *
 * @author adrai
 */
public class MDatos_medicos {
    private int id_usu, id_diab, id_can;
    private float peso, estatura, imc;

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public int getId_diab() {
        return id_diab;
    }

    public void setId_diab(int id_diab) {
        this.id_diab = id_diab;
    }

    public int getId_can() {
        return id_can;
    }

    public void setId_can(int id_can) {
        this.id_can = id_can;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }
    
    
}
