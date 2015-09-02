package com.example.eduardo.demoproyecto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Quitamos barra de titulo de la aplicacion
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
          requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Quitamos barra de notificaciones
          this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        lanzarAvtivityPrincipal();
    }

    public void lanzarAvtivityPrincipal(){
     Thread hilo = new Thread(){
         @Override
         public void run() {
             super.run();
             try {
                 sleep(4000);
             }catch (InterruptedException e){
                 e.printStackTrace();
             }finally {
                 Intent activityPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                 startActivity(activityPrincipal);
                 finish();
             }
         }
     };
        hilo.start();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
