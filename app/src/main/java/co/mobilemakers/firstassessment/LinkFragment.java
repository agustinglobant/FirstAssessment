package co.mobilemakers.firstassessment;


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
public class LinkFragment extends Fragment {

    Button mButton;
    EditText mEditTextText, mEditTextUrl;
    RadioGroup mRadioGroupType;
    Changeable mActivity;

    public LinkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_link, container, false);
        findWidgets(rootView);
        mActivity = (Changeable) getActivity();
        setupButton();
        setupEditTextWatcher();
        return rootView;
    }

    private void setupEditTextWatcher() {
        mEditTextUrl.addTextChangedListener(getTextWatcher());
        mEditTextText.addTextChangedListener(getTextWatcher());
    }

    private TextWatcher getTextWatcher() {
        return new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (!mEditTextText.getText().toString().isEmpty() &&
                            !mEditTextUrl.getText().toString().isEmpty()){
                        mButton.setEnabled(true);
                    } else {
                        mButton.setEnabled(false);
                    }
                }
            };
    }

    private void setupButton() {
        mButton.setEnabled(false);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String markdown = prepareString();
                mActivity.addMarkdown(markdown);

                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new ConstructorFragment()).
                        commit();
            }

            private String prepareString() {
                String m = "";
                if (mRadioGroupType.getCheckedRadioButtonId() == R.id.radio_button_image){
                    m += "!";
                }
                m += "["+mEditTextText.getText().toString()+"]"+
                        "("+mEditTextUrl.getText().toString()+")\n";
                return m;
            }
        });
    }

    private void findWidgets(View rootView) {
        mButton = (Button)rootView.findViewById(R.id.button_add_link);
        mEditTextText = (EditText)rootView.findViewById(R.id.edit_text_text);
        mEditTextUrl = (EditText)rootView.findViewById(R.id.edit_text_url);
        mRadioGroupType = (RadioGroup)rootView.findViewById(R.id.radio_group_type);
    }


}
