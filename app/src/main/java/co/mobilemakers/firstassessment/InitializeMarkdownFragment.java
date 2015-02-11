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
public class InitializeMarkdownFragment extends Fragment {

    Button mButtonAddTitle;
    RadioGroup mRadioGroupSize;
    EditText mEditTextTitle;
    Changeable mActivity;

    public InitializeMarkdownFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (Changeable) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_initialize_markdown, container, false);
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
                title += mEditTextTitle.getText().toString()+ "\n\n";

                mActivity.addMarkdown(title);
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
