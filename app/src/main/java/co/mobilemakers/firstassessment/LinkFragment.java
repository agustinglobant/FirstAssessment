package co.mobilemakers.firstassessment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class LinkFragment extends Fragment {

    Button mButton;
    EditText mEditTextText, mEditTextUrl;

    public LinkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_link, container, false);
        mButton = (Button)rootView.findViewById(R.id.button_add_link);
        mEditTextText = (EditText)rootView.findViewById(R.id.edit_text_text);
        mEditTextUrl = (EditText)rootView.findViewById(R.id.edit_text_url);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).addMarkdown("["+mEditTextText.getText().toString()+"]"+
                                                          "("+mEditTextUrl.getText().toString()+")\n");


                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new ConstructorFragment()).
                        commit();
            }
        });
        return rootView;
    }


}
