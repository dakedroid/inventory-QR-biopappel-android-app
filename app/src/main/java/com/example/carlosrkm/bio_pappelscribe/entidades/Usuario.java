package com.example.carlosrkm.bio_pappelscribe.entidades;

/**
 * Created by carlosrkm on 12/11/17.
 */

public class Usuario {
    private Integer id;
    private String nombre;
    private String departamento;
    private String extension;
    private String direccionip;
    private String marcamonitor;
    private String modelomonitor;
    private String seriemonitor;
    private String marcacpu;
    private String modelocpu;
    private String seriecpu;
    private String marcateclado;
    private String modeloteclado;
    private String serieteclado;
    private String marcamouse;
    private String modelomouse;
    private String seriemouse;

    public Usuario(Integer id, String nombre, String departamento, String extension, String direccionip, String marcamonitor, String modelomonitor, String seriemonitor, String marcacpu, String modelocpu, String seriecpu, String marcateclado, String modeloteclado, String serieteclado, String marcamouse, String modelomouse, String seriemouse) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccionip() {
        return direccionip;
    }

    public void setDireccionip(String direccionip) {
        this.direccionip = direccionip;
    }

    public String getMarcamonitor() {
        return marcamonitor;
    }

    public void setMarcamonitor(String marcamonitor) {
        this.marcamonitor = marcamonitor;
    }

    public String getModelomonitor() {
        return modelomonitor;
    }

    public void setModelomonitor(String modelomonitor) {
        this.modelomonitor = modelomonitor;
    }

    public String getSeriemonitor() {
        return seriemonitor;
    }

    public void setSeriemonitor(String seriemonitor) {
        this.seriemonitor = seriemonitor;
    }

    public String getMarcacpu() {
        return marcacpu;
    }

    public void setMarcacpu(String marcacpu) {
        this.marcacpu = marcacpu;
    }

    public String getModelocpu() {
        return modelocpu;
    }

    public void setModelocpu(String modelocpu) {
        this.modelocpu = modelocpu;
    }

    public String getSeriecpu() {
        return seriecpu;
    }

    public void setSeriecpu(String seriecpu) {
        this.seriecpu = seriecpu;
    }

    public String getMarcateclado() {
        return marcateclado;
    }

    public void setMarcateclado(String marcateclado) {
        this.marcateclado = marcateclado;
    }

    public String getModeloteclado() {
        return modeloteclado;
    }

    public void setModeloteclado(String modeloteclado) {
        this.modeloteclado = modeloteclado;
    }

    public String getSerieteclado() {
        return serieteclado;
    }

    public void setSerieteclado(String serieteclado) {
        this.serieteclado = serieteclado;
    }

    public String getMarcamouse() {
        return marcamouse;
    }

    public void setMarcamouse(String marcamouse) {
        this.marcamouse = marcamouse;
    }

    public String getModelomouse() {
        return modelomouse;
    }

    public void setModelomouse(String modelomouse) {
        this.modelomouse = modelomouse;
    }

    public String getSeriemouse() {
        return seriemouse;
    }

    public void setSeriemouse(String seriemouse) {
        this.seriemouse = seriemouse;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
