package cursos.android.CalculadorIMC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Se agregan elementos a utilizar para relacionarse con los elementos de la interfaz activity_main
    EditText _peso, _estatura;
    Button calcular;
    TextView resultado;
   
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se obtiene relación con los objetos EditText, botón Calcular
        peso= (EditText)findViewById(R.id.peso);
        estatura= (EditText)findViewById(R.id.estatura);
        calcular = (Button)findViewById(R.id.calcular);

        // Se activa escucha y se crea evento OnClick
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Se obtiene la info desde la interfaz
                String n1= peso.getText().toString();
                String n2= estatura.getText().toString();

                // Se convierte a número
                double peso_num= Double.parseDouble(n1);
                double estatura_num= Double.parseDouble(n2);

                double rta =0.0d;

                // Objeto para dejar solo 2 decimales en el resultado
                DecimalFormat df = new DecimalFormat("#.00");

                // El cáculo de IMC

                        rta = (peso_num * 10000) /(estatura_num * estatura_num);

                String estado="";
                if(rta<=20)
                 {
                     estado="su estado nutricional es Bajo Peso";
                 }
                 else
                 {
                     if (rta<=24.9)
                     {
                         estado="su estado nutricional es Normal";
                     }
                     else
                     {
                         if (rta<=27.5)
                         {
                             estado="su estado nutricional es Sobre Peso";
                         }
                         else
                         {
                             estado="su estado nutricional es Obesidad";
                         }
                     }
                 }
                 // Se asigna el resultado, con formato de 2 decimales, en el campo texto de la TextView resultado
                resultado.setText(String.valueOf("Su IMC es " + df.format(rta))+ " y " + estado);             
            }
        });
        // Se presenta resultado en la interfaz, con formato de 2 decimales, en la TextView resultado
        resultado = (TextView)findViewById(R.id.resultado);
     }
}
