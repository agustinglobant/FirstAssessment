package co.mobilemakers.firstassessment;


import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment {

    TextView mTextViewShow;
    Button mButtonOk, mButtonBack;
    Changeable mActivity;

    public ShowFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_show, container, false);
        findWidgets(rootView);
        showMarkdown(mActivity.getMarkdown());

        if (getActivity().findViewById(R.id.container_show) != null) {
            if (savedInstanceState != null) {
                mButtonOk = (Button)rootView.findViewById(R.id.button_ok);
                mButtonBack = (Button)rootView.findViewById(R.id.button_go_back);

                mButtonBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getFragmentManager().beginTransaction().
                                addToBackStack(null).
                                replace(R.id.container, new ConstructorFragment()).
                                commit();
                    }
                });

                mButtonOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("markdown", mActivity.getMarkdown());
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getActivity(), "Text copied to the clipboard",Toast.LENGTH_LONG).show();
                        mActivity.cleanMarkdown();
                    }
                });
            }
        }
        return rootView;
    }

    private void findWidgets(View rootView) {
        mTextViewShow = (TextView)rootView.findViewById(R.id.text_view_show_markdown);
    }

    public void showMarkdown(String mkdown) {
        mTextViewShow.setText(mkdown);
    }


}
