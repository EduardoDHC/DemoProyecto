package com.example.eduardo.demoproyecto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Eduardo on 20/09/2015.
 */
@DatabaseTable(tableName = "reporte")
public class Reporte {

    @DatabaseField(generatedId = true)
    private int id_Empresa;

    @DatabaseField(index = true, canBeNull = false)
    private String empresa;

    @DatabaseField(canBeNull = false)
    private String nombre;

    @DatabaseField(canBeNull = false)
    private String correo;

    @DatabaseField(canBeNull = false)
    private String telefono;

    @DatabaseField(canBeNull = false)
    private String fecha;

    public Reporte(){
    }

    public Reporte(String empresa, String nombre, String correo, String telefono, String fecha) {
        this.empresa = empresa;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    //<editor-fold desc="METODOS GETTER">
    public int getId_Empresa() {
        return id_Empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha() {
        return fecha;
    }
    //</editor-fold>

    //<editor-fold desc="METODOS SETTER">
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    //</editor-fold>


}
