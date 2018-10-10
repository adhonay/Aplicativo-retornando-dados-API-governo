package com.software.tp.adhonay.tp02lddm;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListItemSelectedListener {

    public Toolbar dxToolbar;


    public static final String CONTRATO_FRAGMENT = "detalhescontrato";
    public static final String CONTRATOS_FRAGMENT = "listadecontratos";

     public ContratoView detalhescontrato;
     public ItemFragment listadecontratos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        dxToolbar = (Toolbar) findViewById(R.id.principal);
        dxToolbar.setTitle(R.string.texto_contratos);

        listadecontratos = new ItemFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contratos2, listadecontratos).commit();

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Adiciona o fragmento com as listas
        getSupportFragmentManager().putFragment(outState, CONTRATOS_FRAGMENT, listadecontratos);

        if (detalhescontrato != null && detalhescontrato.isVisible()) {
            outState.putBoolean(CONTRATO_FRAGMENT, (detalhescontrato.isVisible()));
            getSupportFragmentManager().putFragment(outState, CONTRATO_FRAGMENT, detalhescontrato);
        }
    }

        @Override
    public void onBackPressed(){
        FragmentManager fm = getSupportFragmentManager();
        int backStackEntryCount = fm.getBackStackEntryCount();
        if (backStackEntryCount > 0){
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onListItemSelected(Contrato contrato) {
        detalhescontrato = ContratoView.newInstance(contrato);
        FragmentTransaction ts = getSupportFragmentManager().beginTransaction();
        ts.addToBackStack(CONTRATOS_FRAGMENT);
        ts.replace(R.id.contratos2,detalhescontrato);
        ts.commit();
    }
}
