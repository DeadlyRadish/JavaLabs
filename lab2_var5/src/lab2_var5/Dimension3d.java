package lab2_var5;

import java.io.Serializable;

public class Dimension3d implements Serializable{
	private static final long serialVersionUID = 1L;
	private double height;
    private double width;
    private double deep;

    public Dimension3d(double height, double width, double deep){
        setHeight(height);
        setWidth(width);
        setDeep(deep);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0){
            throw new IllegalArgumentException("Negative values are not allowed");
        }
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (height < 0){
            throw new IllegalArgumentException("Negative values are not allowed");
        }
        this.width = width;
    }

    public double getDeep() {
        return deep;
    }

    public void setDeep(double deep) {
        if (height < 0){
            throw new IllegalArgumentException("Negative values are not allowed");
        }
        this.deep = deep;
    }
}