package ac.id.litanisamarinda.aplikasibola;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLastMatch extends Fragment {


    public FragmentLastMatch() {
        // Required empty public constructor
    }
    public static Fragment newIntance() {
        // Required empty public constructor
        return new FragmentLastMatch();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last_match, container, false);
    }

}
