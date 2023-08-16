package com.my.fruit;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Objects;

@Entity(tableName = "favorite_fruits")
public class Fruit implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private String family;
    private String order;
    private String genus;
    public int calories;
    public double fat;
    public double sugar;
    public double carbohydrates;
    public double protein;


    public Fruit() {
    }

    public Fruit(int id, String name, String family, String order, String genus, int calories, double fat, double sugar, double carbohydrates, double protein) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.order = order;
        this.genus = genus;
        this.calories = calories;
        this.fat = fat;
        this.sugar = sugar;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", order='" + order + '\'' +
                ", genus='" + genus + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sugar=" + sugar +
                ", carbohydrates=" + carbohydrates +
                ", protein=" + protein +
                '}';
    }

    public String getDescription(){
        return "Family :" + family  +"\n"+
                "Order :" + order  +"\n"+
                "Genus :" + genus  +"\n"+
                "Calories :" + calories +"\n"+
                "Fat :" + fat +"\n"+
                "Sugar :" + sugar +"\n"+
                "Carbohydrates :" + carbohydrates +"\n"+
                "Protein :" + protein ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;
        Fruit fruit = (Fruit) o;
        return getId() == fruit.getId() && getCalories() == fruit.getCalories() && Double.compare(fruit.getFat(), getFat()) == 0 && Double.compare(fruit.getSugar(), getSugar()) == 0 && Double.compare(fruit.getCarbohydrates(), getCarbohydrates()) == 0 && Double.compare(fruit.getProtein(), getProtein()) == 0 && Objects.equals(getName(), fruit.getName()) && Objects.equals(getFamily(), fruit.getFamily()) && Objects.equals(getOrder(), fruit.getOrder()) && Objects.equals(getGenus(), fruit.getGenus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFamily(), getOrder(), getGenus(), getCalories(), getFat(), getSugar(), getCarbohydrates(), getProtein());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(family);
        dest.writeString(order);
        dest.writeString(genus);
        dest.writeInt(calories);
        dest.writeDouble(fat);
        dest.writeDouble(sugar);
        dest.writeDouble(carbohydrates);
        dest.writeDouble(protein);
    }

    protected Fruit(Parcel in) {
        id = in.readInt();
        name = in.readString();
        family = in.readString();
        order = in.readString();
        genus = in.readString();
        calories = in.readInt();
        fat = in.readDouble();
        sugar = in.readDouble();
        carbohydrates = in.readDouble();
        protein = in.readDouble();
    }



}
