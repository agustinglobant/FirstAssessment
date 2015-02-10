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

    public ConstructorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_constructor, container, false);
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

        mButtonEmphasis = (Button) rootView.findViewById(R.id.button_add_new_emphasis);
        mButtonEmphasis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        addToBackStack(null).
                        replace(R.id.container, new EmphasisFragment()).
                        commit();
            }
        });

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

        return rootView;
    }


}
