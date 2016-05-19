package lolstudio.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.Arrays;

/**
 * Created by lolstudio on 2016/5/16.
 */
public class ChangeLanguageFragment extends Fragment {
    ListView mListView;
    ImageView iv_back, iv_complete;
    OnCountryListener mOnCountryListener;

    public static ChangeLanguageFragment newInstance() {
        ChangeLanguageFragment languageFragment = new ChangeLanguageFragment();
        return languageFragment;
    }

    public void setOnCountryListener(OnCountryListener mOnCountryListener) {
        this.mOnCountryListener = mOnCountryListener;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        iv_back = (ImageView) v.findViewById(R.id.iv_back);
        iv_complete = (ImageView) v.findViewById(R.id.iv_complete);
        mListView = (ListView) v.findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, Arrays.asList("abc", "english", "111")));
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnCountryListener.btnClick(true);
            }
        });

        iv_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //restart app
                mOnCountryListener.btnClick(false);
            }
        });

        return v;
    }
}
