package co.mobilemakers.firstassessment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConstructorFragment extends Fragment {

    Button mButtonSubtitle, mButtonEmphasis, mButtonShow, mButtonLink;
    Changeable mActivity;

    public ConstructorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_constructor, container, false);
        mActivity = (Changeable) getActivity();
        setupButtonSubtitle(rootView);
        setupButtonEmphasis(rootView);
        setupButtonLink(rootView);
        setupButtonShow(rootView);


        return rootView;
    }

    private void setupButtonShow(View rootView) {
        mButtonShow = (Button) rootView.findViewById(R.id.button_show);
        mButtonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new ShowFragment()).
                        commit();
            }
        });
    }

    private void setupButtonLink(View rootView) {
        mButtonLink = (Button) rootView.findViewById(R.id.button_add_new_link);
        mButtonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new LinkFragment()).
                        commit();
            }
        });
    }

    private void setupButtonEmphasis(View rootView) {
        mButtonEmphasis = (Button) rootView.findViewById(R.id.button_add_new_text);
        mButtonEmphasis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new TextFragment()).
                        commit();
            }
        });
    }

    private void setupButtonSubtitle(View rootView) {
        mButtonSubtitle = (Button) rootView.findViewById(R.id.button_add_new_subtitle);
        mButtonSubtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new SubtitleFragment()).
                        commit();
           }
        });
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
