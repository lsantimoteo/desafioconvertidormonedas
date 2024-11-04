package Paridad;

import com.google.gson.annotations.SerializedName;

public class Paridad implements Comparable<Paridad>{
    @SerializedName("base_code")
    private String nombreBase;
    @SerializedName("target_code")
    private String nombreAConvertir;
    @SerializedName("conversion_rate")
    private Double factorDeConversion;
    @SerializedName("time_last_update_utc")
    private String fechaUltimaActualizacion;

    public String getNombreBase() {
        return nombreBase;
    }

    public void setNombreBase(String nombreBase) {
        this.nombreBase = nombreBase;
    }

    public String getNombreAConvertir() {
        return nombreAConvertir;
    }

    public void setNombreAConvertir(String nombreAConvertir) {
        this.nombreAConvertir = nombreAConvertir;
    }

    public Double getFactorDeConversion() {
        return factorDeConversion;
    }

    public void setFactorDeConversion(Double factorDeConversion) {
        this.factorDeConversion = factorDeConversion;
    }


    @Override
    public int compareTo(Paridad o) {
        return 0;
    }
}
