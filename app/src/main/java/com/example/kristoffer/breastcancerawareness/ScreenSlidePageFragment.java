package com.example.kristoffer.breastcancerawareness;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ScreenSlidePageFragment extends Fragment {

    private GetArrays useInterface;
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
            try{
                useInterface = (GetArrays) activity;       //checks if the interface is implemented
            }
            catch (ClassCastException castException){
                //activity does not implement the interface
        }
    }
    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ScreenSlidePageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_screen_slide, container, false);

        String[] headers = useInterface.getHeaders();
        String[] text = useInterface.getInfo();
        String[] text2 = useInterface.getInfo2();
        Integer[] images = useInterface.getImage();

        ((TextView) rootView.findViewById(android.R.id.text1)).setText(headers[getPageNumber()]);
        ((TextView) rootView.findViewById(android.R.id.text2)).setText(text[getPageNumber()]);
        ((TextView) rootView.findViewById(R.id.text3)).setText(text2[getPageNumber()]);
        ((ImageView) rootView.findViewById(R.id.img)).setImageResource(images[getPageNumber()]);

        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}