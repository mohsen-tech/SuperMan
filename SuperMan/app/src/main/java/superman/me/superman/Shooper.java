package superman.me.superman;

import android.media.Image;

/**
 * Created by Amin2 on 7/25/2017.
 */
public class Shooper {
    private int id;
    private String namefamily;
    private String nameshop;
    private int telephone;
    private int phone;
    private String location;
    private Image logo;
    private String email;
    private String tavalod;

    public Shooper() {
    }

    public Shooper(int id, String namefamily, int phone, String email) {
        this.id = id;
        this.namefamily = namefamily;
        this.nameshop = nameshop;
        this.telephone = telephone;
        this.phone = phone;
        this.location = location;
        this.logo = logo;
        this.email = email;
        this.tavalod = tavalod;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNamefamily(String namefamily) {
        this.namefamily = namefamily;
    }

    public void setNameshop(String nameshop) {
        this.nameshop = nameshop;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTavalod(String tavalod) {
        this.tavalod = tavalod;
    }

    public int getId() {
        return id;
    }

    public String getNamefamily() {
        return namefamily;
    }

    public String getNameshop() {
        return nameshop;
    }

    public int getTelephone() {
        return telephone;
    }

    public int getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public Image getLogo() {
        return logo;
    }

    public String getEmail() {
        return email;
    }

    public String getTavalod() {
        return tavalod;
    }


}
