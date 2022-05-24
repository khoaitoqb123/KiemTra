package cntt61.a61133985.HinhBinhHanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText CanhA, CanhB, CanhH;
    RadioButton ChuVi, DienTich;
    Button Cal;
    int kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CanhA =(EditText) findViewById(R.id.edCanhA);
        CanhB =(EditText) findViewById(R.id.edCanhB);
        CanhH =(EditText) findViewById(R.id.edCanhH);
        ChuVi = (RadioButton) findViewById(R.id.radioChuVi);
        DienTich = (RadioButton) findViewById(R.id.radioDienTich);
        Cal = (Button) findViewById(R.id.btnCal);

        Cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String canhA = CanhA.getText().toString();
                int a = Integer.parseInt(canhA);

                String canhB = CanhB.getText().toString();
                int b = Integer.parseInt(canhB);

                String canhH = CanhH.getText().toString();
                int c = Integer.parseInt(canhH);

                if (ChuVi.isChecked()){
                    kq = 2*(a+b);
                    Toast.makeText(MainActivity.this, "Chu vi là: "+kq, Toast.LENGTH_SHORT).show();
                }

                else
                    if (DienTich.isChecked()){
                        kq = a*c;
                        Toast.makeText(MainActivity.this, "Diện tích là: "+kq, Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}