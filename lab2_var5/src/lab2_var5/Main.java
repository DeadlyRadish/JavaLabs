package lab2_var5;

import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        Controller control = new Controller();
        try {
            control.startProgram();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}