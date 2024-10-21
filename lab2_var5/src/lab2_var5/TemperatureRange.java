package lab2_var5;

import java.io.Serializable;

public class TemperatureRange implements Serializable{
	private static final long serialVersionUID = 1L;
	private double minTemperature;
    private double maxTemperature;

    public TemperatureRange(double minTemperature, double maxTemperature){
        setMinTemperature(minTemperature);
        setMaxTemperature(maxTemperature);
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        if (minTemperature < -273){
            throw new IllegalArgumentException("Temperature cannot be less than absolute zero");
        }
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        if (maxTemperature > 1000){
            throw new IllegalArgumentException("The temperature must be within realistic limits");
        }
        this.maxTemperature = maxTemperature;
    }
    
    @Override
    public String toString() {
        return this.minTemperature + " - " + this.maxTemperature;
    }
}
