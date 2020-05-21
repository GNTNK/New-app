package com.example.loyverseposexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.Calendar;

public class ReceiptsFragment extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_receipts, container, false);
        Calendar calendar = Calendar.getInstance();
        String currentCalendar = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        textView = v.findViewById(R.id.receipts_clock);
        textView.setText(currentCalendar);
        return v;
    }
}
