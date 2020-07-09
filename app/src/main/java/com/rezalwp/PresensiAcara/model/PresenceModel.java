package com.rezalwp.PresensiAcara.model;

import com.google.gson.annotations.SerializedName;

public class PresenceModel {
    @SerializedName("id")
    private String idPeserta;

    @SerializedName("nama")
    private String namaPeserta;

    @SerializedName("noHp")
    private String noHpPeserta;

    @SerializedName("kategori")
    private String kategoriPeserta;

    @SerializedName("institut")
    private String institutPeserta;

    @SerializedName("noTiket")
    private String noTiketPeserta;

    @SerializedName("idPanitia")
    private String idPanitiaPeserta;

    @SerializedName("tglInput")
    private String tglInputPeserta;

    @SerializedName("waktu")
    private String waktuPeserta;

    @SerializedName("presensi")
    private String presensiPeserta;

    public String getPresensiPeserta() {
        return presensiPeserta;
    }

    public void setPresensiPeserta(String presensiPeserta) {
        this.presensiPeserta = presensiPeserta;
    }

    public String getIdPeserta() {
        return idPeserta;
    }

    public void setIdPeserta(String idPeserta) {
        this.idPeserta = idPeserta;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }
    public String getNoHpPeserta() {
        return noHpPeserta;
    }

    public void setNoHpPeserta(String noHpPeserta) {
        this.noHpPeserta = noHpPeserta;
    }

    public String getKategoriPeserta() {
        return kategoriPeserta;
    }

    public void setKategoriPeserta(String kategoriPeserta) {
        this.kategoriPeserta = kategoriPeserta;
    }

    public String getInstitutPeserta() {
        return institutPeserta;
    }

    public void setInstitutPeserta(String institutPeserta) {
        this.institutPeserta = institutPeserta;
    }

    public String getNoTiketPeserta() {
        return noTiketPeserta;
    }

    public void setNoTiketPeserta(String noTiketPeserta) {
        this.noTiketPeserta = noTiketPeserta;
    }

    public String getIdPanitiaPeserta() {
        return idPanitiaPeserta;
    }

    public void setIdPanitiaPeserta(String idPanitiaPeserta) {
        this.idPanitiaPeserta = idPanitiaPeserta;
    }

    public String getTglInputPeserta() {
        return tglInputPeserta;
    }

    public void setTglInputPeserta(String tglInputPeserta) {
        this.tglInputPeserta = tglInputPeserta;
    }

    public String getWaktuPeserta() {
        return waktuPeserta;
    }

    public void setWaktuPeserta(String waktuPeserta) {
        this.waktuPeserta = waktuPeserta;
    }


}
