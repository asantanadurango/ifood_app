

package com.aprendiendo.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aprendiendo.android.Models.User;
import com.aprendiendo.android.Models.UserLogin;
import com.aprendiendo.android.Services.LogUser;
import com.aprendiendo.android.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.aprendiendo.android.Services.ipConfig.ip;

public class MainActivity extends AppCompatActivity  {

    User usuario;
    private Retrofit retrofit;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private ActivityMainBinding binding;
    String llave = "sesion";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initElements();

        usuario = new User();

        if (checkSession())
        {
            Intent inte = new Intent(getApplicationContext(), Inicio.class);
            inte.putExtra("compro","no");
            startActivity(inte);

        }else
        {
            String mesage = "inicia sesion";
            Toast.makeText(this,mesage,Toast.LENGTH_SHORT).show();
        }


        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LogUser();
            }
        });




    }
       // incializo Elementos de la shared
    private void initElements()
    {

        preferences = getSharedPreferences("sesiones",Context.MODE_PRIVATE);
        editor = preferences.edit();
    }
    //edita el shared preferences
    private void saveSession(boolean checked)
    {
        editor.putBoolean(llave,checked);
        editor.apply();
    }

    private boolean checkSession()
    {
        return this.preferences.getBoolean(llave,false);
    }

    //Metodo boton Registrarse
    public void Registrarse (View view){
        Intent registrarse = new Intent(this, RegistrarUsuarios.class);
        startActivity(registrarse);
    }






        public void LogUser()
        {

            retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
            LogUser service = retrofit.create(LogUser.class);
            UserLogin userLogging = new UserLogin();
            userLogging.setEmail(binding.etMail.getText().toString());
            userLogging.setPassword(binding.etPass.getText().toString());
            Call<User> log = service.LogUser(userLogging);

            log.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful())
                    {
                        if(response.body()== null)
                        {
                            Toast.makeText(getApplicationContext(),"Error en email o constraseña",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            User user = response.body();
                            Toast.makeText(getApplicationContext(),user.adress,Toast.LENGTH_SHORT).show();
                            // dejo logeado al usuario si esta checkeado el radiobutton
                            
                            saveSession(binding.rbSaveSession.isChecked());
                            //paso a activity inicio y le paso la direccion.
                            Intent inte = new Intent(getApplicationContext(), Inicio.class);
                            String userAdress = user.getAdress();
                            String adress = "direccion";
                            int userId= user.getId();

                            editor.putString(adress,userAdress);
                            editor.apply();
                            startActivity(inte);

                        }
                    }


                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Connection problem:"+t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

}
