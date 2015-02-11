package co.mobilemakers.firstassessment;


import android.app.Activity;
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
public class TextFragment extends Fragment {

    Button mButtonAdd;
    RadioGroup mRadioGroup;
    EditText mEditText;
    Changeable mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (Changeable) activity;
    }

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_text, container, false);
        mButtonAdd = (Button)rootView.findViewById(R.id.button_add_emphasis);
        mRadioGroup = (RadioGroup)rootView.findViewById(R.id.radio_group_emphasis);
        mEditText = (EditText)rootView.findViewById(R.id.edit_text_paragraph_emphasis);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emphasis;
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
                    default:
                        emphasis = "";
                        break;
                }

                mActivity.addMarkdown(emphasis+mEditText.getText().toString()+emphasis+" ");
                mActivity.updateView();
                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new ConstructorFragment()).
                        commit();
            }
        });
        return rootView;
    }


}
