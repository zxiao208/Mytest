package com.zx.mytest.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.TextPaint;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.zx.mytest.R;
import com.zx.mytest.base.BaseActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaoxiao on 2018/7/10.
 */

public class CustomViewActivity extends BaseActivity implements View.OnClickListener{
    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    @BindView(R.id.custom_btn_calendar)
    Button customBtnCalendar;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_customview;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        customBtnCalendar.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.custom_btn_calendar:
                    new SimpleCalendarDialogFragment().show(getSupportFragmentManager(),"选择日期");
                break;
                default:
                    break;
        }
    }

    public static class SimpleCalendarDialogFragment extends AppCompatDialogFragment implements CalendarView.OnDateChangeListener{
        CalendarView calendarView;
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.fragment_custom,null);
            calendarView = view.findViewById(R.id.fg_calendar);
            calendarView.setOnDateChangeListener(this);
            return new AlertDialog.Builder(getActivity())
                    .setView(view)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "关闭dialog", Toast.LENGTH_SHORT).show();
                        }
                    }).create();
        }

        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            Toast.makeText(getActivity(), FORMATTER.format(view.getDate()), Toast.LENGTH_SHORT).show();
        }
    }
}
