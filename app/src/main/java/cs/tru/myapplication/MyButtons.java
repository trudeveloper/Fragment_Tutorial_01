package cs.tru.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyButtons extends Fragment {


    private OnFragmentInteractionListener mListener;
      String city ="";

    public MyButtons() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().findViewById(R.id.butn1).setOnClickListener(handleClick);

        getActivity().findViewById(R.id.butn2).setOnClickListener(handleClick);

        getActivity().findViewById(R.id.butn3).setOnClickListener(handleClick);

        if (savedInstanceState == null){
            city = "";
        }else{
            city = savedInstanceState.getString("city","");
            Log.d("INFO","City = "+city);
        }
    }


    private View.OnClickListener handleClick = new View.OnClickListener(){
        public void onClick(View arg0) {
            Button btn = (Button)arg0;
            //Toast.makeText(getActivity().getApplicationContext(),"Testing",Toast.LENGTH_SHORT).show();
            if (mListener != null) {
                city = btn.getText().toString();
                mListener.onFragmentInteraction(city);
            }
        }
    };


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("city",city);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_buttons, container, false);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
     public void onFragmentInteraction(String data);
  }

}
