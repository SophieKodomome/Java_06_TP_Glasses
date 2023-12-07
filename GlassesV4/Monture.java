package eyeglass;

public class Monture {
    int id;
    String name;
    String imgsrc;
    int prix;
    int stock;

    public Monture() {
    }

    public Monture(int i, String n, String img, int p, int s) {
        this.setID(i);
        this.setName(n);
        this.setImgsrc(img);
        this.setPrix(p);
        this.setStock(s);
    }

    public void setID(int i) {
        this.id = i;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setImgsrc(String img) {
        this.imgsrc = img;
    }

    public void setPrix(int p) {
        this.prix = p;
    }

    public void setStock(int s) {
        this.stock = s;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getImgsrc() {
        return this.imgsrc;
    }

    public int getPrix() {
        return this.prix;
    }

    public int getStock() {
        return this.stock;
    }
}
