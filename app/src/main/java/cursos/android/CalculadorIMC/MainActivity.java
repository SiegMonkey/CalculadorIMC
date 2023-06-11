package cursos.android.CalculadorIMC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText _peso, _estatura;
    Button calcular;
    TextView resultado;
    Requerimiento requerimiento = new Requerimiento();  // Instancia de la nueva clase Requerimiento

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _peso = (EditText)findViewById(R.id.peso);
        _estatura = (EditText)findViewById(R.id.estatura);
        calcular = (Button)findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1= _peso.getText().toString();
                String n2= _estatura.getText().toString();

                double peso_num = Double.parseDouble(n1);
                double estatura_num = Double.parseDouble(n2);

                String imcResult = requerimiento.calculateIMC(peso_num, estatura_num);  // Se utiliza el método de la clase Requerimiento

                resultado.setText(imcResult);  // Se muestra directamente el resultado
            }
        });

        resultado = (TextView)findViewById(R.id.resultado);
    }
}
