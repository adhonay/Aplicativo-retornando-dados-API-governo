package com.software.tp.adhonay.tp02lddm;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContratoView extends Fragment {

    private Contrato contrato;

    public ContratoView() {
        // Required empty public constructor
    }
    public static ContratoView newInstance(Contrato c) {
        ContratoView fragment = new ContratoView();

        Bundle args = new Bundle();
        args.putSerializable("contrato", c);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("SAVED INSTANCE IS NULL? -> " + (savedInstanceState == null ? "=)" : "=("));
        super.onCreate(savedInstanceState);
        contrato = (Contrato) getArguments().getSerializable("contrato");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contrato_view, container, false);

        //int uasg, codigo_contrato;
        //String identificador, cnpj_contratada, objeto;




        TextView identificador = (TextView) view.findViewById(R.id.fragment_contrato_identificador_contrato);
        TextView licitacaoAssociada = (TextView) view.findViewById(R.id.fragment_contrato_licitacao_associada);
        TextView origemLicitacao = (TextView) view.findViewById(R.id.fragment_contrato_origem_licitacao);
        TextView numero = (TextView) view.findViewById(R.id.fragment_contrato_numero);
        TextView codigoContrato = (TextView) view.findViewById(R.id.fragment_contrato_codigo_contrato);
        TextView uasg = (TextView) view.findViewById(R.id.fragment_contrato_uasg);
        TextView cnpj_contratada =  (TextView) view.findViewById(R.id.fragment_contrato_cnpj);
        TextView objeto = (TextView) view.findViewById(R.id.fragment_contrato_objeto);
        TextView fundamentoLegal = (TextView) view.findViewById(R.id.fragment_contrato_fundamento_legal);
        TextView numeroAvisoLicitacao = (TextView) view.findViewById(R.id.fragment_contrato_numero_aviso_licitacao);
        TextView numeroProcesso = (TextView) view.findViewById(R.id.fragment_contrato_numero_processo);
        TextView numeroAditivo = (TextView) view.findViewById(R.id.fragment_contrato_numero_aditivos);
        TextView dataAssinatura = (TextView) view.findViewById(R.id.fragment_contrato_data_assinatura);
        TextView dataInicioVigencia = (TextView) view.findViewById(R.id.fragment_contrato_data_inicio);
        TextView dataFinalVigencia = (TextView) view.findViewById(R.id.fragment_contrato_data_termino);
       // TextView valorInicial = (TextView) view.findViewById(R.id.fragment_contrato_valor_inicial);




        identificador.setText(String.valueOf(contrato.getIdentificador()));
        licitacaoAssociada.setText(String.valueOf(contrato.getLicitacaoAssociada()));
        origemLicitacao.setText(String.valueOf(contrato.getOrigemLicitacao()));
        numero.setText(String .valueOf(contrato.getNumero()));
        codigoContrato.setText(String.valueOf(contrato.getCodigoContrato()));
        uasg.setText(String.valueOf(contrato.uasg));
        cnpj_contratada.setText(String.valueOf(contrato.cnpj_contratada));
        objeto.setText(String.valueOf(contrato.objeto));
        fundamentoLegal.setText(String.valueOf(contrato.fundamentoLegal));
        numeroAvisoLicitacao.setText(String.valueOf(contrato.numeroAvisoLicitacao));
        numeroProcesso.setText(String.valueOf(contrato.numeroAvisoLicitacao));
        numeroAditivo.setText(String.valueOf(contrato.numeroAditivo));
        dataAssinatura.setText(String.valueOf(contrato.dataAssinatura));
        dataInicioVigencia.setText(String.valueOf(contrato.dataInicioVigencia));
        dataFinalVigencia.setText(String.valueOf(contrato.dataFinalVigencia));
        //valorInicial.setText(String.valueOf(contrato.valorInicial));



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }
}
