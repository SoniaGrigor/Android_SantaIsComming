package com.example.soniagrigor.santascomming;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.support.v4.content.ContextCompat.getSystemService;

public class NameFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_MESSAGE = "message";

    private String messageFromActivity;
    private Button btnAskSanta;
    private OnFragmentInteractionListener mListener;
    private EditText txtYourName;
    private TextView txtResponsName;
    private static List<String> list=new ArrayList<String>();

    public static NameFragment newInstance(String param1){
        NameFragment nameFragment= new NameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE, param1);
        nameFragment.setArguments(args);


        return nameFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            messageFromActivity = getArguments().getString(ARG_MESSAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnAskSanta = view.findViewById(R.id.btn_ask_santa);
        btnAskSanta.setOnClickListener(this);

        txtYourName=(EditText) view.findViewById(R.id.txt_yourName);
        txtResponsName=(TextView) view.findViewById(R.id.txt_result);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    @Override
    public void onClick(View v) {
        if(v.equals(btnAskSanta)){
            onButtonPressed();
        }
    }

    private void onButtonPressed() {
        list.add(", you've been naughty!");
        list.add(", you've been nice!");

        Random randomizer = new Random();
        String random = list.get(randomizer.nextInt(list.size()));
        String str=txtYourName.getText()+random.toString();
        Intent intent = new Intent(getActivity(), Pop.class);
        intent.putExtra("myExtra",str);
        startActivity(intent);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
    }
}
