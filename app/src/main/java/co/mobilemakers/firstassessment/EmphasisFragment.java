package co.mobilemakers.firstassessment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmphasisFragment extends Fragment {

    Button mButtonAdd;
    RadioGroup mRadioGroup;
    EditText mEditText;
    public EmphasisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_emphasis, container, false);
        mButtonAdd = (Button)rootView.findViewById(R.id.button_add_emphasis);
        mRadioGroup = (RadioGroup)rootView.findViewById(R.id.radio_group_emphasis);
        mEditText = (EditText)rootView.findViewById(R.id.edit_text_paragraph_emphasis);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emphasis = "";
                switch (mRadioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_button_bold:
                        emphasis = "*";
                        break;
                    case R.id.radio_button_italic:
                        emphasis = "**";
                        break;
                    case R.id.radio_button_scratch:
                        emphasis = "~~";
                        break;
                }

                ((MainActivity)getActivity()).addMarkdown(emphasis+mEditText.getText().toString()+emphasis+"\n");

                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new ConstructorFragment()).
                        commit();
            }
        });
        return rootView;
    }


}
