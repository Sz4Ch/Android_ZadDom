package com.example.ostatnia_wersja;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CallDialog extends DialogFragment {

    private OnCallDialogInteractionListener mListener;

    public CallDialog() {

    }
    static CallDialog newInstance(){
        return new CallDialog();
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(getString(R.string.call_question));

        builder.setPositiveButton(getString(R.string.dialog_confirm), new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onCallDialogPositiveClick(CallDialog.this);
            }
        });

        builder.setNegativeButton(getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onCallDialogNegativeClick(CallDialog.this);
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCallDialogInteractionListener) {
            mListener = (OnCallDialogInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnCallDialogInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnCallDialogInteractionListener {
        void onCallDialogPositiveClick(DialogFragment dialog);
        void onCallDialogNegativeClick(DialogFragment dialog);
    }
}