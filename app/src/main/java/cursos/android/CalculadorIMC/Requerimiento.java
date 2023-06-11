package cursos.android.CalculadorIMC;

import java.text.DecimalFormat;

public class Requerimiento {
    public String calculateIMC(double peso, double estatura) {
        double rta = (peso * 10000) /(estatura * estatura);

        DecimalFormat df = new DecimalFormat("#.00");

        String estado = "";
        if(rta <= 20) {
            estado = "su estado nutricional es Bajo Peso";
        } else if (rta <= 24.9) {
            estado = "su estado nutricional es Normal";
        } else if (rta <= 27.5) {
            estado = "su estado nutricional es Sobre Peso";
        } else {
            estado = "su estado nutricional es Obesidad";
        }

        return "Su IMC es " + df.format(rta) + " y " + estado;
    }
}
