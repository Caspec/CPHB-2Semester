/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

/**
 *
 * @author Makemewant
 */
public class Offer {

    private int tilbud_id;
    private String tilbud_name;
    private String tilbud_info;
    private String tilbud_img;
    private int tilbud_rabat;

    public Offer(int tilbud_id, String tilbud_name, String tilbud_info, String tilbud_img, int tilbud_rabat) {
        this.tilbud_id = tilbud_id;
        this.tilbud_name = tilbud_name;
        this.tilbud_info = tilbud_info;
        this.tilbud_img = tilbud_img;
        this.tilbud_rabat = tilbud_rabat;
    }

    public Offer() {
    }

    public int getTilbud_id() {
        return tilbud_id;
    }

    public String getTilbud_name() {
        return tilbud_name;
    }

    public void setTilbud_name(String tilbud_name) {
        this.tilbud_name = tilbud_name;
    }

    public String getTilbud_info() {
        return tilbud_info;
    }

    public void setTilbud_info(String tilbud_info) {
        this.tilbud_info = tilbud_info;
    }

    public String getTilbud_img() {
        return tilbud_img;
    }

    public void setTilbud_img(String tilbud_img) {
        this.tilbud_img = tilbud_img;
    }

    public int getTilbud_rabat() {
        return tilbud_rabat;
    }

    public void setTilbud_rabat(int tilbud_rabat) {
        this.tilbud_rabat = tilbud_rabat;
    }


    @Override
    public String toString() {
        return "Tilbud{" + "tilbud_id=" + tilbud_id + ", tilbud_name=" + tilbud_name + ", tilbud_info=" + tilbud_info + ", tilbud_img=" + tilbud_img + ", tilbud_rabat=" + tilbud_rabat + '}';
    }

}
