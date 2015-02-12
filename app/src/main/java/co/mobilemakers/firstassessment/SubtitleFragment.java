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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubtitleFragment extends Fragment {

    Button mButtonAddSubtitle;
    RadioGroup mRadioGroupSize;
    EditText mEditTextSubtitle;
    Changeable mActivity;

    public SubtitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_subtitle, container, false);
        findWidgets(rootView);
        mActivity = (MainActivity)getActivity();
        setupButton();
        mEditTextSubtitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()){
                    mButtonAddSubtitle.setEnabled(true);
                } else {
                    mButtonAddSubtitle.setEnabled(false);
                }
            }
        });
        return rootView;
    }

    private void setupButton() {
        mButtonAddSubtitle.setEnabled(false);
        mButtonAddSubtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subtitle = "\n\n";

                switch (mRadioGroupSize.getCheckedRadioButtonId()) {
                    case R.id.radio_button_h2: subtitle+="##"; break;
                    case R.id.radio_button_h3: subtitle+="###"; break;
                    case R.id.radio_button_h4: subtitle+="####"; break;
                    case R.id.radio_button_h5: subtitle+="#####"; break;
                    case R.id.radio_button_h6: subtitle+="######"; break;
                }
                subtitle += mEditTextSubtitle.getText().toString()+ "\n\n";

                mActivity.addMarkdown(subtitle);


                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new ConstructorFragment()).
                        commit();

            }
        });
    }

    private void findWidgets(View rootView) {
        mButtonAddSubtitle = (Button)rootView.findViewById(R.id.button_add_subtitle);
        mRadioGroupSize = (RadioGroup)rootView.findViewById(R.id.radio_group_title_size);
        mEditTextSubtitle  = (EditText)rootView.findViewById(R.id.edit_text_subtitle);
    }


}
