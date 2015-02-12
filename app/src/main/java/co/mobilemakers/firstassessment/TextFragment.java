package co.mobilemakers.firstassessment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
        findWidgets(rootView);
        setupButton();
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()){
                    mButtonAdd.setEnabled(true);
                } else {
                    mButtonAdd.setEnabled(false);
                }
            }
        });
        return rootView;
    }

    private void setupButton() {
        mButtonAdd.setEnabled(false);
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

                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new ConstructorFragment()).
                        commit();
            }
        });
    }

    private void findWidgets(View rootView) {
        mButtonAdd = (Button)rootView.findViewById(R.id.button_add_emphasis);
        mRadioGroup = (RadioGroup)rootView.findViewById(R.id.radio_group_emphasis);
        mEditText = (EditText)rootView.findViewById(R.id.edit_text_paragraph_emphasis);
    }


}
