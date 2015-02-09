package co.mobilemakers.firstassessment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConstructorFragment extends Fragment {

    Button mButtonAddTitle;
    RadioGroup mRadioGroupSize;
    EditText mEditTextTitle;

    public ConstructorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_constructor, container, false);
        mButtonAddTitle = (Button)rootView.findViewById(R.id.button_add_title);
        mRadioGroupSize = (RadioGroup)rootView.findViewById(R.id.radio_group_title_size);
        mEditTextTitle  = (EditText)rootView.findViewById(R.id.edit_text_title);

        mButtonAddTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "";

                switch (mRadioGroupSize.getCheckedRadioButtonId()) {
                    case R.id.radio_button_h1: title="#"; break;
                    case R.id.radio_button_h2: title="##"; break;
                    case R.id.radio_button_h3: title="###"; break;
                    case R.id.radio_button_h4: title="####"; break;
                    case R.id.radio_button_h5: title="#####"; break;
                    case R.id.radio_button_h6: title="######"; break;
                }
                title += mEditTextTitle.getText().toString()+ "\n";
            }
        });
        return rootView;
    }


}
