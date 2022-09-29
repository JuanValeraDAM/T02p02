package com.dam.t02p03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dam.t02p03.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btCancelar.setOnClickListener(btCancelar_OnClickListener);
        binding.btAceptar.setOnClickListener(btAceptar_OnClickListener);
        binding.etDni.setOnFocusChangeListener(et_OnFocusChange);
        binding.etNombre.setOnFocusChangeListener(et_OnFocusChange);


    }

    private final View.OnClickListener btCancelar_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            binding.etDni.setText("");
            binding.etNombre.setText("");
            binding.rg.clearCheck();
            binding.ckEdad.setChecked(false);
            binding.etDni.requestFocus();
            Toast.makeText(MainActivity.this, R.string.msg_DatosEliminados, Toast.LENGTH_SHORT).show();

        }
    };

    private final View.OnClickListener btAceptar_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!binding.etNombre.getText().toString().equals("") && !binding.etDni.getText().toString().equals("")) {
                String texto = "";
                texto = texto + getString(R.string.msg_Dni) + binding.etDni.getText().toString() + "\n" +
                        getString(R.string.msg_Nombre) + binding.etNombre.getText().toString() + "\n";
                if (binding.rbHombre.isChecked()) {
                    texto = texto + getString(R.string.msg_SexoH) + "\n";
                } else if (binding.rbMujer.isChecked()) {
                    texto = texto + getString(R.string.msg_SexoM) + binding.rbMujer.getText().toString();
                }
                if (binding.ckEdad.isChecked()) {
                    texto = texto + getString(R.string.msg_MayorE);
                } else {
                    texto = texto + getString(R.string.msg_MenorE);
                }
                Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG).show();


            } else {
                Toast.makeText(MainActivity.this, "Debes rellenar los campos obligatorios", Toast.LENGTH_LONG).show();
            }
        }
    };
    private final View.OnFocusChangeListener et_OnFocusChange = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {
            if (b) {
                if (!binding.etDni.getText().toString().equals("") && !binding.etNombre.getText().toString().equals(""))
                    ;
                binding.imageView3.setImageResource(R.drawable.ic_ok);
            } else {
                binding.imageView4.setImageResource(R.drawable.ic_ko);
            }
        }
    };

}

