package com.arkteya.criminal_intent

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment


class PhotoDialogFragment : DialogFragment() {

    /*override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    val builder = AlertDialog.Builder(requireActivity())
        return builder.setView(R.id.iv_photo_scale).create()
    }
     */
    private lateinit var photoView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photo_dialog, container, false)

        photoView = view.findViewById(R.id.iv_photo_scale) as ImageView

        return view
    }
}


