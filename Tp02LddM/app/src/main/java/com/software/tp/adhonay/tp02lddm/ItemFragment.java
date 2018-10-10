package com.software.tp.adhonay.tp02lddm;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends ListFragment {

    private OnListItemSelectedListener mOnListItemSelectedListener;

    public ItemFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        new Classe().execute("http://compras.dados.gov.br/contratos/v1/contratos.json");

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);

        ContratoAdapter adapter = (ContratoAdapter) l.getAdapter();
        ((ContratoAdapter) l.getAdapter()).getItem(position);

        mOnListItemSelectedListener.onListItemSelected(((ContratoAdapter) l.getAdapter()).getItem(position));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListItemSelectedListener) {
            mOnListItemSelectedListener = (OnListItemSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    public interface OnListItemSelectedListener {
        public void onListItemSelected(Contrato contrato);
    }

    public class Classe extends AsyncTask<String,Void,List<Contrato>>{

        JSONObject json;

        private String getString(String campo){
            try {
                Object obj = json.get(campo);
                if (obj == null){
                    return "";
                } else {
                    return (String) obj;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return "";
        }

        private int getInt(String campo){
            try {
                Object obj = json.get(campo);
                if (obj == null){
                    return -1;
                } else {
                    return (Integer) obj;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return -1;
        }

        @Override
        protected List<Contrato> doInBackground(String... params) {
            InputStream is = null;
            List<Contrato> list = new ArrayList<>();
            try {
                is = new URL(params[0]).openStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = "";

                StringBuilder sb = new StringBuilder();
                int cp;
                while ((cp = rd.read()) != -1) {
                    sb.append((char) cp);
                }

                jsonText = sb.toString();

                json = new JSONObject(jsonText);
                JSONArray array = (JSONArray) ((JSONObject) json.get("_embedded")).get("contratos");

                for (int i=0; i<array.length(); i++){
                    json = (JSONObject) array.get(i);

                    String identificador = getString("identificador");
                    String licitacaoAssociada = getString("licitacao_associada");
                    String origemLicitacao = getString("origem_licitacao");
                    String numeroProcesso = getString("numero_processo");
                    String cnpjContratada = getString("cnpj_contratada");
                    String dataAssinatura = getString("data_assinatura");
                    String fundamentoLegal = getString("fundamento_legal");
                    String dataInicioVigencia = getString("data_inicio_vigencia");
                    String dataFinalVigencia = getString("data_termino_vigencia");
                    int numeroAvisoLicitacao = getInt("numero_aviso_licitacao");
                    int numero = getInt("numero");
                    int numeroAditivo = getInt("numero_aditivo");
                    int uasg = getInt("uasg");
                    int codigoContrato = getInt("codigo_contrato");
                    String objeto = getString("objeto");
                    String valorInicial = getString("valcial");

                    list.add(new Contrato( identificador, licitacaoAssociada,  origemLicitacao, numeroProcesso, cnpjContratada, dataAssinatura, fundamentoLegal,
                             dataInicioVigencia, dataFinalVigencia, numeroAvisoLicitacao, numero, numeroAditivo,  uasg,   codigoContrato,objeto, valorInicial));
                }


            }catch (IOException e){
                e.printStackTrace();
            }catch (JSONException e){
                e.printStackTrace();
            } finally {
                if(is !=null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return list;
        }

        @Override
        protected void onPostExecute(List<Contrato> contratos) {
            super.onPostExecute(contratos);

            ContratoAdapter adapter = new ContratoAdapter(getContext(), R.layout.fragment_item, contratos);
            setListAdapter(adapter);
        }
    }

}
